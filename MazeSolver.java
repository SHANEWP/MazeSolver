import java.awt.Point;

/**
 * Solves the given maze.
 * @author Shane_Panagakos
 */
public class MazeSolver
{
    private char[][] maze;

    private int height;
    private int width;
    private int count; //Number of solutions

    private Point start; //Coordinates of the starting point
    private Point end;  //Coordinates of the ending point

    //Symbols represent corisponding name
    private final char WALL  = '1';
    private final char FREE  = '0';
    private final char PATH  = 'p';
    private final char START = 'b';
    private final char END   = 'e';

    /**
     * Creates a new Maze object
     * @param m the maze to be solved
     * @param h height of the maze
     * @param w width of the maze
     */
    public MazeSolver(int h, int w, char[][] m)
    {
        maze=m;
        height=h;
        width=w;
        count=1;

        for(int i=0; i<h; i++)
            for(int j=0; j<w; j++)
                if(m[i][j]==START)
                    start=new Point(j, i);
        for(int i=0; i<h; i++)
            for(int j=0; j<w; j++)
                if(m[i][j]==END)
                    end=new Point(j, i);
    }
    /**
     * Solves this maze.
     * Prints the solution if there is one or prints that there is no solution
     * @param x coordinate of the maze position
     * @param y coordinates of the maze position
     * @return true of there is a successful path false otherwise
     */
    public boolean solve(int x, int y)
    {
        maze[start.y][start.x]=START;
        maze[y][x] = PATH;
        maze[end.y][end.x]=END;

        if(x==end.x&&y==end.y)
        {
            System.out.println("Solution "+count++ +":");
            print();
            maze[y][x]=FREE;
            return solve(start.x, start.y);
        }
        if(x>0&&(maze[y][x-1]==FREE||maze[y][x-1]==END)&&solve(x-1, y))
        {
            maze[y][x]=FREE;
            return true;
        }
        if(x<width&&(maze[y][x+1]==FREE||maze[y][x+1]==END)&&solve(x+1, y))
        {
            maze[y][x]=FREE;
            return true;
        }
        if(y>0&&(maze[y-1][x]==FREE||maze[y-1][x]==END)&&solve(x, y-1))
        {
            maze[y][x]=FREE;
            return true;
        }
        if(y<height&&(maze[y+1][x]==FREE||maze[y+1][x]==END)&&solve(x, y+1))
        {
            maze[y][x]=FREE;
            return true;
        }

        maze[y][x]=FREE;
        return false;
    }
    /**
     * starts the solve method at the beginning of the maze.
     * prints out the solution if there is one and returns
     * "There is no solution!" if there is not.
     */
    public void run()
    {
        solve(start.x, start.y);
    }
    /**
     * Prints the maze to the screen
     */
    public void print()
    {
        for(int i=0; i<height; i++)
        {
            for(int j=0; j<width; j++)
                System.out.print(maze[i][j]);
            System.out.println();
        }
        System.out.println();
    }
}
