import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    // 필드
    private int num;
    private String name;
    private String ex;
    private double price;
    public List<Menu> menuList;
    Scanner sc = new Scanner(System.in);
    // 생성자
    public Menu(int num, String name, String ex) {
        this.num = num;
        this.name = name;
        this.ex = ex;
    }

    public Menu(String name, double price, String ex) {
        this.name = name;
        this.ex = ex;
        this.price = price;
    }
    public Menu(int num, String name, double price, String ex) {
        this.num = num;
        this.name = name;
        this.ex = ex;
        this.price = price;
    }

    public Menu() {

    }

    public Menu(List<Menu> menuList) {
        this.menuList = menuList;
    }




    // 메소드
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getEx() {
        return ex;
    }

    public double getPrice() {
        return price;
    }

    public List<Menu> mainMenu () {
        List<Menu> mainMenu = Arrays.asList(
                new Menu(1, "커피", "카페인이 필요할 때 커피를 마셔보세요"),
                new Menu(2, "더치커피", "쓴 맛이 덜하고 부드러운 풍미의 커피를 마셔보세요"),
                new Menu(3, "베버리지", "카페인이 땡기지 않을 때 음료를 즐겨보세요")
        );
        return (mainMenu);
    }




}