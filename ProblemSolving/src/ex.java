import java.util.*;

public class ex {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        Node[] array = new Node[10];
        Arrays.sort(array, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return 0;
            }
        });

        int[] array2 = new int[10];
        Arrays.fill(array2,10);

    }
}
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
