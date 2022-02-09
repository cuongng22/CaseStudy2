package login;

import manager.MngAccount;
import model.Account;

import java.util.Scanner;

public class ScreenLogin {
    public static final Scanner scanner = new Scanner(System.in);
public static void menuLogin() {
    MngAccount mngAccount = new MngAccount();
    int choice1;
    do {
        System.out.println("1.Đăng nhập");
        System.out.println("2.Đăng kí");
        System.out.println("0.Exit");
        choice1 = scanner.nextInt();
        switch (choice1) {
            case 1:
                mngAccount.login();
                break;
            case 2:
                mngAccount.createAcc();
                break;
            default:
                System.out.println("vui lòng nhập lại!");
                break;
        }
    } while (choice1 != 0);
}
}
