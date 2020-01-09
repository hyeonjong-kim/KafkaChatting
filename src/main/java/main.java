import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter your nick name : ");
        String nickName = scan.nextLine();

        ClientUi ui = new ClientUi(nickName);

        Consumer c = new Consumer(ui, nickName);
        Thread t = new Thread(c);
        t.start();

       ui.run();
    }
}
