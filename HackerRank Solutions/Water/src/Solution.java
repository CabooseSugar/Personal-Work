import java.util.*;

class Solution
{
    static int ROW;
    static int COL;

    static class Cell
    {
        int x;
        int y;

        public Cell(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    };

    static class queueNode
    {
        Cell pt; // cell coordinates
        int dist; // cell distance from src

        public queueNode(Cell pt, int dist)
        {
            this.pt = pt;
            this.dist = dist;
        }
    };

    // Check if cell is in range of board
    static boolean isValid(int row, int col)
    {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    // simplify for loop in BFS
    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};

    // Find the shortest path between src and dest
    static int BFS(char board[][], Cell src, Cell dest)
    {
        boolean [][]visited = new boolean[ROW][COL];

        // Mark src cell as visited
        visited[src.x][src.y] = true;

        Queue<queueNode> q = new LinkedList<>();
        queueNode s = new queueNode(src, 0);
        q.add(s);

        // BFS
        while (!q.isEmpty())
        {
            queueNode curr = q.peek();
            Cell pt = curr.pt;

            // Base case
            if (pt.x == dest.x && pt.y == dest.y)
                return curr.dist;

            // dequeue front cell, enqueue adjacent cells
            q.remove();

            for (int i = 0; i < 4; i++)
            {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];


                if (isValid(row, col) &&
                        (board[row][col] == '*' || board[row][col] == 'w') &&
                        !visited[row][col])
                {
                    visited[row][col] = true;
                    queueNode AdjCell = new queueNode(new Cell(row, col), curr.dist + 1 );
                    q.add(AdjCell);
                }
            }
        }

        // Destination can't be reached
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ROW = n;
        int m = sc.nextInt();
        COL = m;
        sc.nextLine();
        char[][] board  = new char[n][m];

        int currentN = 0 ;
        int currentM = 0;

        List<int[]> waterLocs = new ArrayList<>();

        for (int i = 0; i < n; i++){
            String line = sc.nextLine();
            char[] arr = line.toCharArray();
            for (int j = 0; j < m; j++){
                board[i][j] = arr[j];
                if (board[i][j] == 'k'){
                    currentN = i;
                    currentM = j;
                }
                if (board[i][j] == 'w'){
                    int[] temp = {i, j};
                    waterLocs.add(temp);
                }
            }
        }

        int fastest = Integer.MAX_VALUE;
        for (int[] i : waterLocs) {
            Cell start = new Cell(currentN, currentM);
            Cell water = new Cell(i[0], i[1]);

            int currentSpeed = BFS(board, start, water);
            if (currentSpeed < fastest){
                fastest = currentSpeed;
            }
        }

        if (fastest != Integer.MAX_VALUE)
            System.out.println(fastest);
        else
            System.out.println(":-P");
    }
}