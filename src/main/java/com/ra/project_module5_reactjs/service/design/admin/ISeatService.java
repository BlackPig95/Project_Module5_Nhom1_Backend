package com.ra.project_module5_reactjs.service.design.admin;

import com.ra.project_module5_reactjs.model.entity.Room;
import com.ra.project_module5_reactjs.model.entity.Seat;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISeatService {
    public Page<Seat> getSeatPagination(Integer page, Integer limit);

    public List<Seat> getAllSeat();

    public void updateSeat(Seat seat);

    public Page<Seat> sortByNumber(Integer page, Integer limit, String direction);

    
}

