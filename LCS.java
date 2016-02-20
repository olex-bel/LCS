
/**
 * This class implements the Longest Common Subsequence algorithm.
 * 
 * @author ban
 */
public class LCS
{
    private final int DIAGONAL = 1;
    private final int UP = 2;
    private final int BACKWORD = 3;
    
    private int solution[][];
    private int lcs[][];
    private int nRows, nCols;
    private String str1, str2;
    
    /**
     * Constructor for objects of class LCS
     * 
     * @param str1
     * @param str2
     */
    public LCS(String str1, String str2)
    {
       this.str1 = str1;
       this.str2 = str2;
       
       initialize();
       lcsLength();
    }

    /**
     * Retruns Longest Common Subsequence.
     * 
     * @return String
     */
    public String getLCS() {
        return traceback(nRows - 1, nCols - 1);
    }
    
    /**
     *  Initializes solution and lcs arrays.
     */
    private void initialize() {
        nRows = str1.length() + 1;
        nCols = str2.length() + 1;
            
        solution = new int[nRows][nCols];
        lcs = new int[nRows][nCols];
    }
    
    /**
     * Computing the length of the LCS.
     */
    private void lcsLength() {
        for ( int i = 1; i < nRows; ++i ) {
            for ( int j = 1; j < nCols; ++j ) {
                if ( str1.charAt(i - 1) == str2.charAt(j - 1) ) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    solution[i][j] = DIAGONAL;
                } else if ( lcs[i - 1][j] >= lcs[i][j-1] ) {
                    lcs[i][j] = lcs[i - 1][j];
                    solution[i][j] = UP;
                } else {
                    lcs[i][j] = lcs[i][j - 1];
                    solution[i][j] = BACKWORD;
                }
            }
        }
        
        printSolutionTable();
    }
    
    /**
     * Prints solution table.
     */
    private void printSolutionTable() {
        System.out.print(' ');
        
        for ( int j = 0; j < str2.length(); ++j ) {
            System.out.print(str2.charAt(j));
            System.out.print(' ');
        }
        
        System.out.println();
        
        for ( int i = 1; i < nRows; ++i ) {
            
            System.out.print(str1.charAt(i - 1));
            
            for ( int j = 1; j < nCols; ++j ) {
                char c = '_';
                
                switch ( solution[i][j] ) {
                    case DIAGONAL:
                        c = '↖';
                        break;
                    case UP:
                        c = '↑';
                        break;
                    case BACKWORD:
                        c = '←';
                        break;
                }
                
                System.out.print(c);
                System.out.print(' ');
            }
            
            System.out.println();
        }
    }
    
    /**
     * Returns longest common subsequence by following the arrows backwards.
     * 
     * @return String 
     */
    private String traceback(int i, int j) {
        if ( (i == 0) || (j == 0) ) {
            return "";
        }
        if ( DIAGONAL == solution[i][j] ) {
            return traceback(i - 1, j - 1) + str1.charAt(i - 1);
        } else if ( UP == solution[i][j] ) {
            return traceback(i - 1, j);
        }
        
        return traceback(i, j - 1);
    }
}
