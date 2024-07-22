package com.ra.project_module5_reactjs.repository;

import com.ra.project_module5_reactjs.controller.admin.RoomController;
import com.ra.project_module5_reactjs.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Long> {

    List<Room> findRoomByNameContainingIgnoreCase(String name);


}
