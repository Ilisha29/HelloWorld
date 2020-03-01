import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[279];
        for (int i = 0; i <  arr.length; i++) {
            arr[i]= scanner.nextLine();
        }

        for (int i = 0; i < arr.length ; i++) {
            System.out.println("'"+arr[i]+"',");
        }
    }
}
