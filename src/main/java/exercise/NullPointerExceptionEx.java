package exercise;

public class NullPointerExceptionEx {
    public static void main(String[] args) {
        String str = null;
        String[] strings = null;

        try {
            System.out.println(str.charAt(0));
        } catch (NullPointerException e) {
            System.out.println("예외 터졌다!");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }
}
