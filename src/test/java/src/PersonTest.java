package src;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    //Getters
    @Test
    void getName() {
        // Arrange
        Person person = new Person("Sam", "", "Doe", 39, "male");

        //Act
        String name = person.getName();

        // Assert
        assertEquals("Sam", name);
    }

    @Test
    void getMiddleName(){
        // Arrange
        Person person = new Person("Sam", "", "Dekker", 39, "male");

        //Act
        String middleName = person.getMiddleName();

        // Assert
        assertEquals("", middleName );
    }

    @Test
    void getLastName(){
        // Arrange
        Person person = new Person("Sam", "", "Dekker", 39, "male");

        //Act
        String lastName = person.getLastName();

        // Assert
        assertEquals("Dekker", lastName);
    }

    @Test
    void getSex(){
        // Arrange
        Person person = new Person("Sam", "", "Dekker", 39, "male");

        //Act
        String sex = person.getSex();

        // Assert
        assertEquals("male", sex);

    }

    @Test
    void getAge(){
        //Arrange
        Person person = new Person("Sam", "Dekker",  23, "male");

        // Act
        int age = person.getAge();

        // Assert
        assertEquals(23, age);
    }

    @Test
    void getMother(){
        // Arrange
        Person mother = new Person("Jannie", "Pietersen",  54, "female");
        Person child = new Person("Tess", "Van Der", "Loo", 16, "female");
        child.setMother(mother);

        // Act
        Person mother1 = child.getMother();

        // Assert
        assertSame(mother, mother1);
    }

    @Test
    void getFather(){
        // Arrange
        Person father = new Person("Sam", "Bakker", 30, "male");
        Person child = new Person("Tom", "Bakker", 5, "male");

        child.setFather(father);

        // Act
        Person result = child.getFather();

        // Assert
        assertEquals(father, result);
    }

    @Test
    void getSiblings(){
        // Arrange
        Person father = new Person("Sam", "Bakker", 30, "male");
        Person child = new Person("Tom", "Bakker", 5, "male");
        Person child2 = new Person("Tom", "Bakker", 5, "male");

        father.addChild(child);
        father.addChild(child2);

        // Act
        List<Person> siblings = child.getSiblings();

        // Assert
        assertNotNull(siblings);
        assertInstanceOf(List.class, siblings);
        assertEquals(1, siblings.size());
        assertTrue(siblings.contains(child2));
    }










//
//
//
//    // Other tests
//    @Test
//    void testGetChilderenReturnsChilderenList(){
//        // Arrange
//        Person parent = new Person("John");
//        Person child1 = new Person("Alice");
//        Person child2 = new Person("Bob");
//
//        List<Person> childeren = new ArrayList<>();
//        childeren.add(child1);
//        childeren.add(child2);
//
//        parent.setChildren(childeren);
//
//        // Act
//        List<Person> result = parent.getChildren();
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertSame(child1, result.get(0));
//        assertSame(child2, result.get(1));
//
//    }



}