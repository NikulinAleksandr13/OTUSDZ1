package fabrica;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import helper.TypeOfAnimalsData;

public class Fabric {
    private String name;
    private int age;
    private double weight;
    private String color;

    public Fabric(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Animal create(TypeOfAnimalsData typeOfAnimalsData) {
        switch (typeOfAnimalsData) {
            case CAT:
                return new Cat(name, age, weight, color);
            case DOG:
                return new Dog(name, age, weight, color);
            case DUCK:
                return new Duck(name, age, weight, color);
        }
        return null;
    }
}
