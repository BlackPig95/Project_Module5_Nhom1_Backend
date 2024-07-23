package com.ra.project_module5_reactjs.service.design.admin;


import com.ra.project_module5_reactjs.model.entity.Banner;
import com.ra.project_module5_reactjs.model.entity.Seat;

import java.util.List;

public interface IBannerService
{
    public List<Banner> getAllBanner();

    public Banner createBanner(Banner banner);

    public void updateBanner(Banner banner);

    public void deleteBanner(Banner banner);

    List<Banner> getActiveBanner();
}
