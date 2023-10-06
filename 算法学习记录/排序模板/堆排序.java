/*
*  堆排序 O(n*logn)
*  用数组模拟完全二叉树结构
*  在每次交换值后,进行堆调整,始终保持堆为大/小顶堆
*/

    public static void heapSort(int[] arr)
    {
        //数据从arr[1]开始
        int n = arr.length;
        //构造最初的大/小顶堆
        for (int i = n / 2 ; i > 0; i--)
            heapify(arr, n, i);

        for (int i = n-1; i > 0; i--)
        {
            swap(arr, 1, i);
            heapify(arr, i, 1);
        }
    }

/*  
*   堆调整
*   递归和循环均可
*/
//  递归大顶堆
    public static void heapify(int[] arr, int n, int i)
    {
        int largest = i;
        int left = 2 * i ;
        int right = 2 * i+1 ;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        
        if (largest != i)
        {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }

    }

//  循环大顶堆
    public static void heapify(int[] arr,int n,int i)
    {
        int temp=arr[i];
        //循环将较大值上升为堆顶
        for(int j=i*2;j<n;j*=2)
        {
            if(j+1<n&&arr[j+1]>arr[j])
                j++;
            if(temp>arr[j])
                break;

            arr[i]=arr[j];
            i=j;
        }
        //将最初的堆顶下滑到合适位置
        arr[i]=temp;
    }
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
