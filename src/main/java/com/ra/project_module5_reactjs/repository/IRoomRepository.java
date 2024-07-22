package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.controller.admin.RoomController;
import com.ra.project_module5_reactjs.model.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Long>, PagingAndSortingRepository<Room, Long>
{
    @Override
    Page<Room> findAll(Pageable pageable);
}
