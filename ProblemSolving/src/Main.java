import com.sun.org.apache.xpath.internal.operations.Variable;

public class Main {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6,}, {7, 8, 9,}};
        a(array[1]);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void a (int[] b){
        b[2] = 9;
    }
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
