package catapp.cat;

import catapp.owner.Owner;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Cat {

        @Id
        @GeneratedValue(generator = "catgen", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "catgen", initialValue = 1, allocationSize = 1, sequenceName = "cat_seq")

        private Long catId;
        private String catName;
        private String catColor;
        private int catAge;

        @ManyToOne
        @JoinColumn(name = "owner_id")
        @JsonIgnoreProperties("cats")
        private Owner owner;

    public Cat(){

    }


    public Cat(Long catId, String catName, int catAge, String catColor) {
        this.catId = catId;
        this.catName = catName;
        this.catAge = catAge;
        this.catColor = catColor;
    }
    public Cat(String catName, int catAge, String catColor) {
        this.catName = catName;
        this.catAge = catAge;
        this.catColor = catColor;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long id) {
        this.catId = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatAge() {
        return catAge;
    }

    public void setCatAge(int age) {
        this.catAge = age;
    }

    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String color) {
        this.catColor = color;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
