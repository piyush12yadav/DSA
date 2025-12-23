package Array.Operation;

public class MyArray {
    private int[] arr;
    private int size;

    MyArray(){
        arr = new int[2];   // initial capacity;
        size = 0; // initial value;
    }

    public void add(int val){
        if(size == arr.length){
            resize();
        }
        arr[size++] = val;
    }
    private void resize() {
        int[] newArr = new int[arr.length * 2];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;

        if (size > 0 && size <= arr.length / 4) {
            shrink();
        }
    }

    private void shrink() {
        int[] newArr = new int[arr.length / 2];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }



    public int getValueByIndex(int idx){
        if(idx<0 || idx >= size){
            throw new IndexOutOfBoundsException();
        }

        return arr[idx];
    }

}
