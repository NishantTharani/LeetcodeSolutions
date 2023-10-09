class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        out = [[1]]

        for i in range(1, numRows):
            row = []
            above_row = out[i-1]

            # Add left outer number
            row.append(1)

            # We want to fill in the row through index i//2
            for j in range(i//2):
                # j = 0 means we're adding a number at index 1
                row.append(above_row[j] + above_row[j+1])

            """
            Now we've filled in row[0] through row[i//2]
            If i is odd:
                We want to copy row[0:i//2] to row[i//2+1:i]
            If i is even:
                We want to copy row[0:i//2-1] to row[i//2+1:i]
            """

            if i % 2 == 1:
                for j in range(i//2, -1, -1):
                    row.append(row[j])
            else:
                for j in range(i//2 - 1, -1, -1):
                    row.append(row[j])


            out.append(row)
        
        return out