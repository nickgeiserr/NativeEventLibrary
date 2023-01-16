package EventSystem.Modules;

public class StringExtension {
    public static String reverse(String input) {
        StringBuilder result = new StringBuilder();
        for(int i = input.length() - 1; i >= 0; i--) {
            result.append(input.charAt(i));
        }

        return result.toString();
    }

    public static String toPigLatin(String input) {
        StringBuilder result = new StringBuilder();
        for(int i = input.length() - 1; i > 0; i--) {
            result.append(input.charAt(i));
        }

        result = new StringBuilder(StringExtension.reverse(result.toString()));

        result.append(input.charAt(0));
        result.append("ay");

        result = new StringBuilder(result.toString().toLowerCase());

        String up = result.substring(0, 1).toUpperCase() + result.substring(1);

        return up;
    }
}
