class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        out = [[1]]

        for i in range(1, numRows):
            row = []
            above_row = out[i-1]

            # Add left outer number
            row.append(1)

            for j in range(i-1):
                # Add interior numbers
                row.append(above_row[j] + above_row[j+1])

            # Add right outer number
            row.append(1)

            out.append(row)
        
        return out