package com.example;

public class App {
	public static void main(String[] args) {
		CustomString customString = new CustomString(
				new char[] { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!' });

		// toArray
		System.out.println("toArray: " + new String(customString.toArray()));

		// forEach
		System.out.print("forEach: ");
		customString.forEach(System.out::print);
		System.out.println();

		// reverse
		System.out.println("reverse: " + customString.reverse());

		// iterator
		System.out.print("iterator: ");
		for (char c : customString) {
			System.out.print(c);
		}
		System.out.println();

		// length
		System.out.println("length: " + customString.length());

		// charAt
		System.out.println("charAt: " + customString.charAt(0));

		// equals
		System.out.println("equals: " + customString
				.equals(new CustomString(new char[] { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!' })));

		// isEmpty
		System.out.println("isEmpty: " + customString.isEmpty());

		// replace
		System.out.println("replace: " + customString.replace('l', 'p'));

		// substring
		System.out.println("substring: " + customString.substring(0, 5));

		// trim
		CustomString customStringWithSpaces = new CustomString(
				new char[] { ' ', ' ', 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!', ' ' });
		System.out.println("trim: " + customStringWithSpaces.trim());

		// toJson
		System.out.println("toJson: " + customString.toJson());

		// indexOf
		System.out.println("indexOf: " + customString.indexOf('o'));

		// hashCode
		System.out.println("hashCode: " + customString.hashCode());
	}
}