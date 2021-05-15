package BOJ._1Greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1092__ {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> craneList = new ArrayList<>();
        ArrayList<Integer> boxList = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            craneList.add(a);
        }
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            boxList.add(a);
        }
        Descending descending = new Descending();
        Collections.sort(craneList, descending);
        Collections.sort(boxList, descending);
        int count = 0;
        if(boxList.get(0) > craneList.get(0))
            System.out.println(-1);
        else{
            while(boxList.size() != 0){
                int idx = 0;
                int tmp = 0;
                while(idx < n){
                    if(tmp == boxList.size())
                        break;
                    if(boxList.get(tmp) <= craneList.get(idx)){
                        boxList.remove(tmp);
                        idx++;
                    }
                    else if(boxList.get(tmp) > craneList.get(idx)){
                        tmp++;
                    }
                }
                count++;
            }
            System.out.println(count);
        }
        sc.close();
    }
}
class Descending implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}