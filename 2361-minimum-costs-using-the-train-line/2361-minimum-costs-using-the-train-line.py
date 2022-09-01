class Solution:
    def minimumCosts(self, regular: List[int], express: List[int], expressCost: int) -> List[int]:
        regular_val = []
        express_val = []
        out = []
        regular_val.append(regular[0])
        express_val.append(expressCost + express[0])
        out.append(min(regular_val[0], express_val[0]))
        
        for i in range(1, len(regular)):
            regular_val.append(min(regular_val[i-1] + regular[i], express_val[i-1] + regular[i]))
            express_val.append(min(regular_val[i-1] + expressCost + express[i], express_val[i-1] + express[i]))
            out.append(min(regular_val[i], express_val[i]))
        
        return out