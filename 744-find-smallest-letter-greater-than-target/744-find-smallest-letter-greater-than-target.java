class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // Edge cases
        if (target < letters[0] || target >= letters[letters.length - 1])
            return letters[0];
        
        // Binary search for the interior case
        int left = 0;
        int right = letters.length - 1;
        int mid = (left + right) / 2;
        
        while (!(target >= letters[mid] && target < letters[mid+1])) {
            if (target < letters[mid]) {
                right = mid;
                mid = (left + right) / 2;
            } else {
                left = mid;
                mid = (left + right) / 2;
            }
        }
        
        return letters[mid+1];
    }
}