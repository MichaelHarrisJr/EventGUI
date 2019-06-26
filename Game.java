package project3;

public interface Game {  // interface
    public abstract String getWinner();  // toss coin, if tie
    public abstract String getLoser();
    public abstract int    getWinnerScore();
    public abstract int    getLoserScore();
}  // interface Game