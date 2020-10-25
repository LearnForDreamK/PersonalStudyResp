import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和18 {

    /**
     *
     *  相比三数之和 添加了一次循环固定第二个值的位置
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result=new ArrayList<>();

        List<Integer> tmp;

        Arrays.sort(nums);

        int left,right,sum;
        //第一个固定值
        for(int i=0;i<nums.length-3;i++){
            //去除重复
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            //第二个固定值
            for(int j=i+1;j<nums.length-2;j++){
                left=j+1;
                right=nums.length-1;
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                while(left<right){

                    sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        tmp=new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        result.add(tmp);
                        while (left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }

                        left++;
                        right--;
                    }else if (sum>target){
                        right--;
                    }else {
                        left++;
                    }

                }
            }

        }

        return result;
    }


    public static void main(String[] args) {
        //-2 -1 0 0 1 0
        for(List<Integer> rs:new 四数之和18().fourSum(new int[]{1, 0, -1, 0, -2, 2},0)){

            for(int a:rs){
                System.out.printf("%d ",a);
            }
            System.out.println();
        }

    }

}
