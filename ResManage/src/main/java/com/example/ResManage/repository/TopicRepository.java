package com.example.ResManage.repository;

import com.example.ResManage.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
