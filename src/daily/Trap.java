package daily;

/**
 * @author xzx
 * @date 2020/10/19
 */
public class Trap {

    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int result = 0;
        // 先找到第一个不为0的数字
        int i = 0;
        while (i<height.length && height[i] == 0) {
            i++;
        }
        if (i >= height.length) {
            // 全是0
            return 0;
        }
        // 找到最后一个不为0的数字
        int j = height.length - 1;
        while (j >= 0 && height[j] == 0) {
            j--;
        }
        // 找到最大的数字
        int max = -1;
        int maxIndex = -1;
        for (int k = 0; k < height.length; k++) {
            if (height[k] > max) {
                max = height[k];
                maxIndex = k;
            }
        }
        int last = height[i];
        i++;
        int temp = 0;
        for (; i <= maxIndex; i++) {
            if (height[i] < last) {
                temp += (last - height[i]);
            } else {
                last = height[i];
                result += temp;
                temp = 0;
            }
        }
        last = height[j];
        temp = 0;
        j--;
        for (; j >= maxIndex; j--) {
            if (height[j] < last) {
                temp += (last - height[j]);
            } else {
                last = height[j];
                result += temp;
                temp = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(a));
    }
}
