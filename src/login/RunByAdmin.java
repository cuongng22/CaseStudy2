package login;

import manager.MngAccount;
import manager.MngFulltime;
import manager.MngParttime;

import java.util.Scanner;

public class RunByAdmin {
    public MngAccount mngAccount = new MngAccount();
    public MngParttime mngParttime = new MngParttime();
    public MngFulltime mngFulltime = new MngFulltime();
    public void menuAd() {
        Scanner scanner = new Scanner(System.in);
        int choice1;
        do {
            System.out.println("*****************************");
            System.out.println("*   1. Quản lý nhân viên    *");
            System.out.println("*   2. Quản Lý Tài khoản    *");
            System.out.println("*   0. Đăng xuất            *");
            System.out.println("*****************************");
            System.out.println("******  Nhập lựa chọn ******");
            choice1 = scanner.nextInt();
            if (choice1 < 0 || choice1 > 2) {
                System.out.println();
                System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
            }
            switch (choice1) {
                case 1:
                    int choice2;
                    do {
                        System.out.println("Quản lí nhân viên");
                        System.out.println("1.Nhân viên Full Time");
                        System.out.println("2.Nhân viên Part Time");
                        System.out.println("0. Thoát");
                        System.out.println("Nhập lựa chọn!");
                        choice2 = scanner.nextInt();
                        if (choice2 < 0 || choice2 > 2) {
                            System.out.println();
                            System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
                        }
                        switch (choice2) {
                            case 1:
                                int choice3;
                                do {
                                    System.out.println("Staff Full Time");
                                    System.out.println("1.Thêm nhân viên");
                                    System.out.println("2.Sửa nhân viên theo ID");
                                    System.out.println("3.Xoá nhân viên theo ID");
                                    System.out.println("4.TÌm kiếm nhân viên theo ID");
                                    System.out.println("5.Tìm kiếm nhân viên theo tên");
                                    System.out.println("6.Hiển thị tất cả nhân viên");
                                    System.out.println("7.Hiển thị tất cả nhân viên đang làm");
                                    System.out.println("8.Hiển thị tất cả nhân viên đang nghỉ");
                                    System.out.println("9.Kiểm tra trạng thái nhân viên theo ID");
                                    System.out.println("10.Hiển thị lương theo ID");
                                    System.out.println("11.Hiển thị lương tất cả nhân viên full time!");
                                    System.out.println("12. hiển thị mã bảo mật của nhân viên");
                                    System.out.println("0. Thoát");
                                    choice3 = scanner.nextInt();
                                    if (choice3 < 0 || choice3 > 12) {
                                        System.out.println();
                                        System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
                                    }
                                    switch (choice3) {
                                        case 1:
                                            mngFulltime.createStaffFullTime();
                                            break;
                                        case 2:
                                            mngFulltime.editStaffFullTime();
                                            break;
                                        case 3:
                                            mngFulltime.deleteById();
                                            break;
                                        case 4:
                                            mngFulltime.searchById();
                                            break;
                                        case 5:
                                            mngFulltime.searchByName();
                                            break;
                                        case 6:
                                            mngFulltime.displayAllFullTime();
                                            break;
                                        case 7:
                                            mngFulltime.displayByStatusON();
                                            break;
                                        case 8:
                                            mngFulltime.displayByStatusOff();
                                            break;
                                        case 9:
                                            mngFulltime.checkStatusById();
                                            break;
                                        case 10:
                                            mngFulltime.displaySalaryById();
                                            break;
                                        case 11:
                                            mngFulltime.showAllSalary();
                                            break;
                                        case 12:
                                            mngFulltime.disPlayCode();
                                            break;
                                    }
                                } while (choice3 != 0);
                                break;
                            case 2:
                                int choice4;
                                do {
                                    System.out.println("Staff Part Time");
                                    System.out.println("1.Thêm nhân viên");
                                    System.out.println("2.Sửa nhân viên theo ID");
                                    System.out.println("3.Xoá nhân viên theo ID");
                                    System.out.println("4.TÌm kiếm nhân viên theo ID");
                                    System.out.println("5.Tìm kiếm nhân viên theo tên");
                                    System.out.println("6.Hiển thị tất cả nhân viên");
                                    System.out.println("7.Hiển thị tất cả nhân viên đang làm");
                                    System.out.println("8.Hiển thị tất cả nhân viên đang nghỉ");
                                    System.out.println("9.Kiểm tra trạng thái nhân viên theo ID");
                                    System.out.println("10.Hiển thị lương theo ID");
                                    System.out.println("11.Hiển thị lương tất cả nhân viên part time!");
                                    System.out.println("12. hiển thị mã bảo mật của nhân viên");
                                    System.out.println("0. Thoát");
                                    choice4 = scanner.nextInt();
                                    if (choice4 < 0 || choice4 > 12) {
                                        System.out.println();
                                        System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
                                    }
                                    switch (choice4) {
                                        case 1:
                                            mngParttime.createStaffPartTime();
                                            break;
                                        case 2:
                                            mngParttime.editStaffFullTime();
                                            break;
                                        case 3:
                                            mngParttime.deleteById();
                                            break;
                                        case 4:
                                            mngParttime.searchById();
                                            break;
                                        case 5:
                                            mngParttime.searchByName();
                                            break;
                                        case 6:
                                            mngParttime.displayAll();
                                            break;
                                        case 7:
                                            mngParttime.displayByStatusON();
                                            break;
                                        case 8:
                                            mngParttime.displayByStatusOff();
                                            break;
                                        case 9:
                                            mngParttime.checkStatusById();
                                            break;
                                        case 10:
                                            mngParttime.displaySalaryById();
                                            break;
                                        case 11:
                                            mngParttime.showAllSalary();
                                            break;
                                        case 12:
                                            mngParttime.disPlayCode();
                                            break;
                                    }
                                } while (choice4 != 0);
                                break;
                        }
                    } while (choice2 != 0);
                    break;
                case 2:
                    int choice5;
                    do {
                        System.out.println("1. Thêm tài khoản");
                        System.out.println("2. Xoá tài khoản");
                        System.out.println("3. Hiển thị tất cả tài khoản");
                        System.out.println("4. Đổi mật khẩu tài khoản nhân viên");
                        System.out.println("0. Thoát");
                        choice5 =scanner.nextInt();
                        if (choice5 < 0 || choice5 > 4) {
                            System.out.println();
                            System.out.println("Lựa chọn không tồn tại! Mời bạn nhập lại!");
                        }
                        switch (choice5) {
                            case 1:
                                mngAccount.createAcc();
                                break;
                            case 2:
                                mngAccount.deleteAcc();
                                break;
                            case 3:
                                mngAccount.showAllUser();
                                break;
                            case 4:
                                mngAccount.editPassword();
                                break;
                        }
                    } while (choice5 !=0);
                    break;
            }
        }while(choice1 != 0);
    }
}
