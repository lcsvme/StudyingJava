package Jokenpo;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int wins = 0;
    static int losses = 0;

    static List<String> options = Arrays.asList(
            "Pedra",
            "Papel",
            "Tesoura",
            "Sair"
    );

    static List<String> menuOptions = Arrays.asList(
            "Jogar",
            "Sair"
    );

    static List<String> gameOptions = Arrays.asList(
            "Partida Única",
            "Melhor de 3",
            "Melhor de 5",
            "Sair"
    );

    public static String getUserChoice(List<String> options, String title) {
        System.out.print("ESCOLHA UMA OPÇÃO: ");
        String choice = input.next();

        if (Interface.isInteger(choice)) {
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
                Interface.scoreboard(wins, losses);
            } else if ((userOption.equals("Pedra") && computerChoice.equals("Tesoura")) ||
                    (userOption.equals("Papel") && computerChoice.equals("Pedra")) ||
                    (userOption.equals("Tesoura") && computerChoice.equals("Papel"))) {
                Interface.header("VOCÊ GANHOU!", 42);
                wins = wins + 1;
                Interface.scoreboard(wins, losses);
            } else {
                Interface.header("VOCÊ PERDEU!", 42);
                losses = losses + 1;
                Interface.scoreboard(wins, losses);
            }
        }
    }

    public static void playGame(String gameMode) {
        if  (gameMode.equals("1")) {
            matchResult(gameMode, 1);
        }  else if (gameMode.equals("2")) {
            matchResult(gameMode, 2);
        } else if (gameMode.equals("3")) {
            matchResult(gameMode, 3);
        } else {
            Interface.clearConsole(500);
            Interface.header("SAINDO..", 42);
        }
    }

    public static void startMatch() {
        Interface.header("PEDRA, PAPEL OU TESOURA", 42);
        Interface.menu(options);
        Interface.line((42));
        String userChoice = getUserChoice(options, "PEDRA, PAPEL OU TESOURA");
        String computerChoice = getComputerChoice();
        determineWinner(userChoice, computerChoice);
    }

    public static void matchResult(String gameMode, Integer limit ) {
        if (wins != limit && losses != limit) {
            Interface.clearConsole(500);
            startMatch();
            playGame(gameMode);
        }  else {
            Interface.clearConsole(500);
            Interface.printCentered("FIM DA PARTIDA!", 42);
            Interface.scoreboard(wins, losses);
            main(new String[0]);
        }
    }

    public static void main(String[] args) {

        wins = 0;
        losses = 0;

        Interface.header("JOKENPO", 42);
        Interface.menu(menuOptions);
        Interface.line(42);
        String choice = getUserChoice(options, "JOKENPO");

        if (choice.equals("1")) {
            Interface.clearConsole(350);
            Interface.header("MODOS DE JOGO", 42);
            Interface.menu(gameOptions);
            Interface.line((42));
            String gameMode = getUserChoice(gameOptions, choice);
            playGame(gameMode);
        } else if (choice.equals("2")) {
            Interface.clearConsole(350);
            Interface.header("SAINDO..",42);
        }
    }
}
