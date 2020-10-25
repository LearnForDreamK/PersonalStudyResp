import java.util.Arrays;
import java.util.List;

public class 最接近的三数之和16 {

    /**
     *
     * 错误解答
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {


        Arrays.sort(nums);
        //储存临时的最接近值
        int tmp=getAbsolute(nums[0],nums[1],nums[2],target),left,right;
        int tmpsum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){

            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            left=i+1;
            right=nums.length-1;
            while(left<right){

                if(getAbsolute(nums[i],nums[left],nums[right],target)<tmp){
                    //-5 -4 -2 2 4 5
                    tmp=getAbsolute(nums[i],nums[left],nums[right],target);
                    tmpsum=nums[i]+nums[left]+nums[right];
                }
                //目的在于总和的值 和 target的值 的距离
                if(getAbsolute(nums[i],nums[left],nums[right],target)<tmp){

                    if(nums[i]+nums[left]+nums[right]>target){

                        //此时左指针向右移没有意义 只需要移动右指针
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        right--;
                    }else{
                        //移动左指针
                        while(left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        left++;
                    }

                }else{
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    left++;
                    right--;

                }

            }
        }

        return tmpsum;
    }
    public static int getAbsolute(int a,int b,int c,int target){
        if(a+b+c>=target){
            System.out.println("result: "+a+" "+b+" "+c+" target "+(a+b+c-target) +" sum " +(a+b+c));
            return a+b+c-target;
        }else{
            System.out.println("result: "+a+" "+b+" "+c+" target "+(target-(a+b+c))+" sum " +(a+b+c));
            return target-(a+b+c);
        }

    }

    public int threeSumClosestTrue(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }

                if(sum > target){
                    end--;
                }

                else if(sum < target){
                    start++;
                }else{
                    return ans;
                }

            }
        }
        return ans;
    }


    public static void main(String[] args) {
        //-4 -1 1 2 [1,1,-1,-1,3] -1 -1 1 1 3
        //3
        int result=new 最接近的三数之和16().threeSumClosestTrue(new int[]{1,1,-1,-1,3},3);
        System.out.println(result);

    }


}
