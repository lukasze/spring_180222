package com.example.demo.service;

import com.example.demo.model.Hobbit;
import com.example.demo.repository.HobbitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class HobbitService {

    private final HobbitRepository hobbitRepository;

    public List<Hobbit> findAll(){
        return hobbitRepository.findAll();
    }
}
