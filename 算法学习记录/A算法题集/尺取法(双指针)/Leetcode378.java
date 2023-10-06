class Solution {
    public int kthSmallest(int[][] matrix, int k) {

/*
 * 以二分查找,枚举可能的第k小的数,将其带入matrix检验,
 */
        int row=matrix.length;
        int col=matrix[0].length;
        int left=matrix[0][0];
        int right=matrix[row-1][col-1];
        while(left<right)
        {
            int mid=left+(right-left)/2;
            int now=check(mid,matrix);
            //当now==k时，不可直接返回mid，因为此时枚举的
            //mid不一定在矩阵中，需要继续枚举，不断缩小范围
            //直至left==right
            if(now>=k)
                right=mid;
            else left=mid+1;
        }
        return right;
    }

    public int check(int target,int[][] a)
    {
        int i=a.length-1;
        int j=0;
        int sum=0;
        while(i>=0&&j<a[0].length)
        {
            //若当前元素<=target,则计数加其所在列以上的元素个数
            //同时，下标右移,寻找更大值判断
            if(a[i][j]<=target)
            {
                sum+=i+1;
                j++;
            }
            //否则下标上移,寻找更小值判断
            else i--;
        }
        return sum;
    }
}