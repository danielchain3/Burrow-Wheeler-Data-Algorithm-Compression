import java.util.*;

public class Huffman{

	private String _decoded;
	private String _encoded;
	private HuffmanTreeNode _root;
	private String[] st = new String[256];
	
	public Huffman(HuffmanTree rt, MTFE input){
		_decoded = input.getDecodedMessage();
		_root = rt.getTree();
        buildCode(st, _root, "");
		createEncodedMessage(input.getCharacters());
	}
	
	public void createEncodedMessage(ArrayList<Character> input){
		Character letter;
		_encoded = "";

		for (int i = 0; i < input.size(); i++){
			letter = input.get(i);
			_encoded += st[letter];
		}
	}

    private static void buildCode(String[] st, HuffmanTreeNode x, String s) {
		if (!x.isLeaf()) {
			buildCode(st, x.getLeft(),  s + '0');
			buildCode(st, x.getRight(), s + '1');
		}
		else {
			st[x.getLetter()] = s;
		}
	}

	public String[] getSt(){
		return st;
	}

	public String getEncodedMessage(){
		return _encoded;
	}

	public String getDecodedMessage(){
		return _decoded;
	}
}
