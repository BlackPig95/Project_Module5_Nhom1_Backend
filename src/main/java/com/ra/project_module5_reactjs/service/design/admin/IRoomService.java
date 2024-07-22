package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.model.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IRoomService {
    public Page<Room> getAllProduct(Integer page, Integer limit);

    public Room createRoom(Room room);


}
