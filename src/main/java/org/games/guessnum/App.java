package org.games.guessnum;

import java.util.Random;
import java.util.Scanner;

public class App
{
    static Boolean game = true;
    public static void main(String[] args) {
        while (game) {
            int guess = randomize();
            int attempts = 10;

            System.out.println("Игра началась!\nПопробуйте угадать загаданное программой число\n" +
                    "На всё у вас есть 10 попыток\n" +
                    "Вводите ваши догадки в окно консоли");

            Scanner sc = new Scanner(System.in);

            while (attempts > 0) {
                int ans = 0;

                boolean cont = false;
                do {
                    try {
                        ans = sc.nextInt();
                        if (ans >= 0){
                            cont = true;
                        } else {
                            System.out.println("Введите число от 0 до 100");
                        }
                    } catch (Exception e) {
                        System.out.println("Введите число от 0 до 100");
                        sc.next();
                    }
                } while (!cont);

                if (ans == guess) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (ans > guess) {
                    System.out.println("Ваше число больше загаданного");
                    attempts--;
                } else if (ans < guess) {
                    System.out.println("Ваше число меньше загаданного");
                    attempts--;
                }
            }

            if (attempts == 0) {
                System.out.println("Game over");
            }

            restart();
        }
    }

    public static int randomize() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public static void restart() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Для перезапуска игры введите R или r, для окончания S или s");
        String answer = sc.next();
        if (answer.equals("R") || answer.equals("r")) {
        } else if (answer.equals("S") || answer.equals("s")) {
            System.out.println("Пока!");
            game = false;
        } else {
            restart();
        }
    }
}
