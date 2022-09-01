class Solution:
    def minimumCosts(self, regular: List[int], express: List[int], expressCost: int) -> List[int]:
        regular_val = []
        express_val = []
        regular_val.append(regular[0])
        express_val.append(expressCost + express[0])
        
        for i in range(1, len(regular)):
            regular_val.append(min(regular_val[i-1] + regular[i], express_val[i-1] + regular[i]))
            express_val.append(min(regular_val[i-1] + expressCost + express[i], express_val[i-1] + express[i]))
        
        out = []
        for r, e in zip(regular_val, express_val):
            out.append(min(r, e))
        
        return out