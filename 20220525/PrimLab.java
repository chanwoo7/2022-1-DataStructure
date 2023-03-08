interface Graph{
    public void add(int src, int dest, int weight){
        // check range src and dest : 0 <= src, dest < size
        // check weight : weight >= 0;
        this.edges[src][dest] = weight;
        if(!this.directed)
            this.edges[dest][src] = weight;
    }
    public int getWeight(int src, int dest){
        // check range src and dest : 0 <= src, dest < size
        // check weight : weight > 0;
        return this.edges[src][dest];
    }
    public int getSize(){
        return this.size;
    }
    public boolean isDirected(){
        return this.directed;
    }

}

class GraphMatrix implements Graph{
    boolean directed;
    int size;
    int[][] edges;

    GraphMatrix(int size, boolean directed){
        this.size = size;
        this.directed = directed;
        this.edges = new int[size][size];
    }

    public void print(){
        System.out.println("SIZE = " + this.size);
        System.out.println("DIRECTED = " + this.directed);
        for(int row = 0; row < this.size; row++){
            for(int col = 0; col < this.size; col++){
                System.out.format("%02d | ", this.edges[row][co]);
            }
            System.out.println();
        }
    }
}

class SpanningTree extends GraphMatrix{
    SpanningTree(int size){
        super(size, true);
    }

    public void add(int src, int dest, int weight){
        // check range src and dest : 0 <= src , dest < size
        // check weight : weight >= 0;
        // check cycle
        this.edges[src][dest] = weight;
    }

    public int weight(){
        int result = 0;
        for(int row = 0; row < this.size; row++){
            for(int col = 0; col < this.size; col++){
                result += this.edges[row][col];
            }
        }
        return result;
    }
}

interface SpanningTreeBuilder{
    public SpanningTree build(Graph graph, int source)
}


public class Primlab{
    public static void main(String[] args){
        GraphMatrix g = new GraphMatrix(7, false);
        g.add(0, 5, 10);
        g.add(0, 1, 28);
        g.add(0, 1, 28);
        g.add(1, 2, 16);
        g.add(1, 6, 14);
        g.add(2, 3, 12);
        g.add(3, 4, 22);
        g.add(3, 6, 18);
        g.add(4, 5, 25);
        g.add(4, 6, 24);
        g.print();

        SpanningTreeBuilder builder = new PrimMethodBuilder();
        SpanningTreeBuilder tree = builder.build(g, 0);
        tree.print();
        SpanningTreeBuilder tree = builder.build(g, 3);
        tree.print();
        SpanningTreeBuilder tree = builder.build(g, 6);
        tree.print();
    }
}
