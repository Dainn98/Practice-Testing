package src.model;
public class User {
    private int age;
    private String creditRating;
    private int income;

    public User(int age, int income, String creditRating) {
        this.age = age;
        this.creditRating = creditRating;
        this.income = income;
    }

    public int getAge() {
        return age;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public int getIncome() {
        return income;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
