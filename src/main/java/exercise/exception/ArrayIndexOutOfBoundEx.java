package exercise.exception;

public class ArrayIndexOutOfBoundEx {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // 예외 발생 상황
        // try catch
        // 어떤 예외 클래스로 예외 받아줄건지

        try {
            System.out.println(nums[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("예외 터졌다!");
            System.out.println(e.getMessage());
        }
    }
}
