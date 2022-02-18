package com.example.demo.service;

import com.example.demo.repository.HobbitRepository;
import org.springframework.stereotype.Service;


@Service
public class HobbitService {

    private final HobbitRepository hobbitRepository;

    /*
        Jeśli jeden konstruktor, nie musimy jawnie wstawiać @Autowired
     */
    public HobbitService(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }
}
