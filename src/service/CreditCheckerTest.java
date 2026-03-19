package src.service;

import src.constant.Result;
import src.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreditCheckerTest {

    private String name;
    private User user;
    private Result expected;

    public CreditCheckerTest(String name, User user, Result expected) {
        this.name = name;
        this.user = user;
        this.expected = expected;
    }

    // danh dau noi junit lay data tu ham data()
    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{

                // bang quyet dinh
                {"R1_Under18", new User(17, 10, "Tot"), Result.ERROR},
                {"R1_Over60", new User(61, 10, "Tot"), Result.ERROR},

                {"R2", new User(30, 3, "Xau"), Result.REJECTED},
                {"R3", new User(30, 10, "Xau"), Result.REJECTED},
                {"R4", new User(30, 15, "Xau"), Result.GUARANTEED},

                {"R5", new User(30, 3, "Tot"), Result.REJECTED},
                {"R6", new User(30, 10, "Tot"), Result.APPROVED},
                {"R7", new User(30, 15, "Tot"), Result.APPROVED},

                // gia tri bien
                {"TC1", new User(30, 10, "Tot"), Result.APPROVED},
                {"TC2", new User(30, 0, "Tot"), Result.REJECTED},
                {"TC3", new User(30, 1, "Tot"), Result.REJECTED},
                {"TC4", new User(30, 14, "Tot"), Result.APPROVED},
                {"TC5", new User(30, 15, "Tot"), Result.APPROVED},
                {"TC6", new User(18, 10, "Tot"), Result.APPROVED},
                {"TC7", new User(19, 10, "Tot"), Result.APPROVED},
                {"TC8", new User(59, 10, "Tot"), Result.APPROVED},
                {"TC9", new User(60, 10, "Tot"), Result.APPROVED},

                {"TC10", new User(30, 10, "Xau"), Result.REJECTED},
                {"TC11", new User(30, 0, "Xau"), Result.REJECTED},
                {"TC12", new User(30, 1, "Xau"), Result.REJECTED},
                {"TC13", new User(30, 14, "Xau"), Result.REJECTED},
                {"TC14", new User(30, 15, "Xau"), Result.GUARANTEED},
                {"TC15", new User(18, 10, "Xau"), Result.REJECTED},
                {"TC16", new User(19, 10, "Xau"), Result.REJECTED},
                {"TC17", new User(59, 10, "Xau"), Result.REJECTED},
                {"TC18", new User(60, 10, "Xau"), Result.REJECTED},
        });
    }

    @Test
    public void testCredit() {
        Result actual = CreditChecker.checkCredit(user);
        System.out.println(name + "," + expected + "," + actual);
        assertEquals(expected, actual);
    }
}