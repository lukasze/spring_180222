package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

// supermoc - uruchom pełen kontekst Spring'a przed uruchomieniem testu
@SpringBootTest
// podpowiedz Spring'owi jak utworzyć ziarno MockMvc
@AutoConfigureMockMvc
class HobbitControllerTest {
    // Wstrzukiwanie przez pole!! (w teście OK ;) )
    @Autowired
    // API do testów endpointów
    private MockMvc mockMvc;
    // adnotacja JUnit - metoda testowa
    @Test
    void findAllHobbits() {
        fail();
    }

}