import java.util.Arrays;

public class Main {
    private static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minElementIndex];
            arr[minElementIndex] = tmp;
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }



    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] arr = new Integer[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        stringList.add ("string 0");
        stringList.add ("string 1");
        stringList.add ("string 2");
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.add(1, "string new Index");
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove(0);
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove(2);
        System.out.println(Arrays.toString(stringList.toArray()));
        System.out.println( stringList.get(1));
        stringList.clear();
        System.out.println(stringList.size());

        IntList intList = new IntListImpl();
        intList.add(0);
        intList.add(10);
        intList.add(5);
        intList.add(22);
        System.out.println(Arrays.toString(intList.toArray()));
        intList.sortInsertion();
        System.out.println(Arrays.toString(intList.toArray()));

        System.out.println("hello");
        Integer[] arr = generateRandomArray();
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        long start = System.currentTimeMillis();
        sortBubble(arr);
        System.out.print("Сортировка пузырьком ");
        System.out.println(System.currentTimeMillis() - start);

        long start2 = System.currentTimeMillis();
        sortSelection(arr2);
        System.out.print("Сортировка выбором ");
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        sortInsertion(arr3);
        System.out.print("Сортировка вставкой ");
        System.out.println(System.currentTimeMillis() - start3);


    }
    }