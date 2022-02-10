package manager;

import IO.ReadAndWriteFile;
import login.RunByAdmin;
import login.RunByUser;
import model.Account;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MngAccount {
    private static Account ad = new Account("admin", "admin");
    private ArrayList<Account> accounts;
    Scanner scanner = new Scanner(System.in);
    private static final String Path_of_acc = "files/account.txt";
    private final ReadAndWriteFile ioFile = new ReadAndWriteFile();

    public MngAccount() {
        if (new File(Path_of_acc).length() == 0) {
            this.accounts = new ArrayList<>();
        } else {
            this.accounts = ioFile.readFileData(Path_of_acc);
        }
    }
    public void createAcc() {
        System.out.println("Nhập tên tài khoản: ");
        String check = scanner.nextLine();
        String user = checkUser(check);
        System.out.println("Nhập mật khẩu");
        String pass = scanner.nextLine();
        Account account = new Account(user, pass);
        accounts.add(account);
        System.out.println("Đăng kí thành công!");
        ioFile.writerFileData(accounts, Path_of_acc);
    }

    public String checkUser(String user) {
        for (Account account : accounts) {
            while(account.getUserName().equals(user)
            ) {
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
            if (account1.getUserName().equals(user)) {
                account = account1;
                break;
            }
        }
        if (account != null) {
            accounts.remove(account);
            System.out.println("Xoá thành công");
        } else System.out.println("Không tìm thấy tên tài khoản!");
        ioFile.writerFileData(accounts, Path_of_acc);
    }

    public void editPassword() {
        System.out.println("Nhập username muốn đổi mk : ");
        String user = scanner.nextLine();
        Account account = null;
        for (Account account1 : accounts) {
            if (account1.getUserName().equals(user)) {
                account = account1;
                break;
            }
        }
        if (account != null) {
            System.out.println("Nhập mk mới" );
            String mk = scanner.nextLine();
            account.setPassWord(mk);
        } else System.out.println("Không tìm thấy tên tài khoản!");
        ioFile.writerFileData(accounts, Path_of_acc);
    }

    public boolean login(Account account) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName()) && acc.getPassWord().equals(account.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    public void showAllUser() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    public void editPass() {
        System.out.println("Nhập tên tk: ");
        String tk = scanner.nextLine();
        System.out.println("Nhập mk: ");
        String mk = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < accounts.size();i++) {
            if (accounts.get(i).getUserName().equals(tk) && accounts.get(i).getPassWord().equals(mk)) {
                index = i;
            }
        }

        if (index != -1) {
            System.out.println("Nhap mk moi:");
            String newMk = scanner.nextLine();
            accounts.get(index).setPassWord(newMk);
        } else System.out.println("Sai ten dang nhap hoac mk");
    }

    public void login123() {
        RunByAdmin runByAdmin = new RunByAdmin();
        RunByUser runByUser = new RunByUser();
        System.out.println("Nhập tài khoản: ");
        String tk = scanner.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String mk = scanner.nextLine();
        Account account = new Account(tk,mk);

        if (account.getUserName().equals(ad.getUserName())&&account.getPassWord().equals(ad.getPassWord())) {
            runByAdmin.menuAd();
        } else if (login(account)) {
            runByUser.menuUser();
        } else System.out.println("sai tên đăng nhập hoặc mật khẩu");
    }
}