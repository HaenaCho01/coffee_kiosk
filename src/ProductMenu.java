import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductMenu extends Menu {

    public ProductMenu() {
        super();
    }
    public ArrayList product;

    public ProductMenu(ProductMenu name, ProductMenu price, String string) {
    }

    public ProductMenu(String name, double price, String string) {
    }

    public ArrayList product(String selName, double selPrice, String selEx) {
        ArrayList product = new ArrayList();
        product.add(selName);
        product.add(selPrice);
        product.add(selEx);
        return product;
    }
    public List<Menu> coffee () {
        List<Menu> coffee = Arrays.asList(
                new Menu(1, "에스프레소", 2.0, "비터홀릭 원두의 풍성한 크레마가 입안 가득히 느껴지며 고소 쌉쌀함이 담긴 음료"),
                new Menu(2, "아메리카노", 2.0, "진한 에스프레소에 물과 얼음을 더하여 컴포즈커피의 고소함과 초콜리티함이 담김 음료"),
                new Menu(3, "카페라떼", 3.4, "진한 에스프레소에 우유를 더하여 부드럽게 마실 수 있는 음료")
        );
        return (coffee);
    }

    public List<Menu> dutchCoffee () {
        List<Menu> dutchCoffee = Arrays.asList(
                new Menu(1, "더치커피", 3.8, "찬물로 추출하여 풍부한 향을 가진 더치 아메리카노"),
                new Menu(2, "더치라떼", 4.3, "찬물로 추출하여 풍부한 향을 가진 더치와 부드러운 우유의 조화"),
                new Menu(3, "디카페인 더치커피", 4.0, "부드러운 디카페인 콜드브루 아메리카노")
        );
        return (dutchCoffee);
    }

    public List<Menu> beverage () {
        List<Menu> beverage = Arrays.asList(
                new Menu(1, "곡물라떼", 3.8, "풍부한 곡물과 우유가 어우러져 고소한 곡물라떼"),
                new Menu(2, "고구마라떼", 4.0, "자색 고구마와 우유가 어우러져 달콤한 고구마라떼"),
                new Menu(3, "더블초코라떼", 4.0, "진한 초콜릿과 우유가 어우러져 달콤한 초코라떼")
        );
        return (beverage);
    }
}
