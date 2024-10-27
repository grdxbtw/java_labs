public class Main {

    public static String reverseEverySecondWord(String sentence) {

        String[] words = sentence.split(" ");

        for (int i = 1; i < words.length; i += 2) {
            words[i] = reverseWordWithoutPunctuation(words[i]);
        }

        return String.join(" ", words);
    }


    private static String reverseWordWithoutPunctuation(String word) {

        char[] characters = word.toCharArray();
        int left = 0, right = characters.length - 1;

        while (left < right) {

            if (!Character.isLetterOrDigit(characters[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(characters[right])) {
                right--;
            } else {

                char temp = characters[left];
                characters[left] = characters[right];
                characters[right] = temp;
                left++;
                right--;
            }
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        String sentence = "This is a simple example string, to check the function: {reverseEverySecondWord}!";
        String result = reverseEverySecondWord(sentence);
        System.out.println(result);
    }
}
