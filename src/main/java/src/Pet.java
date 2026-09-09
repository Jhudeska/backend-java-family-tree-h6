package src;

class  Pet {
    private String name;
    private int age;
    private String species;
    private Person owner;

    public Pet(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }


    // Getters
    public String getName() {

        return name;
    }
    public int getAge() {

        return age;
    }

    public String getSpecies() {

        return species;
    }

    public Person getOwner() {
        return owner;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", owner='" + (owner != null ? owner.getFullName() : "none") + '\'' +
                '}';
    }
}

