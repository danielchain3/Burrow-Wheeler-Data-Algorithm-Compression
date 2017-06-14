import java.util.*;

public class Huffman{

	private String _decoded;
	private ArrayList<String> _encoded = new ArrayList<String>(); ;
	private HashMap<Character,Integer> _frequencyTable;
	private HuffmanTreeNode _root;
	public String test;

	public Huffman(HuffmanTree rt, MTFE input){
		_decoded = input.getDecodedMessage();
		_frequencyTable = input.getFrequencyTable();
		_root = rt.getTree();
		test = test(input.getCharacters(), _root);
		createEncodedMessage(input.getCharacters(), _root);

	}
	
	public String test(ArrayList<Character> input, HuffmanTreeNode rt){
		Character value;
		Integer frequency;
		String path = "";
		HuffmanTreeNode root = rt;
		boolean test;

		for (int i = 0; i < input.size(); i++){
			value = input.get(i);
			path += "Value: " + value + "\t";
			frequency = _frequencyTable.get(value);
			path += "Frequency: " + frequency + "\t" + (frequency < root.getRight().getValue()) + "\t" + root.getRight().getValue() + "\n";
		}

		return path;
	}

	public void createEncodedMessage(ArrayList<Character> input, HuffmanTreeNode rt){
		Character value;
		Integer frequency;
		HuffmanTreeNode root = rt;

		for (int i = 0; i < input.size(); i++){
			value = input.get(i);
			frequency = _frequencyTable.get(value);

			_encoded.add(find(frequency,root));
		}
	}


    private String find(Integer val, HuffmanTreeNode root){
		HuffmanTreeNode curr = root;
		String retString = "";

		while (curr != null && !val.equals(curr.getValue())){
		    if (val.compareTo(curr.getValue()) < 0) {
				retString += 0;
				curr = curr.getLeft();
			}

		    else{ 
				retString += 1;
				curr = curr.getRight();
			}
		}
		return retString;
	}

	public ArrayList<String> getEncodedMessage(){
		return _encoded;
	}

	public String getDecodedMessage(){
		return _decoded;
	}
}
