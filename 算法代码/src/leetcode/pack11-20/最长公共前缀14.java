public class 最长公共前缀14 {


    /**
     *
     * 个人解法 先找出最短的字符串 然后取出最短字符串，拿出每一个字符对数组的每一个字符串的对应位置进行一一对比
     * 效率 88.56 // 94.66
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        if(strs.length==0){
            return "";
        }

        StringBuilder result=new StringBuilder("");
        int mintmp=strs[0].length();
        for(int i=0;i<strs.length;i++){
            if(mintmp>strs[i].length()){
                mintmp=strs[i].length();
            }
        }
        char tmp,center;

        for(int i=0;i<mintmp;i++){
            //最短字符串的字符指针
            center=strs[0].charAt(i);
            //遍历每个字符串的这个位置
            for(int j=0;j<strs.length;j++){

                tmp=strs[j].charAt(i);
                if(tmp!=center){
                    return result.toString();
                }

            }

            result.append(center);

        }

        return result.toString();



    }

    public static void main(String[] args) {


        String rs=new 最长公共前缀14().longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(rs);

    }


}
