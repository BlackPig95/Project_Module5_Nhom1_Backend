package com.ra.project_module5_reactjs.controller.admin;

import com.ra.project_module5_reactjs.exception.CustomException;
import com.ra.project_module5_reactjs.model.entity.User;
import com.ra.project_module5_reactjs.service.design.admin.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/admin/user-management")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService ;

    @GetMapping
    public ResponseEntity<Page<User>> findAll(
            @PageableDefault(page = 0, size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "ASC") String direction
    ) {
        Pageable sortedPageable = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.fromString(direction), sort)
        );
        return ResponseEntity.ok().body(userService.findAll(sortedPageable, search));
    }


    @PutMapping("/{id}/status")
    public ResponseEntity<Void> updateUserStatus(@PathVariable Long id) throws CustomException {
            userService.updateUserStatus(id);
            return ResponseEntity.noContent().build();
    }


}
