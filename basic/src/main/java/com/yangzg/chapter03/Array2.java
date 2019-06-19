package com.yangzg.chapter03;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Created by Sam on 2019/6/11.
 */
public class Array2 {
    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        MongoClient mongoClient = new MongoClient();
        MongoCollection<Document> collection = mongoClient.getDatabase("shop").getCollection("names");

        List<String> names = new ArrayList<>();

        collection.find().map(item -> item.getString("name")).forEach((Consumer<? super String>) names::add);
        String name = names.remove(new Random().nextInt(names.size()));
        System.out.println(name);
        name = names.remove(new Random().nextInt(names.size()));
        System.out.println(name);
        name = names.remove(new Random().nextInt(names.size()));
        System.out.println(name);
        mongoClient.close();
    }

    private static void test1() {
        MongoClient mongoClient = new MongoClient();
        MongoCollection<Document> collection = mongoClient.getDatabase("shop").getCollection("names");

        long count = collection.count();
        FindIterable<Document> limit = collection.find().skip(new Random().nextInt((int) count)).limit(1);
        Document first = limit.first();
        System.out.println(first.getString("name"));

        mongoClient.close();
    }

}
