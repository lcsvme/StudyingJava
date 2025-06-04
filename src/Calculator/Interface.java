package Calculator;

import java.util.List;

public class Interface {
    public static void clearConsole(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void printCentered(String text, int width) {
        if (text == null || width <= text.length()) {
            System.out.println(text);
            return;
        }

        int padding = (width - text.length()) / 2;
        String pad = " ".repeat(padding);
        System.out.println(pad + text);
    }

    public static void line(Integer size) {
        System.out.println("=".repeat((size)));
    }

    public static void header(String title, Integer size) {
        line(size);
        printCentered(title, size);
        line(size);
    }

    public static void menu(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("[%d]. %s%n", i + 1, options.get(i));
        }
    }
}
