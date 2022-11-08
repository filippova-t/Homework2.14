import exception.*;


import java.util.Arrays;

public class IntListImpl implements IntList{
    public Integer[] numbers;
    private int size;

    public IntListImpl() {numbers = new Integer [3];
    }

    public IntListImpl(int newSize) {numbers = new Integer [newSize];
    }

    @Override
    public Integer add(Integer item) {
        checkItem(item);
        checkSize();
        numbers[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkIndexIsNotNegative(index);
        checkItem(item);
        checkSize();
        if (index == size) {
            numbers[size++] = item;;
            return item;
        }
        System.arraycopy(numbers, index, numbers, index+1, size - index);

        numbers[index] = item;
        size++;
        return item;
    }
    @Override
    public void grow() {
        numbers = Arrays.copyOf(numbers, size*15/10);
    }


    @Override
    public Integer set(int index, Integer item) {
        checkIndexIsNotNegative(index);
        checkIndexIsNotMoreThanSize(index);
        checkItem(item);
        numbers[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException("Данный элемент не найден в списке");
        }
        System.arraycopy(numbers, index+1, numbers, index, size - index);

        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        checkIndexIsNotNegative(index);
        checkIndexIsNotMoreThanSize(index);
        Integer item = numbers [index];
        System.arraycopy(numbers, index+1, numbers, index, size - index);

        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
       Integer [] numbersCopy = toArray();
        quickSort(numbersCopy, 0, numbersCopy.length-1);
        return binarySearch(numbersCopy, item);
    }

    @Override
    public Integer indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(numbers[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(numbers[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndexIsNotNegative(index);
        checkIndexIsNotMoreThanSize(index);
        return numbers[index];
    }

    @Override
    public boolean equals(IntList otherList) {
        if (otherList.equals(null)) {
            throw new ListIsNullException("Список в параметре метода равен null");
        } else {
            return Arrays.equals(numbers, otherList.toArray());
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(numbers, size);
    }

    private void checkItem (Integer item) {
        if (item == null){
            throw new ElementIsNullException("Добавляемый элемент равен null");

        }
    }

    private void checkSize(){
        if (size == numbers.length) {
            grow();
        }
    }

    private void checkIndexIsNotNegative (int index) {
        if (index < 0) {
            throw new IllegalIndexException("Индекс не может быть отрицательным");
        }
    }
    private void checkIndexIsNotMoreThanSize (int index) {
        if (index >= size) {
            throw new IllegalIndexException("Индекс не может превышать длину массива");
        }
    }


    @Override
    public void sort() {
        quickSort(numbers, 0, numbers.length -1);
    }


    public void quickSort(Integer[] arr, int begin, int end) {
            if (begin < end) {
                int partitionIndex = partition(arr, begin, end);

                quickSort(arr, begin, partitionIndex - 1);
                quickSort(arr, partitionIndex + 1, end);
            }
        }

        private static int partition(Integer [] arr, int begin, int end) {
            Integer pivot = arr[end];
            int i = (begin - 1);

            for (int j = begin; j < end; j++) {
                if (arr[j] <= pivot) {
                    i++;

                    swapElements(arr, i, j);
                }
            }

            swapElements(arr, i + 1, end);
            return i + 1;
        }


    private static void swapElements(Integer[] arr, int left, int right) {
        Integer temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    @Override
    public boolean binarySearch(Integer[] numbers, Integer element) {
        //quickSort(numbers, numbers[0], numbers[size-1]);
        int min = 0;
        int max = size - 1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (element.equals(numbers[mid])) {
                return true;
            }
            if (element < numbers[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }


}