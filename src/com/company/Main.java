package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> warehouse = new HashMap<String, Integer>();
        String key;
        Integer value;
        Integer val;
        Integer dif;
        Integer d = 10;
        Integer amount;

        while (true) {
            System.out.print("Введите команду: ");
            String command = in.nextLine();
            if (command.equals("exit")) break;
            switch (command) {
                case ("add")://Добавление объекта
                    if (warehouse.size() == 10) {
                        System.out.println("Склад заполнен! Вы не можете больше добавить товар");
                    }
//
                    else {
                        System.out.println("Введите наименование товара: ");
                        key = in.nextLine();
                        warehouse.putIfAbsent(key, 0);
                        value = warehouse.get(key);
                        System.out.println("Введите колличество ");
                        value = in.nextInt();
                        val = warehouse.get(key);
                        amount = val + value;

                        if (amount <= 10) {
                            warehouse.put(key, amount);
                        } else {
                            dif = d - val;
                            System.out.println("Вы ввели количество товара " + key + " большее чем может вместить склад." +
                                    " Вы можете внести не более " + dif + " Повторите попытку.");
                        }
                    }

                    break;

                case ("search")://Просмотр количества товаров объекта
                    System.out.println("Введите наименование товара: ");
                    key = in.nextLine();
                    System.out.println("Колличество " + key + " " + warehouse.get(key));
                    break;
                case ("amount")://количество объектов на складе
                    System.out.println("Обещее колличество наименований на складе: " + warehouse.size());
                    break;

                case ("remove"):// Удаление объектов
                    System.out.println("Введите товар который хотите удалить: ");
                    key = in.nextLine();
                    warehouse.remove(key);
                    break;

                case ("set"):
                    System.out.println("Список видов товаров на складе: " + warehouse.keySet());
                    break;

            }

        }
        in.close();
    }
}

