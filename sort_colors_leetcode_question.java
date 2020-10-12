import java.util.Arrays;
class Solution {
    public int[] sortColors(int[] nums) {
            int c_1=0;
        int c_2=0;
        int c_0=0;
            if(nums.length==1){
                    return nums;
            }
            if (nums.length==2){
                    Arrays.sort(nums);// you can't write return here as sort returns void type
            }else {
            for(int i=0;i<nums.length;i++){
                    if(nums[i]==0){
                            c_0+=1;
                    }
                     else if(nums[i]==2){
                            c_2+=1;
                    } 
                    else if(nums[i]==1){
                            c_1+=1;
                    }
            }
        for(int j=0;j<=c_0;j++){
                nums[j]=0;
        }
        for(int k=c_0;k<c_0+c_1;k++){
                nums[k]=1;
        } int y=(c_0+c_1);
        for(int l=y;l<nums.length;l++){
                nums[l]=2;
        }
            }
        return nums;
    }
}
