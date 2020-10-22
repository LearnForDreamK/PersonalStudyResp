import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数13 {


    public int romanToInt(String s) {

        Map<String,Integer> rs=new HashMap<>();
        rs.put("M",1000);
        rs.put("CM",900);
        rs.put("D", 500);
        rs.put("CD", 400);
        rs.put("C", 100);
        rs.put("XC", 90);
        rs.put("L", 50);
        rs.put("XL", 40);
        rs.put("X", 10);
        rs.put("IX", 9);
        rs.put("V", 5);
        rs.put("IV", 4);
        rs.put("I", 1);
        StringBuilder stringBuilder=new StringBuilder();
        int result=0;
        for(int i=s.length()-1;i>=0;i--){//对字符串每个字符遍历  当左边的字母代表的值小于右边的字母的值时  则是特殊值（两个字母）
            //除去最后一个字符的双字符情况
            if(i!=0){
                if(rs.get(String.valueOf(s.charAt(i)))>rs.get(String.valueOf(s.charAt(i-1)))){
                    //这里相加的顺序是先左后右
                    result=result+rs.get(String.valueOf(s.charAt(i-1)) + String.valueOf(s.charAt(i))
                    );
                    //如果最后一个是双字符代表的数字 直接跳出循环
                    if(i==1){
                        i++;
                        break;
                    }
                    i--;//最后i再偏移一位（算了两位字符串的值 指针多向左移一步）
                }else{
                    result = result+rs.get(String.valueOf(s.charAt(i)));
                }
            }else{
                result=result+rs.get(String.valueOf(s.charAt(0)));
            }
        }
        return result;
    }


    /**、
     * 优解
     * @param s
     * @return
     */

        public int romanToInt1(String s) {
            int sum = 0;
            int preNum = getValue(s.charAt(0));
            for(int i = 1;i < s.length(); i ++) {
                int num = getValue(s.charAt(i));
                if(preNum < num) {
                    sum -= preNum;
                } else {
                    sum += preNum;
                }
                preNum = num;
            }
            sum += preNum;
            return sum;
        }

        private int getValue(char ch) {
            switch(ch) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }




    public static void main(String[] args) {

        int c=new 罗马数字转整数13().romanToInt("I");
        System.out.println(c);
    }

}
