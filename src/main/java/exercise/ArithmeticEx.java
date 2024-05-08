package exercise;

public class ArithmeticEx {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("");
        }
    }

    public static int divide(int x, int y) {
//        throw
        int result = 0;
            result = x / y;
            System.out.println("0으로는 나눌 수 없습니다.");
        return result;
    }
}
