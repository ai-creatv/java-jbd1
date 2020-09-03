public class TicTacToe implements Initializable, Observable<Board>, Playable<Point> {
    static final int BOARD_SIZE = 3;
    protected final Board board = new Board(BOARD_SIZE);
    protected Player playerOne, playerTwo;

    public TicTacToe(Player playerOne, Player playerTwo) {
        setPlayerOne(playerOne);
        setPlayerTwo(playerTwo);
    }

    public void setPlayerOne(Player player) {
        playerOne = player;
        playerOne.setTicTacToe(this);
    }

    public void setPlayerTwo(Player player) {
        playerTwo = player;
        playerTwo.setTicTacToe(this);
    }

    @Override
    public void initialize() {
        board.initialize();
    }

    @Override
    public Board observe() {
        return board;
    }

    @Override
    public boolean play(Point move, Player player) {
        if (!board.isPossible(move)) {
            return false;
        } else {
            char mark = player == playerOne ? Board.MARKER_ONE : Board.MARKER_TWO;
            board.setMark(move, mark);
            return true;
        }
    }
}
