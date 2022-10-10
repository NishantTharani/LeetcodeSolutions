class Solution:
    def countArrangement(self, n: int) -> int:
        # Define which numbers can go at which index
        allowed = collections.defaultdict(list)
        for i in range(1, n+1):
            for j in range(1, n+1):
                if i % j == 0 or j % i == 0:
                    allowed[i].append(j)
        
        # Enumerate them
        count = 0
        queue = collections.deque()
        queue.append((set(), 0))
        
        while len(queue) > 0:
            curr_set, curr_len = queue.popleft()
            if curr_len == n:
                count += 1
            else:
                for candidate in allowed[curr_len + 1]:
                    if candidate not in curr_set:
                        new_set = set(curr_set)
                        new_set.add(candidate)
                        queue.append((new_set, curr_len+1))
        
        return count