public class MorseTree {

    private final MorseNode rootNode;

    public MorseTree() {
        this.rootNode = new MorseNode('*');
    }

    // Heuristica do codigo morse: ponto desce para a esquerda, traco desce para a direita.
    public void insertLetter(char letter, String morseCode) {
        MorseNode currentNode = rootNode;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                if (currentNode.getLeftNode() == null) {
                    currentNode.setLeftNode(new MorseNode('.'));
                }
                currentNode = currentNode.getLeftNode();
            } else if (symbol == '-') {
                if (currentNode.getRightNode() == null) {
                    currentNode.setRightNode(new MorseNode('-'));
                }
                currentNode = currentNode.getRightNode();
            }
        }
        currentNode.setLetter(letter);
    }

    public char decodeLetter(String morseCode) {
        MorseNode currentNode = rootNode;
        for (char symbol : morseCode.toCharArray()) {
            currentNode = (symbol == '.') ? currentNode.getLeftNode() : currentNode.getRightNode();
            if (currentNode == null) {
                return '?';
            }
        }
        return currentNode.hasLetter() ? currentNode.getLetter() : '?';
    }

    public String decodeWord(String morseWord) {
        StringBuilder decodedWord = new StringBuilder();
        String[] morseGroups = morseWord.trim().split("/");
        for (int groupIndex = 0; groupIndex < morseGroups.length; groupIndex++) {
            String[] morseLetters = morseGroups[groupIndex].trim().split("\\s+");
            for (String morseLetter : morseLetters) {
                if (!morseLetter.isEmpty()) {
                    decodedWord.append(decodeLetter(morseLetter));
                }
            }
            if (groupIndex < morseGroups.length - 1) {
                decodedWord.append(' ');
            }
        }
        return decodedWord.toString();
    }

    public void printTree() {
        printSubtree(rootNode, 0);
    }

    private void printSubtree(MorseNode node, int depth) {
        if (node == null) {
            return;
        }
        printSubtree(node.getRightNode(), depth + 1);
        System.out.println("    ".repeat(depth) + describeNode(node));
        printSubtree(node.getLeftNode(), depth + 1);
    }

    private String describeNode(MorseNode node) {
        if (node == rootNode) {
            return "*";
        }
        return node.hasLetter() ? String.valueOf(node.getLetter()) : String.valueOf(node.getSymbol());
    }
}
