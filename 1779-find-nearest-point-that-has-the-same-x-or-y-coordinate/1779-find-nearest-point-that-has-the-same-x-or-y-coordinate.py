class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        dist = float('inf')
        out = None
        
        for idx, point in enumerate(points):
            if point[0] == x or point[1] == y:
                if abs(point[0] - x) + abs(point[1] - y) < dist:
                    dist = abs(point[0] - x) + abs(point[1] - y)
                    out = idx
        
        return out if out is not None else -1