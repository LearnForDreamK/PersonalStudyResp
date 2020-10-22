public class 整数转罗马数字12 {

    /**
     *
     * 整数转罗马数字
     * @param num
     * @return
     */

   public String intToRoman(int num) {

            /**
             1000 M
             900 CM
             500 D
             400 CD
             100 C
             90 XC
             50 L
             40 XL
             10 X
             9 IX
             5 V
             4 IV
             1 I

             */
            if(num<1||num>3999) {
                return "0";
            }

            //两数组一一对应
            int[] keys={1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] values={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            int counts=0;
            StringBuilder result=new StringBuilder();
            int sum;
            for(sum=0;sum<num;){
                if((keys[counts]+sum)<=num){
                    sum=sum+keys[counts];
                    result.append(values[counts]);
                    if(sum==num){
                        break;
                    }
                }else{
                    if(counts!=12) {
                        counts++;
                    }
                }

            }
            return result.toString();
        }

    public static void main(String[] args) {
        String a=new 整数转罗马数字12().intToRoman(8);
        System.out.println(a);
    }


}
