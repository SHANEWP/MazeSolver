import java.util.Scanner;

/**
 * Tests the MazeSolver class
 * @author Shane_Panagakos
 */
public class MazeTest
{
    public static void main(String[] a)
    {
        Scanner scan = new Scanner(System.in);
        int height;
        int width;

        System.out.print("Enter the maze height: ");
        height = scan.nextInt();
        System.out.print("Enter the maze width: ");
        width = scan.nextInt();
        char[][] maze = new char[width][height];
        char[] currentLine = new char[width];
        for(int i=0; i< height; i++)
        {
            System.out.print("Enter line "+(i+1)+" of the maze: ");
            currentLine=scan.next().toCharArray();
            for(int j=0; j<width; j++)
            {
                maze[i][j]=currentLine[j];
            }
        }
        System.out.println();
        MazeSolver solver = new MazeSolver(height, width, maze);
        solver.run();
    }
}
