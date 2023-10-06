
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int N = (int) st.nval;
        st.nextToken();
        int C = (int) st.nval;
        int[] nums = new int[N];
        long sum = 0;
        for (int i = 0; i < N; i++)
        {
            st.nextToken();
            nums[i] = (int) st.nval;
        }
        Arrays.sort(nums);
        for (int i = 0; i < N - 1; i++)
        {
            int j = findfirst(nums, nums[i] + C);
            int k = findlast(nums, nums[i] + C);
            if (j == -1)
                continue;
            sum+=k-j+1;
        }
        System.out.print(sum);
    }

    public static int findfirst(int[] arr, int target)
    {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
            {
                result = mid;
                right = mid - 1; // 继续在左半边查找，找到第一次出现的位置
            } else if (arr[mid] < target)
            {
                left = mid + 1;
            } else
            {
                right = mid - 1;
            }
        }

        return result;
    }

    public static int findlast(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;
        int lastOccurrence = -1;

        while (low <= high)
        {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
            {
                if (mid == arr.length - 1 || arr[mid + 1] != target)
                {
                    lastOccurrence = mid;
                    break;
                } else
                {
                    low = mid + 1;
                }
            } else if (arr[mid] < target)
            {
                low = mid + 1;
            } else
            {
                high = mid - 1;
            }
        }

        return lastOccurrence;
    }


}

