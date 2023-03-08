package sortTest;

// 삽입 정렬 - 반복적 방법
public class InsertionSort2Test{
    public static void insertionSort(int[] data){
        int pos = 0; int insert;
        for(int s = 1; s < data.length; s++){
            insert = data[s];
            for(pos = 0; pos < s; pos++)
                if(data[pos] > insert) break;  // find
            for(int i = s; i > pos; i--)
                data[i] = data[i - 1];  // move
            data[pos] = insert;
        }
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
