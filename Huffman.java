import java.util.*;

public class Huffman{

	private String _decoded;
	private ArrayList<String> _encoded;
	private HashMap<Character,Integer> _frequencyTable;
	private HuffmanTreeNode _root;

	public Huffman(HuffmanTree rt, MTFE input){
		_decoded = input.getDecodedMessage();
		_frequencyTable = input.getFrequencyTable();
		_root = rt.getTree();
		createEncodedMessage(_decoded, _root);
	}

	public void createEncodedMessage(String input, HuffmanTreeNode rt){
		Character value;
		Integer frequency;
		String path = "";
		HuffmanTreeNode root = rt;

		for (int i = 0; i < input.length(); i++){
			value = new Character(input.charAt(i));
			frequency = _frequencyTable.get(value);

			while (frequency != root.getValue() || root == null){
				if (frequency == root.getValue())
					_encoded.add(path);

				if(frequency < root.getLeft().getValue()){
					path += "1";
					root = root.getRight();
				}

				else{
					path += "0";
					root = root.getLeft();
				}
			}
		}
	}

	public ArrayList<String> getEncodedMessage(){
		return _encoded;
	}

	public String getDecodedMessage(){
		return _decoded;
	}
}
