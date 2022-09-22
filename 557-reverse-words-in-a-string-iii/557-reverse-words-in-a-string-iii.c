char* reverseWord(char * left);

char * reverseWords(char * s){
    char* t = s;
    while (*t != '\0') {
        t = reverseWord(t);
    }
    return s;
}

char * reverseWord(char * left) {
    int leftIdx = 0;
    int rightIdx = 0;
    char* right = left;
    char* out = left;
    
    while (*(right+1) != '\0' && *(right+1) != ' ') {
        right++;
        rightIdx++;
    }
    
    if (*(right+1) == '\0') {
        out = right + 1;
    } else {
        out = right + 2;
    }
    
    char tmp;
    while (rightIdx > leftIdx) {
        tmp = *left;
        *left = *right;
        *right = tmp;
        rightIdx--;
        right--;
        leftIdx++;
        left++;
    }
    
    return out;
}