package cpm.jay.greddy;

import java.util.PriorityQueue;

public class GreddyImpl {

  static class Node {

    private Integer row;
    private Integer col;
    private Integer cost;

    public Node(Integer row, Integer col) {
      this.row = row;
      this.col = col;
    }

    public Integer getRow() {
      return row;
    }

    public void setRow(Integer row) {
      this.row = row;
    }

    public Integer getCol() {
      return col;
    }

    public void setCol(Integer col) {
      this.col = col;
    }

    public Integer getCost() {
      return cost;
    }

    public void setCost(Integer cost) {
      this.cost = cost;
    }
  }

  private Integer[][] maze;

  private Integer[][] maze_best;

  // 根據每個 Node 的 cost, 由低 -> 高排序
  private PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>((n1, n2) -> {
    if (n1.getCost() - n2.getCost() > 0) {
      return 1;
    } else if (n1.getCost() - n2.getCost() < 0) {
      return -1;
    } else {
      return 0;
    }
  });

  // 計算每一格最佳 cost
  public void goMaze() {
    int rowStart = 0, colStart = 0;
    int rowTarget = 2, colTarget = 2;

    Node start = new Node(0, 0);
    start.setCost(maze[rowStart][colStart]);

    priorityQueue.add(start);

    // 只要 priorityQueue 不為空, 執行此 while loop
    while (true) {
      if (priorityQueue.size() == 0) {
        break;
      }

      // 從 priorityQueue 取出的 Node 一定是當下 cost 最低的 Node
      Node now = priorityQueue.poll();
      // 檢查此 Node 是否探索過
      if (maze_best[now.getRow()][now.getCol()] != null) {
        continue;
      }
      // 紀錄此 Node 位置的 min cost, 代表此 Node 位置已被訪問過
      maze_best[now.getRow()][now.getCol()] = now.getCost();

      // 找 up Node
      if (now.getRow() - 1 >= 0 && maze_best[now.getRow() - 1][now.getCol()] == null) {
        Node up = new Node(now.getRow() - 1, now.getCol());
        up.setCost(now.getCost() + maze[now.getRow() - 1][now.getCol()]);
        priorityQueue.add(up);
      }

      // 找 down Node
      if (now.getRow() + 1 < maze.length && maze_best[now.getRow() + 1][now.getCol()] == null) {
        Node down = new Node(now.getRow() + 1, now.getCol());
        down.setCost(now.getCost() + maze[now.getRow() + 1][now.getCol()]);
        priorityQueue.add(down);
      }

      // 找 left Node
      if (now.getCol() - 1 >= 0 && maze_best[now.getRow()][now.getCol() - 1] == null) {
        Node left = new Node(now.getRow(), now.getCol() - 1);
        left.setCost(now.getCost() + maze[now.getRow()][now.getCol() - 1]);
        priorityQueue.add(left);
      }

      // 找 right Node
      if (now.getCol() + 1 > maze[0].length && maze_best[now.getRow()][now.getCol() + 1] == null) {
        Node right = new Node(now.getRow(), now.getCol() + 1);
        right.setCost(now.getCost() + maze[now.getRow()][now.getCol() + 1]);
        priorityQueue.add(right);
      }
    }// end while loop

  }

  public GreddyImpl(Integer[][] maze) {
    this.maze = maze;
    this.maze_best = new Integer[maze.length][maze[0].length];
  }

  public static void main(String[] args) {
    Integer[][] maze = new Integer[][]{
        {1, 4, 5},
        {8, 7, 9},
        {9, 14, 14}
    };

    GreddyImpl greddy = new GreddyImpl(maze);

    greddy.goMaze();

  }
}
