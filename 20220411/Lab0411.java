public class Lab0411 {
    public static void testCases1() {
        DoubleLinkedList list = new DoubleLinkedList();
        final ItemComparator c = (lhs, rhs) -> {
            return ((String)lhs).compareTo((String)rhs);
        };
        System.out.println("Add \"A\"");
        list.add("A", c);
        list.traverse(visitor);


        // list = Create DoubleLinkedList
        // System.out.println("Add 'A'");
        // list.add("A");
        // list.traverse(visitor);

        // Adds "F", "G", "E".

        // System.out.println("Remove 'A'");
        // list.remove("A");
        // list.traverse(visitor);

        // Remove "G"
        // Adds "B", "A"
    }
    public static void testCases2() {
        // Handle Integer
        // list = Create DoubleLinkedList

        // list.add(1); list.add(3); list.add(5);...
        // (1, 3, 5, 7, 9)
        // list.traverse(visitor);

        // while(items in list >= 2){
        //     int x = list.removeFirst();
        //     System.out.println("Remove First - " + x);
        //     int y = list.removeFirst();
        //     System.out.println("Remove First - " + y);
        //     int n = (x + y) * 2;
        //     System.out.println("Add " + n);
        //     list.add(n);
        //     list.traverse(visitor);
        // }
    }
    public static void main(String[] args) {
        testCases1();
        //testCases2();
    }
}
