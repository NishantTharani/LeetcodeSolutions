
class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        if (N < K) {
            return 0;
        }
        
        int start = 0;
        int end = K - 1;
        int max = 0;
        
        for (int i = start; i <= end; i++) {
            max += Arr.get(i);
        }
        
        int candidate = max;
        
        while (end < N - 1) {
            candidate -= Arr.get(start);
            start++;
            end++;
            candidate += Arr.get(end);
            if (candidate > max) {
                max = candidate;
            }
        }
        
        return max;
    }
}
