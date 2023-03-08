class CharArrayStack{
    int top = -1;
    int maxsize = 0;
    char[] elements;

    public CharArrayStack(int maxStackSize){
        top = -1;
        elements = new char[maxStackSize];
    }

    public boolean isFull(){
        return top >= elements.length - 1;
    }

    public CharArrayStack add(char item){
        if(isFull()){
            throw new RuntimeException("Stack is full!");
        }
        top++;
        elements[top] = item;
        return this;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public char delete(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        return elements[top--];
    }

    public void clear(){
        top = -1;
    }
}

public class ParenthesesChecker{
    char[] open;
    char[] close;
    CharArrayStack stack;

    public ParenthesesChecker(char[] open, char[] close){
        this.open = open; // (<[
        this.close = close; // )>]
        stack = new CharArrayStack(100);
    }

    boolean isParenthese(char p){
        for(int i = 0; i < open.length; i++){
            if(p == open[i] || p == close[i])
                return true;
        }
        return false;
    }

    boolean isOpen(char p){
        for(int i = 0; i < open.length; i++){
            if(p == open[i])
                return true;
        }
        return false;
    }

    boolean isClose(char p){
        for(int i = 0; i < close.length; i++){
            if(p == close[i])
                return true;
        }
        return false;
    }

    boolean isMatch(char p1, char p2){
        boolean status1 = false;
        boolean status2 = false;

        for(int i = 0; i < open.length; i++){
            if(p1 == open[i]){
                status1 = true;
                break;
            }
        }
        for(int i = 0; i < close.length; i++){
            if(p2 == close[i]){
                status2 = true;
                break;
            }
        }

        if (!status1 || !status2) return false;

        int i1 = 0;
        int i2 = 0;
        for(int i = 0; i < open.length; i++){
            if(p1 == open[i]){
                i1 = i;
                break;
            }
        }
        for(int i = 0; i < close.length; i++){
            if(p2 == close[i]){
                i2 = i;
                break;
            }
        }

        return i1 == i2;
    }

    boolean validate(String expression){
        stack.clear();
        for(int i = 0; i < expression.length(); i++){
            char test = expression.charAt(i);
            if(!isParenthese(test)) continue;
            if(isOpen(test)){
                stack.add(test);
            }
            else{
                char last = stack.delete();
                if(!isMatch(last, test)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        char[] open = {'(', '[', '<'};
        char[] close = {')', ']', '>'};
        ParenthesesChecker p = new ParenthesesChecker(open, close);

        String expression1 = "(1+2)";
        String expression2 = "2+(2+[3+<4*5>]-9)/2";
        String expression3 = "(3+(3+(4+5]))";
        String expression4 = "(4*[1+(3-5]))";
        String expression5 = "5+(5+6*7+(9+[2/5])";

        System.out.print(expression1 + ":=");
        System.out.println(p.validate(expression1));
        System.out.print(expression2 + ":=");
        System.out.println(p.validate(expression2));
        System.out.print(expression3 + ":=");
        System.out.println(p.validate(expression3));
        System.out.print(expression4 + ":=");
        System.out.println(p.validate(expression4));
        System.out.print(expression5 + ":=");
        System.out.println(p.validate(expression5));
    }
}
