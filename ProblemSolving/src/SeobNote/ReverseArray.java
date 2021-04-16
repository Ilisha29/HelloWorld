package SeobNote;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {9, 8, 2, 1, 4, 3, 6, 6};
        reverse_array(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void reverse_array(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
    }
}
