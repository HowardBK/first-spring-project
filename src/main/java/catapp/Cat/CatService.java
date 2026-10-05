package catapp.Cat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public Cat addCat(Cat cat){
        return catRepository.save(cat);
    }

    public Cat findCat(long id) {
        return catRepository.findById(id).orElse(null);
    }

    public List<Cat> addCats(List<Cat> cats) {
        return  catRepository.saveAll(cats);
    }

    public List<Cat> findAllCats (){
        return catRepository.findAll();
    }

    public Cat updateCat (Cat cat){
        return catRepository.save(cat);
    }

    public void deleteCat (long id){
        catRepository.deleteById(id);
    }
}
