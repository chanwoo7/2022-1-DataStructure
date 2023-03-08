public class OneArray{
  static void print(int[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.println("arr[" + i + "] = " + arr[i]);
    }
  }

  public static void main(String[] args){
    int[] one = {0, 1, 2, 3, 4};
    print(one);
  }
}
