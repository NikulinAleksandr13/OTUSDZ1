import animals.Animal;
import animals.Cat;
import animals.Dog;
import animals.Duck;
import helper.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        String line = null;
        while (line != "EXIT") {
            System.out.println("Введите одну из команд: add, list, exit");
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine().toUpperCase().trim();

            switch (line) {
                case "ADD":
                    System.out.println("Какое животное добавить?\n cat,dog,duck");
                    Scanner scannerType = new Scanner(System.in);
                    String type = scanner.nextLine().toUpperCase().trim();
                    if (!type.equals("CAT") && !type.equals("DOG") && !type.equals("DUCK")) {
                        System.out.println("Такого животного нет в списке, попробуйте заново");
                        break;
                    } else {
                        System.out.println("Какое имя?");
                        Scanner scannerName = new Scanner(System.in);
                        while (!scannerName.hasNext("[a-zA-Z]*$")) {
                            System.out.println("Введите только буквы!");
                            scannerName.next();
                        }
                        String name = scannerName.nextLine().trim();

                        System.out.println("Какой возраст?");
                        Scanner scannerAge = new Scanner(System.in);
                        while (!scannerAge.hasNextInt()) {
                            System.out.println("Введите только числа!");
                            scannerAge.next();
                        }
                        int age = scannerAge.nextInt();


                        System.out.println("Какой вес?");
                        Scanner scannerWeight = new Scanner(System.in);
                        while (!scannerWeight.hasNextDouble()) {
                            System.out.println("Введите целое число или число с разделителем запятая!");
                            scannerWeight.next();
                        }
                        double weight = scannerWeight.nextDouble();

                        System.out.println("Какой цвет?");
                        Scanner scannerColor = new Scanner(System.in);
                        while (!scannerColor.hasNext("[a-zA-Z]*$")) {
                            System.out.println("Введите только буквы!");
                            scannerColor.next();
                        }
                        String color = scannerColor.next().trim();


                        switch (type) {
                            case "CAT":
                                animals.add(new Cat(name, age, weight, color));
                                System.out.println(new Cat(name, age, weight, color).say());
                                continue;
                            case "DOG":
                                animals.add(new Dog(name, age, weight, color));
                                System.out.println(new Dog(name, age, weight, color).say());
                                continue;
                            case "DUCK":
                                animals.add(new Duck(name, age, weight, color));
                                System.out.println(new Duck(name, age, weight, color).say());
                                continue;
                        }
                    }


                case "LIST":
                    if (animals.size()==0){
                        System.out.println("В списке пока еще нет животных");
                    } else {
                        for (Animal an : animals) {
                            System.out.println(an);
                        }
                    } break;

                case "EXIT":
                    line = "EXIT";
                    break;
            }

        }
    }
}