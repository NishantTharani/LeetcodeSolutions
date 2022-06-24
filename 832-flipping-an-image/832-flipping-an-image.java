class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int tmp;
        
        for (int[] row : image) {
            for (int i = 0; i < (n+1)/2; i++) {
                int other = n - 1 - i;
                tmp = row[i];
                row[i] = row[other] ^ 1;
                row[other] = tmp ^ 1;
            }
        }
        
        return image;
    }
}