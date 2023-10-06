    class Solution {
    public  List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans=new LinkedList();
        List<Integer> now=new LinkedList();
        Set<Integer> set=new HashSet<>();
        Arrays.sort(nums);

        for(int j=0;j<nums.length-2;j++)
        {
            if(set.contains(nums[j]))
                continue;
            int i=j+1,k=nums.length-1;
            int sum=-nums[j];
            Set<Integer> set2=new HashSet<>();
            while(i<k)
            {
                if(set2.contains(nums[i])&&set2.contains(nums[k]))
                {
                    i++;k--;
                    continue;
                }
                int s=nums[i]+nums[k];
                if(s==sum)
                {
                    if(i==j)
                        i++;
                    else if(k==j)
                        k--;
                    else
                    {
                        set2.add(nums[i]);
                        set2.add(nums[k]);
                        now.add(nums[k]);
                        now.add(nums[i]);
                        now.add(nums[j]);
                        ans.add(now);
                        now=new LinkedList<>();
                        i++;k--;
                    }
                }
                else if(s<sum)
                    i++;
                else k--;
            }
            set.add(nums[j]);
        }
        return ans;
    }
}