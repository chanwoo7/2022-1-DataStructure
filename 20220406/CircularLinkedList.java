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

public class CircularLinkedList {
  Node begin;


  public CircularLinkedList() {
    begin = new Node();
    begin.link = begin;
  }


  public boolean isEmpty() {
    return begin.link == begin;
  }


  public void traverse(Node L, Visitor visitor) {
	// 수정 전
	// for(Node p=L ; p.link!=L ; p=p.link) {
    Node p;
    for(p=L ; p.link!=L ; p=p.link) {
      visitor.visit(p);
    }
    if(L!=begin && L!=begin.link) {
      visitor.visit(L);
    } else {
	  // 추가됨
      visitor.visit(p);
    }
  }

  public void invert(){
      Node prev = null;
      Node curr = begin;
      Node next = null;

      do{
          next = curr.link;
          curr.link = prev;
          prev = curr;
          curr = next;
      } while(curr != begin);

      begin.link = prev;
      begin = prev;
  }

  public void concatenate(CircularLinkedList other){
      ItemComparator c = (lhs, rhs) -> {
        return ((String)lhs).compareTo((String)rhs);
      };

      Node last = search(begin.link, begin.data, c);

      Node olast = search(other.begin.link, other.begin.data, c);
      // Node last = begin;
      // for(Node p = begin; p != p; p = p.link){
      //     last = p;
      // }
      // Node olast = other.begin;
      // for(Node p = other.begin; p != p; p = p.link){
      //     olast = p;
      // }
      olast.link = begin;
      last.link = other.begin;
      // this.last.link = other.begin;
      // other.last.link = this.begin;
  }


  public void traverse(Node L, Node E, Visitor visitor) {
    for(Node p=L ; p!=E ; p=p.link) {
      visitor.visit(p);
    }
    visitor.visit(E);
  }


  public void traverse(Visitor visitor) {
    this.traverse(begin.link, visitor);
  }


  public Node search(Node L, Object data, ItemComparator comparator) {
    Node p = L;
    Node found = L;
    while( p.link!=L && comparator.compare(p.data, data) <= 0) {
      found = p;
      p = p.link;
    }
    if(L.link!=L && comparator.compare(p.data, data) <= 0) {
      found = p;
    }
    return found;
  }


  public Node search(Object data, ItemComparator comparator) {
    return this.search(begin.link, data, comparator);
  }


  public Node add(Object data, ItemComparator comparator) {
    Node insert = new Node(data);
    if( isEmpty() ) {
      // 변경됨
      begin.link = insert;
      insert.link = insert;
    } else {
      Node pos = search(begin.link, data, comparator);
      insert.link = pos.link;
      pos.link = insert;
      // 변경됨 begin link 를 변경
      if(comparator.compare(pos.data, insert.data)>0) {
        this.begin.link = insert;
      }
    }
    return insert;
  }


  public static void main(String[] args) {
    final ItemComparator c = (lhs, rhs) -> {
      return ((String)lhs).compareTo((String)rhs);
    };
    CircularLinkedList l1 = new CircularLinkedList();
    final Node begin1 = l1.begin;
    Visitor v1 = (n) -> {
      // form "(a,b,c,d)"
      if(begin1.link == n) {
        System.out.print("(");
      }
      System.out.print(n.data);
      if(n.link == n || c.compare(n.data, n.link.data)> 0) {
        System.out.println(")");
      } else {
        System.out.print(", ");
      }
    };
    l1.add("1", c);
    l1.add("3", c);
    l1.add("5", c);
    l1.add("7", c);
    l1.add("9", c);
    System.out.println("INPUT:");
    l1.traverse(v1);
    l1.invert();
    System.out.println("INVERTED:");
    l1.traverse(v1);

    System.out.println();
    System.out.println();

    CircularLinkedList l2 = new CircularLinkedList();
    final Node begin2 = l2.begin;
    Visitor v2 = (n) -> {
      // form "(a,b,c,d)"
      if(begin2.link == n) {
        System.out.print("(");
      }
      System.out.print(n.data);
      if(n.link == n || c.compare(n.data, n.link.data)> 0) {
        System.out.println(")");
      } else {
        System.out.print(", ");
      }
    };
    l2.add("Bear", c);
    l2.add("Ant", c);
    l2.add("Dog", c);
    l2.add("Cat", c);
    System.out.println("INPUT:");
    l2.traverse(v2);
    l2.invert();
    System.out.println("INVERTED:");
    l2.traverse(v2);

    System.out.println();
    System.out.println();

    CircularLinkedList l3 = new CircularLinkedList();
    final Node begin3 = l3.begin;
    Visitor v3 = (n) -> {
      // form "(a,b,c,d)"
      if(begin3.link == n) {
        System.out.print("(");
      }
      System.out.print(n.data);
      if(n.link == n || c.compare(n.data, n.link.data)> 0) {
        System.out.println(")");
      } else {
        System.out.print(", ");
      }
    };
    l3.add("1", c);
    l3.add("3", c);
    l3.add("5", c);
    l3.add("7", c);
    l3.add("9", c);

    CircularLinkedList l4 = new CircularLinkedList();
    final Node begin4 = l4.begin;
    Visitor v4 = (n) -> {
      // form "(a,b,c,d)"
      if(begin4.link == n) {
        System.out.print("(");
      }
      System.out.print(n.data);
      if(n.link == n || c.compare(n.data, n.link.data)> 0) {
        System.out.println(")");
      } else {
        System.out.print(", ");
      }
    };
    l4.add("2", c);
    l4.add("10", c);
    l4.add("12", c);
    l4.add("20", c);

    System.out.println("INPUT:");
    l3.traverse(v3);
    l4.traverse(v4);
    l3.concatenate(l4);
    System.out.println("CONCATENATED:");
    l3.traverse(v3);

    System.out.println();
    System.out.println();

    CircularLinkedList l5 = new CircularLinkedList();
    final Node begin5 = l5.begin;
    Visitor v5 = (n) -> {
      // form "(a,b,c,d)"
      if(begin5.link == n) {
        System.out.print("(");
      }
      System.out.print(n.data);
      if(n.link == n || c.compare(n.data, n.link.data)> 0) {
        System.out.println(")");
      } else {
        System.out.print(", ");
      }
    };
    l5.add("Ant", c);
    l5.add("Cat", c);

    CircularLinkedList l6 = new CircularLinkedList();
    final Node begin6 = l6.begin;
    Visitor v6 = (n) -> {
      // form "(a,b,c,d)"
      if(begin6.link == n) {
        System.out.print("(");
      }
      System.out.print(n.data);
      if(n.link == n || c.compare(n.data, n.link.data)> 0) {
        System.out.println(")");
      } else {
        System.out.print(", ");
      }
    };
    l6.add("2", c);
    l6.add("10", c);
    l6.add("12", c);
    l6.add("20", c);

    System.out.println("INPUT:");
    l5.traverse(v5);
    l6.traverse(v6);
    l5.concatenate(l6);
    System.out.println("CONCATENATED:");
    l5.traverse(v5);

  }
}
