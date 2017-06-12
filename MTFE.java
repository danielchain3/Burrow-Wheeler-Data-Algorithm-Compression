import java.util.ArrayList;
import java.util.HashMap;

public class MTFE{
	
	private ArrayList<Character> _asciiTable = new ArrayList<Character>();
	private String _decoded;
	private ArrayList<Integer> _encoded = new ArrayList<Integer>();
	private int _size;
	private HashMap<Character, Integer> _frequencyTable;

	public MTFE(String input){
		asciiTable();
		_size = input.length();
		_decoded = input;
		encoding(_decoded);
		_frequencyTable = new HashMap<Character, Integer>();
	}

	public MTFE(ArrayList<Integer> input){
		createAsciiTable();
		_size = input.size();
		_encoded = input;
		decoding(_encoded);
		_frequencyTable = new HashMap<Character, Integer>();
	}

	public void createAsciiTable(){
		for (int i = 0; i < 257; i++){
			_asciiTable.add((char) i);
		}
	}

	
	//encodes the message into a series of integers
	public void encoding(String input){
		//Implemented to reduce redundancy
		int length = input.length();
		int pos; 

		//makes the input into an array of chars
		char[] charArray = input.toCharArray();

		for (int i = 0; i < length; i++){
			pos = _asciiTable.indexOf(charArray[i]);
			_encoded.add(pos);

			_asciiTable.add(0,_asciiTable.remove(pos));
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

	public void calculateFrequency(){
		int val;
		char ascii;
		
		ArrayList<Character> newAsciiTable = new ArrayList<Character>();

		for (int i = 0; i < 257; i++)
			newAsciiTable.add((char) i);

		for (int i = 0; i < _encoded.size(); i++){
			val = _encoded.get(i); //used as an index
			ascii = newAsciiTable.get(val);
			
			if(_frequencyTable.containsKey(ascii))
				_frequencyTable.put(ascii, _frequencyTable.get(ascii) + 1);

			else
				_frequencyTable.put(ascii, 1);
		}
	}

	public ArrayList<Character> asciiTable(){
		return _asciiTable;
	}


	public ArrayList<Integer> encodedMessage(){
		return _encoded;
	}

	public String decodedMessage(){
		return _decoded;
	}

	public HashMap frequencyTable(){
		return _frequencyTable;
	}
}
