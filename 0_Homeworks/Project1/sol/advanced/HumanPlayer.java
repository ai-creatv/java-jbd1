import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Please input %s's move (x y): ", name);

            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;

            Point move = new Point(x, y);
            if (ticTacToe.observe().isPossible(move)) {
                ticTacToe.play(move, this);
                break;
            }
        }
    }
}
