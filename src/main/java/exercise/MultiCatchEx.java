package exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiCatchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] cards = {1, 2, 3, 4, 5, 6};

        try {
            System.out.println("몇 번째 카드를 뽑으실래요?");
            int cardIdx = scanner.nextInt();

            System.out.println("뽑은 카드 번호는 : " + cardIdx);
            System.out.println("뽑은 카드에 적힌 숫자는 : " + cards[cardIdx]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("없는 번호입니다.");
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요.");
        }
    }
}
