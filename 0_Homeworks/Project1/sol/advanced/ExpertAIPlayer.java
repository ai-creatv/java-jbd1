public class ExpertAIPlayer extends Player {
    static final int SCORE_WIN = 1;
    static final int SCORE_LOSE = -1;
    static final int SCORE_TIE = 0;

    @Override
    void play() {
        Point move = findBest();
        ticTacToe.play(move, this);
        System.out.printf("Expert AI Player %s's input is: (%d %d)\n", name, move.getX() + 1, move.getY() + 1);
    }

    Point findBest() {
        Board board = ticTacToe.observe();
        int maxScore = Integer.MIN_VALUE;
        Point bestMove = new Point(0, 0);
        char marker = findMarker(true);

        for (int x = 0; x < TicTacToe.BOARD_SIZE; x++) {
            for (int y = 0; y < TicTacToe.BOARD_SIZE; y++) {
                Point move = new Point(x, y);
                if (!board.isPossible(move)) {
                    continue;
                }

                board.setMark(move, marker);
                int score = miniMax(board, false);
                board.setMark(move, Board.BLANK);

                if (score > maxScore) {
                    maxScore = score;
                    bestMove = move;
                }
            }
        }

        return bestMove;
    }

    char findMarker(boolean isMyTurn) {
        boolean isPlayerOne = ticTacToe.getPlayerOne().equals(this);

        if ((isPlayerOne && isMyTurn) || (!isPlayerOne && !isMyTurn)) {
            return Board.MARKER_ONE;
        } else {
            return Board.MARKER_TWO;
        }
    }

    int miniMax(Board board, boolean isMyTurn) {
        int bestScore = isMyTurn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        char marker = findMarker(isMyTurn);

        switch(board.getWinnerStatus()) {
            case PLAYER_ONE:
                return ticTacToe.getPlayerOne().equals(this) ? SCORE_WIN : SCORE_LOSE;
            case PLAYER_TWO:
                return ticTacToe.getPlayerTwo().equals(this) ? SCORE_WIN : SCORE_LOSE;
            case TIE:
                return SCORE_TIE;
        }

        for (int x = 0; x < TicTacToe.BOARD_SIZE; x++) {
            for (int y = 0; y < TicTacToe.BOARD_SIZE; y++) {
                Point move = new Point(x, y);
                if (!board.isPossible(move)) {
                    continue;
                }

                board.setMark(move, marker);
                int score = miniMax(board, !isMyTurn);
                board.setMark(move, Board.BLANK);

                if (isMyTurn) {
                    if (score > bestScore) {
                        bestScore = score;
                    }
                } else {
                    if (score < bestScore) {
                        bestScore = score;
                    }
                }
            }
        }
        return bestScore;
    }
}
