import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player playerOne = new AIPlayer();
        Player playerTwo = new AIPlayer();

        playerOne.setName("Jack");
        playerTwo.setName("Jill");

        TicTacToe ticTacToe = new TicTacToe(playerOne, playerTwo);

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many wins to finish the game?: ");
        int N = scanner.nextInt();

        while (playerOne.getTotalWin() < N && playerTwo.getTotalWin() < N) {
            Player player = Math.random() > 0.5 ? playerOne : playerTwo;
            ticTacToe.initialize();

            System.out.println("-- Current Score --");
            System.out.printf(" %s %d : %d %s\n", playerOne.getName(), playerOne.getTotalWin(),
                    playerTwo.getTotalWin(), playerTwo.getName());
            System.out.println("-----------------");

            while (ticTacToe.observe().getWinnerStatus() == Board.WinnerStatus.NOT_FINISHED) {
                System.out.println();
                System.out.println("-- Current Board Status --");
                ticTacToe.observe().showBoard();
                System.out.println("--------------------------");

                player.play();
                player = player == playerOne ? playerTwo : playerOne;
            }

            System.out.println();
            System.out.println("-- Final Board Status --");
            ticTacToe.observe().showBoard();
            System.out.println("--------------------------");

            switch (ticTacToe.observe().getWinnerStatus()) {
                case PLAYER_ONE -> {
                    playerOne.win();
                    System.out.printf("%s has won!\n", playerOne.name);
                }
                case PLAYER_TWO -> {
                    playerTwo.win();
                    System.out.printf("%s has won!\n", playerTwo.name);
                }
                default -> System.out.println("The game ended tie.");
            }
            System.out.println();
        }

        System.out.println("-- Final Score --");
        System.out.printf(" %s %d : %d %s\n", playerOne.getName(), playerOne.getTotalWin(),
                                            playerTwo.getTotalWin(), playerTwo.getName());
        System.out.println("-----------------");
        System.out.println();
    }
}
