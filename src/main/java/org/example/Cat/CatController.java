package org.example.Cat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/v1/cat")

public class CatController {

    private final CatService catService;

    public CatController(CatService catService){
        this.catService = catService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Cat> getCat(@PathVariable int id){
        Cat cat = catService.findCat(id);
        if (cat == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cat);
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getAllCats(){
        return ResponseEntity.ok(catService.findAllCats());
    }

    @PostMapping
    public ResponseEntity<Cat> postCat(@RequestBody Cat cat){
        var result = catService.addCat(cat);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Cat>> postCats(@RequestBody List<Cat> cats){
        var result = catService.addCats(cats);
        return ResponseEntity.ok(result);
    }

    @PutMapping()
    public ResponseEntity<Cat> updateCat(@RequestBody Cat cat){
        var result = catService.updateCat(cat.id(),cat.name(),cat.age(),cat.color());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cat> deleteCat(@PathVariable int id){
        var result = catService.deleteCat(id);
        if (result==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

}
