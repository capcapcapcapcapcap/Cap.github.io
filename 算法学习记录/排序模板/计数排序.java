public static void countingSort(Match[] arr) {
        int max = 1000000; // 值范围上限
        int[] count = new int[max + 1];

        // 统计每个end出现的次数
        for (Match a : arr) {
            count[a.end]++;
        }

        // 计算每个end的累计次数
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // 根据计数数组构建排序后的数组
        Match[] sortedArray = new Match[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArray[count[arr[i].end] - 1] = arr[i];
            count[arr[i].end]--;
        }

        // 将排序后的数组复制回原数组
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }

