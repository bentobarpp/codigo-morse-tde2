public class MorseNode {

    private final char symbol;
    private char letter;
    private boolean hasLetter;
    private MorseNode leftNode;
    private MorseNode rightNode;

    public MorseNode(char symbol) {
        this.symbol = symbol;
        this.hasLetter = false;
    }

    public char getSymbol() {
        return symbol;
    }

    public char getLetter() {
        return letter;
    }

    public boolean hasLetter() {
        return hasLetter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
        this.hasLetter = true;
    }

    public MorseNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(MorseNode leftNode) {
        this.leftNode = leftNode;
    }

    public MorseNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(MorseNode rightNode) {
        this.rightNode = rightNode;
    }
}
