package task_1;

public class AlternateCaptial {
    public static void main(String[] args) {
        String input = "happy";
        String output = capitalizeAlternates(input);
        System.out.println(output);
    }

    public static String capitalizeAlternates(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(str.charAt(i)));
            } else {
                result.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        return result.toString();
    }
}
