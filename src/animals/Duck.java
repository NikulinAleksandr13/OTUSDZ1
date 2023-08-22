package animals;

public class Duck extends Animal implements IFying{

    public Duck(String name, int age, double weight, String color) {
        super(name, age, weight, color);
    }

    @Override
    public String say() {
        return "Кря";
    }


    public void fly() {
        System.out.println("Я лечу");
    }
}
