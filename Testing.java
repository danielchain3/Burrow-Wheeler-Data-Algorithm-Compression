public class Testing{

    //for square matrices
    public static void printMatrix(String[][] given){
        for(int i = 0; i < given.length; i++){
            for(int j = 0; j < given.length; j++){
                System.out.print(given[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        String test = "Somebody Once Told Me";
        BWTE a = new BWTE(test);
        String[][] mat = a.createMatrix();
        printMatrix(mat);

        System.out.println("Then sort the arrays:");
        int rowOfOriginal = a.sortMatrix(mat); //sortMatrix also produces an integer. 
        printMatrix(mat);

        System.out.println("Take the last column of letters and turn them into a string: ");
        System.out.println("\t" + "Encoded: " + a.getEncoded());
        System.out.println("\t" + "Row of original: " + rowOfOriginal);

        BWTD aDecoded = new BWTD(a);
        System.out.println("\n" + "\"dyeenlocmMoo ObTS e d\" Decoded: " + aDecoded.getDecoded());


    }
}