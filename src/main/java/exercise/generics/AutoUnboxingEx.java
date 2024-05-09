package exercise.generics;

public class AutoUnboxingEx {
    public static void main(String[] args) {
        Int num1 = new Int(7);
        System.out.println(num1.i);

        int num2 = 8;
        System.out.println(num2);

        // Deprecated 되어서 이건 쓰지 않기로.
        // Integer num3 = new Integer(9);
        Integer num3 = 9;
        System.out.println(num3); // 객체를 출력해도 그 안에 감싸진 데이터가 출력됨 -> AutoUnboxing
    }
}

class Int {
    int i;

    Int(int i) {
        this.i = i;
    }
}
