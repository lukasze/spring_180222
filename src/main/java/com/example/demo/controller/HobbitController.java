package com.example.demo.controller;

import com.example.demo.model.Hobbit;
import com.example.demo.service.HobbitService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HobbitController {

    private final HobbitService hobbitService;

    @GetMapping("/hobbits")
    List<Hobbit> findAll(){
        return hobbitService.findAll();
    }
}
