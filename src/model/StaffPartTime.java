package model;

public class StaffPartTime extends Staff {
    private double timeWork;

    public StaffPartTime(int id, String name, int age, String address, String gender, String phoneNumber, String email, String status, String code, double timeWork) {
        super(id, name, age, address, gender, phoneNumber, email, status, code);
        this.timeWork = timeWork;
    }

    public double getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(double timeWork) {
        this.timeWork = timeWork;
    }

    @Override
    public String toString() {
        return "StaffPartTime{" + super.toString()+
                "timeWork=" + timeWork +
                '}';
    }
}
