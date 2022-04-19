package com.news.task.service;

import com.news.task.model.ReadStatus;
import com.news.task.repository.ReadStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadStatusService {
    @Autowired
    private ReadStatusRepository readStatusRepository;

    public void setReadStaus( ReadStatus readStatus) {
        readStatusRepository.save(readStatus);
    }
}
