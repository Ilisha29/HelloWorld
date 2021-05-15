package BOJ._4Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> stringSet = new HashSet<>();
        int rep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < rep; i++) {
            stringSet.add(bufferedReader.readLine());
        }
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (String string : stringSet) {
            stringArrayList.add(string);
        }
        Collections.sort(stringArrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });
        for (String string : stringArrayList) {
            System.out.println(string);
        }
        bufferedReader.close();
    }
}
