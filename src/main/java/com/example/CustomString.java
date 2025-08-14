package com.example;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomString implements Iterable<Character> {

    private final char[] value;

    public CustomString(char[] value) {
        this.value = value;
    }

    public char[] toArray() {
        return value;
    }

    public void forEach(Consumer<? super Character> action) {
        for (char c : value) {
            action.accept(c);
        }
    }

    public CustomString reverse() {
        char[] reversedValue = new char[value.length];
        for (int i = 0; i < value.length; i++) {
            reversedValue[i] = value[value.length - 1 - i];
        }
        return new CustomString(reversedValue);
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < value.length;
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return value[currentIndex++];
            }
        };
    }

    public int length() {
        return value.length;
    }

    public char charAt(int index) {
        return value[index];
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof CustomString) {
            CustomString anotherString = (CustomString) anObject;
            if (value.length != anotherString.value.length) {
                return false;
            }
            for (int i = 0; i < value.length; i++) {
                if (value[i] != anotherString.value[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return value.length == 0;
    }

    public CustomString replace(char oldChar, char newChar) {
        char[] replacedValue = new char[value.length];
        for (int i = 0; i < value.length; i++) {
            if (value[i] == oldChar) {
                replacedValue[i] = newChar;
            } else {
                replacedValue[i] = value[i];
            }
        }
        return new CustomString(replacedValue);
    }

    public CustomString substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > value.length || beginIndex > endIndex) {
            throw new StringIndexOutOfBoundsException();
        }
        int subLen = endIndex - beginIndex;
        char[] subValue = new char[subLen];
        System.arraycopy(value, beginIndex, subValue, 0, subLen);
        return new CustomString(subValue);
    }

    public CustomString trim() {
        int start = 0;
        int end = value.length - 1;
        while ((start <= end) && (value[start] <= ' ')) {
            start++;
        }
        while ((end >= start) && (value[end] <= ' ')) {
            end--;
        }
        return substring(start, end + 1);
    }

    public String toJson() {
        return "{\"value\":\"" + new String(value) + "\"}";
    }

    public int indexOf(char ch) {
        for (int i = 0; i < value.length; i++) {
            if (value[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int hashCode() {
        int h = 0;
        for (char c : value) {
            h = 31 * h + c;
        }
        return h;
    }
}
