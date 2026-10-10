package catapp.cat;

public record OwnershipChangeRequest(
    Long ownerId,
    Long catId
) {

}
