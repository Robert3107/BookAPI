package pl.coderslab.sources;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService implements BookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MemoryBookService() {
        list = new ArrayList<>();

        list.add(new Book(1L, "9788324631766", "Thiniking	in Java",
                "Bruce	Eckel", "Helion", "programming"));

        list.add(new Book(2L, "9788324627738", "Rusz głowa Java.",
                "Sierra	Kathy, Bates Bert", "Helion", "programming"));

        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy",
                "Cay	Horstmann, Gary	Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> getBook() {
        return this.list;
    }

    @Override
    public Book findBook(int id) {
        Book bookToFind = null;
        for (Book book : this.list) {
            if (book.getId() == id) {
                bookToFind = book;
            }
        }
        return bookToFind;
    }

    @Override
    public Book addBook(String isbn, String title, String author, String publisher, String type) {
        Book bookToAdd = new Book(this.nextId, isbn, title, author, publisher, type);
        list.add(bookToAdd);
        return bookToAdd;
    }

    @Override
    public List<Book> deleteBook(int id) {
        Book bookToDelete = findBook(id);
        list.remove(bookToDelete);
        return list;
    }

    @Override
    public Book updateBook(int id, String isbn, String title, String author, String publisher, String type) {
        Book bookToUpdate = findBook(id);
        bookToUpdate.setIsbn(isbn);
        bookToUpdate.setTitle(title);
        bookToUpdate.setAuthor(author);
        bookToUpdate.setPublisher(publisher);
        bookToUpdate.setType(type);
        return bookToUpdate;
    }
}
