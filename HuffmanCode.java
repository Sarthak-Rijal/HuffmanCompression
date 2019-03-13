import java.io.*;
import java.util.*;

public class HuffmanCode{



	private class HuffmanNode{
	public String character;
	public int frequency;
	public HuffmanNode left;
	public HuffmanNode right;

	public HuffmanNode(String character, int frequency, 
					HuffmanNode left, HuffmanNode right ){
		this.character = character;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
		}
	}

//     This constructor should initialize a new HuffmanCode object using the algorithm described for making
// a code from an array of frequencies. frequencies is an array of frequencies where frequences[i]
// is the count of the character with ASCII value i. Make sure to use a PriorityQueue to build the
// huffman code.
    public HuffmanCode(int[] frequencies){
		System.out.println(frequencies);

    }
    // This constructor should initialize a new HuffmanCode object by reading in a previously constructed
    // code from a .code file. You may assume the Scanner is not null and is always contains data
    // encoded in legal, valid standard format.
    public HuffmanCode(Scanner input){

    }

//  This method should store the current huffman codes to the given output stream in the standard
//  format described above.
    public void save(PrintStream output){

    }
// This method should read individual bits from the input stream and write the corresponding characters
// to the output. It should stop reading when the BitInputStream is empty. You may assume that
// the input stream contains a legal encoding of characters for this tree’s huffman code. See below
// for the methods that a BitInputStream has.
    public void translate(BitInputStream input, PrintStream output){

    }

//     This method returns the next bit in the input stream. If there is no such bit, then it throws a
// NoSuchElementException.
    public int nextBit(){
        return 0;
    }
    
    //This method returns true if the input stream has at least one more bit and false otherwise.
    public boolean hasNextBit(){
        return true;
    }

}

