package com.news.task.repository;

import com.news.task.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("SELECT u from User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

}
