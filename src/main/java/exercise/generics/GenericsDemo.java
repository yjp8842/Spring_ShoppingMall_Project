package exercise.generics;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
        // 3종류의 차가 순서대로 bbang()
        // 배열은 차를 더 추가할 수 없음.
        Car[] cars = new Car[3];
        cars[0] = new Taxi();
        cars[1] = new SuperCar();
        cars[2] = new Truck();

        for (int i = 0; i < 3; i++) {
            cars[i].bbang();
        }

        // 크기가 가변적인 ArrayList 사용
        ArrayList<Car> carArrayList = new ArrayList<>();
        carArrayList.add(new Taxi());
        carArrayList.add(new SuperCar());
        carArrayList.add(new Truck());

        for (int i = 0; i < carArrayList.size(); i++) {
            carArrayList.get(i).bbang();
        }

        CarList<Car> carList = new CarList<>();
        carList.add(new Taxi());
        carList.add(new SuperCar());
        carList.add(new Truck());

        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).bbang();
        }
    }
}

class CarList<T> {
    ArrayList<T> arrayList = new ArrayList<>();

    void add(T data) {
        // arrayList에 car 객체를 하나씩 추가
        arrayList.add(data);
    }

    int size() {
        return arrayList.size();
    }

    T get(int i) {
        return arrayList.get(i);
    }
}

class Car {
    void bbang() {
        System.out.println("경적 소리");
    }
}

class Taxi extends Car {
    void bbang() {
        System.out.println("빵빵");
    }
}

class SuperCar extends Car {
    void bbang() {
        System.out.println("빠아앙");
    }
}

class Truck extends Car {
    void bbang() {
        System.out.println("빵!!");
    }
}