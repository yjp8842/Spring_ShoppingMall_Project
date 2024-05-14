package exercise.etc;

public enum EnumAfterDemo {
    AMERICANO(0, "아메리카노"),
    LATTE(1, "라떼"),
    STRAWBERRY_ADE(2, "딸기에이드"),
    ESPRESSO(3, "에스프레소");

    private final int i;
    private final String menu;

    EnumAfterDemo(int i, String menu) {
        this.i = i;
        this.menu = menu;
    }

    public void selectMenu() {
        System.out.println(this.menu);
    }

    @Override
    public String toString() {
        return "EnumDemo{" +
                "i=" + i +
                ", menu='" + menu + '\'' +
                '}';
    }

    public static void main(String[] args) {
        EnumAfterDemo.AMERICANO.selectMenu();
        EnumAfterDemo.LATTE.selectMenu();
        EnumAfterDemo.STRAWBERRY_ADE.selectMenu();
        EnumAfterDemo.ESPRESSO.selectMenu();
    }
}