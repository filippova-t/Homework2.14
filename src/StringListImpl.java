import exception.*;

import java.util.Arrays;

public class StringListImpl implements StringList {
    public final String[] strings;
    private int size;

    public StringListImpl() {
        strings = new String [10];
    }

    public StringListImpl(int newSize) {
        strings = new String[newSize];
    }

    @Override
    public String add(String item) {
        checkItem(item);
        checkSize();
       strings[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkIndex(index);
        checkItem(item);
        checkSize();
        if (index == size) {
           strings[size++] = item;;
           return item;
        }
       System.arraycopy(strings, index, strings, index+1, size - index);

        strings[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        checkItem(item);
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
       checkItem(item);
       int index = indexOf(item);
       if (index == -1) {
           throw new ElementNotFoundException("Данная строка не найдена в списке");
       }
       System.arraycopy(strings, index+1, strings, index, size - index);

        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = strings[index];
        System.arraycopy(strings, index+1, strings, index, size - index);

        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;

    }

    @Override
    public int indexOf(String item) {
        checkItem (item);
        for (int i = 0; i < size; i++) {
            if (item.equals(strings[i])) {
              return i;
            }
        }
    return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkItem (item);
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(strings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList.equals(null)) {
            throw new ListIsNullException("Список в параметре метода равен null");
        } else {
            return Arrays.equals(strings, otherList.toArray());
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
    public String[] toArray() {
        return Arrays.copyOf(strings, size);
    }

    private void checkItem (String item) {
        if (item == null){
            throw new ElementIsNullException("Добавляемый элемент равен null");

        }
    }

    private void checkSize(){
        if (size == strings.length) {
            throw new StringListOverflowException("Массив заполнен полностью");
        }
    }

    private void checkIndex (int index) {
        if (index < 0 || index >= size) {
            throw new IllegalIndexException("Индекс отрицательный либо превышает длину массива");
        }
    }


}
