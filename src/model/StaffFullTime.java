package model;

public class StaffFullTime extends Staff {
    private double overTime;
    private double bonusSalary;
    private double offDay;

    public StaffFullTime(int id, String name, int age, String address, String gender, String phoneNumber, String email, String status, double overTime, double bonus, double dayOff) {
    }

    public StaffFullTime(int id, String name, int age, String address, String gender, String phoneNumber, String email, boolean status, double overTime, double bonusSalary, double offDay) {
        super(id, name, age, address, gender, phoneNumber, email, status);
        this.overTime = overTime;
        this.bonusSalary = bonusSalary;
        this.offDay = offDay;
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public double getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(double bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public double getOffDay() {
        return offDay;
    }

    public void setOffDay(double offDay) {
        this.offDay = offDay;
    }

    @Override
    public String toString() {
        return "StaffFullTime{" + super.toString()+
                "overTime=" + overTime +
                ", bonusSalary=" + bonusSalary +
                ", offDay=" + offDay +
                '}';
    }
}
