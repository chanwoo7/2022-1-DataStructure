import java.util.Random;
import java.util.Arrays;

public class RandomArray{
  static void accumulatedSum(int[] a){
    int[] sum = new int[a.length];

    for(int i = 0; i < a.length; i++){
      for(int total = 0, j = 0; j <= i; j++){
        total += a[j];
        sum[i] = total;
      }
    }

    System.out.println("sum = " + Arrays.toString(sum));
  }

  public static void main(String[] args){
    Random rand = new Random();
    int[] value = new int[5];
    for(int i = 0; i < value.length; i++){
      value[i] = rand.nextInt(5 + i);
    }
    accumulatedSum(value);
  }
}
