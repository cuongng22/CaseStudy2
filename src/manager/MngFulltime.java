package manager;

import IO.ReadAndWriteFile;
import model.StaffFullTime;
import regex.RegexEmail;
import regex.RegexPhoneNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class MngFulltime {

    private ArrayList<StaffFullTime> staffFullTimes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    public static final String PATH_NAME_Staff = "C:\\Users\\Admin\\Desktop\\CaseStudy2\\src\\file\\Staff";

    public MngFulltime() {
        this.staffFullTimes = readAndWriteFile.readFileData(PATH_NAME_Staff);
    }

    public ArrayList<StaffFullTime> getStaffFullTimes() {
        return staffFullTimes;
    }

    public void displayAllFullTime() {
        for (StaffFullTime staffFullTime : staffFullTimes) {
            System.out.println(staffFullTime);
        }
    }

    public String getGender(int choice) {
        String gender = "";
        switch (choice) {
            case 1:
                gender = "NAM";
                break;
            case 2:
                gender = "NỮ";
                break;
            case 3:
                gender = "OTHER";
                break;
        }
        return gender;
    }

    public String getStatus(int choice) {
        String status = "";
        switch (choice) {
            case 1:
                status = "ON";
                break;
            case 2:
                status = "OFF";
                break;
        }
        return status;
    }


    public void createStaffFullTime() {
        System.out.println("Nhập ID: ");
        int id = checkId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = checkAge(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        String gender="";
        System.out.println("Chọn giới tính: ");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.println("3. Khác");
        int choice = scanner.nextInt();
        gender = getGender(choice);
        String phoneNumber;
        boolean checkPhoneNumber;
        do {
            System.out.println("Nhập số điện thoại :");
            phoneNumber = scanner.nextLine();
            checkPhoneNumber = RegexPhoneNumber.validate(phoneNumber);
        }while (!checkPhoneNumber);
        boolean checkEmail;
        String email;
        do {
            System.out.println("Nhập email:");
            email = scanner.nextLine();
            checkEmail = RegexEmail.validate(email);
        }while (!checkEmail);
        String status = "";
        System.out.println("Chọn trạng thái: (on : làm, off: nghỉ)");
        System.out.println("1. On");
        System.out.println("2. Off");
        int choice1 = scanner.nextInt();
        status = getStatus(choice1);
        System.out.println("Nhập số giờ làm thêm");
        double overTime = checkOverTime(scanner.nextDouble());
        System.out.println("Nhập số ngày nghỉ: ");
        double dayOff = dayOff(scanner.nextDouble());
        System.out.println("Nhập lương thưởng");
        double bonus = checkBonus(scanner.nextDouble());
        StaffFullTime staffFullTime = new StaffFullTime(id, name, age, address,gender, phoneNumber, email, status, overTime, bonus, dayOff );
        staffFullTimes.add(staffFullTime);
    }

    public void editStaffFullTime() {
        System.out.println("Nhập id của nhân viên Full Time bạn muốn sửa: ");
        int id = scanner.nextInt();
        StaffFullTime staffFullTime = null;
        for (StaffFullTime staffFullTime1 : staffFullTimes) {
            if (staffFullTime1.getId() == id) {
                staffFullTime = staffFullTime1;
            }
        }

        if (staffFullTime != null) {
            int choice;
            do {
                System.out.println("Bạn muốn sửa cái gì? ");
                System.out.println("1. ID");
                System.out.println("2. Tên");
                System.out.println("3. Tuổi");
                System.out.println("4. Địa chỉ");
                System.out.println("5. Giới tính");
                System.out.println("6. Số điện thoại");
                System.out.println("7. Email");
                System.out.println("8. Trạng thái");
                System.out.println("9. Giờ làm thêm");
                System.out.println("10. Tiền thưởng");
                System.out.println("11. Ngày nghỉ");
                System.out.println(" 0. Thoát");
                choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Nhập ID mới: ");
                        int id1 = checkId(scanner.nextInt());
                        staffFullTime.setId(id);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 2:
                        System.out.println("Nhập tên mới: ");
                        String name = scanner.nextLine();
                        staffFullTime.setName(name);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 3:
                        System.out.println("Nhập tuổi mới: ");
                        int age = checkAge(scanner.nextInt());
                        staffFullTime.setAge(age);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 4:
                        System.out.println("Nhập địa chỉ mới: ");
                        String address = scanner.nextLine();
                        staffFullTime.setAddress(address);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 5:
                        System.out.println("Chọn lại giới tính: ");
                        String gender="";
                        System.out.println("1. Nam");
                        System.out.println("2. Nữ");
                        System.out.println("3. Khác");
                        int choice1 = scanner.nextInt();
                        gender = getGender(choice);
                        staffFullTime.setGender(gender);
                        System.out.println("Sửa thành công!");
                    case 6:
                        String phoneNumber;
                        boolean checkPhoneNumber;
                        do {
                            System.out.println("Nhập số điện thoại mới :");
                            phoneNumber = scanner.nextLine();
                            checkPhoneNumber = RegexPhoneNumber.validate(phoneNumber);
                        }while (!checkPhoneNumber);
                        staffFullTime.setPhoneNumber(phoneNumber);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 7:
                        boolean checkEmail;
                        String email;
                        do {
                            System.out.println("Nhập email:");
                            email = scanner.nextLine();
                            checkEmail = RegexEmail.validate(email);
                        }while (!checkEmail);
                        staffFullTime.setEmail(email);
                        System.out.println("thay đổi thành công");
                        break;
                    case 8:

                }
            } while (choice != 0);
        } else System.out.println("Nhập sai ID rồi!");
    }


    public int checkAge(int age){
        while (age<=0){
            System.out.println("Vui lòng nhập lại tuổi");
            age = scanner.nextInt();
        }
        return age;
    }

    public double checkOverTime(double overTime) {
        while (overTime < 0) {
            System.out.println("Vui lòng nhập lại!");
            overTime = scanner.nextDouble();
        }
        return overTime;
    }

    public double checkBonus(double bonus) {
        while (bonus < 0) {
            System.out.println("Vui lòng nhập lại!");
            bonus = scanner.nextDouble();
        }
        return bonus;
    }

    public double dayOff(double dayOff) {
        while (dayOff < 0) {
            System.out.println("Vui lòng nhập lại!");
            dayOff = scanner.nextDouble();
        }
        return dayOff;
    }

    public int checkId(int id){
        for (StaffFullTime staffFullTime : staffFullTimes) {
            while (staffFullTime.getId() == id ) {
                System.out.println("Vui lòng nhập lại ID");
                id = scanner.nextInt();
            }
        }
        return id;
    }
}
