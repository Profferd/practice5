package com.java.intership.practice5;

import com.java.intership.practice5.entity.Author;
import com.java.intership.practice5.entity.Book;
import com.java.intership.practice5.service.AuthorService;
import com.java.intership.practice5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @RequestMapping(path = {"/"})
    @GetMapping("/{pageNo}/{pageSize}")
    public String readBooks(Model model,
                            @RequestParam(value = "keyword", required = false) String keyword,
                            HttpServletRequest request) {
        List<Book> allBooks = new ArrayList<>();

        if(keyword == null || keyword.equals("")) {
            allBooks = bookService.readBooks();
            PagedListHolder pagedListHolder = new PagedListHolder(allBooks);
            int page = ServletRequestUtils.getIntParameter(request, "p", 0);
            pagedListHolder.setPage(page);
            pagedListHolder.setPageSize(3);
            model.addAttribute("pagedListHolder", pagedListHolder);
        } else if (keyword.matches("\\d+"))  {
            allBooks = bookService.findByAuthorId(Integer.parseInt(keyword));
        }else if(keyword.matches("\\S+")) {
            allBooks = bookService.findByGenre(keyword.toLowerCase(Locale.ROOT));
        }
        model.addAttribute("allBooks", allBooks);
        model.addAttribute("keyword", keyword);
        return "allBooks";
    }

    @RequestMapping("/addNewBook")
    public String addNewBook(Model model) {

        Book book = new Book();
        model.addAttribute("book", book);

        return "bookInfo";
    }

    @RequestMapping("/update")
    public String saveBook(@ModelAttribute("book") Book book) {

        bookService.update(book);

        return "redirect:/";

    }

    @RequestMapping("/updateInfo")
    public String updateBook(@RequestParam("bookId") int id, Model model) {

        Book book = bookService.read(id);
        model.addAttribute("book", book);

        return "bookInfo";

    }

    @RequestMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int id) {

        bookService.delete(id);

        return "redirect:/";
    }

    @RequestMapping("/allAuthors")
    public String allAuthors(Model model) {
        List<Author> allAuthors = authorService.readAuthors();
        model.addAttribute("allAuthors", allAuthors);

        return "allAuthors";

    }
}
