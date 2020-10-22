import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和15 {


    /**
     *
     * 个人暴力法计算 找出所有三元组
     * 数据量大就会超时
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumPer(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();
        if(nums.length<3){
            return result;
        }
        //找出所有的三元组 0 1 2 最短长度>=3
        int tm1,tm2;
        ArrayList<Integer> tmp;
        Boolean isC=false;
        for(int i=0;i<nums.length-2;i++){

            for(int j=i+1;j<nums.length-1;j++){

                tm1=nums[j];

                for(int k=j+1;k<nums.length;k++){

                    tm2=nums[k];

                    if((nums[i]+tm1+tm2)==0){
                        tmp=new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(tm1);
                        tmp.add(tm2);
                        //System.out.println(nums[i]+""+tm1+""+tm2);
                        isC=false;
                        //判断是否有重复集合
                        for(int l=0;l<result.size();l++){
                            //这个方法会排除掉0 0 0 这种异常情况 所以需要双边同时调用containsAll方法
                            if(result.get(l).containsAll(tmp)&&tmp.containsAll(result.get(l))){
                                isC=true;
                                break;
                            }
                        }
                        if(isC){

                        }else{
                            result.add(tmp);
                        }


                    }
                }

            }

        }

        return result;
    }


    /**
     * 题解思路
     *
     *
     * 思路
     * 标签：数组遍历
     * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
     * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
     * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
     * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
     * 时间复杂度：O(n^2)O(n
     *
     * 4数之和5数之和增加一个/两个for循环进行去重处理即可
     *
     * 84.6 / 89.3
     *
     * @param
     */

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();
        if(nums.length<3){
            return result;
        }
        List<Integer> tmp;
        //对数组进行排序
        Arrays.sort(nums);
        int l,r,sum;
        //循环到倒数第二个截止 0 1 2 4 5 即下标为2处为最后一次可进入循环的位置
        for(int i=0;i<nums.length-2;i++){
            //最小值大于0 没有sum=0的可能性
            if(nums[i]>0){
                break;
            }
            //去重
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            r=nums.length-1;
            l=i+1;
            while (l<r){

                sum=nums[i]+nums[l]+nums[r];

                if(sum>0){
                    r--;
                }else if(sum<0){
                    l++;
                }
                else{
                    tmp=new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    result.add(tmp);
                    //去除重复值
                    while (l<r&&nums[l]==nums[l+1]){
                        l++;
                    }
                    while (l<r&&nums[r]==nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {

        for(List<Integer> rs:new 三数之和15().threeSum(new int[]{0,-4,3,-2,-1,1})){

            for(int a:rs){
                System.out.printf("%d ",a);
            }
            System.out.println();
        }

    }
}
