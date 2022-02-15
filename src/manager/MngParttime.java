package manager;

import IO.ReadAndWriteFile;
import model.StaffFullTime;
import model.StaffPartTime;
import regex.RegexEmail;
import regex.RegexPhoneNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class MngParttime {
    private ArrayList<StaffPartTime> staffPartTimes = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    private static final String PATH_NAME_OF_Staff2 = "files/StaffPartTime";

    public MngParttime() {
        this.staffPartTimes = readAndWriteFile.readFileData(PATH_NAME_OF_Staff2);
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


    public void createStaffPartTime() {
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
        String gender = "";
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
        } while (!checkPhoneNumber);
        boolean checkEmail;
        String email;
        do {
            System.out.println("Nhập email:");
            email = scanner.nextLine();
            checkEmail = RegexEmail.validate(email);
        } while (!checkEmail);
        String status = "";
        System.out.println("Chọn trạng thái: (on : làm, off: nghỉ)");
        System.out.println("1. On");
        System.out.println("2. Off");
        int choice1 = scanner.nextInt();
        status = getStatus(choice1);
        System.out.println("Nhập vào số giờ đã làm: ");
        double timeWork = checkTimeWork(scanner.nextDouble());
        System.out.println("Nhập mã bảo mật của nhân viên: ");
        String check124 = scanner.nextLine();
        String code = checkCode(check124);
        StaffPartTime staffPartTime = new StaffPartTime(id, name, age, address, gender, phoneNumber, email, status, code, timeWork);
        staffPartTimes.add(staffPartTime);
        readAndWriteFile.writerFileData(staffPartTimes,PATH_NAME_OF_Staff2);
    }

    public double checkTimeWork(double timeWork) {
        while (timeWork < 0) {
            System.out.println("Vui lòng nhập lại: ");
            timeWork = scanner.nextDouble();
        }
        return timeWork;
    }

    public boolean abc(String code) {
        for (StaffPartTime staffFullTime : staffPartTimes) {
            if (staffFullTime.getCode().equals(code)) {
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
        StaffPartTime staffPartTime = null;
        for (StaffPartTime staffPartTime1 : staffPartTimes) {
            if (staffPartTime1.getId() == id) {
                staffPartTime = staffPartTime1;
            }
        }

        if (staffPartTime != null) {
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
                System.out.println("9. Số giờ làm");
                System.out.println(" 0. Thoát");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập ID mới: ");
                        int id1 = checkId(scanner.nextInt());
                        staffPartTime.setId(id);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.println("Nhập tên mới: ");
                        String name = scanner.nextLine();
                        staffPartTime.setName(name);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 3:
                        System.out.println("Nhập tuổi mới: ");
                        int age = checkAge(scanner.nextInt());
                        staffPartTime.setAge(age);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.println("Nhập địa chỉ mới: ");
                        String address = scanner.nextLine();
                        staffPartTime.setAddress(address);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 5:
                        System.out.println("Chọn lại giới tính: ");
                        String gender = "";
                        System.out.println("1. Nam");
                        System.out.println("2. Nữ");
                        System.out.println("3. Khác");
                        int choice1 = scanner.nextInt();
                        gender = getGender(choice);
                        scanner.nextLine();
                        staffPartTime.setGender(gender);
                        System.out.println("Sửa thành công!");
                    case 6:
                        String phoneNumber;
                        boolean checkPhoneNumber;
                        do {
                            System.out.println("Nhập số điện thoại mới :");
                            phoneNumber = scanner.nextLine();
                            checkPhoneNumber = RegexPhoneNumber.validate(phoneNumber);
                        } while (!checkPhoneNumber);
                        staffPartTime.setPhoneNumber(phoneNumber);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 7:
                        boolean checkEmail;
                        String email;
                        do {
                            System.out.println("Nhập email:");
                            email = scanner.nextLine();
                            checkEmail = RegexEmail.validate(email);
                        } while (!checkEmail);
                        staffPartTime.setEmail(email);
                        System.out.println("thay đổi thành công");
                        break;
                    case 8:
                        String status = "";
                        System.out.println("Chọn trạng thái: (on : làm, off: nghỉ)");
                        System.out.println("1. On");
                        System.out.println("2. Off");
                        int choice123 = scanner.nextInt();
                        status = getStatus(choice123);
                        staffPartTime.setStatus(status);
                        System.out.println("Thay đổi thành công");
                        break;
                    case 9:
                        System.out.println("Nhập lại giờ đã làm: ");
                        double timeWork123 = checkTimeWork(scanner.nextDouble());
                        staffPartTime.setTimeWork(timeWork123);
                        System.out.println("Done!");
                        break;
                    default:
                        System.out.println("Vui lòng chọn đúng!");
                        break;
                }
            } while (choice != 0);
        } else System.out.println("Nhập sai ID rồi!");
        readAndWriteFile.writerFileData(staffPartTimes,PATH_NAME_OF_Staff2);
    }


    public int checkAge(int age) {
        while (age <= 0) {
            System.out.println("Vui lòng nhập lại tuổi");
            age = scanner.nextInt();
        }
        return age;
    }

    public int checkId(int id) {
        for (StaffPartTime staffFullTime : staffPartTimes) {
            while (staffFullTime.getId() == id) {
                System.out.println("Vui lòng nhập lại ID");
                id = scanner.nextInt();
            }
        }
        return id;
    }

    public void deleteById() {
        System.out.println("Nhập id của nhân viên muốn xoá: ");
        int id = scanner.nextInt();
        StaffPartTime staffFullTime = null;
        for (StaffPartTime staffFullTime123 : staffPartTimes) {
            if (staffFullTime123.getId() == id) {
                staffFullTime = staffFullTime123;
                break;
            }
        }

        if (staffFullTime != null) {
            staffPartTimes.remove(staffFullTime);
        } else {
            System.out.println("ko có nhân viên nào trùng ID!");
        }
        readAndWriteFile.writerFileData(staffPartTimes,PATH_NAME_OF_Staff2);
    }

    public void searchById() {
        System.out.println("Nhập id của nhân viên muốn tìm: ");
        int id = scanner.nextInt();
        StaffPartTime staffFullTime = null;
        for (StaffPartTime staffFullTime123 : staffPartTimes) {
            if (staffFullTime123.getId() == id) {
                staffFullTime = staffFullTime123;
                break;
            }
        }

        if (staffFullTime != null) {
            System.out.println(staffFullTime);
        } else System.out.println("Không có ID của nhân viên cần tìm");
    }

    public void searchByName() {
        ArrayList<StaffPartTime> staff123 = new ArrayList<>();
        System.out.println("Nhập tên của nhân viên muốn tìm kiếm :  ");
        String name = scanner.nextLine();
        for (StaffPartTime staffFullTime : staffPartTimes) {
            if (staffFullTime.getName().equals(name)) {
                staff123.add(staffFullTime);
            }
        }

        for (StaffPartTime staffFullTime : staff123) {
            System.out.println(staffFullTime);
        }
    }

    public void displayByStatusON() {
        boolean check = false;
        ArrayList<StaffPartTime> staffPartTimes123 = new ArrayList<>();
        for (StaffPartTime staffFT : staffPartTimes) {
            if (staffFT.getStatus().equals("ON")) {
                System.out.println(staffFT);
            }
        }
        if (check) {
            System.out.println(staffPartTimes123);
        } else System.out.println("ko có ai");
    }

    public void displayByStatusOff() {
        boolean check = false;
        ArrayList<StaffPartTime> staffPartTimes123 = new ArrayList<>();
        for (StaffPartTime staffFT : staffPartTimes) {
            if (staffFT.getStatus().equals("Off")) {
                System.out.println(staffFT);
            }
        }
        if (check) {
            System.out.println(staffPartTimes123);
        } else System.out.println("ko có ai");
    }

    public void checkStatusById() {
        System.out.println("Nhập ID muốn check trạng thái: ");
        int id = scanner.nextInt();
        StaffPartTime staffFullTime = null;
        for (StaffPartTime staffFullTime1 : staffPartTimes) {
            if (staffFullTime1.getId() == id) {
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
        StaffPartTime staffFullTime = null;
        for (StaffPartTime staffFullTime1 : staffPartTimes) {
            if (staffFullTime1.getId() == id) {
                staffFullTime = staffFullTime1;
                break;
            }
        }

        if (staffFullTime != null) {
            System.out.println(staffFullTime + " Lương : " + salary(staffFullTime) + " VND");
        }
    }

    public double salary(StaffPartTime staffPartTime) {
        return staffPartTime.getTimeWork() * 2;
    }


    public void showAllSalary() {
        for (StaffPartTime staffFullTime : staffPartTimes) {
            System.out.println(staffFullTime + " Lương : " + salary(staffFullTime) + " USD");
        }
    }

    public void displayAll() {
        for (StaffPartTime staffPartTime : staffPartTimes) {
            System.out.println(staffPartTime);
        }
    }

    public void editByCode() {
        System.out.println("Nhập mã bảo mật của bạn: ");
        String code = scanner.nextLine();
        StaffPartTime staffPartTime = null;
        for (StaffPartTime staffPartTime1 : staffPartTimes) {
            if (code.equals(staffPartTime1.getCode())) {
                staffPartTime = staffPartTime1;
                break;
            }
        }
        if (staffPartTime != null) {
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
                System.out.println("9. Số giờ làm");
                System.out.println(" 0. Thoát");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Nhập ID mới: ");
                        int id1 = checkId(scanner.nextInt());
                        staffPartTime.setId(id1);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.println("Nhập tên mới: ");
                        String name = scanner.nextLine();
                        staffPartTime.setName(name);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 3:
                        System.out.println("Nhập tuổi mới: ");
                        int age = checkAge(scanner.nextInt());
                        staffPartTime.setAge(age);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.println("Nhập địa chỉ mới: ");
                        String address = scanner.nextLine();
                        staffPartTime.setAddress(address);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 5:
                        System.out.println("Chọn lại giới tính: ");
                        String gender = "";
                        System.out.println("1. Nam");
                        System.out.println("2. Nữ");
                        System.out.println("3. Khác");
                        int choice1 = scanner.nextInt();
                        gender = getGender(choice);
                        scanner.nextLine();
                        staffPartTime.setGender(gender);
                        System.out.println("Sửa thành công!");
                    case 6:
                        String phoneNumber;
                        boolean checkPhoneNumber;
                        do {
                            System.out.println("Nhập số điện thoại mới :");
                            phoneNumber = scanner.nextLine();
                            checkPhoneNumber = RegexPhoneNumber.validate(phoneNumber);
                        } while (!checkPhoneNumber);
                        staffPartTime.setPhoneNumber(phoneNumber);
                        System.out.println("Thay đổi thành công!");
                        break;
                    case 7:
                        boolean checkEmail;
                        String email;
                        do {
                            System.out.println("Nhập email:");
                            email = scanner.nextLine();
                            checkEmail = RegexEmail.validate(email);
                        } while (!checkEmail);
                        staffPartTime.setEmail(email);
                        System.out.println("thay đổi thành công");
                        break;
                    case 8:
                        String status = "";
                        System.out.println("Chọn trạng thái: (on : làm, off: nghỉ)");
                        System.out.println("1. On");
                        System.out.println("2. Off");
                        int choice123 = scanner.nextInt();
                        status = getStatus(choice123);
                        staffPartTime.setStatus(status);
                        System.out.println("Thay đổi thành công");
                        break;
                    case 9:
                        System.out.println("Nhập lại giờ đã làm: ");
                        double timeWork123 = checkTimeWork(scanner.nextDouble());
                        staffPartTime.setTimeWork(timeWork123);
                        System.out.println("Done!");
                        break;
                }
            } while (choice != 0);
        } else System.out.println("Nhập sai mã bảo mật rồi!");
    }
    public void disPlayCode() {
        for (StaffPartTime staffPartTime : staffPartTimes) {
            System.out.println("Staff PartTime "+ "id ="+staffPartTime.getId()+" name : "+staffPartTime.getName()+ " code: "+ staffPartTime.getCode());
        }
    }
}