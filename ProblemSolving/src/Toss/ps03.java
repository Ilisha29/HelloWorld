package Toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ps03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (hashMap.containsKey(strings[i])) {
                System.out.print(hashMap.get(strings[i]));
            } else {
                //int num = Function.compute(Integer.parseInt(strings[i]));
                /*hashMap.put(strings[i], num);
                System.out.print(num);*/
            }

            if (i != strings.length - 1) {
                System.out.print(" ");
            }
        }
        bufferedReader.close();
    }
}
