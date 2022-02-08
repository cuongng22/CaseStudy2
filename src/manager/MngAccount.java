package manager;

import IO.ReadAndWriteFile;
import model.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class MngAccount {
    private Account ad = new Account("admin", "admin");
    private ArrayList<Account> accounts;
    Scanner scanner = new Scanner(System.in);
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    private static final String Path_of_acc = "C:\\Users\\Admin\\Desktop\\CaseStudy2\\src\\file\\Account";

    public MngAccount() {
        this.accounts = readAndWriteFile.readFileData(Path_of_acc);
    }

    public void createAcc() {
        System.out.println("Nhập tên tài khoản: ");
        String user = checkUser(scanner.nextLine());
        System.out.println("Nhập mật khẩu");
        String pass = scanner.nextLine();
        Account account = new Account(user, pass);
        accounts.add(account);
    }

    public String checkUser(String user) {
        for (Account account : accounts) {
            while(account.getUserName().equals(user)||account.getUserName().equals("admin")) {
                System.out.println("Tên đăng nhập đã tồn tại, vui lòng nhập lại!");
                user = scanner.nextLine();
            }
        }
        return user;
    }

    public void deleteAcc() {
        System.out.println("Nhập username muốn xoá : ");
        String user = scanner.nextLine();
        Account account = null;
        for (Account account1 : accounts) {
            if (account1.getUserName().equals(account)) {
                account = account1;
                break;
            }
        }
        if (account != null) {
            accounts.remove(account);
            System.out.println("Xoá thành công");
        } else System.out.println("Không tìm thấy tên tài khoản!");
    }

    public void editPassword() {
        System.out.println("Nhập username muốn đổi mk : ");
        String user = scanner.nextLine();
        Account account = null;
        for (Account account1 : accounts) {
            if (account1.getUserName().equals(account)) {
                account = account1;
                break;
            }
        }
        if (account != null) {
            System.out.println("Nhập mk mới" );
            String mk = scanner.nextLine();
            account.setPassWord(mk);
        } else System.out.println("Không tìm thấy tên tài khoản!");
    }

    public boolean login(Account account) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName()) && acc.getPassWord().equals(account.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    public boolean loginAdmin(Account account) {
        if (ad.equals(account)) {
            return true;
        } else return false;
    }

    public void editAd() {
        System.out.println("Nhập mk mới: ");
        String mkAd= scanner.nextLine();
        ad.setPassWord(mkAd);
        System.out.println("done!");
    }

    public void showAllUser() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }




}
