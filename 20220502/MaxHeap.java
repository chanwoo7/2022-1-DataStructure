import java.util.Arrays;

class Heap{
    Object data;
    int[] heap;

    public Heap(int size){
        heap = new int[size];
    }

    void inorder(int p){
        if(heap[p] != 0){
            inorder(p * 2);
            System.out.print(heap[p] + " "); // VISIT
            inorder(p * 2 + 1);
        }
    }

    void postorder(int p){
        if(heap[p] != 0){
            postorder(p * 2);
            postorder(p * 2 + 1);
            System.out.print(heap[p] + " "); // VISIT
        }
    }

    void preorder(int p){
        if(heap[p] != 0){
            System.out.print(heap[p] + " "); // VISIT
            preorder(p * 2);
            preorder(p * 2 + 1);
        }
    }

    Boolean isFull(){
        int n = 0;
        for(int i = 0; i < heap.length; i++){
            if(heap[i] != 0) n++;
        }
        if(n == heap.length)
            return true;
        else return false;
    }

    Boolean isEmpty(){
        int n = 0;
        for(int i = 0; i < heap.length; i++){
            if(heap[i] != 0) n++;
        }
        if(n > 0) return false;
        else return true;
    }

    int lastIndex(){
        int n = 0;
        for(int i = 0; i < heap.length; i++){
            if(heap[i] != 0) n = i;
        }
        return n;
    }

    void insert(int item) {
        int ptr;

        if(isFull())
            throw new RuntimeException("Full");

        int n = lastIndex();
        ptr = ++n;
        while((ptr != 1) && (item > heap[ptr / 2])){
            heap[ptr] = heap[ptr/2];
            ptr /= 2;
        }
        heap[ptr] = item;
    }

    int remove(){
        int parent, child, item, temp;

        if(isEmpty())
            throw new RuntimeException("Empty");

        item = heap[1];  // save highest key
        int n = lastIndex();
        temp = heap[n--];  // last element and reduce size
        heap[n+1] = 0;
        parent = 1;
        child = 2;

        while(child <= n){
            // find the larger child of the current parent
            if(child < n && (heap[child] < heap[child + 1]))
                child++;
            if(temp >= heap[child])
                break;
            // move to the next lower level
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
        return item;
    }
}

public class MaxHeap{
    public static void main(String args[]){
        Heap h = new Heap(100);
        h.insert(23);
        h.insert(39);
        h.insert(7);
        h.insert(20);
        h.insert(14);
        h.insert(15);
        h.insert(46);
        h.insert(66);
        h.insert(75);
        h.insert(49);
        h.insert(32);

        // 출력 (1) - 트리 순회하여 출력하기
        System.out.print("Pre-order: ");
        h.preorder(1);
        System.out.println();

        System.out.print("In-order: ");
        h.inorder(1);
        System.out.println();

        System.out.print("Post-order: ");
        h.postorder(1);
        System.out.println();

        //  출력 (2) - 모든 원소를 삭제하며 출력하기
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
    }
}
