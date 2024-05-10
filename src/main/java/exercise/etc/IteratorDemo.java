package exercise.etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> sportStars = new ArrayList<>();
        // add 5개
        // 순수한 for문 돌려서 순서대로 출력
        sportStars.add("김연아");
        sportStars.add("손흥민");
        sportStars.add("이상화");
        sportStars.add("윤성빈");
        sportStars.add("김연경");

        for (int i = 0; i < sportStars.size(); i++)
            System.out.println(sportStars.get(i));

        // index 없이 출력 가능
        Iterator<String> sportStarIterator = sportStars.iterator();
        while (sportStarIterator.hasNext()) {
            System.out.println(sportStarIterator.next());
        }

        for (String sportStar : sportStars) {
            System.out.println(sportStar);
        }

        Map<Integer, String> fruits = new HashMap<>();
        // 과일 5개
        // 순수한 for문 돌려서 순서대로 출력
        fruits.put(0, "딸기");
        fruits.put(1, "바나나");
        fruits.put(2, "포도");
        fruits.put(3, "키위");
        fruits.put(4, "망고");

        for (int i = 0; i < fruits.size(); i++)
            System.out.println(fruits.get(i));

        // index 없이 출력 가능
        Iterator<String> fruitsIterator = fruits.values().iterator();
        while (fruitsIterator.hasNext()) {
            System.out.println(fruitsIterator.next());
        }

        for (String fruit : fruits.values()) {
            System.out.println(fruit);
        }

    }
}
