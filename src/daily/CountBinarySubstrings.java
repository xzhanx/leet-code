package daily;

/**
 * @author xzx
 * @date 2020/8/10
 */
public class CountBinarySubstrings {

    public static int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int count1 = 0;
        int count2 = 0;
        int sum = 0;
        char a = chars[0];
        for (char aChar : chars) {
            if (aChar != a) {
                a = aChar;
                sum += Math.min(count1, count2);
                count2 = count1;
                count1 = 0;
            }
            count1++;
        }
        sum += Math.min(count1, count2);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("10101"));
    }
}
