class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        int mid;
        
        if (target >= letters[right])
            return letters[left];
        
        while (left <= right) {
            mid = left + (right - left)/2;
            
            if (left == right && target == letters[mid]) {
                return letters[mid+1];
            } else if (target < letters[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return letters[left];
    }
}