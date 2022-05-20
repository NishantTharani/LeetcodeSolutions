class Solution {
    public int[][] merge(int[][] intervals) {
        /* Say two intervals are a,b and i,j
        Six cases:
            b <= i: first interval is before second: prepend and break
            a >= j: first interval is after second: append and move on
            a >= i and b <= j: second interval contains the first: ignore and move on
            a <= i and b >= j: first interval contains the second
                here we prepend the new one, delete the old one, but keep going in case other cases apply to later intervals too
            a <= i and b <= j: they overlap. merge and move on
            a >= i and a <= j and b >= j: they overlap. 
                merge. and keep going in case other cases apply to later intervals too
     
        */
        
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        int i;
        int j;
        int a;
        int b;
        int idx;
        
        for (int[] interval : intervals) {
            a = interval[0];
            b = interval[1];
            boolean added = false;
            idx = 0;
            
            while (idx < out.size()) {
                List<Integer> newInt = out.get(idx);
                i = newInt.get(0);
                j = newInt.get(1);
                
                if (b < i) {
                    // Case 1: prepend the new interval and break
                    // Actually do the prepending at the end, so just break here
                    break;
                } else if (a <= i && b <= j) {
                    // Case 2: adjust the new interval, delete the old one, and continue
                    b = j;
                    out.remove(idx);
                    continue;
                } else if (a <= i && b >= j) {
                    // Case 3: delete the old interval, and continue
                    out.remove(idx);
                    continue;
                } else if (a >= i && b <= j) {
                    // Case 4: ignore the new interval, and break
                    idx = -1;
                    break;
                } else if (a >= i && a <= j && b >= j) {
                    // Case 5: adjust the new interval, delete the old one, and continue
                    a = i;
                    out.remove(idx);
                    continue;
                } else if (a >= j) {
                    // Case 6: increment the index and continue
                    idx++;
                }
            }
            
            if (idx >= 0) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(a);
                tmp.add(b);
                out.add(idx, tmp);
            }
        }
        
        int[][] outArr = new int[out.size()][];
        for (int x = 0; x < outArr.length; x++) {
            int[] tmp = new int[2];
            tmp[0] = out.get(x).get(0);
            tmp[1] = out.get(x).get(1);
            outArr[x] = tmp;
        }
        
        return outArr;
    }
}