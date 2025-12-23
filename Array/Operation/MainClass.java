package Array.Operation;

public class MainClass {
   public static void main() {

        MyArray arr = new MyArray();
        arr.add(4);
        arr.add(3);
        arr.add(6);
        int val = arr.getValueByIndex(2);
        System.out.println(val);
    }
}
