package src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Person {
    private String name;
    private String middleName = "";
    private String lastName;
    private int age;
    private String sex;
    private Person mother;
    private Person father;
    private List<Person> children = new ArrayList<>();
    private List<Person> siblings;
    private List<Pet> pets;

    public Person(String name, String lastName, String sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name, String middleName, String lastName, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Person> getchildren() {
        return this.children;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setChilderen(List<Person> childeren) {
        this.children = childeren;
    }





    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public List<Person> getSiblings() {
        return findSiblings();
    }

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

    public List<Person> getChildren() {
        return this.children;
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
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
        if(sex == "male" ){
            child.setFather(this);
        }
        if(sex == "female" ){
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
}