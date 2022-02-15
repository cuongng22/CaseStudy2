package login;

import manager.MngAccount;

import java.util.Scanner;

public class ScreenLogin {
    public static final Scanner scanner = new Scanner(System.in);
    MngAccount mngAccount = new MngAccount();
    public void menuLogin() {
        int choice1;
        do {
            System.out.println("***************************");
            System.out.println("*     1. Đăng Nhập        *");
            System.out.println("*     2. Đăng Ký          *");
            System.out.println("*     0. Exit             *");
            System.out.println("***************************");
            choice1 = scanner.nextInt();
            if (choice1 <0 || choice1 >2) {
                System.out.println();
                System.out.println("Vui lòng nhập đúng lựa chọn!");
            }
            switch (choice1) {
                case 1:
                    mngAccount.login123();
                    break;
                case 2:
                    mngAccount.createAcc();
                    break;
            }
        } while (choice1 != 0);
    }
}
