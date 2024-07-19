package com.ra.project_module5_reactjs.service.design.general;

import com.ra.project_module5_reactjs.model.entity.Country;
import com.ra.project_module5_reactjs.repository.ICountryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements ICountryService
{
    private final ICountryRepo countryRepo;

    @Override
    public List<Country> getAllCountries()
    {
        return countryRepo.findAll();
    }
}
