import java.util.*;

public class Huffman{

	private String _decoded;
	private String _encoded;
	private HashMap<Character,Integer> _frequencyTable;
	private HuffmanTreeNode _root;

	public Huffman(HuffmanTree rt, MTFE input){
		_decoded = input.getDecodedMessage();
		_frequencyTable = input.getFrequencyTable();
		_root = rt.getTree();
		createEncodedMessage(input.getCharacters(), _root);

	}
	
	public void createEncodedMessage(ArrayList<Character> input, HuffmanTreeNode rt){
		Character value;
		Integer frequency;
		HuffmanTreeNode root = rt;

		for (int i = 0; i < input.size(); i++){
			value = input.get(i);
			frequency = _frequencyTable.get(value);

			_encoded +=find(frequency,root));
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
