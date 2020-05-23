import java.util.Arrays;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        int a = 11;
        System.out.println(Integer.bitCount(a));
        System.out.println(Integer.toBinaryString(a));
        Vector<Integer> integers = new Vector<>();
        integers.add(3);
    }
        /*String a = "0002";
        System.out.println(Integer.parseInt(a));
        String[] as = {"abc", "ab", "abcd", "a"};
        Arrays.sort(as);
        for (int i = 0; i < as.length; i++) {
            System.out.println(as[i]);
        }*/
        /*String b = "ab";
        String c = "abc";
        System.out.println(b.compareTo(c));  //양수
        */
        /* for (int i = 0; i < 8; i++) {
            for (int j = i+1; j <9 ; j++) {
                for (int k = j+1 ; k < 10 ; k++) {
                    System.out.println(i+" "+j+" "+k);
                }
            }
        }*/


    /*public static void main(String[] args) {
        int[] array = {4,4,8,8};
        //array = E048(array);
        E048(array);
    }

    private static int[] E048(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] tmpArray = new int[array.length + 1];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                tmpArray[index++] = array[i];
            }
        }
        tmpArray[array.length] = -1;

        for (int i = 0; i < tmpArray.length - 1; i++) {
            if (tmpArray[i] != tmpArray[i + 1]) {
                arrayList.add(tmpArray[i]);
            } else {
                arrayList.add(tmpArray[i] * 2);
                i++;
            }
        }

        int[] newArray = new int[array.length];
        for (int i = 0; i < arrayList.size(); i++) {
            newArray[i] = arrayList.get(i);
        }

        

        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
        return newArray;
    }*/
}
