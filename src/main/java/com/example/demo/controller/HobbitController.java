package com.example.demo.controller;

import com.example.demo.service.HobbitService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbitController {

    private final HobbitService hobbitService;

    /*
        Jeśli jeden konstruktor, nie musimy jawnie wstawiać @Autowired
     */
    public HobbitController(HobbitService hobbitService) {
        this.hobbitService = hobbitService;
    }
}
