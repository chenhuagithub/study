package com.maoyan.elasticsearchproject;


import com.maoyan.elasticsearchproject.bean.Book;
import com.maoyan.elasticsearchproject.dao.BookRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ElasticsearchProjectApplicationTests {
    
    @Autowired
    private BookRepository bookRepository;
    
    
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    
    
    @Test
    void contextLoads() {
        String str = "中华人民共和国关羽张飞刘备你是谁成龙";
        for (int i = 0; i < 20; i++) {
            Book book = new Book();
            book.setId((int)(Math.random() * 100) + "");
            StringBuilder name = new StringBuilder();
            for (int j = 0; j < 5; j++) {
                int index = (int)(Math.random() * (str.length() - 1));
                name.append(str.charAt(index));
            }
            book.setName(name.toString());
    
            StringBuilder summary = new StringBuilder();
            for (int j = 0; j < 20; j++) {
                int index = (int)(Math.random() * (str.length() - 1));
                summary.append(str.charAt(index));
            }
            book.setSummary(summary.toString());
            book.setPrice((int)(Math.random()*100));
            bookRepository.save(book);
        }
    }
    
    
    @Test
    public void query() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder
                .query(QueryBuilders.matchAllQuery())
                .postFilter(QueryBuilders.matchAllQuery())
                .size(20);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println("文档总数：" + response.getHits().getTotalHits());
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
    
    @Test
    public void update() {
    
    }
    
}
