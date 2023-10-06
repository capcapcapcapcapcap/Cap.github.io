/* 
* 希尔排序 O( n^(3/2) )
* 局部有序->整体有序
* 将整体分为多个局部,使得局部有序,
* 同时,细化每个局部,再得到更小的局部,并更小的局部仍有序
* 最后当最小局部细化到1时,着可保证整体一定有序.
*/

public static void shellSort(int[] array)
{

/*
* element:增量,即局部的大小.
* 增量的选取十分关键,研究表明:
* dlta[k]=2^(t_k+1)-1 (0<=k<=t<=(向下取整)log2 (n+1))时
* 复杂度为O( n^(3/2) ),注意,增量序列最后一个增量必须为1
*/

    int increment=array.length;
    int len=array.length;
    do
    {
        increment=increment/3+1;
        for(int i=increment+1;i<=len;i++)
        {
            if(array[i]<array[i - increment])
            {
                //将当前值暂存在a[0]
                array[0]=array[i];

                //根据增量,向前跳跃到每个局部中对应位置,记录后移,查找插入位置
                for(int j=i - increment;j>0&&array[0]<array[j];j-=increment)
                    array[j+increment]=array[j];

                array[j+increment]=array[0]; //插入
            }
        }
    }while(increment>1);
}