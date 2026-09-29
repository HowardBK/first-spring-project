package org.example.Cat;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CatRepository {
    private final List<Cat> cats= new ArrayList<>();
//    private final CatService catService;
    private int nextId = 1;

//    public CatRepository(CatService catService) {
//        this.catService = catService;
//    }

    public Cat addCat(Cat cat){
        Cat savedCat = new Cat(nextId,cat.name(),cat.age(),cat.color());
        nextId++;
        cats.add(savedCat);
        return savedCat;
    }

    public Cat findCat(int id) {

        for (Cat cat : cats) {
            if (cat.id() == id) {
                return cat;
            }
        }
            System.out.println("Ingen katt lagret med id: " + id);
            return null;
    }

    public List<Cat> addCatList(List<Cat> newCats) {
        List<Cat> savedCats = new ArrayList<>();
        for (Cat cat : newCats){
            Cat savedCat = new Cat(nextId, cat.name(), cat.age(), cat.color());
            nextId++;
            cats.add(savedCat);
            savedCats.add(savedCat);
        }
        return savedCats;
    }

    public List<Cat> findAllCats() {
            return new ArrayList<>(cats);
    }

    public Cat updateCat(int id, String name, int age, String color){
        for (int i = 0; i < cats.size() ; i++) {
            Cat cat = cats.get(i);
            if (cat.id() == id){
                Cat updatedCat = new Cat(cat.id(), name, age, color);
                cats.set(i, updatedCat);
                return updatedCat;
         }
        }
        System.out.println("Ingen katt lagret med id: " + id);
        return null;
    }

    public Cat deleteCat(int id) {

        for (int i = 0; i < cats.size(); i++) {

            if (cats.get(i).id()==id){
                return cats.remove(i);
            }
        }
        System.out.println("Ingen katt lagret med id: " + id);
        return null;
    }

}
