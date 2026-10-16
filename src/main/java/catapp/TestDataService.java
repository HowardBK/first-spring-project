package catapp;

import catapp.cat.Cat;
import catapp.cat.CatService;
import catapp.owner.Owner;
import catapp.owner.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/testdata")
public class TestDataService {
    private final CatService catService;
    private final OwnerService ownerService;

    public TestDataService(CatService catService, OwnerService ownerService) {
        this.catService = catService;
        this.ownerService = ownerService;
    }

    //This PostMapping was created to demonstrate that you have to add the owner to the cat
    // and not add the cat to the owner.
    //It is supposed to not work.

//    @PostMapping
//    public ResponseEntity<String> createSampleData() {
//
//        var createdCat = catService.addCat(new Cat(
//                "Fluffyboy", 7, "Orange"
//        ));
//
//        var createdOwner = ownerService.createOwner(new Owner(
//                "Alfred", "Fredson", "Alfredson@hotmail.com"
//        ));
//
//        createdOwner.setCats(List.of(createdCat));
//        ownerService.updateOwner(createdOwner);
//        return ResponseEntity.ok("Hey it worked, owner created");
//    }

}
