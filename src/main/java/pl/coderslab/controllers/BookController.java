package pl.coderslab.controllers;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.sources.Book;
import pl.coderslab.sources.BookService;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(
                1L,
                "9788324631766",
                "Thinking in Java",
                "Bruce Eckel",
                "Helion",
                "programming");
    }

    @GetMapping("")
    @ResponseBody
    public List<Book> getList() {
        return bookService.getBook();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBook(@PathVariable int id) {
        return bookService.findBook(id);
    }

    @PostMapping("")
    public Book getBookAndAddToList(
            @RequestParam String isbn,
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String publisher,
            @RequestParam String type) {

        return bookService.addBook(isbn, title, author, publisher, type);
    }

    @DeleteMapping("/{id}")
    public List<Book> bookToDelete(@PathVariable int id) {
        return bookService.deleteBook(id);
    }

    @PutMapping("")
    public Book bookToUpdate(
            @RequestParam int id,
            @RequestParam String isbn,
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam String publisher,
            @RequestParam String type) {

        return bookService.updateBook(id, isbn, title, author, publisher, type);
    }
}
