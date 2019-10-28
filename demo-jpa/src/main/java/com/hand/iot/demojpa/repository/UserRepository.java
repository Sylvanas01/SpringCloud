package com.hand.iot.demojpa.repository;

import com.hand.iot.demojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findById(Integer id);

    User save(User user);

    List<User> findAll();

    void deleteById(Integer id);
}

