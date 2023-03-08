package sortTest;

// 선택 정렬 - 반복적 방법
public class SelectionSort2Test{
    public static void selectionSort(int[] data){
        int min_index = 0;
        for(int s = 0; s < data.length - 1; s++){
            min_index = s;
            for(int i = s; i < data.length; i++){
                if(data[i] < data[min_index]) min_index = i;
            }
            swap(data, s, min_index);  // Copy from bubble sort;
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
        selectionSort(data);
        printArray(data);
    }
}
