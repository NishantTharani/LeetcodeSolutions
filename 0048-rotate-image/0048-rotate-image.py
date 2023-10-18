class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        
        num_to_rotate = None
        starting_idx = None

        if n % 2 == 1:
            num_to_rotate = 0
            starting_idx = n // 2
        else:
            num_to_rotate = 1
            starting_idx = (n//2) - 1
        
        # Starting at [starting_idx, starting_idx], circular swap of the index with the one num_to_rotate ahead, then repeat num_to_rotate times, then decrement starting_idx
        while starting_idx >= 0:
            starting_row = starting_idx
            starting_col = starting_idx
            ending_row = starting_idx + num_to_rotate
            ending_col = starting_idx + num_to_rotate

            for increment in range(num_to_rotate):
                """
                Swap:
                    (starting_row, starting_col + increment)
                    (starting_row + increment, ending_col)
                    (ending_row, ending_col - increment)
                    (ending_row - increment, starting_col)
                """
                tmp = matrix[starting_row][starting_col + increment]
                matrix[starting_row][starting_col + increment] = matrix[ending_row - increment][starting_col]
                matrix[ending_row - increment][starting_col] = matrix[ending_row][ending_col - increment]
                matrix[ending_row][ending_col - increment] = matrix[starting_row + increment][ending_col]
                matrix[starting_row + increment][ending_col] = tmp

            
            starting_idx -= 1
            num_to_rotate += 2


