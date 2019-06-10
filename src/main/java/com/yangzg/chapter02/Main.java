package com.yangzg.chapter02;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sam on 2019/6/9.
 */
public class Main {
    private static final MongoClient MONGO_CLIENT = new MongoClient();
    private static final MongoDatabase DB = MONGO_CLIENT.getDatabase("shop");
    private static final MongoCollection SHOP = DB.getCollection("shop");

    public static void main(String[] args) {
//        destroy();
//
//        init();
//
//        MONGO_CLIENT.close();

        test1();
    }

    public static void test1() {

        BsonDocument document = new BsonDocument("a", new BsonString("MongoDB"))
                .append("b", new BsonArray(Arrays.asList(new BsonInt32(1), new BsonInt32(2))));
        System.out.println(document.toJson());
    }

    public static void test2() {
        Document document = new Document("a", new BsonString("MongoDB"))
                .append("b", new BsonArray(Arrays.asList(new BsonInt32(1), new BsonInt32(2))));
        System.out.println(document.toJson());
    }

    public static void init() {
        Shop shop = new Shop("MacBookAir", 13.3, 6988.88, 5);


        List<Document> shops = Stream.of(
                new Document("name", "MacBookAir").append("size", 13.3).append("price", 6988.88).append("count", 5),
                new Document("name", "ThinkpadT450").append("size", 14.0).append("price", 5999.99).append("count", 10),
                new Document("name", "ASUS-FL5800").append("size", 15.6).append("price", 4999.50).append("count", 18)
        ).collect(Collectors.toList());
        SHOP.insertMany(shops);
    }

    public static void destroy() {
        SHOP.drop();
    }
}
