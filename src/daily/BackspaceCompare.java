package daily;

/**
 * @author xzx
 * @date 2020/10/19
 */
public class BackspaceCompare {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int count;
        while (i >= 0 && j >= 0) {
            count = 0;
            while (i >= 0 && S.charAt(i) == '#') {
                i--;
                count++;
            }
            i -= count;
            count = 0;
            while (j >= 0 && T.charAt(j) == '#') {
                j--;
                count++;
            }
            j -= count;
            if ((i < 0 && j >= 0) || (j < 0 && i >= 0)) {
                return false;
            }
            if (S.charAt(i) != T.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
