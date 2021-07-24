package com.maoyan.elasticsearchproject.dao;

import com.maoyan.elasticsearchproject.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
}
