package daily;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xzx
 * @date 2020/8/3
 */
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        char[] chars1;
        char[] chars2;
        if (num1.length() > num2.length()) {
            chars1 = num1.toCharArray();
            chars2 = num2.toCharArray();
        } else {
            chars1 = num2.toCharArray();
            chars2 = num1.toCharArray();
        }
        boolean levelUp = false;
        // '0' 对应 48
        int i = chars1.length - 1;
        int j = chars2.length -1;
        for (; j >= 0; i--, j--) {
            int sum = levelUp ? chars1[i] + chars2[j] + 1 : chars1[i] + chars2[j];
            if (sum >= 106) {
                // 进位
                levelUp = true;
                chars1[i] = (char) (sum - 58);
            } else {
                levelUp = false;
                chars1[i] = (char) (sum - 48);
            }
        }
        if (chars1.length > chars2.length) {
            // 数组长度还有剩余
            for (; i >=0; i--) {
                if (levelUp) {
                    if (chars1[i] == 57) {
                        chars1[i] = '0';
                    } else {
                        levelUp = false;
                        chars1[i] = (char) (chars1[i] + 1);
                    }
                }
            }
        }
        String s = String.copyValueOf(chars1);
        if (levelUp) {
            // 最后进一位
            s = "1" + s;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(addStrings("58", "8"));
//        char[] a = new char[]{'1'};
//        System.out.println(String.copyValueOf(a));
    }
}
