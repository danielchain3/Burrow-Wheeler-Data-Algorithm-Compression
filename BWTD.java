public class BWTD{

    //supposedly takes the result of move to front decoding

    private String _encodedString;
    private int _rowOfOriginal;
    private int _length;
    
    //gets the output of reverse 
    public BWTD(MTFD encoded){ 
        _encodedString = encoded.getDecodedMessage();
        _rowOfOriginal = encoded.getRow();
        _length = _encodedString.length();
    }

    public String getDecoded(){
        return this.decode();
    }

    //add the last column to the front and keep sorting it
    //start building from the back
    public String[][] recreateMatrix(){
        String [][] mat = new String[_length][_length];
        for(int j = _length-1; j >= 0; j--){ //column
            for(int i = 0; i < _length; i++){//row
		        mat[i][j] = _encodedString.substring(i, i+1);
	    }
	    sortMatrix(mat);
        }
        return mat;
    }

    public int compare(String[] a, String[] b){
        String a2 = arrayToString(a);
        String b2 = arrayToString(b);
        return (a2.toLowerCase().compareTo(b2.toLowerCase()));    
    }

    public String arrayToString(String[] a){
        String word = "";
        for(int i = 0; i < a.length; i++){
	    if(a[i] == null){
		word += "";
	    } else {
		word += a[i];
	    }
        }
        return word;
    }

    public void sortMatrix(String[][] given){
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
    }

    public static void printMatrix(String[][] given){
        int length = given.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++){
                System.out.print(given[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String decode(){
        String [][] mat = recreateMatrix();
        sortMatrix(mat);
        String ans = "";
        for(int i = 0; i < _length; i++){ //column
            ans += mat[_rowOfOriginal][i];
        }
        return ans;
    }
    
}
