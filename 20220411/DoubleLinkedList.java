class BidirectNode {
    Object data;
    BidirectNode llink; // previous
    BidirectNode rlink; // next

    public BidirectNode(){
        this(null, null, null);
    }

    public BidirectNode(Object data){
        this(data, null, null);
    }

    public BidirectNode(Object data, BidirectNode llink){
        this(data, llink, null);
    }

    public BidirectNode(Object data, BidirectNode llink, BidirectNode rlink){
        this.data = data;
        this.llink = llink;
        this.rlink = rlink;
    }
}

@FunctionalInterface
interface Visitor {
    void visit(BidirectNode n);
}

@FunctionalInterface
interface ItemComparator {
    int compare(Object lhs, Object rhs);
}

public class DoubleLinkedList{
    BidirectNode begin;

    public DoubleLinkedList() {
        begin = new BidirectNode();
        begin.rlink = begin;
    }

    public boolean isEmpty() {
        return begin.rlink == begin;
    }

    public void traverse(BidirectNode L, Visitor visitor) {
        BidirectNode p;
        for (p = L ; p.rlink != L ; p = p.rlink) {
            visitor.visit(p);
        }
        if (L != begin && L != begin.rlink) {
            visitor.visit(L);
        } else {
            visitor.visit(p);
        }
    }

    public void traverse(Visitor visitor) {
        this.traverse(begin.rlink, visitor);
    }

    public BidirectNode search(BidirectNode L, Object data, ItemComparator comparator) {
        BidirectNode p = L;
        BidirectNode found = L;
        while ( p.rlink != L && comparator.compare(p.data, data) <= 0) {
            found = p;
            p = p.rlink;
        }
        if (L.rlink != L && comparator.compare(p.data, data) <= 0) {
            found = p;
        }
        return found;
    }


    public BidirectNode search(Object data, ItemComparator comparator) {
        return this.search(begin.rlink, data, comparator);
    }

    public BidirectNode deleteSearch(BidirectNode L, Object data, ItemComparator comparator) {
        BidirectNode p = L;
        if (comparator.compare(p.data, data) == 0) return p;
        while (p.rlink != L && comparator.compare(p.data, data) != 0) {
            p = p.rlink; // Move Next node
        }
        if (comparator.compare(p.data, data) != 0) return begin;
        return p;
    }


    public BidirectNode deleteSearch(Object data, ItemComparator comparator) {
        return deleteSearch(begin.rlink, data, comparator);
    }

    public BidirectNode add(Object data, ItemComparator comparator) {
        BidirectNode insert = new BidirectNode();
        insert.data = data;
        if (isEmpty()) {
            begin.rlink = insert;
            insert.rlink = insert;
            insert.llink = insert;
        } else {
            BidirectNode pos = search(begin.rlink, data, comparator);
            insertAfter(pos, insert);
            if (comparator.compare(pos.data, insert.data) > 0) {
                this.begin.rlink = insert;
            }
        }
        return insert;
    }

    public Object remove(Object data, ItemComparator comparator) {
        if (isEmpty()) return null; // isEmpty
        BidirectNode pos = deleteSearch(begin.rlink, data, comparator);
        if (pos == begin) return null; // Not Found
        delete(pos);
        if (pos == begin.rlink) {
            if (pos.rlink == pos) { // Last One
                begin.rlink = begin;
            } else { // Remove First
                begin.rlink = pos.rlink;
            }
        }
        return pos.data;
    }

    void insertAfter(BidirectNode pos, BidirectNode insert) {
        insert.rlink = pos.rlink;
        pos.rlink.llink = insert;
        pos.rlink = insert;
        insert.llink = pos;
    }

    void delete(BidirectNode delete) {
        delete.llink.rlink = delete.rlink;
        delete.rlink.llink = delete.llink;
    }

    public Object removeFirst() {
        if (isEmpty()) return null;
        BidirectNode first = begin.rlink;
        Object removedData = first.data;
        delete(first);
        begin.rlink = first.rlink;
        return removedData;
    }

    public static void testCases1() {
        DoubleLinkedList list = new DoubleLinkedList();
        final ItemComparator c = (lhs, rhs) -> {
            return ((String)lhs).compareTo((String)rhs);
        };
        final BidirectNode begin = list.begin.rlink;
        Visitor v = (n) -> {
            // form "(data:Ant) -> "
            if(begin.rlink == n) {
                System.out.print("LIST = (");
            }
            System.out.print(n.data);
            if(n.rlink == begin.rlink) {
                System.out.println(")");
            } else {
                System.out.print(", ");
            }
        };
        System.out.println("Add 'A'");
        list.add("A", c);
        list.traverse(v);
        System.out.println("Add 'F'");
        list.add("F", c);
        list.traverse(v);
        System.out.println("Add 'G'");
        list.add("G", c);
        list.traverse(v);
        System.out.println("Add 'E'");
        list.add("E", c);
        list.traverse(v);
        System.out.println("Remove 'A'");
        list.remove("A", c);
        list.traverse(v);
        System.out.println("Remove 'G'");
        list.remove("G", c);
        list.traverse(v);
        System.out.println("Add 'B'");
        list.add("B", c);
        list.traverse(v);
        System.out.println("Add 'A'");
        list.add("A", c);
        list.traverse(v);
        System.out.println();
    }

    public static void testCases2() {
        DoubleLinkedList list = new DoubleLinkedList();
        final ItemComparator c = (lhs, rhs) -> {
            return ((String)lhs).compareTo((String)rhs);
        };
        final BidirectNode begin = list.begin.rlink;
        Visitor v = (n) -> {
            // form "(data:Ant) -> "
            if(begin.rlink == n) {
                System.out.print("LIST = (");
            }
            System.out.print(n.data);
            if(n.rlink == begin.rlink) {
                System.out.println(")");
            } else {
                System.out.print(", ");
            }
        };
        list.add("1", c);
        list.add("3", c);
        list.add("5", c);
        list.add("7", c);
        list.add("9", c);
        list.traverse(v);

        System.out.println("Remove first - " + list.removeFirst());
        System.out.println("Remove first - " + list.removeFirst());
        System.out.println("Add " + 8);
        list.add("8", c);
        list.traverse(v);

        System.out.println("Remove first - " + list.removeFirst());
        System.out.println("Remove first - " + list.removeFirst());
        System.out.println("Add " + 24);
        list.add("24", c);
        list.traverse(v);

        System.out.println("Remove first - " + list.removeFirst());
        System.out.println("Remove first - " + list.removeFirst());
        System.out.println("Add " + 48);
        list.add("48", c);
        list.traverse(v);

        System.out.println("Remove first - " + list.removeFirst());
        System.out.println("Remove first - " + list.removeFirst());
        System.out.println("Add " + 144);
        list.add("144", c);
        list.traverse(v);
    }

    public static void main(String[] args) {
        // testCases1();
        testCases2();
    }

}
