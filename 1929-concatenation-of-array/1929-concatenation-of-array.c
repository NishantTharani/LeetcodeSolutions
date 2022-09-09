

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getConcatenation(int* nums, int numsSize, int* returnSize){
    int* out = malloc(2 * numsSize * sizeof(int));
    *returnSize = 2 * numsSize;
    
    for (int i = 0; i < numsSize; i++) {
        out[i] = nums[i];
        out[numsSize+i] = nums[i];
    }
    
    
    return out;
    
}