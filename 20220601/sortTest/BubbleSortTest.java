package sortTest;

// 버블 정렬 - 재귀적 방법
public class BubbleSortTest{
    public static void bubbleSort(int[] data){
        bubbleSort(data, data.length - 1);
    }

    public static void bubbleSort(int[] data, int last){
        if(last > 0){
            for(int i = 1; i <= last; i++){
                if(data[i - 1] > data[i]) swap(data, i - 1, i);
            }
            bubbleSort(data, last - 1);
        }
    }

    public static void swap(int[] data, int s1, int s2){
        int tmp = data[s1];
        data[s1] = data[s2];
        data[s2] = tmp;
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
        bubbleSort(data);
        printArray(data);
    }
}
