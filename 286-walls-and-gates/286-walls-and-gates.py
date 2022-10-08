class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        
        # First: find the locations of the gates
        m = len(rooms)
        n = len(rooms[0])
        gates = []
        for row_idx, row in enumerate(rooms):
            for col_idx, room in enumerate(row):
                if room == 0:
                    gates.append((row_idx, col_idx))
        
        # Loop over each gate:
        for gate_row, gate_col in gates:
            # Run BFS starting from that gate, considering valid cells (not walls, not gates)
            queue = collections.deque()
            visited = set()
            # In the BFS queue: store (row, col, distance from current gate)
            queue.append((gate_row, gate_col, 0))
            visited.add((gate_row, gate_col))
            
            while len(queue) > 0:
                curr_row, curr_col, distance = queue.popleft()
                # Each time we reach a cell: check if distance is smaller than current value in cell
                rooms[curr_row][curr_col] = min(rooms[curr_row][curr_col], distance)
                
                for nr, nc in [(curr_row+1, curr_col), (curr_row-1, curr_col), (curr_row, curr_col-1), (curr_row, curr_col+1)]:
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and ((nr, nc) not in visited) and rooms[nr][nc] > 0:
                        queue.append((nr, nc, distance+1))
                        visited.add((nr, nc))

    
 
"""
Brainstorm:
	Recursion - brute force
  
  
  Starting at each gate and working outwards:
  	G is number of gates -> O(G * M * N)

"""
