

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
char ** fizzBuzz(int n, int* returnSize){
    char** out = malloc(n * sizeof(char*));
    char* tmp = malloc(9 * sizeof(char));
    
    for (int i = 1; i <= n; i++) {
        if (i % 3 == 0 && i % 5 == 0) {
            sprintf(tmp, "FizzBuzz");
        } else if (i % 3 == 0) {
            sprintf(tmp, "Fizz");
        } else if (i % 5 == 0) {
            sprintf(tmp, "Buzz");
        } else {
            sprintf(tmp, "%d", i);
        }
        
        out[i-1] = malloc((strlen(tmp) + 1) * sizeof(char));
        strcpy(out[i-1], tmp);
    }
    
    *returnSize = n;
    return out;
}