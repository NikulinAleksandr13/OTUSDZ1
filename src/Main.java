import animals.Animal;
import fabrica.Fabric;
import helper.CommandsData;
import helper.TypeOfAnimalsData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        String line = null;
        while (true) {
            System.out.println("Введите одну из команд: add, list, exit");
            Scanner scanner = new Scanner(System.in);
            line = scanner.nextLine().toUpperCase().trim();
            CommandsData commands;
            try {
                commands = CommandsData.valueOf(line);
            } catch (Exception ex) {
                System.out.println("Такой команды не существует!");
                continue;
            }

            switch (commands) {
                case ADD:
                    System.out.println("Какое животное добавить?\n cat,dog,duck");
                    Scanner scannerType = new Scanner(System.in);
                    String type = scanner.nextLine().toUpperCase().trim();
                    if (!type.equals("CAT") && !type.equals("DOG") && !type.equals("DUCK")) {
                        System.out.println("Такого животного нет в списке, введите имя из списка!");
                        break;
                    } else {
                        System.out.println("Какое имя?");
                        while (!scannerType.hasNext("[a-zA-Z]*$")) {
                            System.out.println("Введите только буквы!");
                            scannerType.next();
                        }
                        String name = scannerType.nextLine().trim();

                        System.out.println("Какой возраст?");
                        while (!scannerType.hasNextInt()) {
                            System.out.println("Введите только числа!");
                            scannerType.next();
                        }
                        int age = scannerType.nextInt();

                        System.out.println("Какой вес?");
                        while (!scannerType.hasNextDouble()) {
                            System.out.println("Введите целое число или число с разделителем запятая!");
                            scannerType.next();
                        }
                        double weight = scannerType.nextDouble();

                        System.out.println("Какой цвет?");
                        while (!scannerType.hasNext("[a-zA-Z]*$")) {
                            System.out.println("Введите только буквы!");
                            scannerType.next();
                        }
                        String color = scannerType.next().trim();

                        TypeOfAnimalsData typeOfAnimals;
                        try {
                            typeOfAnimals = TypeOfAnimalsData.valueOf(type);
                        } catch (Exception ex) {
                            System.out.println("Неверный тип животного!");
                            continue;
                        }

                        Animal animal = new Fabric(name, age, weight, color).create(typeOfAnimals);
                        animals.add(animal);
                        System.out.println(animal.say());
                        break;
                    }

                case LIST:
                    if (animals.size() == 0) {
                        System.out.println("В списке пока еще нет животных");
                    } else {
                        for (Animal an : animals) {
                            System.out.println(an);
                        }
                    }
                    break;

                case EXIT:
                    scanner.close();
                    System.exit(0);
            }

        }
    }
}