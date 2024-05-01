package com.msk.joblisting.repositories;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.msk.joblisting.model.Post;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchPostRepositoryImp implements SearchPostRepository {

    final MongoClient client;
    final MongoConverter converter;

    public SearchPostRepositoryImp(MongoClient client, MongoConverter converter) {
        this.client = client;
        this.converter = converter;
    }

    @Override
    public List<Post> searchByKeyWord(String query) {
        final List<Post> posts = new ArrayList<Post>();
        MongoDatabase database = client.getDatabase("ClusterS");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(
                Arrays.asList(
                        new Document("$search", new Document("index", "default")
                                .append("text",new Document("query", "java")
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                        new Document("$sort", new Document("exp", 1L)),
                        new Document("$limit", 5L)));

        result.forEach(document -> posts.add(converter.read(Post.class, document)));

        return posts;
    }
}
