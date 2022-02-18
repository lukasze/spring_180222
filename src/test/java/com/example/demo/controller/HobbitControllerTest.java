package com.example.demo.controller;

import com.example.demo.model.Hobbit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class HobbitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // mapujemy Java <-> JSON, wstrzyknięty jest 'bogatszy' niż tworzony przez new
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("GET /hoobits -> HTTP 200")
    @SneakyThrows
    void findAllHobbits200() {

        var endpoint = "/hobbits";

        mockMvc
                .perform(
                        MockMvcRequestBuilders.get(endpoint)
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("GET /hoobits -> HTTP 200 & 3 hobbity")
    @SneakyThrows
    void findAllHobbits3() {

        var endpoint = "/hobbits";
        var returnedListSize = 3;

        ResultActions resultActions = mockMvc
                .perform(
                        MockMvcRequestBuilders.get(endpoint)
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        var hobbitsFromDBAsJSON = resultActions.andReturn().getResponse().getContentAsString();

        List<Hobbit> hobbitsFromDBAsJava = objectMapper.readValue(hobbitsFromDBAsJSON, new TypeReference<>() {});

        assertAll("3-elentowa lista Hobbitów: Frodo, Bilbo, Penelope",
                () -> assertEquals(hobbitsFromDBAsJava.size(), returnedListSize),
                () -> assertEquals(hobbitsFromDBAsJava.get(0).getName(), "Frodo"),
                () -> assertEquals(hobbitsFromDBAsJava.get(1).getName(), "Bilbo"),
                () -> assertEquals(hobbitsFromDBAsJava.get(2).getName(), "Penelope")

        );

    }

}