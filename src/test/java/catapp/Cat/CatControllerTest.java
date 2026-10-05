package catapp.Cat;

    import org.junit.jupiter.api.BeforeEach;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
    import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest
public class CatControllerTest {

        @Autowired
        private CatController controller;

        @MockitoBean
        private CatService catService;

        @BeforeEach
        public void setup(){
            var cat1 = new Cat("Pusen", 4, "Orange, black and white");

        }



}
