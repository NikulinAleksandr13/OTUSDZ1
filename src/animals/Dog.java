package animals;

public class Dog extends Animal{

    public Dog(String name, int age, double weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public String say() {
        return "Гав";
    }
}
