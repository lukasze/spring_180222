package com.example.demo.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class HobbitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /hoobits -> HTTP 200")
    @SneakyThrows
    void findAllHobbits() {

        var endpoint = "/hobbits";

        mockMvc
                // wywołaj endpoint: metoda HTTP, nagłówek, media type etc.
                .perform(
                        // get zwraca obiekt, na którym możemy ustawiać nagłówek, ciało rządania etc.
                        MockMvcRequestBuilders.get(endpoint)
                )
                // lepsze logowanie
                .andDo(print())
                // czego oczekujemy
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}