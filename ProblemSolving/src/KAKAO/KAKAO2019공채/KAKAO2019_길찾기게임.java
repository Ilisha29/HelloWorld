package KAKAO.KAKAO2019공채;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 15 : 38 start
public class KAKAO2019_길찾기게임 {

    public static void main(String[] args) {
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};    // [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]];
        int[][] answer = solution(nodeinfo);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < nodeinfo.length; j++) {
                System.out.println(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int index;

    public static int[][] solution(int[][] nodeinfo) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodeList.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        Collections.sort(nodeList);
        Node root = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            addNode(root, nodeList.get(i));
        }
        int[][] answer = new int[2][nodeList.size()];
        index = 0;
        preOrder(answer, root);
        index = 0;
        postOrder(answer, root);
        return answer;
    }

    private static void postOrder(int[][] answer, Node root) {
        if (root != null) {
            postOrder(answer, root.Left);
            postOrder(answer, root.Right);
            answer[1][index++] = root.num;
        }
    }

    private static void preOrder(int[][] answer, Node root) {
        if (root != null) {
            answer[0][index++] = root.num;
            preOrder(answer, root.Left);
            preOrder(answer, root.Right);
        }
    }

    private static void addNode(Node root, Node node) {
        if (root.x > node.x) {
            if (root.Left == null) {
                root.Left = node;
            } else {
                addNode(root.Left, node);
            }
        } else {
            if (root.Right == null) {
                root.Right = node;
            } else {
                addNode(root.Right, node);
            }
        }
    }
}

class Node implements Comparable<Node> {
    public int num;
    public int x;
    public int y;
    public Node Left;
    public Node Right;

    public Node(int x, int y, int num) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    @Override //오름차순
    public int compareTo(Node node) {
        if (this.y > node.y) {
            return -1;
        } else if (this.y < node.y) {
            return 1;
        } else {
            return 0;
        }
    }
}
