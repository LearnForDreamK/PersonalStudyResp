import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合17 {

    /**
     *
     * 时间复杂度高
     * 注 stringbuilder
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        List<String> result=new ArrayList<>();

        String[] maps=new String[]{
        // 0  1   2     3     4     5    6      7     8      9
          "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        if(digits.length()==0){
            return result;
        }
        findAnswer(digits, 0, "", result, maps);
        return  result;
    }


    public void findAnswer(String digits,int index,String currentString,List<String> result,String[] tables ){
        //递归的出口 表示当前字符串长度和数字字符串长度相同
        if(index==digits.length()){
            result.add(currentString);
            return;
        }
        //字符都是数字 得到对应字符串的下标
        String table=tables[digits.charAt(index)-'0'];
        for(int i=0;i<table.length();i++){
            findAnswer(digits, index+1, currentString+table.charAt(i), result, tables);
        }

    }


    /**
     *
     * 队列解决
     * @param digits
     * @return
     */
    public List<String> letterCombinationsQueue(String digits) {
        if(digits==null || digits.length()==0) {
            return new ArrayList<String>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letter_map = {
                " ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for(int i=0;i<digits.length();i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letter_map[digits.charAt(i)-'0'];
            int size = res.size();
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for(int j=0;j<size;j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for(int k=0;k<letters.length();k++) {
                    res.add(tmp+letters.charAt(k));
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(new 电话号码的字母组合17().letterCombinations("23"));
    }



}
