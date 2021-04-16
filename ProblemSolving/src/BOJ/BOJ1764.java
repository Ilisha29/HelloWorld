package BOJ;

import java.util.*;

/*3 4
        ohhenrie
        charlie
        baesangwook
        obama
        baesangwook
        ohhenrie
        clinton*/
public class BOJ1764 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr3 = new ArrayList<>();
        for (int i = 0; i < first; i++) {
            arr1.add(scanner.next());
        }

        String[] temp = new String[arr1.size()];
        temp = arr1.toArray(temp);
        Collections.sort(arr1);
        for (int i = 0; i < second; i++) {
            String string = scanner.next();
            System.out.println(string);
            int index = Arrays.binarySearch(temp, string);
            if (index >= 0) {
                arr3.add(string);
            }
        }
        Collections.sort(arr3);
        System.out.println(arr3.size());
        for (int i = 0; i < arr3.size(); i++) {
            System.out.println(arr3.get(i));
        }
    }
}
