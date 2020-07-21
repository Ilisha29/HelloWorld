package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine().trim();
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (int i = 0; i < arr.length; i++) {
            if (string.contains(arr[i])) {
                string = string.replaceAll(arr[i], " ");
            }
        }
        System.out.println(string.length());
        bufferedReader.close();
    }
}
