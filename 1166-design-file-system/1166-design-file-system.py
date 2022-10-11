class FileSystem:

    def __init__(self):
        self.map = {}
        

    def createPath(self, path: str, value: int) -> bool:
        # Check that path is valid
        if not self.check_path_valid(path):
            return False
        
        # Associate path with value
        subpaths = path.split('/')[1:]
        curr = self.map
        for parent in subpaths[:-1]:
            if parent not in curr:
                return False
            curr = curr[parent]
        
        child = subpaths[-1]
        if child in curr:
            return False
        curr[child] = {}
        curr[child][-1] = value
        
        return True

    def get(self, path: str) -> int:
        if not self.check_path_valid(path):
            return -1
        
        subpaths = path.split('/')[1:]
        curr = self.map
        for subpath in subpaths:
            if subpath not in curr:
                return -1
            curr = curr[subpath]
        if -1 not in curr:
            return -1
        return curr[-1]
        
    
    def check_path_valid(self, path: str) -> bool:
        slashes = []
        
        for idx, val in enumerate(path):
            if val == '/':
                slashes.append(idx)
            elif not val.islower():
                return False
        
        if slashes[0] != 0:
            return False
        
        for i in range(1, len(slashes)):
            if slashes[i] - slashes[i-1] <= 1:
                return False
        
        if slashes[-1] == len(path) - 1:
            return False
        
        return True
        
        


# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.createPath(path,value)
# param_2 = obj.get(path)