package animals;

public abstract class Animal {
    private String name;
    private int age;
    private double weight;
    private String color;
    private String years;


    public Animal(String name, int age, double weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        switch (age % 10) {
            case 1:
                if (age % 100 != 11) {
                    years = " год ";
                } else {
                    years = " лет ";
                }
                break;
            case 2:
            case 3:
            case 4:
                if ((age % 100 < 10 || age % 100 >= 20)) {
                    years = " года ";
                } else {
                    years = " лет ";
                }
                break;
            default:
                years = " лет ";
                break;
        }

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String say() {
        return "Я говорю";
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }


    @Override
    public String toString() {
        return "Привет! меня зовут " + name +
                ", мне " + age + years +
                "я вешу - " + weight + " кг, мой цвет - " + color;
    }
}
