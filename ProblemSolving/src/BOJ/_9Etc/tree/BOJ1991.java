package BOJ._9Etc.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991 {
    public static Tree[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        trees = new Tree[N];
        for (int i = 0; i < N; i++) {
            trees[i] = new Tree((char) (i + 'A'));
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char data = stringTokenizer.nextToken().charAt(0);
            char left = stringTokenizer.nextToken().charAt(0);
            char right = stringTokenizer.nextToken().charAt(0);
            if (left != '.') trees[data - 'A'].left = trees[left - 'A'];
            if (right != '.') trees[data - 'A'].right = trees[right - 'A'];
        }
        //전위 순회
        preorder(0);
        System.out.println();
        //중위 순회
        inorder(0);
        System.out.println();
        //후위 순회
        postorder(0);
        System.out.println();

        trees.notify();

        bufferedReader.close();
    }

    private static void postorder(int i) {
        if (trees[i].left != null) postorder(trees[i].left.data - 'A');
        if (trees[i].right != null) postorder(trees[i].right.data - 'A');
        System.out.print(trees[i].data);
    }

    private static void inorder(int i) {
        if (trees[i].left != null) inorder(trees[i].left.data - 'A');
        System.out.print(trees[i].data);
        if (trees[i].right != null) inorder(trees[i].right.data - 'A');
    }

    private static void preorder(int i) {
        System.out.print(trees[i].data);
        if (trees[i].left != null) preorder(trees[i].left.data - 'A');
        if (trees[i].right != null) preorder(trees[i].right.data - 'A');
    }
}

class Tree {
    char data;
    Tree left, right;

    Tree(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
