package com.yangzg.service4;

import com.yangzg.exception4.ShopException;
import com.yangzg.model4.Book;
import com.yangzg.model4.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Sam on 2019/11/2.
 */
@Service
public class ShopService {
    @Autowired
    private BookService bookService;

    @Autowired
    private PersonService personService;

    public void purchase(final String personName, final String bookName) {
        final Optional<Book> bookOptional = this.bookService.selectByName(bookName);
        final Book book = bookOptional.orElseThrow(() -> new ShopException(String.format("%s不存在", bookName)));
        final Optional<Person> personOptional = this.personService.selectByName(personName);
        final Person person = personOptional.orElseThrow(() -> new ShopException(String.format("%s不存在", personName)));
        if (book.getAmount() <= 0) {
            throw new ShopException(String.format("%s库存不足", bookName));
        }
        this.bookService.decreaseStock(bookName);
        if (person.getBalance() < book.getPrice()) {
            throw new ShopException(String.format("%s用户余额不足", personName));
        }
        this.personService.decreaseBalance(personName, book.getPrice());
    }
}
