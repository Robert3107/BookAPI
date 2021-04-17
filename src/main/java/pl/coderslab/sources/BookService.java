package pl.coderslab.sources;

import java.util.List;

public interface BookService {

    List<Book> getBook();

    Book findBook(int id);

    Book addBook(String isbn, String title, String author, String publisher, String type);

    List<Book> deleteBook(int id);

    Book updateBook (int id, String isbn, String title, String author, String publisher, String type);

}
