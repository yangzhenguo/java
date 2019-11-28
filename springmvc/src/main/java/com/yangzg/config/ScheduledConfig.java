package com.yangzg.config;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Sam on 2019/6/19.
 */
@Component
public class ScheduledConfig {
    @Value("#{mongoClient?.getDatabase(\"shop\")?.getCollection(\"names\")}")
    private Optional<MongoCollection<Document>> namesOptional;

    private DeferredResult<String> deferredResult;

    @Scheduled(cron = "0 * * * * *")
    public Optional<Document> test1() {
        Optional<Document> documentOptional = namesOptional.map(names -> {
            List<Document> documents = StreamSupport.stream(names.find().limit(10).spliterator(), true).collect(Collectors.toList());
            return documents.get(new Random().nextInt(documents.size()));
        });
        documentOptional.ifPresent(System.out::println);
        return documentOptional;
    }

    public DeferredResult<String> getAsyncUpdate() {
        this.deferredResult = new DeferredResult<>();
        return this.deferredResult;
    }

    @Scheduled(cron = "*/3 * * * * *")
    public void refresh() {
        if (this.deferredResult != null) {
            this.deferredResult.setResult(new Date().toString());
        }
    }
}
