package sortTest;

// Äü Á¤·Ä - Àç±ÍÀû ¹æ¹ı
public class QuickSortTest{
    public static void quickSort(int[] data){
        quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int start, int end){
        int part2 = partition(data, start, end);
        if(start < part2 - 1)  // n(L - partion) > 1
            quickSort(data, start, part2 - 1);
        if(part2 < end)  // n(R - partion) > 1
            quickSort(data, part2, end);
    }

    public static int partition(int[] data, int start, int end){
        int pivot = data[start];
        while(start <= end){
            while(data[start] < pivot) start++;
            while(data[end] > pivot) end--;
            if(start <= end){
                swap(data, start, end);
                start++; end--;
            }
        }
        return start;
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
        quickSort(data);
        printArray(data);
    }
}
