package catapp.Cat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.json.JsonMapper;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class CatIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JsonMapper jsonMapper;

    @Test
    void shouldCreateTwoCats() throws Exception {
        var cat1 = new Cat("Finn", 4, "Black and yellow");
        var cat2 = new Cat("Jordan", 2, "Grey");

        var response = mockMvc.perform(post("/api/v1/cat")
                        .content(jsonMapper.writeValueAsString(cat1))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Finn")))
                .andReturn().getResponse().getContentAsString();

        long id = jsonMapper.readTree(response).get("id").asLong();

        mockMvc.perform(get("/api/v1/cat/" + id)).andExpect(jsonPath("$.name", is("Finn")));

        var response2 = mockMvc.perform(post("/api/v1/cat")
                        .content(jsonMapper.writeValueAsString(cat2))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Jordan")))
                .andReturn().getResponse().getContentAsString();

        long id2 = jsonMapper.readTree(response2).get("id").asLong();

        mockMvc.perform(get("/api/v1/cat/" + id2)).andExpect(jsonPath("$.name", is("Jordan")));


//        mockMvc.perform(get("/api/v1/cat"))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(2)));


    }

}
