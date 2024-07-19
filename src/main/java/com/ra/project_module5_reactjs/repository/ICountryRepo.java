package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepo extends JpaRepository<Country, Long>
{
    Country findByName(String name);
}
