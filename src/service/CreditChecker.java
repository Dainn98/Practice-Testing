package src.service;

import src.constant.Result;
import src.model.User;

public class CreditChecker {
    public static Result checkCredit(User user){
        int A = user.getAge();
        int I = user.getIncome();
        String H = user.getCreditRating();

        // E1
        if (A < 18 || A > 60) {
            return Result.ERROR; 
        }
        // E2
        else if (I < 5) {
            return Result.REJECTED; 
        }

        if (H.equals("Tot")){
            if (I >= 5){
                return Result.APPROVED;
            }
        }
        else if (H.equals("Xau")){
            if (5 <= I && I < 15){
                return Result.REJECTED;
            }
            else if (I >= 15){
                return Result.GUARANTEED;
            }
        }
        return Result.REJECTED;
    }
}
