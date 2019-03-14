import java.io.*;
import java.util.*;

public class HuffmanCode{

	private Queue<HuffmanNode> pQueue;
	private HuffmanNode root;


	private class HuffmanNode implements Comparable<HuffmanNode> {
   	public int character;
   	public int frequency;
   	public HuffmanNode left;
   	public HuffmanNode right;
   
   	public HuffmanNode(int character, int frequency, 
   					HuffmanNode left, HuffmanNode right ){
   		this.character = character;
   		this.frequency = frequency;
   		this.left = left;
   		this.right = right;
	}


	public HuffmanNode(int character, int frequency){
		this(character, frequency, null, null);
	}

	public HuffmanNode(int character){
		this(character, -1, null, null);
	}
		   
   
   	public int compareTo(HuffmanNode other){
   		if (this.frequency < other.frequency){
   			return -1;
   		} else  if (this.frequency > other.frequency){
   			return 1;
   		} else {
   			return 0;
   		}
   	}
   }

//     This constructor should initialize a new HuffmanCode object using the algorithm described for making
// a code from an array of frequencies. frequencies is an array of frequencies where frequences[i]
// is the count of the character with ASCII value i. Make sure to use a PriorityQueue to build the
// huffman code.
    public HuffmanCode(int[] frequencies){
		pQueue = new PriorityQueue<HuffmanNode>();
		for (int i = 0; i < frequencies.length; i++){
			if (frequencies[i] != 0){
				pQueue.add(new HuffmanNode(i, frequencies[i]));
				
			}
		}

		while (pQueue.size() != 1){
			HuffmanNode one = pQueue.remove();
			HuffmanNode two = pQueue.remove();
			HuffmanNode combine = new HuffmanNode(-1, one.frequency+two.frequency, one, two);
			pQueue.add(combine);
		  }
		root = pQueue.remove();
    }

    // This constructor should initialize a new HuffmanCode object by reading in a previously constructed
    // code from a .code file. You may assume the Scanner is not null and is always contains data
    // encoded in legal, valid standard format.
    public HuffmanCode(Scanner input){
		root = new HuffmanNode(-1);
		while (input.hasNextLine()){
			int character = Integer.parseInt(input.nextLine());
			String path = input.nextLine();
			root = buildTree(root, character, path);
		}

	}
	
	private HuffmanNode buildTree(HuffmanNode node, int character, String path){
		if (node == null){
			node = new HuffmanNode(-1);
		}
		if (path.length() == 1){
			if (path.substring(0).equals("0")){
				node.left = new HuffmanNode(character);
			} else {
				node.right = new HuffmanNode(character);
			}
	
		}
		else if (path.substring(0,1).equals("0")){
			node.left = buildTree(node.left, character, path.substring(1));
		} else {
			node.right = buildTree(node.right, character, path.substring(1));
		}

		return node;


	}

//  This method should store the current huffman codes to the given output stream in the standard
//  format described above.
    public void save(PrintStream output){
		writeCode(root, output, "");
	}
	
	private void writeCode(HuffmanNode node, PrintStream output, String str){
		if (node != null){
			if (node.left == null && node.right == null){
				output.println(node.character);
				output.println(str);
			} else {
				writeCode(node.left, output, str+"0");
				writeCode(node.right, output, str+"1");
			}
		}
	}
// This method should read individual bits from the input stream and write the corresponding characters
// to the output. It should stop reading when the BitInputStream is empty. You may assume that
// the input stream contains a legal encoding of characters for this tree’s huffman code. See below
// for the methods that a BitInputStream has.
    public void translate(BitInputStream input, PrintStream output){
		while (input.hasNextBit()){
			HuffmanNode temp = root;
			while (temp.left != null && temp.right != null){
				if (input.nextBit() == 0){
					temp = temp.left;
				} else {
					temp = temp.right;
				}
			}
			output.print((char)temp.character);

		}
	}
	


}


