import src.constant.Result;
import src.model.User;
import src.service.CreditChecker;

public class Main {
    public static void main(String[] args) {

        User u1 = new User(30, 10, "Tot");
        User u2 = new User(30, 0, "Tot");
        User u3 = new User(30, 15, "Xau");
        User u4 = new User(17, 10, "Tot");

        test(u1);
        test(u2);
        test(u3);
        test(u4);
    }

    private static void test(User user) {
        Result result = CreditChecker.checkCredit(user);
        System.out.println("Age: " + user.getAge()
                + ", Income: " + user.getIncome()
                + ", History: " + user.getCreditRating()
                + " => " + result);
    }
}