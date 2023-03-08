import java.util.Arrays;

@FunctionalInterface
interface LambdaArray{
  void print(int[] a, String name);
}

public class LambdaPrintArray{
  public static void main(String[] args){
    int[] a = new int[5];
    int[] b = {0, 1, 5, 7, 9};
    int[] c = new int[5];

    for(int i = 0; i < a.length; i++){
      a[i] = i * i - i;
      c[i] = a[i] + b[i];
    }

    LambdaArray la = (ar, nm) -> {
      System.out.print("Array " + nm + " = ");
      System.out.println(Arrays.toString(ar));
      System.out.println();
    };

    la.print(a, "a");
    la.print(b, "b");
    la.print(c, "c");
  }
}
