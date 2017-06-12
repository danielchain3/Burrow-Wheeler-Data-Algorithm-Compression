public class BWTE{

    private String _givenString;
    private int _length;
    private String _encoded;
    private int _rowOfOriginal;

    public BWTE(String givenString){
        _givenString = givenString;
        _length = givenString.length();
        _encoded = createBWT(); 
	    _rowOfOriginal = sortMatrix(createMatrix());
    } 


    //accessor methods
    public int getRow(){
        return _rowOfOriginal;
    }

    //gets the whole thing
    public String getEncoded(){
	    return _encoded;
    }

    //creates a matrix with all the rotations of the string
    public String[][] createMatrix(){
	String[][] rotations = new String[_length][_length];
	for(int i = 0; i < _length; i++){ //row
	    int k = i;
	    for(int j = 0; j < _length; j++){ //column
		rotations[i][j] = _givenString.substring(k, k+1);
		k = (k+1) % _length;
	    }
	}
	return rotations;
    } 

    //uses insertion sort to sort matrix and returns row with original
    public int sortMatrix(String[][] given){
        for(int currIndex = 0; currIndex < _length-1; currIndex++){
            int currTempIndex = currIndex; //keeps track of index of array being walked down
            while(compare(given[currTempIndex], given[currTempIndex+1]) > 0){ //the latter is supposed to come before the former
                //swap
                String [] temp = given[currTempIndex];
                given[currTempIndex] = given[currTempIndex + 1];
                given[currTempIndex + 1] = temp;
                if(currTempIndex != 0){
                    currTempIndex--;
                }
            }
        }
        return binarySearch(_givenString, given);
    }

    //compares two arrays
    //returns positive if b comes before a
    //returns negative if b comes after a
    //returns 0 if they are the same
    public int compare(String[] a, String[] b){
        return (arrayToString(a).compareTo(arrayToString(b)));    
    }

    //turns an array into a string
    public String arrayToString(String[] a){
        String word = "";
        for(int i = 0; i < a.length; i++){
            word += a[i].toLowerCase();
        }
        return word;
    }


    //performs binary search to find the original thing
    public int binarySearch(String key, String[][] sorted){
        int lower = 0;
        int upper = sorted.length;
        int middle;
        while (lower < upper){
            middle = lower + (upper - lower) /2;
            if(arrayToString(sorted[middle]).compareTo(key.toLowerCase()) == 0){
                return middle;
            } else if(arrayToString(sorted[middle]).compareTo(key.toLowerCase()) > 0){ //in first half
                upper = middle;
            } else {
                lower = middle + 1;
            } 
        }
        return -1; //should never happen but java was dogging me for a return statement
    }


    //given a sorted matrix, produces a String from last letter of each array
    public String produceString(String[][] sorted){
        String ans = "";
        for(int i = 0; i < _length; i++){
            ans += sorted[i][sorted.length - 1]; 
        }
        return ans;
    }

    //produces BWT 
    public String createBWT(){
        String [][] mat = createMatrix();
        _rowOfOriginal = sortMatrix(mat);
	    return produceString(mat);
    }




    
}
