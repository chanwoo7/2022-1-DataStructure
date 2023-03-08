class ArrayLinearList{
    private int N;
    private int size;
    private int increment;
    private int[] itemList;

    public ArrayLinearList(){
        N = -1;
        size = 50;
        increment = 10;
        itemList = new int[size];
    }

    public boolean isEmpty(){
        return N == -1;
    }
    public void insert(int x){
        int pos = 0;
        if(N == -1){
            N++;
            itemList[N] = x;
        }
        else{
            for(int i = 0; i <= N; i++){
                if(x > itemList[i]) pos++;
            }
            for(int i = N + 1; i > pos; i--){
                itemList[i] = itemList[i-1];
            }
            itemList[pos] = x;
            N++;
        }
    }
    public void delete(int x){
        if(isEmpty()){
            System.out.println("List is Empty");
        }
        else{
            int loc = -1;
            for(int i = 0; i <= N; i++)
                if(x == itemList[i])
                    loc = i;
                if(loc == -1)
                    System.out.println("삭제할 원소 " + x + "이 없습니다.");
                else{
                    for(int i = loc; i < N; i++){
                        itemList[i] = itemList[i + 1];
                    }
                    N--;
                }
        }
    }
    public void print(){
        for(int i = 0; i < N; i++)
            System.out.print(itemList[i] + ", ");
        System.out.println(itemList[N]);
    }

    public static void main(String[] args){
        // Test Case 1
        ArrayLinearList list1 = new ArrayLinearList();
        list1.insert(12);
        list1.insert(24);
        list1.insert(36);
        list1.insert(58);
        list1.insert(79);
        System.out.println("*** Show List after insert ***");
        list1.print();
        // Test Case 2
        list1.delete(24);
        System.out.println("*** Show List after delete 24 ***");
        list1.print();
        // Test Case 3
        list1.delete(58);
        System.out.println("*** Show List after delete 58 ***");
        list1.print();
        // Test Case 4
        list1.delete(12);
        System.out.println("*** Show List after delete 12 ***");
        list1.print();
        // Test Case 5
        list1.delete(10);
        System.out.println("*** Show List after delete 10 ***");
        list1.print();
        // Test Case 6
        System.out.println("isEmpty ? " + list1.isEmpty());
    }
}
