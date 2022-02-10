package login;

import manager.MngFulltime;
import manager.MngParttime;

import java.util.Scanner;

public class RunByUser {
    public void menuUser() {
        MngParttime mngParttime = new MngParttime();
        MngFulltime mngFulltime = new MngFulltime();
        Scanner scanner = new Scanner(System.in);
        int choice1;
        do {
            System.out.println("Hệ thống quản lí nhân viên!");
            System.out.println("1.Tìm kiếm nhân viên Full Time theo ID");
            System.out.println("2.Tìm kiếm nhân viên Part Time theo ID");
            System.out.println("3.Hiển thị danh sách nhân viên Full Time");
            System.out.println("4.Hiển thị danh sách nhân viên Part Time");
            System.out.println("5.Tìm kiếm nhân viên Full Time theo tên");
            System.out.println("6.Tìm kiếm nhân viên Part Time theo tên");
            System.out.println("7.Tra cứu lương Full Time");
            System.out.println("8.Tra cứu lương Part Time");
            System.out.println("9. Hiển thị tất cả lương của nhân viên FULLTIME");
            System.out.println("10. Hiển thị tất cả lương của nhân viên PARTTIME");
            System.out.println("11. Thay đổi thông tin cá nhân! (Fulltime)");
            System.out.println("12. Thay đổi thông tin cá nhân! (Parttime)");
            System.out.println("0.Đăng xuất");
            choice1 = scanner.nextInt();
            if (choice1 < 0 || choice1 > 11) {
                System.out.println();
                System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
            }
            switch (choice1) {
                case 1:
                    mngFulltime.searchById();
                    break;
                case 2:
                    mngParttime.searchById();
                    break;
                case 3:
                    mngFulltime.displayAllFullTime();
                    break;
                case 4:
                    mngParttime.displayAll();
                    break;
                case 5:
                    mngFulltime.searchByName();
                    break;
                case 6:
                    mngParttime.searchByName();
                    break;
                case 7:
                    mngFulltime.displaySalaryById();
                    break;
                case 8:
                    mngParttime.displaySalaryById();
                    break;
                case 9:
                    mngFulltime.showAllSalary();
                    break;
                case 10:
                    mngParttime.showAllSalary();
                    break;
                case 11:
                    mngFulltime.editByCode();
                    break;
                case 12:
                    mngParttime.editByCode();
                    break;
            }
        } while (choice1 != 0);
    }
}
