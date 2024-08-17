import java.util.Arrays;

public class AllPathPrint {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true}};
        int[][] path = new int[maze.length][maze[0].length];
        AllPrint("",maze,0,0,path,0);
    }
    static void AllPrint(String p, boolean[][] maze, int r, int c,int[][] path, int step){
        if (r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for ( int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            System.out.println(p);
            return;
        }
        if (!maze[r][c]){
            return;
        }
        //mark the visited block as false so it won't be visited again
        maze[r][c] = false;
        path[r][c] = step;

        if (r < maze.length-1){
            AllPrint(p+'D',maze,r+1,c,path,step+1);
        }
        if (c < maze.length-1){
            AllPrint(p+'H',maze,r,c+1,path,step+1);
        }
        if (c > 0){
            AllPrint(p+'L',maze,r,c-1,path,step+1);
        }
        if (r > 0){
            AllPrint(p+'U',maze,r-1,c,path,step+1);
        }
        // now this is the final line of the code
        // so revert all the previous changes in the blocks(reset to default)
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
