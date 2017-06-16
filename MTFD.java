import java.util.*;

public class MTFD{

	private int _size;
    private int _rowOfOriginal;
	private String _decoded;
	private ArrayList<Integer> _encoded;
	private ArrayList<Character> _asciiTable = new ArrayList<Character>();

	public MTFD(HuffmanDecoding input){
		createAsciiTable();
		_rowOfOriginal = input.getRow();
		_encoded = input.getMTFEValues();
		_size = _encoded.size();
		decoding(_encoded);
	}

	public void createAsciiTable(){
		for (int i = 0; i < 257; i++){
			_asciiTable.add((char) i);
		}
	}
	
	public void decoding(ArrayList<Integer> input){		
		_decoded = "";
		int pos;

		for (int i = 0; i < input.size(); i++){
			pos = input.get(i);
			_decoded += _asciiTable.get(pos);
			_asciiTable.add(0,_asciiTable.remove(pos));
		}
	}

	public ArrayList<Character> getAsciiTable(){
		return _asciiTable;
	}

    public int getRow(){
        return _rowOfOriginal;
    }

	public ArrayList<Integer> getEncodedMessage(){
		return _encoded;
	}

	public String getDecodedMessage(){
		return _decoded;
	}
}
