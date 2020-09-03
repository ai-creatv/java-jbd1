public abstract class Player {
    int totalWin = 0;
    String name = "default name";
    TicTacToe ticTacToe;

    public void win() {
        totalWin++;
    }

    public int getTotalWin() {
        return totalWin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TicTacToe getTicTacToe() {
        return ticTacToe;
    }

    public void setTicTacToe(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    abstract void play();
}
