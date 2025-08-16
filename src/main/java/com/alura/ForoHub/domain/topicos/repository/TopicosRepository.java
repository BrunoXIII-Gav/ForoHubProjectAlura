package com.alura.ForoHub.domain.topicos.repository;

import com.alura.ForoHub.domain.topicos.model.TopicosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicosRepository extends JpaRepository<TopicosEntity,Integer> {
}
