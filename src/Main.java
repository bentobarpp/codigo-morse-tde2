import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MorseTree morseTree = buildMorseTree();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String option = scanner.nextLine().trim();
            switch (option) {
                case "1" -> showTree(morseTree);
                case "2" -> decodeWord(morseTree, scanner);
                case "3" -> encodeWord(scanner);
                case "4" -> playSound(scanner);
                case "0" -> running = false;
                default -> System.out.println("Opcao invalida.\n");
            }
        }
        scanner.close();
    }

    private static MorseTree buildMorseTree() {
        MorseTree morseTree = new MorseTree();
        for (Map.Entry<Character, String> entry : MorseAlphabet.getCodeMap().entrySet()) {
            morseTree.insertLetter(entry.getKey(), entry.getValue());
        }
        return morseTree;
    }

    private static void printMenu() {
        System.out.println("===== Codigo Morse - Arvore Binaria de Busca =====");
        System.out.println("1 - Mostrar a arvore binaria de busca");
        System.out.println("2 - Decodificar uma palavra em Morse");
        System.out.println("3 - Codificar uma palavra para Morse");
        System.out.println("4 - Tocar o codigo Morse em som (bonus)");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void showTree(MorseTree morseTree) {
        System.out.println("\nLegenda: ramo de cima = traco (-)  |  ramo de baixo = ponto (.)\n");
        morseTree.printTree();
        System.out.println();
    }

    private static void decodeWord(MorseTree morseTree, Scanner scanner) {
        System.out.print("\nDigite a palavra em Morse (letras separadas por espaco, ex: .... . .-.. .-.. ---): ");
        String morseInput = scanner.nextLine();
        String decodedWord = morseTree.decodeWord(morseInput);
        System.out.println("Palavra decodificada: " + decodedWord + "\n");
    }

    private static void encodeWord(Scanner scanner) {
        System.out.print("\nDigite a palavra a ser codificada: ");
        String textInput = scanner.nextLine().toUpperCase();
        StringBuilder morseResult = new StringBuilder();
        for (char letter : textInput.toCharArray()) {
            if (letter == ' ') {
                morseResult.append("/ ");
                continue;
            }
            String morseCode = MorseAlphabet.getCodeMap().get(letter);
            morseResult.append(morseCode == null ? "?" : morseCode).append(" ");
        }
        System.out.println("Codigo Morse: " + morseResult.toString().trim() + "\n");
    }

    private static void playSound(Scanner scanner) {
        System.out.print("\nDigite a palavra em Morse para tocar (ex: .... . .-.. .-.. ---): ");
        String morseInput = scanner.nextLine();
        try {
            new MorseSoundPlayer().playMorseWord(morseInput);
        } catch (Exception soundException) {
            System.out.println("Nao foi possivel reproduzir o som: " + soundException.getMessage());
        }
        System.out.println();
    }
}
