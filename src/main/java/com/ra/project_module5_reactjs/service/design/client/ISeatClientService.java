package com.ra.project_module5_reactjs.service.design.client;


import com.ra.project_module5_reactjs.model.entity.Seat;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISeatClientService {

    List<Seat> findSeatByRoomId(Long roomId);
}
