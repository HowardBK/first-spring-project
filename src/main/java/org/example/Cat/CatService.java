package org.example.Cat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository){
        this.catRepository = catRepository;
    }

    public Cat addCat(Cat cat){
        return catRepository.addCat(cat);
    }

    public Cat findCat(int id) {
        return catRepository.findCat(id);
    }

    public List<Cat> addCats(List<Cat> cats) {
        return  catRepository.addCatList(cats);
    }

    public List<Cat> findAllCats (){
        return catRepository.findAllCats();
    }

    public Cat updateCat (int id, String name, int age, String color){
        return catRepository.updateCat(id, name, age, color);
    }

    public Cat deleteCat (int id){
        return catRepository.deleteCat(id);
    }
}
