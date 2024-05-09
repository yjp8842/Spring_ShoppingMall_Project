package exercise;

import java.util.Scanner;

public class NumBaseball {
    public static void main(String[] args) {
        int[] numArr = new int[3];
        int[] inputArr = new int[3];
        String result = "";
        int count = 0;
        int strike = 0;
        int ball = 0;
        int out = 0;
        int flag = 0;
        boolean isDuplicate = false;

        randomNum(numArr);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("3개의 숫자를 입력하세요.(띄어쓰기)");
            String inputLine = scanner.nextLine();
            String[] inputs = inputLine.split(" ");
            result = "";

            if (inputs.length != 3) {
                System.out.println("3개의 숫자만 입력 가능합니다.");
                continue;
            }

            try {
                isDuplicate = false;
                for (int i = 0; i < 3; i++) {
                    inputArr[i] = Integer.parseInt(inputs[i]);
                    for (int j = 0; j < i; j++) {
                        if (inputArr[i] == inputArr[j]) {
                            System.out.println("중복된 숫자가 없도록 입력해주세요.");
                            isDuplicate = true;
                            break;
                        }
                    }
                    if (isDuplicate) break;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다. 다시 3개의 숫자를 입력해주세요.");
                continue;
            }

            if (isDuplicate) {
                count++;
                continue;
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

            if (strike > 0)
                result += strike + "S ";
            if (ball > 0)
                result += ball + "B ";
            if (out > 0)
                result += out + "O";

            System.out.println(result);
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
