package com.ra.project_module5_reactjs.service.implementation.admin;

import com.ra.project_module5_reactjs.model.entity.Banner;
import com.ra.project_module5_reactjs.model.entity.Seat;
import com.ra.project_module5_reactjs.repository.IBannerRepository;
import com.ra.project_module5_reactjs.service.design.admin.IBannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements IBannerService
{

    private final IBannerRepository repository;


    @Override
    public List<Banner> getAllBanner()
    {
        return repository.findAll();
    }

    @Override
    public Banner createBanner(Banner banner)
    {

        return repository.save(banner);
    }

    @Override
    public void updateBanner(Banner banner)
    {
        repository.save(banner);

    }

    @Override
    public void deleteBanner(Banner banner)
    {
        repository.delete(banner);
    }

    @Override
    public List<Banner> getActiveBanner()
    {
        return repository.findAllByStatusTrue();
    }
}
