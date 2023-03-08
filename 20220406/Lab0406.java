class Node{
    Object data;
    Node link;

    public Node(){
        this(null, null);
    }

    public Node(Object data){
        this(data, null);
    }

    public Node(Object data, Node link){
        this.data = data;
        this.link = link;
    }
}

@FunctionalInterface
interface Visitor{
    void visit(Node n);
}

@FunctionalInterface
interface ItemComparator{
    int compare(Object lhs, Object rhs);
}

public class Lab0406{
    static void testCase11(){
        CircularLinkedList l1 = new CircularLinkedList();

        final ItemComparator c = (lhs, rhs) -> {
          return ((String)lhs).compareTo((String)rhs);
        };
        final Node begin = l1.begin;
        Visitor v = (n) -> {
          // form "(a,b,c,d)"
          if(begin.link == n) {
            System.out.print("(");
          }
          System.out.print(n.data);
          if(n.link == n || c.compare(n.data, n.link.data)> 0) {
            System.out.println(")");
          } else {
            System.out.print(", ");
          }
        };

        l1.add(1);
        l1.add(3);
        l1.add(5);
        l1.add(7);
        l1.add(9);
        l1.traverse(v);
        l1.invert();
        l1.traverse(v);
    }
    static void testCase12(){
        CircularLinkedList l2 = new CircularLinkedList();

        final ItemComparator c = (lhs, rhs) -> {
          return ((String)lhs).compareTo((String)rhs);
        };
        final Node begin = l1.begin;
        Visitor v = (n) -> {
          // form "(a,b,c,d)"
          if(begin.link == n) {
            System.out.print("(");
          }
          System.out.print(n.data);
          if(n.link == n || c.compare(n.data, n.link.data)> 0) {
            System.out.println(")");
          } else {
            System.out.print(", ");
          }
        };
    }
    static void testCase21(){
        CircularLinkedList l3 = new CircularLinkedList();

        final ItemComparator c = (lhs, rhs) -> {
          return ((String)lhs).compareTo((String)rhs);
        };
        final Node begin = l1.begin;
        Visitor v = (n) -> {
          // form "(a,b,c,d)"
          if(begin.link == n) {
            System.out.print("(");
          }
          System.out.print(n.data);
          if(n.link == n || c.compare(n.data, n.link.data)> 0) {
            System.out.println(")");
          } else {
            System.out.print(", ");
          }
        };

    }
    static void testCase22(){
        CircularLinkedList l4 = new CircularLinkedList();

        final ItemComparator c = (lhs, rhs) -> {
          return ((String)lhs).compareTo((String)rhs);
        };
        final Node begin = l1.begin;
        Visitor v = (n) -> {
          // form "(a,b,c,d)"
          if(begin.link == n) {
            System.out.print("(");
          }
          System.out.print(n.data);
          if(n.link == n || c.compare(n.data, n.link.data)> 0) {
            System.out.println(")");
          } else {
            System.out.print(", ");
          }
        };

    }

    public static void main(String[] args){
        testCase11();
        // testCase12();
        // testCase21();
        // testCase22();
    }
}
