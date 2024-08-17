# 🚀 AllPathPrint Maze Solver

Explore every path through a maze and see the steps taken along the way with this Java program!

## 📋 Features

- **Pathfinding**: Discover all possible paths from the top-left to the bottom-right.
- **Step Tracking**: Visualize each step in the path with a detailed grid output.
- **Backtracking**: Efficiently navigates the maze using recursive backtracking.

## 🔍 How It Works

1. **Maze Representation**: The maze is a 2D boolean array where `true` indicates a walkable cell.
2. **Path Tracking**: An integer array tracks the steps taken to reach each cell, which helps visualize the path.
3. **Recursive Exploration**:
   - **Base Case**: If the destination (bottom-right) is reached, print the path and step grid.
   - **Valid Move**: Move to adjacent cells (Down `D`, Right `H`, Left `L`, Up `U`) if they are within bounds and walkable.
   - **Mark & Reset**: Mark cells as visited (`false`) and reset them after exploring all possible paths to allow other explorations.

## 💻 Code Example

```java
import java.util.Arrays;

public class AllPathPrint {
    public static void main(String[] args) {
        // Define a maze where true indicates a walkable cell
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}};
        
        // Initialize path tracking array
        int[][] path = new int[maze.length][maze[0].length];
        
        // Start finding all paths from (0,0)
        AllPrint("", maze, 0, 0, path, 0);
    }

    static void AllPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        // 1. Check if the destination is reached
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            // Print the path grid showing steps
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            // Print the path taken as a string of directions
            System.out.println(p);
            return;
        }
        
        // 2. Skip cells that are not walkable or already visited
        if (!maze[r][c]) {
            return;
        }

        // 3. Mark the current cell as visited and record the step
        maze[r][c] = false;
        path[r][c] = step;

        // 4. Explore all possible directions
        if (r < maze.length - 1) { // Move Down
            AllPrint(p + 'D', maze, r + 1, c, path, step + 1);
        }
        if (c < maze[0].length - 1) { // Move Right
            AllPrint(p + 'H', maze, r, c + 1, path, step + 1);
        }
        if (c > 0) { // Move Left
            AllPrint(p + 'L', maze, r, c - 1, path, step + 1);
        }
        if (r > 0) { // Move Up
            AllPrint(p + 'U', maze, r - 1, c, path, step + 1);
        }

        // 5. Reset the cell and path step for other path explorations
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
