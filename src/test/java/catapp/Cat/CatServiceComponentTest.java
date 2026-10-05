package catapp.Cat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CatServiceComponentTest {

    @Autowired
    private CatService catService;

    @Test
    void shouldCreateCat(){
        var result = catService.addCat(new Cat("Melli", 2, "Orange and white"));

        assert result.getName().equals("Melli");

        var catList = catService.findAllCats();
        assert !catList.isEmpty();
    }
}
