package sortTest;

// 합병 정렬 - 재귀적 방법
public class MergeSortTest{
    public static void mergeSort(int[] data){
        int[] divide = new int[data.length];
        mergeSort(data, divide, 0, data.length - 1);
    }

    public static void mergeSort(int[] data, int[] divide, int s, int e){
        if(s >= e) return;
        int mid = (s + e) / 2;
        mergeSort(data, divide, s, mid);
        mergeSort(data, divide, mid + 1, e);
        merge(data, divide, s, mid, e);
    }

    private static void merge(int[] data, int[] divide, int s, int m, int e) {
        for(int i = s; i <= e; i++) divide[i] = data[i];
        int p1 = s; int p2 = m + 1; // L partition and R partition index
        int idx = s; // merged index
        while(p1 <= m && p2 <= e) {
            if(divide[p1] <= divide[p2]) { data[idx] = divide[p1]; p1++; }
            else {data[idx] = divide[p2]; p2++;}
            idx++;
        } // remain part copy
        for(int i = 0; i <= m - p1; i++) {data[idx + i] = divide[p1 + i];}
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
        mergeSort(data);
        printArray(data);
    }
}
