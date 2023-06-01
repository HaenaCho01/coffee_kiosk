import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Print {
    public List<Menu> menuList;

    public Print(List<Menu> menuList) {
    }

    public Print () {
    }


    public void showMenu(List<Menu> menuList) throws InterruptedException {
        while (true) {
            // 메인메뉴 화면
            Print print = new Print();
            print.hello();

            System.out.println("[ 메뉴 ]");

            Menu mainMenu = new Menu();
            List menu = mainMenu.mainMenu(); // 해당 부분이 오래걸렸음...

            Object List;
            menuTool(menu);

            System.out.println();
            System.out.println("[ 주문 ]");
            System.out.println("4. 주문하기     | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. 취소하기     | 진행중인 주문을 취소합니다.");
            System.out.println();

            print.put();
            Scanner sc = new Scanner(System.in);
            int selNum = Integer.parseInt(sc.nextLine());
            print.end();

            if (selNum == 1) {
                // 커피메뉴 이동
                ProductMenu coffee = new ProductMenu();
                List coff = coffee.coffee();
                showProduct(coff);
            } else if (selNum == 2) {
                // 더치커피메뉴 이동
                ProductMenu dutchCoffee = new ProductMenu();
                List ducoff = dutchCoffee.dutchCoffee();
                showProduct(ducoff);
            } else if (selNum == 3) {
                // 음료메뉴 이동
                ProductMenu beverage = new ProductMenu();
                List bev = beverage.beverage();
                showProduct(bev);
            } else if (selNum == 4) {
                Order order = new Order();
                order.order();
            } else if (selNum == 5) {
                Order order = new Order();
                order.cancle();
            } else {
                Print wrong = new Print(menuList);
                wrong.wrong();
            }
        }
    }

    public void showProduct (List<Menu> menuList) throws InterruptedException {
        // 상품메뉴 화면
        while (true) {
            Print print = new Print(menuList);
            print.hello();

            System.out.println("[ MENU ]");

            Print print2 = new Print();
            productMenuTool(menuList);

            print.put();
            Scanner sc = new Scanner(System.in);
            int selNum = Integer.parseInt(sc.nextLine());
            print.end();

            Order order = new Order();
            order.addCart(selNum, menuList);
            break;
        }
    }

    public void menuTool (List<Menu> menuList) {
        double maxLength = 0;
        for (Menu menu : menuList) {
            String menuName = menu.getName().toString();
            double length = menuName.length() * 1.6; // 한글을 스페이스바 1.6개로 계산한 값
            if (length > maxLength) {
                maxLength = length;
            }
        }

        for (Menu menu : menuList) {
            int menuNum = menu.getNum();
            String menuName = menu.getName().toString();
            String menuEx = menu.getEx().toString();

            // 줄 정렬 관련 코드
            double tempLen = maxLength - (menuName.length() * 1.6);
            // 최대 길이 - (한글을 스페이스바 1.6개로 계산한 값)
            // tempLen = 문자열을 정렬을 위해 찍어야하는 스페이스바 갯수
            System.out.print(menuNum + ". " + menuName); // 1. 이름 찍기
            for (int i = 0; i < tempLen; i++) {
                System.out.print(" "); // 2. 정렬을 위해 계산한 tempLen 만큼 스페이스바 찍기
            }
            System.out.print(" | " + menuEx); // 이후 | 설명 찍기
            System.out.println(); // 줄바꿈
        }
    }
    public void productMenuTool(List<Menu> productMenuList) {
        double maxLength = 0;
        for (Menu productMenu : productMenuList) {
            String menuName = productMenu.getName().toString();
            double length = menuName.length() * 1.6; // 한글을 스페이스바 1.6개로 계산한 값
            if (length > maxLength) {
                maxLength = length;
            }
        }
        for (Menu productMenu : productMenuList) {
            int menuNum = productMenu.getNum();
            String menuName = productMenu.getName().toString();
            double menuPrice = productMenu.getPrice();
            String menuEx = productMenu.getEx().toString();

            // 줄 정렬 관련 코드
            double tempLen = maxLength - (menuName.length() * 1.6);
            // 최대 길이 - (한글을 스페이스바 1.6개로 계산한 값)
            // tempLen = 문자열을 정렬을 위해 찍어야하는 스페이스바 갯수
            System.out.print(menuNum + ". " + menuName); // 1. 이름 찍기
            for (int i = 0; i < tempLen; i++) {
                System.out.print(" "); // 2. 정렬을 위해 계산한 tempLen 만큼 스페이스바 찍기
            }
            System.out.print(" | W " + menuPrice); // 이후 | 가격 찍기
            System.out.println(" | " + menuEx); // 이후 | 설명 찍기
        }
        System.out.println();
    }

    public void orderMenuTool(String orderName, double orderPrice, String orderEx) {
        System.out.print(orderName); // 이름 찍기
        System.out.print(" | W " + orderPrice); // 이후 | 가격 찍기
        System.out.println(" | " + orderEx); // 이후 | 설명 찍기
    }


    public void hello() {
        Print print = new Print();
        System.out.println("'COMPOSE COFFEE'에 오신 것을 환영합니다! 키오스크 주문을 진행해주세요!");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 번호를 입력해주세요.");
        System.out.println();
    }
    public void put() {
        Print print = new Print();
        System.out.println();
        System.out.print("번호를 입력해주세요-> ");
    }
    public void wrong() throws InterruptedException {
        Print print = new Print();
        System.out.println("잘못 입력하셨습니다. 번호를 확인하신 후 다시 입력해주세요. 메뉴 화면으로 돌아갑니다.");
        end();
        Thread.sleep(2000);
    }

    public void end() {
        Print print = new Print();
        System.out.println("\n"+"--------------------------------------------------------------------------------------"+"\n");
    }


}
