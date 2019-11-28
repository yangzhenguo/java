package com.hiyzg.shop.util;

import com.hiyzg.shop.model.Book;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Sam on 2019/10/15.
 */
@Data
public class ShopCart {
    private Map<Long, ShopCartItem> books = new LinkedHashMap<>();

    public ShopCart add(Book book) {
        return this.add(book, 1);
    }

    public ShopCart add(Book book, int count) {
        if (this.hasBook(book)) {
            this.getItem(book).increase(count);
        } else {
            this.books.put(book.getId(), new ShopCartItem(book, count));
        }
        return this;
    }

    public void update(long id, int count) {
        this.getItem(id).setQuantity(count);
    }

    private boolean hasBook(Book book) {
        return this.hasBook(book.getId());
    }

    public ShopCart remove(long id) {
        if (this.hasBook(id)) {
            final ShopCartItem item = this.books.get(id);
            if (item.getQuantity() > 1) {
                this.getItem(id).decrease();
            } else {
                this.removeAll(id);
            }
        } else {
            this.removeAll(id);
        }
        return this;
    }

    public ShopCart removeAll(long id) {
        this.books.remove(id);
        return this;
    }

    public boolean hasBook(long id) {
        return this.books.containsKey(id);
    }

    public Book getBook(long id) {
        return this.getItem(id).getBook();
    }

    public ShopCartItem getItem(long id) {
        return this.books.get(id);
    }

    public ShopCartItem getItem(Book book) {
        return this.getItem(book.getId());
    }

    public int getCount() {
        return this.books.values().stream().mapToInt(ShopCartItem::getQuantity).reduce(0, (prev, next) -> prev + next);
    }

    public double getPrice() {
        return this.books.values().stream().mapToDouble(ShopCartItem::getPrice).reduce(0, (prev, next) -> prev + next);
    }

    public boolean isEmpty() {
        return this.books.isEmpty();
    }

    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    public void clear() {
        this.books.clear();
    }
}
