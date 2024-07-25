package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface INewsRepository extends JpaRepository<News,Long> {


}