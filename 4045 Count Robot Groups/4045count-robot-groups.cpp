class Solution {
public:
    int countGroups(vector<int>& position, vector<int>& speed, int distance) {
        int ans = 1;
        int n = speed.size();
        int curmin = speed[n-1];
        for(int i=n-2;i>=0;i--){
            if((speed[i] <= curmin) && (position[i+1] - position[i] > distance)){
                
                    ans++;
                    curmin = speed[i];
                
            }
        }
        return ans;
    }
};