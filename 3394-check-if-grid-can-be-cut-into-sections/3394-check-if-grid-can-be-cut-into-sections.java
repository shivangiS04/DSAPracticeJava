class Solution {
public:
    bool ch(vector<vector<int>>& v, int d){
        sort(v.begin(), v.end(), [&](vector<int>& a, vector<int>& b){
            return a[d] < b[d];
        });

        int mx = v[0][d+2], cnt=0;
        for(int i=1; i<v.size(); i++){
            if(mx <= v[i][d]) cnt++;
            mx = max(mx, v[i][d+2]);
        }
        return cnt>1;
    }
    bool checkValidCuts(int n, vector<vector<int>>& rectangles) {
        return ch(rectangles, 0) | ch(rectangles, 1);
    }
};