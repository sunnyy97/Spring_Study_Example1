package hello.core.singleton;

public class StatefulService {  //Test 코드 만들고 싶을 때 : ctrl + shift + t
    // private int price;
    public int order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        // this.price = price; // 여기가 문제!
        return price;
    }

//    public int getPrice() {
//        //return price;
//
//    }
}
