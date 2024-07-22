package com.ra.project_module5_reactjs.service.design.admin;


import com.ra.project_module5_reactjs.constant.RoleEnum;
import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.entity.Role;

public interface IRoleService {
    Role findByRoleName(RoleEnum name) throws CustomException;
}

