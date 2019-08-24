package Leetcode.AlgorithmBasic;

import java.util.HashSet;
import java.util.Set;

//现在有1,2,2,3,4,5,6这七个数，要求求出所有的不重复的排序，并且3和5不能相邻，4不能是第三位
//解决方法：将这几个数看做是图的节点，3和5不能相邻，即节点3和5不连通，4不能是第三位，代表要排除第三位是4的数
//深度优先遍历这张图
public class PrintArrayAccordingToDirection {

    private int[] numbers = {1, 2, 2, 3, 4, 5, 6};
    private Set<String> result = new HashSet<>();
    private StringBuilder current = new StringBuilder();
    private boolean[] isVisited = new boolean[7];

    private void solution() {
        int[][] graph = buildGraph();
        for (int rowIndex = 0; rowIndex < graph.length; rowIndex++) {
            if (!isVisited[rowIndex]) {
                dfs(graph, rowIndex);
            }
        }
    }

    private int[][] buildGraph() {
        int[][] graph = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i != j) {
                    graph[i][j] = 1;
                }
            }
        }
        graph[3][5] = 0;
        graph[5][3] = 0;
        return graph;
    }

    //对一个节点进行深度优先遍历
    private void dfs(int[][] graph, int startIndex) {
        isVisited[startIndex] = true;
        current.append(numbers[startIndex]);
        if (current.length() == 7 && current.charAt(2) != 4) {
            result.add(new String(current));
        }

        for (int columnIndex = 1; columnIndex < isVisited.length; columnIndex++) {
            if (graph[startIndex][columnIndex] == 1 && !isVisited[columnIndex]) {
                dfs(graph, columnIndex);
            }
        }
        isVisited[startIndex] = false;
        current.deleteCharAt(current.length() - 1);
    }

    private void print(){
        for(String s:result){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        PrintArrayAccordingToDirection p = new PrintArrayAccordingToDirection();
        p.solution();
        p.print();
    }
}
