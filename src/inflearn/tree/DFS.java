package inflearn.tree;

/**
 * 이진 트리의 전위, 중위, 후위 순회를 직접 구현하세요.
 */
public class DFS {

    Node root;

    public static void main(String[] args) {
        DFS tree = new DFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        DFS(tree.root);
        System.out.println();
        DFS2(tree.root);
        System.out.println();
        DFS3(tree.root);
        System.out.println();
    }

    //전위 순회
    public static void DFS(Node root){
        if(root==null) return ;
        System.out.print(root.data+" ");
        DFS(root.lt);
        DFS(root.rt);
    }

    //중위 순회
    public static void DFS2(Node root){
        if(root==null) return ;
        DFS(root.lt);
        System.out.print(root.data+" ");
        DFS(root.rt);
    }
    //후위 순회
    public static void DFS3(Node root){
        if(root==null) return ;
        DFS(root.lt);
        DFS(root.rt);
        System.out.print(root.data+" ");
    }
}
class Node{
    int data;
    Node lt,rt;

    public Node(int val) {
        data = val;
        lt=rt = null;
    }
}
