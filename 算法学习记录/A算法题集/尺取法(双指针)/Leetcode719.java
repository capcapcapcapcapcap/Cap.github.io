class Solution {
    public int smallestDistancePair(int[] nums, int k) {
/* 
 * 本题的二分查找思路可参照Leetcode378
 * 枚举可能的第k小的数对距离,逐个检查
 * 二分枚举的作用是为循环遍历数组获得数对距离附加限制条件,
 * 从而使得O(n^2),降为二分的O(logm)*check的O(n)->O(nlogm);
 */
        Arrays.sort(nums);
        int left=0;
        int right=nums[nums.length-1]-nums[0];
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(check(nums,mid)<k)
                left=mid+1;
            else right=mid;
        }
        return right;
    }

    public int check(int[] a,int target)
    {
        int n=a.length;
        int sum=0;
/* 
 * j的位置不需要随着i变化而充值,因为nums[i+1]>=nums[i],
 * 此时,j之前指向的元素-nums[i+1]<=tar,必然成立
 */
        for(int i=0,j=1;i<n;i++)
        {
            while(j<n&&a[j]-a[i]<=target)
                j++;
            sum+=j-i-1;
        }
        return sum;
    }
}