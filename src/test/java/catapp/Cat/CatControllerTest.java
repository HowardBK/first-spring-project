package catapp.Cat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest
public class CatControllerTest {

    @Autowired
    private CatController controller;

    @MockitoBean
    private CatService catService;

    @BeforeEach
    public void setup() {
        var cat1 = new Cat("Hero", 4, "Orange, black and white");
        var cat2 = new Cat("Marco", 3, "Orange");

        when(catService.findAllCats()).thenReturn(List.of(cat1, cat2));


    }

    @Test
    void shoulGetCats() {
        var result = controller.getAllCats();
        assert result.getBody().size() == 2;
    }


}
