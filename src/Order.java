import java.text.DecimalFormat;
import java.util.*;

public class Order {
    static int waitNum = 0;
    public static ArrayList<ArrayList> cart = new ArrayList();

    public static void order() throws InterruptedException {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();

        System.out.println("[ 주문목록 ]");
        // 장바구니 목록 조회
        showCart(cart);
        System.out.println();

        System.out.println("[ 합계금액 ]");
        totalPrice(cart);
        System.out.println();

        System.out.println("1. 주문        2. 메뉴판");
        System.out.println();

        Print print = new Print();
        print.put();
        Scanner sc = new Scanner(System.in);
        int selNum = Integer.parseInt(sc.nextLine());
        Print print1 = new Print();
        print1.end();

        if (selNum == 1) {
            waitNum++;
            deleteCart(cart);
            Order order = new Order();
            order.success();

        } else if (selNum == 2) {
            System.out.println("메뉴판 화면으로 돌아갑니다.");
            Print print2 = new Print();
            print2.end();
            Thread.sleep(2000);
        } else {
            Print print3 = new Print();
            print3.wrong();
        }
    }

    public void cancle() throws InterruptedException {
        Order order = new Order();
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println();

        System.out.println("1. 확인        2. 메뉴판");
        System.out.println();

        Print print = new Print();
        print.put();

        Scanner sc = new Scanner(System.in);
        int selNum = Integer.parseInt(sc.nextLine());
        Print print1 = new Print();
        print1.end();

        if (selNum == 1) {
            // 장바구니 초기화 기능
            deleteCart(cart);
            System.out.println("진행하던 주문이 취소되었습니다.");
            Print print2 = new Print();
            print2.end();
            Thread.sleep(2000);
        } else if (selNum == 2) {
            System.out.println("메뉴판 화면으로 돌아갑니다.");
            Print print3 = new Print();
            print3.end();
            Thread.sleep(2000);
        } else {
            Print print4 = new Print();
            print4.wrong();
        }
    }

    public void success() throws InterruptedException {
        System.out.println("주문이 완료되었습니다!"+"\n");
        System.out.println("대기번호는 [ " + waitNum + " ] 번 입니다.");
        System.out.println("3초후 메뉴판으로 돌아갑니다.");
        Print print = new Print();
        print.end();
        Thread.sleep(3000);
        // 대기번호 붙이기 기능

    }

    public void addCart(int selNum, List<Menu> productMenuList) throws InterruptedException {
        int idNum = selNum - 1;
        if (selNum != 0) {
            if (selNum <= productMenuList.size()) {
                System.out.println("'" + productMenuList.get(idNum).getName() + " | W " + productMenuList.get(idNum).getPrice() + " | " +
                        productMenuList.get(idNum).getEx() + "'");
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2. 취소");

                Print print = new Print();
                print.put();
                Scanner sc = new Scanner(System.in);
                int finNum = Integer.parseInt(sc.nextLine());
                Print print1 = new Print();
                print1.end();

                int chNum = selNum;
                List<Menu> chList = productMenuList;

                if (finNum == 1) {
                    cartIn(chNum, chList);
                    System.out.println("장바구니 담기 완료! 메뉴 화면으로 돌아갑니다.");
                    Print print2 = new Print();
                    print2.end();
                    Thread.sleep(2000);
                } else if (finNum == 2) {
                    System.out.println("주문이 취소되었습니다. 메뉴 화면으로 돌아갑니다.");
                    Print print2 = new Print();
                    print2.end();
                    Thread.sleep(2000);
                } else {
                    Print print2 = new Print();
                    print2.wrong();
                }
            } else {
                Print print2 = new Print();
                print2.wrong();
            }
        }
    }


    public ArrayList<ArrayList> cartIn(int chNum, List<Menu> chList) { // 해당 부분 오래 걸렸음
        int idNum = chNum - 1;
        String selName = chList.get(idNum).getName();
        double selPrice = chList.get(idNum).getPrice();
        String selEx = chList.get(idNum).getEx();
        ProductMenu getProducts = new ProductMenu();
        getProducts.product(selName, selPrice, selEx);
        cart.add(getProducts.product(selName, selPrice, selEx));
        return cart;
    }

    public static void deleteCart(ArrayList<ArrayList> cart) {
        cart.clear();
    }

    public static void showCart(ArrayList<ArrayList> cart) {
        double maxLength = 0;
        for (int i = 0; i < cart.size(); i++) {
            String orderName = (String) cart.get(i).get(0);
            double length = orderName.length() * 1.6; // 한글을 스페이스바 1.6개로 계산한 값
            if (length > maxLength) {
                maxLength = length;
            }
        }
        for (int i = 0; i < cart.size(); i++) {
            String orderName = (String) cart.get(i).get(0);
            double orderPrice = (double) cart.get(i).get(1);
            String orderEx = (String) cart.get(i).get(2);

            // 줄 정렬 관련 코드
            double tempLen = maxLength - (orderName.length() * 1.6);
            // 최대 길이 - (한글을 스페이스바 1.6개로 계산한 값)
            // tempLen = 문자열을 정렬을 위해 찍어야하는 스페이스바 갯수
            System.out.print(orderName); // 1. 이름 찍기
            for (int j = 0; j < tempLen; j++) {
                System.out.print(" "); // 2. 정렬을 위해 계산한 tempLen 만큼 스페이스바 찍기
            }
            System.out.print(" | W " + orderPrice); // 이후 | 가격 찍기
            System.out.println(" | " + orderEx); // 이후 | 설명 찍기
        }
        System.out.println();
    }

    public static void totalPrice(ArrayList<ArrayList> cart) {
        int total = 0;
        for (int i = 0; i < cart.size(); i++) {
            double orderPrice = (double) cart.get(i).get(1);
            total += orderPrice*1000;
        }
        DecimalFormat df = new DecimalFormat("###,###");
        String money = df.format(total);
        System.out.print("W " + money);
    }
}