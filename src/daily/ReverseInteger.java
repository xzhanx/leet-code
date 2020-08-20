package daily;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xzx
 * @date 2020/8/4
 */
public class ReverseInteger {

    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();
        long value = Long.parseLong(sb.toString());
        if (flag) {
            // 负数
            return -value < Integer.MIN_VALUE ? 0 : (int) -value;
        }
        return value > Integer.MAX_VALUE ? 0 : (int) value;
    }

    public static void main(String[] args) {
//        System.out.println(reverse(-120));
//        System.out.println(Arrays.asList(new String[4]));
//        List<Integer> list = new ArrayList<>();
        String s = "E2A253V,E2A403V,KTB09068,KTA09061,ESZ218V,M3A004V,E2A248V,KTB04036,KTA10072,KTA08068,3000409,KTC03007,ESZ038V,KTB09035,E2A417V,KTB01019,ESZ099V,KTA08124,KTB12006,E2A088V,KTA10064,KTB06045,E2A152V,KTA10034,KTB06047,KTB07045,KTB06042,KTA10066,KTA09029,E2A043V,ESZ232V,KTB05067,KTB03017,KTA08077,KTB11003,E2A110V,KTB10015,KTB03022,KTA08074,KTB04045,ESZ271V,KTA08065,E2A392V,KTB05058,KTB08006,KTA08047,E2A011V,ESZ226V,KTB12057,KTB05070,ESZ279V,KTA08127,ESZ042V,KTB10060,KTB11074,KTA10076,KTB04016,KTA08133,ESZ077V,ESZ153V,KTB11069,KTA11045,ESZ009V,E2A172V,KTB09057,M3A038V,E2A267V,KTA10068,E2A254V,KTB05022,KTB01027,KTA10023,E2A034V,KTB11049,KTA10045,ESZ243V,KTA10081,KTA12082,KTB09037,KTA09060,KTA08081,KTC04016,E2A015V,ESZ056V,KTA10073,KTC01001,KTA08048,E2A196V,ESZ267V,M3A020V,KTB12075,KTA08135,KTB08036,KTC03016,E2A212V,E2A221V,E2A356V,E2A359V,KTB11053,ESZ192V,KTA12055,E2A189V,KTA12080,KTB09066,KTC01002,KTB07055,ESZ027V,E2A224V,E2A105V,KTC03018,M3A005V,KTB12073,KTA10057,E2A005V,E2A098V,M3A006V,ESZ242V,KTB07008,KTB06007,K";
        System.out.println(s.split(",").length);
    }
}
