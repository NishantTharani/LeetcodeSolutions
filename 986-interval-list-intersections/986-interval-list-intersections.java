class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // Firstly: if only one of the list has elements, return an empty array
        
        /* Next: 
            keep two index counters and proceed only if both are < the length of each list of intervals
            two intervals a,b and j,k intersect iff b >= j and k >= a
            if this is the case, figure out the intersection and append it
            then append the counter corresponding to the interval that ends first
            
            and if they don't intersect, just append that same counter anyway
        */
        
        int i = 0;
        int j = 0;
        List<int[]> out = new ArrayList<>();
        int start;
        int end;
        
        while (i < firstList.length && j < secondList.length) {       
            if (firstList[i][1] >= secondList[j][0] && secondList[j][1] >= firstList[i][0]) {
                // The two intervals intersect: append the intersection
                start = Math.max(firstList[i][0], secondList[j][0]);
                end = Math.min(firstList[i][1], secondList[j][1]);
                out.add(new int[]{start, end});
            }
            
            // Append the correct index
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        return out.toArray(new int[out.size()][]);
    }
}