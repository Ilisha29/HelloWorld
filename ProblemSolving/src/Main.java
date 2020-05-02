public class Main {
    public static void main(String[] args) {

        String a = "sd";
        a = a.substring(1, a.length() - 1);
        System.out.println(a);

        String b = "0.2";
        System.out.println(Double.parseDouble(b));


        /* for (int i = 0; i < 8; i++) {
            for (int j = i+1; j <9 ; j++) {
                for (int k = j+1 ; k < 10 ; k++) {
                    System.out.println(i+" "+j+" "+k);
                }
            }
        }*/
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
