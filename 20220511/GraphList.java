import java.util.Queue;
import java.util.LinkedList;

interface GraphListVisitor{
    void visit(int data);
}

class GraphListVisitorImpl implements GraphListVisitor {
    public void visit(int data){
        System.out.println(data + " -> ");
    }
}

public class GraphList{
    boolean directed;
    int size;
    // VertexNode[] heads;
    LinkedList<Integer>[] heads;

    GraphList(int size, boolean directed){
        this.size = size;
        this.directed = directed;
        this.heads = (LinkedList<Integer>[]) new LinkedList[size];
        for(int i = 0; i < size; i++)
            this.heads[i] = new LinkedList<Integer>();
    }

    void add(int v1, int v2){
        LinkedList<Integer> select = this.heads[v1];
        if(!select.contains(v2)){
            select.add(v2);
            if(!this.directed){
                this.add(v2, v1);
            }
        }
    }

    void bfs(int v, GraphListVisitor f){
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[this.size];
        this.bfsInternal(v, f, visited, que);
    }

    private void bfsInternal(int v, GraphListVisitor f, boolean[] visited, Queue<Integer> q){
        visited[v] = true;
        q.add(v);
        while(!q.isEmpty()){
            int node = q.remove();
            LinkedList<Integer> select = this.heads[visit];

            for(int i = 0; i < select.size(); i++){
                int next = select.get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args){
        GraphList graph = new GraphList(8, false);
        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 3);
        graph.add(1, 4);
        graph.add(2, 5);
        graph.add(2, 6);
        graph.add(3, 7);
        graph.add(4, 7);
        graph.add(5, 7);
        graph.add(6, 7);

        GraphListVisitor f = (node) -> {
            System.out.println(node + " -> ");
        };
        graph.bfs(0, f);
        graph.bfs(3, f);
    }
}
