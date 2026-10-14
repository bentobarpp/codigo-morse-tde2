import java.util.LinkedHashMap;
import java.util.Map;

public class MorseAlphabet {

    private static final Map<Character, String> CODE_MAP = new LinkedHashMap<>();

    static {
        CODE_MAP.put('A', ".-");
        CODE_MAP.put('B', "-...");
        CODE_MAP.put('C', "-.-.");
        CODE_MAP.put('D', "-..");
        CODE_MAP.put('E', ".");
        CODE_MAP.put('F', "..-.");
        CODE_MAP.put('G', "--.");
        CODE_MAP.put('H', "....");
        CODE_MAP.put('I', "..");
        CODE_MAP.put('J', ".---");
        CODE_MAP.put('K', "-.-");
        CODE_MAP.put('L', ".-..");
        CODE_MAP.put('M', "--");
        CODE_MAP.put('N', "-.");
        CODE_MAP.put('O', "---");
        CODE_MAP.put('P', ".--.");
        CODE_MAP.put('Q', "--.-");
        CODE_MAP.put('R', ".-.");
        CODE_MAP.put('S', "...");
        CODE_MAP.put('T', "-");
        CODE_MAP.put('U', "..-");
        CODE_MAP.put('V', "...-");
        CODE_MAP.put('W', ".--");
        CODE_MAP.put('X', "-..-");
        CODE_MAP.put('Y', "-.--");
        CODE_MAP.put('Z', "--..");
        CODE_MAP.put('0', "-----");
        CODE_MAP.put('1', ".----");
        CODE_MAP.put('2', "..---");
        CODE_MAP.put('3', "...--");
        CODE_MAP.put('4', "....-");
        CODE_MAP.put('5', ".....");
        CODE_MAP.put('6', "-....");
        CODE_MAP.put('7', "--...");
        CODE_MAP.put('8', "---..");
        CODE_MAP.put('9', "----.");
    }

    private MorseAlphabet() {
    }

    public static Map<Character, String> getCodeMap() {
        return CODE_MAP;
    }
}
