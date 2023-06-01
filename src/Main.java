import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Main startMain = new Main();
        startMain.startMain();
    }

    private void startMain() throws InterruptedException {
        List<Menu> menuList = Arrays.asList();
        Print showMenu = new Print(menuList);
        showMenu.showMenu(menuList);
    }
}
