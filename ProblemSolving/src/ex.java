public class ex {
    public static void main(String[] args) {
        String string = "j";
        if (string.length() >= 2) {
            for (int i = 0; i < string.length() - 1; i++) {
                System.out.println(string.substring(i, i + 2));
            }
        }
    }
}
