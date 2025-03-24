import java.util.Arrays;
import java.util.Scanner;

public class DisappearingTicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int move;
        char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        int[] x_moves = {-1, -1, -1};
        int[] o_moves = {-1, -1, -1};

        while (true) {
            System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\n");
            System.out.println("x's turn.");
            move = in.nextInt();
            board[move / 3][move % 3] = 'x';
            if (x_moves[0] != -1) board[x_moves[0] / 3][x_moves[0] % 3] = '-';
            x_moves[0] = x_moves[1];
            x_moves[1] = x_moves[2];
            x_moves[2] = move;

            System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + "\n");
            System.out.println("o's turn.");
            move = in.nextInt();
            board[move / 3][move % 3] = 'o';
            if (o_moves[0] != -1) board[o_moves[0] / 3][o_moves[0] % 3] = '-';
            o_moves[0] = o_moves[1];
            o_moves[1] = o_moves[2];
            o_moves[2] = move;
        }
    }
}