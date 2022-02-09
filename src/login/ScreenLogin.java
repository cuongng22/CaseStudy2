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
        System.out.println("***************************");
        System.out.println("*     1. Đăng Nhập        *");
        System.out.println("*     2. Đăng Ký          *");
        System.out.println("*     0. Exit             *");
        System.out.println("***************************");
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
