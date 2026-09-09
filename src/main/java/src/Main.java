package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Family Tree!");

        Person sam = new Person("Sam", "", "Doe", 39, "male");
        Person mary = new Person("Mary", "", "Doe", 54, "female");
        Person mario = new Person("Mario", "", "Doe", 59, "male");

        Person lisa = new Person("Lisa", "", "Doe", 22, "female");
        Person calvin = new Person("Calvin", "", "Doe", 20, "male");

        Person steven = new Person("Steven", "", "Doe", 22, "male");
        Person rayen = new Person("Rayen", "", "Doe", 20, "male");

        System.out.println(sam.getName());
        System.out.println(sam.getMiddleName() + "optioneel");
        System.out.println(sam.getLastName());
        System.out.println(sam.getSex());
        System.out.println(sam.getAge());

        sam.addParents(mario, mary);
        lisa.addParents(mario, mary);
        calvin.addParents(mario, mary);

        System.out.println(sam.getSiblings());
        sam.addChild(steven);
        sam.addChild(rayen);
        System.out.println(sam.getChildren());

        System.out.println(sam.getPets());
        Pet bird = new Pet("Bob", 3, "Agaporis");
        bird.setOwner(sam);
        sam.addPet(sam, bird);
        System.out.println(sam.getPets());

        sam.setName("Sammy");
        sam.setMiddleName("The");
        sam.setLastName("Jones");
        sam.setSex("male");
        sam.setAge(50);
        sam.setMother(mary);
        sam.setFather(mario);
        sam.setSiblings(List.of(lisa, calvin));
        Pet bird1 = new Pet("Wappie", 3, "Agaporis");
        sam.setPets(List.of(bird, bird1));
        System.out.println(sam);


        System.out.println(mario.getGrandChildren());



        // Pet class

        System.out.println(bird1.getAge());
        System.out.println(bird1.getSpecies());
        System.out.println(bird1.getOwner());

        bird1.setName("Wappie");
        bird1.setAge(10);
        bird1.setSpecies("mix agapornis");
        bird1.setOwner(sam);
        System.out.println(bird1);

    }
}
