package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.model.entity.Room;
import com.ra.project_module5_reactjs.repository.IRoomRepository;
import com.ra.project_module5_reactjs.service.design.admin.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements IRoomService
{
    private final IRoomRepository roomRepo;

    @Override
    public Page<Room> findAll(Pageable pageable)
    {
        return roomRepo.findAll(pageable);
    }
}
