import java.util.Scanner;

/**
 * 数あてゲーム
 * プログラマが設定した 2 桁の正の整数をユーザが当てるゲームです。
 * ユーザは 5 回まで入力できます。
 * - 当たった場合：「当たり」
 * - 外れた場合：設定された数より「大きいです」か「小さいです」を表示
 *   さらに、差が 20 以上なら「20 以上離れています」とも表示します。
 */
public class Kazuate {
    // プログラマが設定する 2 桁の正の整数（10〜99）
    private static final int SECRET_NUMBER = 42;
    private static final int MAX_TRIES = 5;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("*** 数あてゲームを始めます (2 桁の正の整数) ***");

            for (int attempt = 1; attempt <= MAX_TRIES; attempt++) {
                System.out.printf("%d 回目の入力: ", attempt);

            int guess;
            // 入力が整数かつ 2 桁の正の数であることを簡易チェック
            try {
                guess = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("数字を入力してください。\n");
                attempt--; // 回数を消費しない
                continue;
            }

            if (guess < 10 || guess > 99) {
                System.out.println("2 桁の正の整数を入力してください。\n");
                attempt--; // 回数を消費しない
                continue;
            }

            if (guess == SECRET_NUMBER) {
                System.out.println("当たり！ おめでとうございます。");
                return;
            }

            // 外れた場合のヒント
            if (guess > SECRET_NUMBER) {
                System.out.print("大きいです");
            } else {
                System.out.print("小さいです");
            }

            // 20 以上差があるかチェック
            int diff = Math.abs(guess - SECRET_NUMBER);
            if (diff >= 20) {
                System.out.print("（20 以上離れています）");
            }
            System.out.println("\n");
        }

        System.out.printf("残念！ 正解は %d でした。%n", SECRET_NUMBER);
        }
    }
}
