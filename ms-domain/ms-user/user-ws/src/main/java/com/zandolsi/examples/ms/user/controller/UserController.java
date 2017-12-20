package com.zandolsi.examples.ms.user.controller;

import com.zandolsi.examples.ms.user.dto.request.UserRequestDto;
import com.zandolsi.examples.ms.user.dto.response.UserResponseDto;
import com.zandolsi.examples.ms.user.mapper.UserRequestMapper;
import com.zandolsi.examples.ms.user.mapper.UserResponseMapper;
import com.zandolsi.examples.ms.user.model.User;
import com.zandolsi.examples.ms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserResponseMapper userResponseMapper;
    @Autowired
    private UserRequestMapper userRequestMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserResponseDto> get(@PathVariable String id) {
        Optional<UserResponseDto> user = Optional.ofNullable(userResponseMapper.to(userService
                .get(id)));
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<UserResponseDto> save(@RequestBody UserRequestDto user) throws URISyntaxException {
        User createdUser = userService.save(userRequestMapper.to(user));
        URI newResourceURI = new URI("/api/users" + createdUser.getEmail());
        return ResponseEntity.created(newResourceURI).body(userResponseMapper.to(createdUser));
    }
}
