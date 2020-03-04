import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < rep; i++) {
            String[] strings = bufferedReader.readLine().split(",");
            System.out.println(Integer.parseInt(strings[0]) + Integer.parseInt(strings[1]));
        }
        bufferedReader.close();
    }
}
