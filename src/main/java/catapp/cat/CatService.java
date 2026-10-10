package catapp.cat;

import catapp.owner.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;
    private final OwnerService ownerService;


    public CatService(CatRepository catRepository, OwnerService ownerService) {
        this.catRepository = catRepository;
        this.ownerService = ownerService;
    }

    public Cat addCat(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat findCat(long id) {
        return catRepository.findById(id).orElse(null);
    }

    public List<Cat> addCats(List<Cat> cats) {
        return catRepository.saveAll(cats);
    }

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public Cat updateCat(Cat cat) {
        return catRepository.save(cat);
    }

    public void deleteCat(long id) {
        catRepository.deleteById(id);
    }

    public Cat changeOwnership(OwnershipChangeRequest changeRequest) {
        var cat = catRepository.findById(changeRequest.catId()).orElse(null);
        var owner = ownerService.getOwner(changeRequest.ownerId());
        if (cat == null || owner == null) {
            return null;

        }

        cat.setOwner(owner);
        return catRepository.save(cat);

    }
}
