
/**
 * Implements driver to test LCS class.
 * 
 * @author ban 
 */
public class Runner
{
    public static void main(String[] args) {
        String[][] input = {
            {"ABCDGH", "AEDFHR"},
            {"AGGTAB", "GXTXAYB"},
            {"XMJYAUZ", "MZJAWXU"},
            {"ABCDEF", "CDEFAB"},
            {"x", "z"},
            {"", "a"},
            {"HELLO", "WORLD"},
            {"ABCXD", "BCDEF"},
            {"fghdbkr", "qboutue"}
        };
        
        for ( int i = 0; i < input.length; ++i ){
             LCS lcs = new LCS(input[i][0], input[i][1]);
             
             System.out.println(lcs.getLCS());
        }
    }
}
