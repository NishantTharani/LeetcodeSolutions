class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        """
        Sort the intervals by start
        
        Then, given A,B and C,D with C >= A, our scenarios are:
            C > B
                non overlapping, add current interval and start again with C,D
            C <= B, D > B
                can merge into A,D and keep going
            C <= B, D <= B
                can absorb and keep A,B and keep going
        Then add current interval at the end
        """

        intervals.sort()

        start, end = intervals[0][0], intervals[0][1]
        out = []

        for idx in range(1, len(intervals)):
            c, d = intervals[idx][0], intervals[idx][1]
            
            if c > end:
                out.append([start, end])
                start = c
                end = d
            else:
                if d > end:
                    end = d
        
        out.append([start, end])
        return out