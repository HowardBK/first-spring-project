package catapp.Cat;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CatServiceUnitTest {
    private final CatRepository mockCatRepository = mock(CatRepository.class);
    private final CatService catService = new CatService(mockCatRepository);

    @Test
    void shouldCreateCat() {

        var cuteCat = new Cat("Finn", 4, "Black and yellow");

        when(mockCatRepository.save(any())).thenReturn(cuteCat);

        var result = catService.addCat(cuteCat);

        assert result.getName().equals("Finn");
        assert result.getAge() == 4;
        assert result.getColor().equals("Black and yellow");

    }

    @Test
    void shouldGetAllCats() {
        var cat1 = new Cat("Finn", 4, "Black and yellow");
        var cat2 = new Cat("Jordan", 2, "Grey");

        when(mockCatRepository.findAll()).thenReturn(List.of(cat1, cat2));

        var result = catService.findAllCats();

        assert result.size() == 2;
        assert result.get(0).getName().equals("Finn");
        assert result.get(1).getColor().equals("Grey");
    }


    @Test
    void shouldDeleteCat() {
        catService.deleteCat(1);

        verify(mockCatRepository).deleteById(1L);
    }
    //I thought this logic would work, but apparently doesn't work with Mockito
//    @Test
//    void shouldDeleteCat(){
//        var cat1 = new Cat(1L, "Finn", 4, "Black and yellow");
//        var cat2 = new Cat(2L, "Jordan", 2, "Grey");
//
//        when(mockCatRepository.findAll()).thenReturn(List.of(cat1,cat2));
//
//        var result1 = catService.findAllCats();
//        assert result1.size() == 2;
//        assert result1.get(0).getName().equals("Finn");
//        assert result1.get(1).getColor().equals("Grey");
//
//        catService.deleteCat(1);
//
//        var result2 = catService.findAllCats();
//
//        assert result2.size() == 1;
//
//        assert result2.get(0).getColor().equals("Grey");
//    }
}
