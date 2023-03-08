class GraphMatrix {
    int size;
    boolean directed;
    int[][] edges;
    int[] visited;

    GraphMatrix (int size, boolean directed) {
        this.size = size;
        this.directed = directed;
        this.edges = new int[size][size];
        this.visited = new int[size];
    }

    void add (int v1, int v2) {
        this.edges[v1][v2] = 1;
        if (!this.directed) {
            this.edges[v2][v1] = 1;
        }
    }

    void dfs (int v) {
        this.visited[v] = 1;
        System.out.print(v + " -> ");
        for (int i = 0; i < this.size; i++) {
            if (this.edges[v][i] == 1 && this.visited[i] == 0)
                dfs(i);
        }
    }

    void clean (){
        this.visited = new int[this.size];
    }

    public static void main(String args[]) {
        GraphMatrix graph = new GraphMatrix(8, false);
        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 3);
        graph.add(1, 5);
        graph.add(2, 7);
        graph.add(3, 4);
        graph.add(3, 7);
        graph.add(4, 5);
        graph.add(5, 6);
        graph.add(6, 7);

        graph.dfs(0);
        graph.clean();
        System.out.println();
        graph.dfs(7);
    }
}
