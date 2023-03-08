import java.util.Stack;

public class UseStack{
    public static void main(String[] args){
        Stack<Integer> s = new Stack<Integer>();

        s.push(10);
        s.push(12);
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
