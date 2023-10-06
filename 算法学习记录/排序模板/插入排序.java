    public static void insertionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; i++)
        {
            //待插牌
            int key = arr[i];
            //在左侧有序牌中找出插入位置
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
