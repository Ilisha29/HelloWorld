package 연습할것;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList.size());
        /*for (int number : arrayList) {
            if (number % 2 == 0) {
                arrayList.remove(number);
            }
        }*/
        Iterator<Integer> integerIterator = arrayList.iterator();
        while (integerIterator.hasNext()) {
            if (integerIterator.next()% 2 == 0) {
                integerIterator.remove();
            }
        }
        for (int number : arrayList) {
            System.out.println(number);
        }
    }
}
