package com.yangzg.spring.chapter03;

import com.mongodb.MongoClient;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.function.Consumer;

/**
 * Created by Sam on 2019/6/25.
 */
public class MongoTest {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        mongoClient.getDatabase("shop").getCollection("names").find(Filters.regex("name", ".*雪")).forEach((Consumer<? super Document>) System.out::print);
    }
}
