package com.news.task.service;

import com.news.task.model.News;
import com.news.task.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;

    public List<News> listAll(){
        return newsRepository.findAll();
    }
    public News getbyID(Long id){
        return newsRepository.findById(id).get();
    }
    public void delete(Long id){
        newsRepository.deleteById(id);
    }




    public News saveNews(News news) {
        return newsRepository.save(news);
    }
}