package sortTest;

// »ðÀÔ Á¤·Ä - Àç±ÍÀû ¹æ¹ý
public class InsertionSortTest{
    public static void insertionSort(int[] data){
        insertionSort(data, 1);
    }

    public static void insertionSort(int[] data, int start){
        if(start > data.length - 1) return;
        int insert = data[start]; int pos;
        for(pos = 0; pos < start; pos++)
            if(data[pos] > insert) break;  // find
        for(int i = start; i > pos; i--)
            data[i] = data[i - 1];  // move
        data[pos] = insert;  // insert
        insertionSort(data, start + 1);
    }

    public static void printArray(int[] data){
        for(int key : data){
            System.out.print(key + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] data = {2, 8, 5, 3, 9, 4, 1};
        printArray(data);
        insertionSort(data);
        printArray(data);
    }
}
