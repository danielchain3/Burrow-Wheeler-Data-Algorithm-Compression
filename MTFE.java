import java.util.*;

public class MTFE{
	
	private ArrayList<Character> _asciiTable = new ArrayList<Character>();
	private ArrayList<Character> _characters = new ArrayList<Character>();
	private ArrayList<Integer> _encoded = new ArrayList<Integer>();
	private HashMap<Character, Integer> _frequencyTable = new HashMap<Character, Integer>();
	private String _decoded;
	private int _size;
	private int _rowOfOriginal;
	
	public MTFE(BWTE input){
		createAsciiTable();
		_size = input.getEncoded().length();
		_decoded = input.getEncoded();
		encoding(_decoded);
		calculateFrequency();
		_rowOfOriginal = input.getRow();
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

	public void calculateFrequency(){
		int index, value;
		Character ascii;
		
		ArrayList<Character> newAsciiTable = new ArrayList<Character>();

		for (int i = 0; i < 257; i++)
			newAsciiTable.add((char) i);

		for (int i = 0; i < _encoded.size(); i++){
			index = _encoded.get(i); //used as an index
			ascii = newAsciiTable.get(index);
			
			if(_frequencyTable.containsKey(ascii)){
				_characters.add(ascii);
				_frequencyTable.put(ascii, _frequencyTable.get(ascii) + 1);
			}

			else{
				_characters.add(ascii);
				_frequencyTable.put(ascii, 1);
			}

			value = newAsciiTable.get(index);
			newAsciiTable.add(0, newAsciiTable.remove(index));
		}
	}

	public ArrayList<Character> getAsciiTable(){
		return _asciiTable;
	}

	public ArrayList<Character> getCharacters(){
		return _characters;
	}

	public ArrayList<Integer> getEncodedMessage(){
		return _encoded;
	}

	public String getDecodedMessage(){
		return _decoded;
	}

	public HashMap<Character, Integer> getFrequencyTable(){
		return _frequencyTable;
	}

    public int getRow(){
        return _rowOfOriginal;
    }
}
