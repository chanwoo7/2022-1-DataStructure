import java.util.Stack;

class Position{
    int row;
    int col;
    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public boolean equals(int row, int col){
        return this.row == row && this.col == col;
    }

    public boolean equals(Position p){
        return this.equals(p.row, p.col);
    }

    public void set(int row, int col){
        this.row = row;
        this.col = col;
    }

    public String toString(){
        return "(" + this.row + "," + this.col + ")";
        // return String.format("(%d,%d)", this.row, this.col);
    }

    public int getRow() {return this.row;}
    public int getCol() {return this.col;}
}

public class MazeSolver2{
    int[][] map = {
        {0, 1, 1, 1},
        {0, 0, 0, 0},
        {1, 0, 1, 1},
        {0, 0, 0, 0}
    };
    Position start;
    Position end;
    Position current;
    Stack<Position> close = new Stack<Position>();
    Stack<Position> path = new Stack<Position>();

    public MazeSolver2(int[][] map, Position start, Position end){
        this.map = map;
        this.start = start;
        this.end = end;
        this.close.push(start);
        this.current = new Position(start.getRow(), start.getCol());
    }

    public boolean canMove(int row, int col){
        if(row >= this.map.length || row < 0){
            // throw new RuntimeException("Out of row position");
            return false;
        }
        if(col >= this.map[row].length || col < 0){
            // throw new RuntimeException("Out of col position");
            return false;
        }
        return this.map[row][col] == 0;
    }

    public boolean canMove(Position p){
        return this.canMove(p.getRow(), p.getCol());
    }

    public boolean contains(Stack<Position> s, Position p){
        for(int i = 0; i < s.size(); i++){
            if(s.elementAt(i).equals(p)){
                return true;
            }
        }
        return false;
    }

    public boolean findExit(){
        while(!this.current.equals(this.end)){
            this.path.push(this.current);
            System.out.println(this.path);

            Position next = new Position(this.current.getRow() - 1, this.current.getCol());
            if(canMove(next) && !contains(this.path, next) && !contains(this.close, next)){
                this.current = next;
                continue;
            }
            next = new Position(this.current.getRow() + 1, this.current.getCol());
            if(canMove(next) && !contains(this.path, next) && !contains(this.close, next)){
                this.current = next;
                continue;
            }
            next = new Position(this.current.getRow(), this.current.getCol() - 1);
            if(canMove(next) && !contains(this.path, next) && !contains(this.close, next)){
                this.current = next;
                continue;
            }
            next = new Position(this.current.getRow(), this.current.getCol() + 1);
            if(canMove(next) && !contains(this.path, next) && !contains(this.close, next)){
                this.current = next;
                continue;
            }
            if(this.path.empty()){
                return false;
            }
            this.close.push(this.path.pop());
        }
        boolean result = true;
        System.out.println(path);
        return result;
    }

    public static void main(String[] args){
        int[][] map1 = {
            {0, 1, 1, 1},
            {0, 0, 0, 0},
            {1, 0, 1, 1},
            {0, 0, 0, 0}
        };
        // int[][] map2 = {
        //     {0, 1, 1, 1},
        //     {0, 1, 0, 0},
        //     {1, 0, 1, 1},
        //     {0, 0, 0, 0}
        // };
        // int[][] map3 = {
        //     {0, 0, 0, 0},
        //     {1, 0, 1, 0},
        //     {1, 0, 1, 0},
        //     {0, 0, 0, 0}
        // };

        MazeSolver2 solver1 = new MazeSolver2(map1, new Position(0, 0), new Position(3, 3));
        // MazeSolver2 solver2 = new MazeSolver2(map2, new Position(0, 0), new Position(3, 3));
        // MazeSolver2 solver3 = new MazeSolver2(map3, new Position(0, 0), new Position(3, 3));
        System.out.println(solver1.findExit());
        // System.out.println(solver2.findExit());
        // System.out.println(solver3.findExit());
    }
}
