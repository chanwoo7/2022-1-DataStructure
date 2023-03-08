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


public class MazeSolver1{
    int[][] map = {
        {0, 1, 1, 1},
        {0, 0, 0, 0},
        {1, 0, 1, 1},
        {0, 0, 0, 0}
    };
    Position start;
    Position end;
    Position current;
    Stack<Position> path = new Stack<Position>();

    public MazeSolver1(int[][] map, Position start, Position end){
        this.map = map;
        this.start = start;
        this.end = end;
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

    boolean findExit(Position previous, Position current){
        path.push(current);
        if(current.equals(this.end)){
            return true;
        }
        Position next = new Position(current.getRow() - 1, current.getCol());
        if(canMove(next) && !previous.equals(next)){
            if(findExit(current, next)){
                return true;
            }
        }
        next = new Position(current.getRow() + 1, current.getCol());
        if(canMove(next) && !previous.equals(next)){
            if(findExit(current, next)){
                return true;
            }
        }
        next = new Position(current.getRow(), current.getCol() - 1);
        if(canMove(next) && !previous.equals(next)){
            if(findExit(current, next)){
                return true;
            }
        }
        next = new Position(current.getRow(), current.getCol() + 1);
        if(canMove(next) && !previous.equals(next)){
            if(findExit(current, next)){
                return true;
            }
        }
        path.pop();
        return false;
    }

    public boolean findExit(){
        boolean result = this.findExit(this.current, this.current);
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
        int[][] map2 = {
            {0, 1, 1, 1},
            {0, 1, 0, 0},
            {1, 0, 1, 1},
            {0, 0, 0, 0}
        };
        int[][] map3 = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {1, 0, 1, 0},
            {0, 0, 0, 0}
        };

        MazeSolver1 solver1 = new MazeSolver1(map1, new Position(0, 0), new Position(3, 3));
        MazeSolver1 solver2 = new MazeSolver1(map2, new Position(0, 0), new Position(3, 3));
        MazeSolver1 solver3 = new MazeSolver1(map3, new Position(0, 0), new Position(3, 3));
        System.out.println(solver1.findExit());
        System.out.println(solver2.findExit());
        System.out.println(solver3.findExit());
    }
}
