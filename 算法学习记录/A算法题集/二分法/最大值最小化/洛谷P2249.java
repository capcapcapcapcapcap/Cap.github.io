
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException
    {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        int m = (int)st.nval;
        int[] arr = new int[n + 1];
        arr[0]=-1;
        for (int i = 1; i <= n; i++) {
            st.nextToken();
            arr[i] = (int)st.nval;
        }
        for (int i = 1; i <= m; i++) {
            st.nextToken();
            System.out.print(find(arr,(int)st.nval) + " ");
        }


    }
    public static int find(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left < right) {
            int mid =(right + left) >>1;

            if (arr[mid] == target) {
                result = mid;
                right=mid;
            }
            else if(arr[mid] > target)
                right=mid;
            else left=mid+1;
        }

        return result;
    }

}
