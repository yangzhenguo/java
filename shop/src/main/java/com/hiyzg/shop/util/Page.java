package com.hiyzg.util;

import lombok.Data;

import java.util.List;

/**
 * Created by Sam on 2019/10/11.
 */
@Data
public class Page<T> {
    List<T> list;
    private int page = 1;
    private int size = 5;
    private long total;

    public Page(List<T> list, long total) {
        this.list = list;
        this.total = total;
    }

    public Page(List<T> list, int page, long total) {
        this.list = list;
        this.page = page;
        this.total = total;
    }

    public Page(List<T> list, int page, int size, long total) {
        this(list, page, total);
        this.size = size;
    }

    public int getPage() {
        return Math.min(Math.max(1, this.page), getPages());
    }

    public int getSize() {
        return Math.max(1, this.size);
    }

    public long getTotal() {
        return Math.max(0, this.total);
    }

    public int getPages() {
        return (int)Math.ceil(1.0 * this.getTotal() / this.getSize());
    }

    public boolean isHasNext() {
        return this.getPage() < this.getPages();
    }

    public boolean isHasPrev() {
        return this.getPage() > 1;
    }

    public int getPrevPage() {
        return this.isHasPrev() ? this.getPage() - 1 : this.getPage();
    }

    public int getNextPage() {
        return this.isHasNext() ? this.getPage() + 1 : this.getPage();
    }
}
