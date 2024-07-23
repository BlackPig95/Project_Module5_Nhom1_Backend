package com.ra.project_module5_reactjs.service.implementation.client;

import com.ra.project_module5_reactjs.model.entity.Seat;
import com.ra.project_module5_reactjs.repository.ISeatRepository;
import com.ra.project_module5_reactjs.service.design.client.ISeatClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatClientServiceImpl implements ISeatClientService {
    private final ISeatRepository iSeatRepository;

    @Override
    public List<Seat> findSeatByRoomId(Long roomId) {
        return iSeatRepository.findSeatByRoomId(roomId);
    }
}
