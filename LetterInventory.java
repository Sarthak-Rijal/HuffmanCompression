// Sarthak Rijal
// CSE 143, AC, Dylan Thomas Jergens, 01/16/2019
// Homework 1
// LetterInventory keeps track of an inventory of the letters of the alphabet
// for a given string.

public class LetterInventory {
	
	private int size;
	private int[] inventory;
	public static final int ALPHABET = 26;
	
	//Constructs an inventory of the alphabetic letters by taking a string as an input
	
	public LetterInventory(String data) {
		inventory = new int[ALPHABET];
		String word = data.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (Character.isLetter(ch)) {
				inventory[ch - 'a'] ++;
				size ++;
			}
		}
	}
	
	//pre: Given input has to be an aphpabetic character
	//(otherwise throw an IllegalArgumentException)
	//
	//post: Returns the number of occurences of a given character in the inventory
	
	public int get(char letter) {
		if (!Character.isLetter(letter)) {
			throw new IllegalArgumentException();
		}
		return inventory[Character.toLowerCase(letter) - 'a'];
	}
	
	//pre: takes a character and an integer as input
	// character has to be an alphabetic letter ,otherwise throws IllegalArgumentException
	// integer has to be greater than or equal to 0, throws IllegalArgumentException
	//
	//post: replaces the count of a letter character with the given integer value
	
	public void set(char letter, int value) {
		if (!Character.isLetter(letter)) {
			throw new IllegalArgumentException();
		} else if (value < 0) {
			throw new IllegalArgumentException();
		}
		int change = value - get(letter);
		inventory[Character.toLowerCase(letter) - 'a'] = value;
		size += change;
	}
	
	//post: returns how many letters are in the inventory
	
	public int size() {
		return size;
	}
	
	//post: returns true if the inventory is empty, false if it is not
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	//post: returns a String representation of the inventory
	
	public String toString() {
		String inventoryLetters = "";
		for (int i = 0; i < ALPHABET; i++) {
			for (int j = 0; j < inventory[i]; j++) {
				inventoryLetters += (char) ('a' + i);
			}
		}
		return "[" + inventoryLetters + "]";
	}
	
	//pre: Takes a LetterInventory Object
	//
	//post: Returns a new LetterInventory Object that represents the
	//combination of this and other LetterInventory Objects
	
	public LetterInventory add(LetterInventory other) {
		LetterInventory sum = new LetterInventory("");
		for (char ch = 'a'; ch <= 'z' ; ch++) {
			sum.set(ch, get(ch) + other.get(ch));
		}
		return sum;
	}
	
	//pre: Takes a LetterInventory Object
	//
	//post: Returns a new LetterInventory Object which removes the ocurrences of letters
	//in this LetterInventory Object form the other LetterInventory Object
	
	public LetterInventory subtract(LetterInventory other) {
		LetterInventory sub = new LetterInventory("");
		sub = add(other);
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (get(ch) - other.get(ch) < 0) {
				return null;
			}
			sub.set(ch, get(ch) - other.get(ch));
		}
		return sub;
	}
}