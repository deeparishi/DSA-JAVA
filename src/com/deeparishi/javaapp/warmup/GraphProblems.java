package com.deeparishi.javaapp.warmup;

import java.util.*;
import java.util.stream.Collectors;

/*
          0
        /   \
       1     2
      / \   / \
     3   4 4   5
     |   | |   |
     6   6 7   7
      \ /   \ /
        8     |
         \   /
           9

 */

public class GraphProblems {

    int vertices = 10;

    int[][] directions = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };


    private List<List<Integer>> buildNodes(int vertices) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(4);
        adj.get(2).add(5);

        adj.get(3).add(6);
        adj.get(4).add(6);
        adj.get(4).add(7);

        adj.get(5).add(7);
        adj.get(6).add(8);
        adj.get(7).add(8);
        adj.get(8).add(9);

        return adj;
    }

    // Print vertices via BFS
    public void bfs() {
        List<List<Integer>> nodes = buildNodes(vertices);
        boolean[] visited = new boolean[vertices];
        visited[0] = true;
        List<Integer> people = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int owner = q.poll();
            people.add(owner);
            for (int neighbour : nodes.get(owner)) {
                if (!visited[neighbour]) {
                    q.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        System.out.println(people);
    }

    // Print vertices via DFS
    public void DFS() {
        List<List<Integer>> nodes = buildNodes(vertices);
        boolean[] visited = new boolean[vertices];
        List<Integer> res = new ArrayList<>();
        DFS(nodes, visited, res, 0);
        System.out.println(res);
    }

    private void DFS(List<List<Integer>> nodes, boolean[] visited,
                     List<Integer> res, int node) {

        if (visited[node]) return;
        ;

        visited[node] = true;
        res.add(node);
        for (Integer neighbour : nodes.get(node))
            DFS(nodes, visited, res, neighbour);
    }

    // Print Neighbors
    public void printNeighbours() {
        List<List<Integer>> nodes = buildNodes(vertices);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Map<Integer, List<Integer>> lookup = new HashMap<>();


        while (!queue.isEmpty()) {
            int polled = queue.poll();
            List<Integer> val = new ArrayList<>();
            for (int neighbour : nodes.get(polled)) {
                val.add(neighbour);
                queue.offer(neighbour);
            }
            lookup.putIfAbsent(polled, val);
        }

        System.out.println(lookup);
    }

    // Find Max fish can farmer get via BFS/DFS
    public int findMaxFish(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] > 0) {
                    max = Math.max(max, BFS(i, j, visited, grid));
                }
            }
        }
        return max;
    }

    private int DFS(int row, int col, boolean[][] visited, int[][] grid) {
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length ||
                visited[row][col] || grid[row][col] == 0
        )
            return 0;

        visited[row][col] = true;

        int total = grid[row][col];

        total += DFS(row, col - 1, visited, grid);
        total += DFS(row, col + 1, visited, grid);
        total += DFS(row - 1, col, visited, grid);
        total += DFS(row + 1, col, visited, grid);

        return total;
    }

    private int BFS(int row, int col, boolean[][] visited, int[][] grid) {

        int rowLen = visited.length;
        int colLen = visited[0].length;

        int total = 0;

        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {

            int[] polled = q.poll();
            int pr = polled[0];
            int pc = polled[1];
            total += grid[pr][pc];

            for (int[] direction : directions) {
                int nr = pr + direction[0];
                int nc = pc + direction[1];
                if (isValid(nr, nc, grid, visited)) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        return total;
    }

    private boolean isValid(int row, int col, int[][] grid, boolean[][] visited) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        return row > 0 && row < rowLen && col > 0 && col < colLen && grid[row][col] > 0 && visited[row][col];
    }

    // Find total no of island in grid via BFS/DFS
    public int noOfIsland(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int total = 0;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (!visited[row][col] && grid[row][col] != 0) {
                    noOfIslandDFS(row, col, grid, visited);
                    total++;
                }

            }
        }

        return total;
    }

    private void noOfIslandDFS(int row, int col, int[][] grid, boolean[][] visited) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col])
            return;

        visited[row][col] = true;

        noOfIslandDFS(row - 1, col, grid, visited);
        noOfIslandDFS(row + 1, col, grid, visited);
        noOfIslandDFS(row, col - 1, grid, visited);
        noOfIslandDFS(row, col + 1, grid, visited);
    }

    // Find the max area island on grid
    public int maxAreaOfIsland(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        int maxArea = 0;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] != 0 && !visited[row][col]) {
                    int area = maxAreaOfIslandBFS(row, col, grid, visited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int maxAreaOfIslandDFS(int row, int col, int[][] grid, boolean[][] visited) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] != 1)
            return 0;

        visited[row][col] = true;
        int area = 1;

        area += maxAreaOfIslandDFS(row - 1, col, grid, visited);
        area += maxAreaOfIslandDFS(row + 1, col, grid, visited);
        area += maxAreaOfIslandDFS(row, col - 1, grid, visited);
        area += maxAreaOfIslandDFS(row, col + 1, grid, visited);

        return area;
    }

    private int maxAreaOfIslandBFS(int row, int col, int[][] grid, boolean[][] visited) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        visited[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        int area = 1;

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int pr = polled[0];
            int pc = polled[1];
            for(int[] d : directions) {
                int nr = pr + d[0];
                int nc = pc + d[1];
                if(isValid(nr, nc, grid, visited)) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    area++;
                }
            }
        }
        return area;
    }

    private int maxMin = 0;

    public int orangesRotting(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (!visited[row][col] && grid[row][col] == 2) {
                    orangesRottingDFS(row, col, visited, grid, 0);
                }
            }
        }

        return maxMin;
    }

    private void orangesRottingDFS(int row, int col, boolean[][] visited, int[][] grid, int min) {

        if (row < 0 || row >=  grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return;

        visited[row][col] = true;

        orangesRottingDFS(row - 1, col, visited, grid, 0);
        orangesRottingDFS(row + 1, col, visited, grid, 0);
        orangesRottingDFS(row , col - 1, visited, grid, 0);
        orangesRottingDFS(row, col + 1, visited, grid, 0);

    }

    public void  test() {
        List<Order> orders = buildOrders();

        Map<String, Long> frequentOrder = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(
                                e -> e.getKey(),
                                e -> e.getValue(),
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        )
                );

        Map<String, Long> limit = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(
                      Map.Entry::getKey,
                      Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

    }

    private List<Order> buildOrders() {
        return new ArrayList<>();
    }
}

class Order {
    int id;
    double amount;
    String status;

    public Order(int id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
