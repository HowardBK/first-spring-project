package catapp.owner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {
    private final OwnerService ownerService;


    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<Owner>> getOwners() {
        return ResponseEntity.ok(ownerService.getOwners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwner(@PathVariable Long id) {
        return ResponseEntity.ok(ownerService.getOwner(id));
    }

    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok(ownerService.createOwner(owner));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.ok("Owner with id: " + id + " deleted");
    }
}
