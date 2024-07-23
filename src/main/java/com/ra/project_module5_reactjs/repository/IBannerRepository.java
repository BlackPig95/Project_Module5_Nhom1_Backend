package com.ra.project_module5_reactjs.repository;


import com.ra.project_module5_reactjs.model.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBannerRepository extends JpaRepository<Banner, Long>
{
    List<Banner> findAllByStatusTrue();
}
