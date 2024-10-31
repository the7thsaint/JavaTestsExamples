package ru.testingisgood.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaSyntaxTasks {

    public static void main(String[] args) {
        /*
         Задача: Создать массив чисел типа int размером 7. Заполнить массив числами от 1 до 7.
         Используя цикл перебрать массив с выводом чисел на экран. Если значение массива = 5 - прервать вывод.
        */
        System.out.println("\n---------------FIRST TASK---------------\n");
        int[] currentArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        for (int j : currentArray) {
            if (j == 5) break;
            System.out.println(j);
        }

        /*
         Задача: В стране XYZ население равно 10 миллионов человек.
         Рождаемость составляет 14 человек на 1000 человек, смертность - 8 человек.
         Рассчитайте, какая численность населения будет через 10 лет, принимая во внимание,
         что показатели рождаемости и смертности постоянны.
        */
        System.out.println("\n---------------SECOND TASK---------------\n");
        int population = 10000000;
        int born = 14;
        int death = 8;
        int dif = born - death;
        for (int i = 1; i <= 10; i++) {
            population += population * dif / 1000;
        }
        System.out.println(population);

        /*
        Задача: Создать коллекцию ArrayList с типом данных String, заполнить коллецию 10 значениями,
        вывести на экран все значения с помощью foreach
        */
        System.out.println("\n---------------THIRD TASK---------------\n");
        List<String> currentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            currentList.add("data" + new Random().nextInt());
        }

        currentList.forEach(System.out::println);
    }
}

