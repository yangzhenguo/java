package com.yangzg.spring.chapter03;

import com.mongodb.MongoClient;

/**
 * Created by Sam on 2019/6/19.
 */
public class MongoUtil {
    private MongoClient mongoClient;

    public void init() {
        if (null == this.mongoClient) {
            this.mongoClient = new MongoClient();
        }
    }

    public MongoClient mongoClient() {
        return this.mongoClient;
    }

    public void destroy() {
        if (null != this.mongoClient) {
            this.mongoClient.close();
        }
    }
}
