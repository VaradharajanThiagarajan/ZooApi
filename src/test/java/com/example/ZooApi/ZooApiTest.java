package com.example.ZooApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooApiTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addAnimalTest()
    {
        Animal a1 = new Animal("Dog","walking");
        Zoo z1 = new Zoo();
        //z1.addAnimal(a1);
        mockMvc.perform(post("/animal")
                .content(objectMapper.writeValueAsString(a1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

    }
}
