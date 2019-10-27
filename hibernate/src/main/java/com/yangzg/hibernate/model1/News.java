package com.yangzg.hibernate.model1;

import lombok.*;

import java.util.Date;

/**
 * Created by Sam on 2019/10/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class News {
    private Integer id;
    private String title;
    private String author;
    private String content;
    @Setter(AccessLevel.PRIVATE)
    private String newTitle;

    public News(String title, String author, String content, Date date) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    private Date date;
}
