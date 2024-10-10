Here is the explanation and code formatted in Markdown:

```python
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        
        # Get the dimensions of the grid
        rows, cols = len(grid), len(grid[0])
        island_count = 0

        def dfs(r, c):
            # Base case: if out of bounds or at water ('0'), return
            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == '0':
                return
            
            # Mark the current cell as visited by setting it to '0'
            grid[r][c] = '0'
            
            # Explore all four adjacent cells (up, down, left, right)
            dfs(r - 1, c)  # up
            dfs(r + 1, c)  # down
            dfs(r, c - 1)  # left
            dfs(r, c + 1)  # right

        # Traverse the grid to find all islands
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1':
                    # Start DFS for a new island
                    dfs(r, c)
                    # Increment the island count
                    island_count += 1

        return island_count
```

## Explanation

### Approach:

1. **DFS (Depth-First Search) Traversal**:
   - We use a DFS traversal to explore all connected land ('1') in all four possible directions (up, down, left, right). Each DFS traversal marks the visited land by turning '1' into '0' to avoid recounting the same island.
   
2. **Grid Traversal**:
   - Traverse the entire grid. When we find a '1', initiate DFS to explore the entire island and increment the island count by one.

3. **Boundary Conditions**:
   - If the current cell is out of bounds or is water ('0'), we stop the DFS.

### Code Walkthrough:

- **`dfs(r, c)`**:
   - **Base Case**: Stops when the cell is out of bounds or contains water ('0').
   - **Recursion**: The DFS continues by exploring all adjacent cells (up, down, left, right) that contain '1'.
   - **Mark as Visited**: To avoid revisiting the same land, the current cell is set to '0'.

- **Grid Traversal**:
   - The outer loops traverse every cell in the grid. When a '1' is found, DFS is initiated to explore the entire island, and `island_count` is incremented.

### Complexity Analysis:

- **Time Complexity**: O(m * n), where `m` is the number of rows and `n` is the number of columns. We traverse each cell once.
- **Space Complexity**: O(m * n), which is the space needed for the recursion stack during DFS in the worst case (when all land is connected).

### Example Usage:

```python
grid1 = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
solution = Solution()
print(solution.numIslands(grid1))  # Output: 1

grid2 = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
print(solution.numIslands(grid2))  # Output: 3
```

### Example 1 Explanation:
- The grid has one large connected component of land ('1's), so the number of islands is `1`.

### Example 2 Explanation:
- The grid has three separate connected components of land ('1's), so the number of islands is `3`. 

---

This solution efficiently counts islands in an m x n binary grid using DFS.