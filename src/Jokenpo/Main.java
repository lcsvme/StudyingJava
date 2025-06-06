package Jokenpo;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static List<String> options = Arrays.asList(
            "Pedra",
            "Papel",
            "Tesoura",
            "Sair"
    );

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static String getUserChoice(List<String> options, String title) {
        System.out.print("ESCOLHA UMA OPÇÃO: ");
        String choice = input.next();

        if (isInteger(choice)) {
            return choice;
        } else {
            System.out.println("Opção inválida! Tente novamente.");
            Interface.clearConsole(500);
            Interface.header(title, 42);
            Interface.menu(options);
            Interface.line((42));
            return getUserChoice(options, title);
        }
    }

    public static String getComputerChoice() {
        List<String> choices = Arrays.asList("Pedra", "Papel", "Tesoura");
        Random random = new Random();
        return choices.get(random.nextInt(choices.size()));
    }

    public static void determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals("4")) {
            Interface.clearConsole(350);
            Interface.header("Saindo do jogo...",42);
        } else {
            int userIndex = Integer.parseInt(userChoice) - 1;
            String userOption = options.get(userIndex);

            Interface.clearConsole(350);
            System.out.println("VOCÊ ESCOLHEU.. " + userOption.toUpperCase());
            System.out.println("O COMPUTADOR ESCOLHEU.. " + computerChoice.toUpperCase());

            if (userOption.equals(computerChoice)) {
                Interface.header("EMPATE!", 42);
            } else if ((userOption.equals("Pedra") && computerChoice.equals("Tesoura")) ||
                    (userOption.equals("Papel") && computerChoice.equals("Pedra")) ||
                    (userOption.equals("Tesoura") && computerChoice.equals("Papel"))) {
                Interface.header("VOCÊ GANHOU!", 42);
            } else {
                Interface.header("VOCÊ PERDEU!", 42);
            }

            System.out.print("APERTE QUALQUER COISA PARA CONTINUAR.. ");
            input.nextLine();
            Interface.clearConsole(500);
            playGame();
        }
    }

    public static void playGame() {
        Interface.header("PEDRA, PAPEL OU TESOURA", 42);
        Interface.menu(options);
        Interface.line((42));
        String userChoice = getUserChoice(options, "PEDRA, PAPEL OU TESOURA");
        String computerChoice = getComputerChoice();
        determineWinner(userChoice, computerChoice);
    }

    public static void main(String[] args) {
        List<String> options = Arrays.asList(
                "Jogar",
                "Sair"
        );

        Interface.header("JOKENPO", 42);
        Interface.menu(options);
        Interface.line(42);
        String choice = getUserChoice(options, "JOKENPO");
        if (choice.equals("1")) {
            Interface.clearConsole(350);
            playGame();
        } else if (choice.equals("2")) {
            Interface.clearConsole(350);
            Interface.header("Saindo do jogo...",42);
        }
    }
}
