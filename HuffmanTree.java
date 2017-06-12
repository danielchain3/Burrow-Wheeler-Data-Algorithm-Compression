import java.util.ArrayList;
import java.util.PriorityQueue<E>;
import java.util.HashMap;

public class HuffmanTree{

	private HuffmanTreeNode _root;
	private int _size;
	private HashMap<Character, Integer> _frequencyTable;

	public HuffmanTree(MTFE input){
		
	}

	public void calculateFrequency(MTFE input){
		int val;
		char ascii;
		
		for (int i = 0; i < 257; i++){
			_asciiTable.add((char) i);
		
		ArrayList<Integer> array = input.encoded();
		for (int i = 0; i < input.encoded().size(); i++){
			val = array.get(i);
			ascii = 
			if (_frequencyTable.get(
