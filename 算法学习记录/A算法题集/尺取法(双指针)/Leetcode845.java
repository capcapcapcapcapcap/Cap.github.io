class Solution {
    public int longestMountain(int[] arr) 
    {

        int l=1;
        int lsum=0;
        int max=0;
        while(l<arr.length)
        {
            if(arr[l]-arr[l-1]>0)
                {
                    lsum++;
                    l++;
                }
            else 
            {
                int r=l;
                int rsum=0;
                while(r<arr.length)
                {
                    if(arr[r]<arr[r-1])
                        {
                            rsum++;
                            r++;
                        }
                    else break;
                }
                int sum=lsum+rsum+1;
                if(lsum==0||rsum==0)
                    sum=0;
                max=Math.max(max,sum);
                lsum=0;
                l=r;
                if(rsum==0)
                    l++;
            }
        }
    return max;

    }
}