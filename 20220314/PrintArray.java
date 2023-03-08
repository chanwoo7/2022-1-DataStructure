import java.util.Arrays;

public class PrintArray{
  public static void main(String[] args){
    int[] a = new int[3];
    for(int i = 0; i < a.length; i++){
      a[i] = i * 3;
    }

    System.out.print("Int Array : a = ");
    System.out.println(Arrays.toString(a));

    char[] b = {'a', 'b', 'c', 'd', 'e', 'f'};
    System.out.print("Char Array : b = ");
    System.out.println(Arrays.toString(b));

    Object[] obj = new Object[5];
    for(int i = 0; i < obj.length; i++){
      obj[i] = i * 5;
    }
    System.out.print("Object Array : obj = ");
    System.out.println(Arrays.toString(obj));
  }
}
