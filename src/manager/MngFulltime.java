package manager;

import IO.ReadAndWriteFile;
import model.Account;
import model.StaffFullTime;
import model.StaffPartTime;
import regex.RegexEmail;
import regex.RegexPhoneNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class MngFulltime {

    private ArrayList<StaffFullTime> staffFullTimes;
    Scanner scanner = new Scanner(System.in);
    private ReadAndWriteFile ioFile = new ReadAndWriteFile();
    public static final String PATH_NAME_Staff1 = "files/StaffFullTime.txt";

    public MngFulltime() {
        this.staffFullTimes = ioFile.readFileData(PATH_NAME_Staff1);
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
        scanner.nextLine();
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
        scanner.nextLine();
        System.out.println("Nhập mã bảo mật của nhân viên: ");
        String check124 = scanner.nextLine();
        String code = checkCode(check124);
        StaffFullTime staffFullTime = new StaffFullTime(id, name, age, address,gender, phoneNumber, email, status, code, overTime, bonus, dayOff );
        staffFullTimes.add(staffFullTime);
        ioFile.writerFileData(staffFullTimes,PATH_NAME_Staff1);
    }

    public boolean abc(String code) {
        for (StaffFullTime staffFullTime : staffFullTimes) {
            if (staffFullTime.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }


    public String checkCode(String code) {
        while (abc(code) || code.equals("")) {
            System.out.println("Vui lòng nhập code");
            code = scanner.nextLine();
        }
        return code;
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
                        staffFullTime.setId(id1);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 2:
                        scanner.nextLine();
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
                        scanner.nextLine();
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
                        gender = getGender(choice1);
                        scanner.nextLine();
                        staffFullTime.setGender(gender);
                        System.out.println("Sửa thành công!");
                    case 6:
                        String phoneNumber;
                        boolean checkPhoneNumber;
                        do {
                            scanner.nextLine();
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
                        String status = "";
                        System.out.println("Chọn trạng thái: (on : làm, off: nghỉ)");
                        System.out.println("1. On");
                        System.out.println("2. Off");
                        int choice123 = scanner.nextInt();
                        status = getStatus(choice123);
                        staffFullTime.setStatus(status);
                        System.out.println("Thay đổi thành công");
                        break;
                    case 9:
                        System.out.println("Nhập giờ làm thêm mới: ");
                        double overTime = checkOverTime(scanner.nextDouble());
                        staffFullTime.setOverTime(overTime);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 10:
                        System.out.println("Nhập tiền thưởng mới: ");
                        double bonus = checkBonus(scanner.nextDouble());
                        staffFullTime.setBonusSalary(bonus);
                        System.out.println("Thành công");
                        break;
                    case 11:
                        System.out.println("Nhập ngày nghỉ mới: ");
                        double dayOff = dayOff(scanner.nextDouble());
                        staffFullTime.setOffDay(dayOff);
                        System.out.println("thành công");
                        break;
                    default:
                        System.out.println("Vui lòng chọn đúng!");
                        break;
                }
            } while (choice != 0);
        } else System.out.println("Nhập sai ID rồi!");
        ioFile.writerFileData(staffFullTimes,PATH_NAME_Staff1);
    }


    public int checkAge(int age){
        while (age<=0){
            System.out.println("Vui lòng nhập lại tuổi");
            age = scanner.nextInt();
        }
        return age;
    }

    public double checkOverTime(double overTime) {
        while (overTime < 0 & overTime >30) {
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

    public void deleteById() {
        System.out.println("Nhập id của nhân viên muốn xoá: ");
        int id = scanner.nextInt();
        StaffFullTime staffFullTime = null;
        for (StaffFullTime staffFullTime123 : staffFullTimes) {
            if (staffFullTime123.getId() == id) {
                staffFullTime =staffFullTime123;
                break;
            }
        }

        if (staffFullTime != null) {
            staffFullTimes.remove(staffFullTime);
        } else {
            System.out.println("ko có nhân viên nào trùng ID!");
        }
        ioFile.writerFileData(staffFullTimes,PATH_NAME_Staff1);
    }

    public void searchById() {
        System.out.println("Nhập id của nhân viên muốn tìm: ");
        int id = scanner.nextInt();
        StaffFullTime staffFullTime = null;
        for (StaffFullTime staffFullTime123 : staffFullTimes) {
            if (staffFullTime123.getId() == id) {
                staffFullTime =staffFullTime123;
                break;
            }
        }

        if (staffFullTime != null) {
            System.out.println(staffFullTime);
        } else System.out.println("Không có ID của nhân viên cần tìm");
    }

    public void searchByName() {
        boolean check =false;
        ArrayList<StaffFullTime> staff123 = new ArrayList<>();
        System.out.println("Nhập tên của nhân viên muốn tìm kiếm :  ");
        String name = scanner.nextLine();
        for (StaffFullTime staffFullTime : staffFullTimes) {
            if (staffFullTime.getName().equals(name)) {
                staff123.add(staffFullTime);
                check = true;
            }
        }

        if (check) {
            System.out.println(staff123);
        } else System.out.println("Ko tim thay!");
    }

    public void displayByStatusON() {
        boolean check = false;
        ArrayList<StaffFullTime> staffFullTimes123 = new ArrayList<>();
        for (StaffFullTime staffFT : staffFullTimes) {
            if (staffFT.getStatus().equals("ON")) {
                staffFullTimes123.add(staffFT);
                check = true;
            }
        }
        if (check) {
            System.out.println(staffFullTimes123 + "\n");
        }
        else System.out.println("ko có ai");
    }

    public void displayByStatusOff() {
        boolean check = false;
        ArrayList<StaffFullTime> staffFullTimes123 = new ArrayList<>();
        for (StaffFullTime staffFT : staffFullTimes) {
            if (staffFT.getStatus().equals("OFF")) {
                staffFullTimes123.add(staffFT);
                check = true;
            }
        }
        if (check) {
            System.out.println(staffFullTimes123);
        }
        else System.out.println("ko có ai");
    }

    public void checkStatusById() {
        System.out.println("Nhập ID muốn check trạng thái: ");
        int id = scanner.nextInt();
        StaffFullTime staffFullTime = null;
        for (StaffFullTime staffFullTime1 : staffFullTimes) {
            if (staffFullTime1.getId() == id ) {
                staffFullTime = staffFullTime1;
                break;
            }
        }

        if (staffFullTime != null) {
            System.out.println(staffFullTime.getStatus());
        } else System.out.println("Nhập sai ID");
    }

    public void displaySalaryById() {
        System.out.println("Nhập ID của nhân viên muốn xem lương: ");
        int id = scanner.nextInt();
        StaffFullTime staffFullTime = null;
        for (StaffFullTime staffFullTime1 : staffFullTimes) {
            if (staffFullTime1.getId() == id ) {
                staffFullTime = staffFullTime1;
                break;
            }
        }

        if (staffFullTime != null) {
            System.out.println(staffFullTime + " Lương : " + salary(staffFullTime)+" USD");
        }
    }

    public double salary(StaffFullTime staffFullTime) {
        double day = staffFullTime.getOffDay();
        if (day <5) {
            return ((30-day) * 20*1.4 + staffFullTime.getBonusSalary()+ staffFullTime.getOverTime()*3);
        } else if (day < 10) {
            return ((30-day) * 20*1 + staffFullTime.getBonusSalary()+ staffFullTime.getOverTime()*3);
        } else return ((30-day) * 20*1 + staffFullTime.getBonusSalary()+ staffFullTime.getOverTime()*3);
    }

    public void showAllSalary() {
        for (StaffFullTime staffFullTime : staffFullTimes) {
            System.out.println(staffFullTime + " Lương : " + salary(staffFullTime) + " USD");
        }
    }

    public void editByCode() {
        System.out.println("Nhập mã bảo mật của bạn: ");
        String code =scanner.nextLine();
        StaffFullTime staffFullTime = null;
        for (StaffFullTime staffFullTime1 : staffFullTimes) {
            if (staffFullTime1.getCode().equals(code)) {
                staffFullTime = staffFullTime1;
                break;
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
                        staffFullTime.setId(id1);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 2:
                        scanner.nextLine();
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
                        scanner.nextLine();
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
                        scanner.nextLine();
                        staffFullTime.setGender(gender);
                        System.out.println("Sửa thành công!");
                    case 6:
                        String phoneNumber;
                        boolean checkPhoneNumber;
                        do {
                            scanner.nextLine();
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
                        String status = "";
                        System.out.println("Chọn trạng thái: (on : làm, off: nghỉ)");
                        System.out.println("1. On");
                        System.out.println("2. Off");
                        int choice123 = scanner.nextInt();
                        status = getStatus(choice123);
                        staffFullTime.setStatus(status);
                        System.out.println("Thay đổi thành công");
                        break;
                    case 9:
                        System.out.println("Nhập giờ làm thêm mới: ");
                        double overTime = checkOverTime(scanner.nextDouble());
                        staffFullTime.setOverTime(overTime);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 10:
                        System.out.println("Nhập tiền thưởng mới: ");
                        double bonus = checkBonus(scanner.nextDouble());
                        staffFullTime.setBonusSalary(bonus);
                        System.out.println("Thành công");
                        break;
                    case 11:
                        System.out.println("Nhập ngày nghỉ mới: ");
                        double dayOff = dayOff(scanner.nextDouble());
                        staffFullTime.setOffDay(dayOff);
                        System.out.println("thành công");
                        break;
                }
            } while (choice != 0);
        } else System.out.println("Nhập sai mã bảo mật rồi!");
        ioFile.writerFileData(staffFullTimes,PATH_NAME_Staff1);
    }

    public void disPlayCode() {
        for (StaffFullTime staffFullTime : staffFullTimes) {
            System.out.println("Staff FullTime "+ "id ="+staffFullTime.getId()+" name : "+staffFullTime.getName()+ " code: "+ staffFullTime.getCode());
        }
    }
}
