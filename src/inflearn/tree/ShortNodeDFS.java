package inflearn.tree;

/**
 * 말단 노드까지 가장 짧은 경로 구하기
 */
public class ShortNodeDFS {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(4);
        System.out.println(dfs(0, root));
    }

    public static int dfs(int level, Node root){
        if(root.lt==null && root.rt==null) return level;
        return Math.min(dfs(level+1, root.lt), dfs(level+1, root.rt));
    }
}
