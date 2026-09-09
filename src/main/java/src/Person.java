package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Person {
    private String name;
    private String middleName = "";
    private String lastName;;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();

    public Person(String name, String lastName,int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String middleName, String lastName, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }


// Getters
    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getSiblings() {
        return findSiblings();
    }

    public List<Person> getChildren() {

        return this.children;
    }

    public List<Pet> getPets() {
        return this.pets;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        if(age == 0){
            this.age = age;
        }else {
            this.age++;
        }
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public void setChildren(List<Person> children) {
        this.children = new ArrayList<>();
        if(children == null) {
            return;
        }
        this.children = new ArrayList<>();
        for (Person child: children) {
            addChild(child);
        }
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


    // helpers
    private List<Person> findSiblings() {
        var siblings = new HashSet<Person>();
        if (mother != null) {
            siblings.addAll(mother.getChildren());
        }
        if (father != null) {
            siblings.addAll(father.getChildren());
        }
        siblings.remove(this); // Deze persoon is geen sibling van zichzelf, dus verwijder deze persoon uit de siblings lijst.

        List<Person> siblingsList = new ArrayList<>(siblings);
        return siblingsList;
    }
    private String personName(Person person) {
        return person == null ? "null" : person.getFullName();
    }
    private List<String> personNames(List<Person> people) {
        return people.stream()
                .map(this::personName)
                .toList();
    }

    public String getFullName() {
        return String.join(" ",
                name == null ? "" : name,
                middleName == null ? "" : middleName,
                lastName == null ? "" : lastName
        ).trim();
    }

// Others
    public void addParents(Person father, Person mother){
        setMother(mother);
        mother.addChild(this);
        setFather(father);
        father.addChild(this);
    }

    public void addChild(Person child){
        if(!getChildren().contains(child))
        {
            getChildren().add(child);
        }
        if(sex.equals("male")){
            child.setFather(this);
        }
        if(sex.equals("female" )){
            child.setMother(this);
        }
    }

    public void addPet(Person person, Pet pet){
        List<Pet> pets = new ArrayList<>();
        if(person.getPets() != null){
            pets.addAll(person.getPets());
        }
        pets.add(pet);
        person.setPets(pets);
    }

    public List<Person> getGrandChildren(){
        List<Person> grandChildren = new ArrayList<>();
        for (Person children : getChildren()) {
            grandChildren.addAll(children.getChildren());
        }
        return grandChildren;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", mother=" + personName(mother) +
                ", father=" + personName(father) +
                ", children=" + personNames(children) +
                ", siblings=" + personNames(siblings) +
                ", pets=" + pets +
                '}';
    }
}