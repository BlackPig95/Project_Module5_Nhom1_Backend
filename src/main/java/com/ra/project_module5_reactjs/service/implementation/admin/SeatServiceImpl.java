package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.model.entity.Seat;
import com.ra.project_module5_reactjs.repository.ISeatRepository;
import com.ra.project_module5_reactjs.service.design.admin.ISeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements ISeatService {

    private final ISeatRepository iSeatRepository;
    @Override
    public Page<Seat> getSeatPagination(Integer page, Integer limit) {
        Pageable pageable = PageRequest.of(page,limit);

        return iSeatRepository.findAll(pageable);
    }

    @Override
    public List<Seat> getAllSeat() {
        return iSeatRepository.findAll();
    }

    @Override
    public void updateSeat(Seat seat) {
        iSeatRepository.save(seat);

    }

    @Override
    public Page<Seat> sortByNumber(Integer page, Integer limit, String direction) {
        Sort sort1 = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by("number").ascending() : Sort.by("number").descending();
        Pageable pageable = PageRequest.of(page,limit,sort1);
        return iSeatRepository.findAll(pageable);
    }
}
