package SeobNote;

public class StringReverse {
    public static void main(String[] args) {
        String s = "abaskljqwkleasd";
        s = new StringBuffer(s).reverse().toString();
        System.out.println(s);
    }
}
