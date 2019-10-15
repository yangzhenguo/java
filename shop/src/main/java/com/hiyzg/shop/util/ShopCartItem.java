package com.hiyzg.shop.util;

import com.hiyzg.shop.model.Book;
import lombok.Data;

/**
 * Created by Sam on 2019/10/15.
 */
@Data
public class ShopCartItem {
    private Book book;
    private int quantity = 1;

    public ShopCartItem(Book book) {
        this.book = book;
    }

    public ShopCartItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.book.getPrice() * this.quantity;
    }

    public int increase() {
        return ++quantity;
    }

    public int decrease() {
        return --quantity;
    }

    public int increase(int count) {
        return quantity += count;
    }
}
