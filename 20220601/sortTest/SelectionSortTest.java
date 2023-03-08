package sortTest;

// 선택 정렬 - 재귀적 방법
public class SelectionSortTest{
    public static void selectionSort(int[] data){
        selectionSort(data, 0);
    }

    public static void selectionSort(int[] data, int start){
        if(start > data.length - 1) return;
        int min_index = start;
        for(int i = start; i < data.length; i++){
            if(data[i] < data[min_index]) min_index = i;
        }
        swap(data, start, min_index);  // Copy from bubble sort;
        selectionSort(data, start + 1);
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
        selectionSort(data);
        printArray(data);
    }
}
