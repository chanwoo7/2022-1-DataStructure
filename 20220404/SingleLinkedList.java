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

public class SingleLinkedList{
    Node begin;
    Node end;

    public SingleLinkedList(){
        this.begin = new Node();
        this.end = new Node();
        // Empty List;
        this.begin.link = this.end;
    }

    public boolean isEmpty(){
        return this.begin.link == this.end;
    }

    public Node search(Node L, Object data, ItemComparator c){
        Node p = L;
        Node found = L;
        while(p != end && c.compare(p.data, data) <= 0){
            found = p;
            p = p.link;
        }
        return found;
    }

    public Node search(Object data, ItemComparator c){
        return this.search(begin.link, data, c);
    }

    public Node add(Object data, ItemComparator c){
        Node insert = new Node(data);

        if(this.isEmpty()){
            insert.link = begin.link;
            begin.link = insert;
            // insert.link = end;
        }
        else{
            Node pos = this.search(data, c);
            insert.link = pos.link;
            pos.link = insert;
        }
        return insert;
    }

    // delete 추가해야

    public void traverse(Node L, Visitor visitor){
        for(Node p = L; p != end; p = p.link){
            visitor.visit(p);
        }
        visitor.visit(end);
    }

    public void traverse(Visitor visitor){
        this.traverse(begin.link, visitor);
    }

    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
        ItemComparator comp = (lhs, rhs) -> {
            String s1 = (String)lhs;
            String s2 = (String)rhs;
            return s1.compareTo(s2);
        };
        list.add("Alpha", comp);
        list.add("Delta", comp);
        list.add("Omega", comp);
        list.add("Beta", comp);

        Node p = list.begin.link;
        while(p != list.end){
            System.out.print("(data:" + p.data + ") -> ");
            p = p.link;
        }
        System.out.println("nil");

        Visitor v = (n) -> {
            if(n.link == null){
                System.out.println("nil");
            }
            else{
                System.out.print("(data:" + n.data + ") -> ");
            }
        };
        list.traverse(v);

        Visitor v2 = (n) -> {
            if(n.link == null){
                System.out.println("!!");
            }
            else{
                System.out.print("(D:" + n.data + "), ");
            }
        };
        list.traverse(v2);

    }
}
