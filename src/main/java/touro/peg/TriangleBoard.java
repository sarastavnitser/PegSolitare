package touro.peg;

public class TriangleBoard {
    private boolean[] pegs = new boolean[15];
    private final int startingIndex;

    public TriangleBoard(int startingIndex) {
        this.startingIndex = startingIndex;
        for (int i = 0; i < pegs.length; i++)
        {
            pegs[i] = i != startingIndex;
        }
    }
    public boolean[] getPegs() {
        return pegs;
    }
    public void setPeg(int pegIndex, boolean pegStatus) {
        pegs[pegIndex] = pegStatus;
    }
    public boolean hasPeg(int index) {
        return pegs[index];
    }

    private int intPeg(int index) {
        return pegs[index] ? 1 : 0;
    }

    @Override
    public String toString() {
        return String.format("""
                            %d
                           %d %d
                          %d %d %d
                         %d %d %d %d
                        %d %d %d %d %d""",
                intPeg(0), intPeg(1), intPeg(2), intPeg(3),
                intPeg(4), intPeg(5), intPeg(6), intPeg(7),
                intPeg(8), intPeg(9), intPeg(10), intPeg(11),
                intPeg(12), intPeg(13), intPeg(14));
    }

    public boolean isWin(){
        int numTrues = 0;

        for (boolean peg : pegs)
        {
            if (peg) {
                numTrues++;
            }
        }
        return numTrues==1;
    }
    public boolean isBestWin(){
        return isWin() && pegs[startingIndex];
    }

}
