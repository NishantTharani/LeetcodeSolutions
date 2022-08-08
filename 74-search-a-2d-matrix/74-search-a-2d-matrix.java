class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Binary search the columns then the rows?
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0;
        int bottom = m - 1;
        
        while (top < bottom) {
            int mid = (top + bottom + 1) / 2;
            
            if (target >= matrix[mid][0]) {
                top = mid;
            } else {
                bottom = mid - 1;
            }
        }
        
        // Now, top == bottom is the index of the correct row. Binary search within that row
        int[] row = matrix[top];
        
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (row[mid] == target) {
                return true;
            } else if (target > row[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        if (row[left] == target)
            return true;
        else
            return false;
    }
}


/*


*/