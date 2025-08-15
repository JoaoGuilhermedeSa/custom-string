package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.function.Consumer;

public class CustomStringTest {

    @Test
    public void testToArray() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        assertNotNull(customString.toArray());
        assertEquals(data.length, customString.toArray().length);
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], customString.toArray()[i]);
        }
    }

    @Test
    public void testForEach() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        final StringBuilder sb = new StringBuilder();
        customString.forEach(new Consumer<Character>() {
            @Override
            public void accept(Character c) {
                sb.append(c);
            }
        });
        assertEquals("test", sb.toString());
    }

    @Test
    public void testReverse() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        CustomString reversedString = customString.reverse();
        assertEquals("tset", reversedString.toString());
    }

    @Test
    public void testIterator() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        StringBuilder sb = new StringBuilder();
        for (char c : customString) {
            sb.append(c);
        }
        assertEquals("test", sb.toString());
    }

    @Test
    public void testLength() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        assertEquals(4, customString.length());
    }

    @Test
    public void testCharAt() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        assertEquals('t', customString.charAt(0));
        assertEquals('e', customString.charAt(1));
        assertEquals('s', customString.charAt(2));
        assertEquals('t', customString.charAt(3));
    }

    @Test
    public void testEquals() {
        char[] data1 = { 't', 'e', 's', 't' };
        char[] data2 = { 't', 'e', 's', 't' };
        char[] data3 = { 'T', 'E', 'S', 'T' };
        CustomString customString1 = new CustomString(data1);
        CustomString customString2 = new CustomString(data2);
        CustomString customString3 = new CustomString(data3);
        assertTrue(customString1.equals(customString2));
        assertFalse(customString1.equals(customString3));
    }

    @Test
    public void testIsEmpty() {
        CustomString customString1 = new CustomString(new char[0]);
        CustomString customString2 = new CustomString(new char[] { 't', 'e', 's', 't' });
        assertTrue(customString1.isEmpty());
        assertFalse(customString2.isEmpty());
    }

    @Test
    public void testReplace() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        CustomString replacedString = customString.replace('t', 'p');
        assertEquals("pesp", replacedString.toString());
    }

    @Test
    public void testSubstring() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        CustomString substring = customString.substring(1, 3);
        assertEquals("es", substring.toString());
    }

    @Test
    public void testTrim() {
        char[] data = { ' ', ' ', 't', 'e', 's', 't', ' ', ' ' };
        CustomString customString = new CustomString(data);
        CustomString trimmedString = customString.trim();
        assertEquals("test", trimmedString.toString());
    }

    @Test
    public void testToJson() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        assertEquals("{\"value\":\"test\"}", customString.toJson());
    }

    @Test
    public void testIndexOf() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        assertEquals(0, customString.indexOf('t'));
        assertEquals(1, customString.indexOf('e'));
        assertEquals(2, customString.indexOf('s'));
        assertEquals(-1, customString.indexOf('a'));
    }

    @Test
    public void testHashCode() {
        char[] data1 = { 't', 'e', 's', 't' };
        char[] data2 = { 't', 'e', 's', 't' };
        CustomString customString1 = new CustomString(data1);
        CustomString customString2 = new CustomString(data2);
        assertEquals(customString1.hashCode(), customString2.hashCode());
    }

    @Test
    public void testToString() {
        char[] data = { 't', 'e', 's', 't' };
        CustomString customString = new CustomString(data);
        assertEquals("test", customString.toString());
    }
}