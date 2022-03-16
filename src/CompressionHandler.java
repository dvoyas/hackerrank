
/**
 * "aaaa" output "a4"
 * "aabbaa" -> "a2b2a2"
 * "abc" -> "abc"
 */

public class CompressionHandler {
//    @AutoWired
//    InputData inputData;

    static String compress(String s) {
//        String s = inputData.nextCompression();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res = res.append(s.charAt(i));
            if (i < s.length() - 1) {
                int comOfChar = 1;
                int newI = i;
                for (int j = i + 1; j < s.length(); j++)
                    if (s.charAt(newI) == s.charAt(j)) {
                        comOfChar++;
                        i++;
                    } else break;
                if (comOfChar > 1) {
                    res.append(comOfChar);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] str){
        System.out.println(compress("aaddaa"));
    }
}
