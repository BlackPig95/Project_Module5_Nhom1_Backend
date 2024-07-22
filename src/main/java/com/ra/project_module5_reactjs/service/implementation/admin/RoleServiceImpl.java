package com.ra.project_module5_reactjs.service.implementation.admin;


import com.ra.project_module5_reactjs.constant.RoleEnum;
import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.entity.Role;
import com.ra.project_module5_reactjs.repository.IRoleRepository;
import com.ra.project_module5_reactjs.service.design.admin.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final IRoleRepository roleRepository;

    @Override
    public Role findByRoleName(RoleEnum name) throws CustomException {
        return roleRepository.findByName(name).orElseThrow(() -> new CustomException("role not found", HttpStatus.NOT_FOUND));
    }
}
