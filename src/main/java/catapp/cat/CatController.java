package catapp.cat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cat")

public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Cat> getCat(@PathVariable long id) {
        Cat cat = catService.findCat(id);
        if (cat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cat);
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getAllCats() {
        return ResponseEntity.ok(catService.findAllCats());
    }

    @PostMapping
    public ResponseEntity<Cat> postCat(@RequestBody Cat cat) {
        var result = catService.addCat(cat);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Cat>> postCats(@RequestBody List<Cat> cats) {
        var result = catService.addCats(cats);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/change")
    public ResponseEntity<Cat> changeOwnership(@RequestBody OwnershipChangeRequest ownershipChangeRequest){
        if (ownershipChangeRequest.catId() == null || ownershipChangeRequest.ownerId() == null) {
            return ResponseEntity.notFound().build();
        }

        var result = catService.changeOwnership(ownershipChangeRequest);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping()
    public ResponseEntity<Cat> updateCat(@RequestBody Cat cat) {
        var result = catService.updateCat(cat);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCat(@PathVariable long id) {
        catService.deleteCat(id);

        return ResponseEntity.ok("Cat with id: " + id + " deleted.");
    }

}
