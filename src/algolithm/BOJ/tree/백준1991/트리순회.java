package algolithm.BOJ.tree.백준1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회 {
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        tree = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';

            // .에서 -'A' 하면 -19
            tree[parent][0] = (left == -19)? -1:left;
            tree[parent][1] = (right == -19)? -1:right;
        }

        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);

        System.out.print(sb);
    }

    public static void preorder(int parent){
        if(parent == -1) return;

        sb.append((char)(parent + 'A'));
        preorder(tree[parent][0]);
        preorder(tree[parent][1]);
    }

    public static void inorder(int parent){
        if(parent == -1) return;

        inorder(tree[parent][0]);
        sb.append((char)(parent + 'A'));
        inorder(tree[parent][1]);
    }

    public static void postorder(int parent){
        if(parent == -1) return;

        postorder(tree[parent][0]);
        postorder(tree[parent][1]);
        sb.append((char)(parent + 'A'));
    }

}
