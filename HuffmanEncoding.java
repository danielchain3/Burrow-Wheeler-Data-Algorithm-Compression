import java.util.*;

public class HuffmanEncoding{

	private int _rowOfOriginal;
	private ArrayList<Integer> _decoded;
	private String _encoded;
	private String[] _conversionTable = new String[257];
	private HuffmanTreeNode _root;

	public HuffmanEncoding(HuffmanTree rt, MTFE input){
		_decoded = input.getEncodedMessage();
		_root = rt.getTree();
        buildTable(_conversionTable, _root, "");
		createEncodedMessage(input.getCharacters());
		_rowOfOriginal = input.getRow();
	}
	
	private void createEncodedMessage(ArrayList<Character> input){
		Character letter;
		_encoded = "";

		for (int i = 0; i < input.size(); i++){
			letter = input.get(i);
			_encoded += _conversionTable[letter];
		}
	}

    private void buildTable(String[] table, HuffmanTreeNode node, String s) {
		if (!node.isLeaf()) {
			buildTable(_conversionTable, node.getLeft(),  s + '0');
			buildTable(_conversionTable, node.getRight(), s + '1');
		}
		else {
			table[node.getLetter()] = s;
		}
	}

	public String[] getConversionTable(){
		return _conversionTable;
	}

	public String getEncodedMessage(){
		return _encoded;
	}

	public ArrayList<Integer> getDecodedMessage(){
		return _decoded;
	}

    public int getRow(){
        return _rowOfOriginal;
    }
}
