package inflearn.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 말단 노드까지 가장 짧은 경로 구하기
 */
public class ShortNodeBFS {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(4);
        System.out.println(bfs(root));
    }

    public static int bfs(Node root){
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        int level = 0;

        while(!que.isEmpty()){
            int length = que.size();
            for(int i=0; i<length; i++){
                Node cur = que.poll();
                if(cur.lt == null && cur.rt == null) return level;
                if(cur.lt != null) que.offer(cur.lt);
                if(cur.rt != null) que.offer(cur.rt);
            }
            level++;
        }

        return 0;
    }
}
