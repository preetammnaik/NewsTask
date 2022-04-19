package com.news.task.repository;

import com.news.task.model.ReadStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadStatusRepository extends JpaRepository<ReadStatus,Long> {
}
