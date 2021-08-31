package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 나무재테크_16235 {
    static int N, M, K;
    static int[][] A;
    static int[][] map;
    static LinkedList<Tree> aliveTrees = new LinkedList<>();
    static Queue<Tree> deadTrees = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static class Tree {
        private int x;
        private int y;
        private int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    public static int solution() {
        int result = 0;

        for (int k = 0; k < K; k++) {
            spring();
            summer();
            fall();
            winter();
        }

        result = aliveTrees.size();

        return result;
    }


    // 봄
    private static void spring() {
        Iterator<Tree> iterator = aliveTrees.iterator();
        while (iterator.hasNext()) {
            Tree tree = iterator.next();
            int age = tree.age;
            if (map[tree.x][tree.y] >= age) {
                map[tree.x][tree.y] -= age;
                tree.age++;
            } else {
                deadTrees.add(tree);
                iterator.remove();
            }
        }
    }

    // 여름
    private static void summer() {
        while (!deadTrees.isEmpty()) {
            Tree deadTree = deadTrees.poll();
            map[deadTree.x][deadTree.y] += deadTree.age / 2;
        }
    }

    // 가울
    private static void fall() {
        ArrayList<Tree> newTrees = new ArrayList<>();
        for (Tree tree : aliveTrees) {
            if (tree.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nx = tree.x + dx[j];
                    int ny = tree.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    newTrees.add(new Tree(nx, ny, 1));
                }
            }
        }
        aliveTrees.addAll(0, newTrees);
    }

    // 겨을
    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        A = new int[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int age = Integer.parseInt(stringTokenizer.nextToken());
            aliveTrees.add(new Tree(x, y, age));
        }

        int result = solution();
        System.out.println(result);
    }

}

