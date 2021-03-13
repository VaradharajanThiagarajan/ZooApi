package com.example.ZooApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooApiTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addAnimalTest() throws Exception {
        AnimalDto a1 = new AnimalDto("Dog","walking");
        Zoo z1 = new Zoo();
        //z1.addAnimal(a1);
        mockMvc.perform(post("/animal")
                .content(objectMapper.writeValueAsString(a1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

    }

    @Test
    public void getAnimalsTest() throws Exception {

        //setup
        AnimalDto a1 = new AnimalDto("Dog","walking");
        AnimalDto a2 = new AnimalDto("Bird","flying");
        Zoo z1 = new Zoo();
        //z1.addAnimal(a1);
        mockMvc.perform(post("/animal")
                .content(objectMapper.writeValueAsString(a1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(post("/animal")
                .content(objectMapper.writeValueAsString(a2))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
        mockMvc.perform(get("/listAnimals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0].name").value("Dog"));




    }
}
