

char * defangIPaddr(char * address){
    char* out = malloc((strlen(address) + 6 + 1) * sizeof(char));
    int idx = 0;
    
    for (int i = 0; i < strlen(address); i++) {
        if (*(address + i) == '.') {
            *(out + idx) = '[';
            *(out + idx + 1) = '.';
            *(out + idx + 2) = ']';
            idx = idx + 3;
        } else {
            *(out + idx) = *(address + i);
            idx++;
        }
    }
    *(out + idx) = '\0';
    return out;
}