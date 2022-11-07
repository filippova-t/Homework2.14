import exception.*;


import java.util.Arrays;

public class IntListImpl implements IntList{
    public final Integer[] numbers;
    private int size;

    public IntListImpl() {numbers = new Integer [10];
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
        checkIndex(index);
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
    public Integer set(int index, Integer item) {
        checkIndex(index);
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
        System.arraycopy(numbers, index+1, numbers, index, size - index + 1);

        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = numbers [index];
        System.arraycopy(numbers, index+1, numbers, index, size - index + 1);

        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        //Integer[] numbersCopy = toArray();
        sortInsertion();
        return binarySearch(item);
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
        checkIndex(index);
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
            throw new StringIsNullException("Добавляемый элемент равен null");

        }
    }

    private void checkSize(){
        if (size == numbers.length) {
            throw new StringListOverflowException("Массив заполнен полностью");
        }
    }

    private void checkIndex (int index) {
        if (index < 0 || index > size) {
            throw new IllegalIndexException("Индекс отрицательный либо превышает длину массива");
        }
    }


    @Override
    public void sortInsertion() {

        for (int i = 1; i < size; i++) {
            int temp = numbers[i];
            int j = i;
            while (j > 0 && numbers[j - 1] >= temp) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = temp;
        }
    }

    @Override
    public boolean binarySearch(Integer element) {
        sortInsertion();
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
