package inflearn.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진트리 레벨 탐색하기
 */
public class BFS {
    Node root;

    public static void main(String[] args) {
        BFS tree = new BFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.bfs(tree.root);
    }
    public void bfs(Node node){
        Queue<Node> que = new LinkedList<>();
        que.offer(node);
        int level = 0;
        while(!que.isEmpty()){
            System.out.println("level : "+level);
            int length = que.size();
            for(int i=0; i<length; i++){
                Node poll = que.poll();
                System.out.print(poll.data+" ");
                if(poll.lt != null) que.offer(poll.lt);
                if(poll.rt != null) que.offer(poll.rt);
            }
            System.out.println();
            level++;
        }
    }
}
