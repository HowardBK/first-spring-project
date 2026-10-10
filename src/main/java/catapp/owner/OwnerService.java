package catapp.owner;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;


    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    public Owner getOwner(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

}
