import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(areAnagrams("кулона", "клоун"));
    }

    //TODO: Даны две строки. Необходимо определить, являются ли они анаграммами друг друга.
    // Для этого можно создать HashMap, где ключами будут символы из одной строки, а значениями - количество их встречаемости.
    // После этого можно пройти по второй строке и для каждого символа уменьшать его количество в HashMap.
    // Если после этого все значения в HashMap равны нулю, то строки являются анаграммами.

    static public boolean areAnagrams(String word1, String word2) {
        HashMap<Character, Integer> letters = new HashMap<>();
        int value;
        for (char ch : word1.toCharArray()) {
            if (letters.containsKey(ch)) {
                value = letters.get(ch);
            } else {
                value = 0;
            }
            letters.put(ch, ++value);
        }

        for (char ch : word2.toCharArray()) {
            if (letters.containsKey(ch)) {
                letters.replace(ch, letters.get(ch) - 1);
            }
        }

        for (int currentValue : letters.values()) {
            if (currentValue > 0) {
                return false;
            }
        }
        return true;
    }
}