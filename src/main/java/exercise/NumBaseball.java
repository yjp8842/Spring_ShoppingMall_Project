package exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumBaseball {
    public static void main(String[] args) {
        int[] numArr = new int[3];
        int[] inputArr = new int[3];
        int count = 0;
        int strike = 0;
        int ball = 0;
        int out = 0;
        int flag = 0;

        randomNum(numArr);

        System.out.println("정답 : " + numArr[0] + numArr[1] + numArr[2]);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("숫자를 입력하세요.(띄어쓰기 혹은 한 줄씩)");
            for (int i = 0; i < 3; i++) {
                try {
                    inputArr[i] = scanner.nextInt();
//                    for (int j = 0; j < i; j++) {
//                        if (inputArr[i] == inputArr[j]) {
//                            System.out.println("다시 입력해주세요.");
//                            i--;
//                            break;
//                        }
//                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");
                    scanner.nextLine();
                }
            }

            strike = 0;
            ball = 0;
            out = 0;

            for (int i = 0; i < 3; i++) {
                flag = 0;
                for (int j = 0; j < 3; j++) {
                    if (inputArr[i] == numArr[j]) {
                        if (i == j)
                            strike++;
                        else
                            ball++;
                    } else {
                        flag++;
                    }
                }

                if (flag == 3)
                    out++;
            }

            System.out.println(strike + "S " + ball + "B " + out + "O");
            count++;

            if (count == 10) {
                System.out.println("기회 10번이 모두 소진되었습니다.");
                break;
            } else {
                if (strike == 3) {
                    System.out.println("정답을 맞추셨습니다! 축하합니다!");
                    break;
                }
            }
        }
    }

    // 랜덤 숫자 3자리
    public static void randomNum(int[] numArr) {
        for (int i = 0; i < 3; i++) {
            numArr[i] = (int) (Math.random() * 10);
        }

        if (numArr[0] == numArr[1] || numArr[1] == numArr[2] || numArr[0] == numArr[2])
            randomNum(numArr);
    }
}
