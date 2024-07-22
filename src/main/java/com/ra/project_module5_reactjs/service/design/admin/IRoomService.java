package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.model.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRoomService
{
    Page<Room> findAll(Pageable pageable);

    Room addRoom(Room room);

    void deleteRoom(Long roomId);

    Room editRoom(Room room);
}
