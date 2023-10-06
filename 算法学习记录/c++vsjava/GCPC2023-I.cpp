#include <iostream>
#include <vector> 
#include <algorithm> 
using namespace std;

int main() 
{   
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL);

    int n;
    cin >> n;
    
    vector<int> flogs(n + 1);
    
    for (int i = 1; i <= n; i++) {
        int k;
        cin >> k;
        //记录每个青蛙的位置
        flogs[i] = k;
    }
    
    //记录睡莲的状态
    vector<bool> jump(flogs[n] + 1);
    for (int i = 1; i <= n; i++)
        jump[flogs[i]] = true;
    
    //记录空白睡莲
    vector<int> blank;
    for (int i = 1; i < jump.size(); i++)
        if (!jump[i])
            blank.push_back(i);
    
    //最远的青蛙位置
    int max = flogs[n] + 1;
    blank.push_back(max);
    
    int q;
    cin >> q;
    while (q-- > 0) {
        int flog;
        cin >> flog;
    
        //当前青蛙位置
        int loc = flogs[flog];
    
        int l = 0;
        int r = blank.size();
        int ans = 0;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (loc < blank[mid]) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
    
        flogs[flog] = blank[ans];
        blank[ans] = loc;
    
        if (flogs[flog] == max)
            blank.push_back(++max);
    
        cout << flogs[flog] << endl;
    }
    
    return 0;
}