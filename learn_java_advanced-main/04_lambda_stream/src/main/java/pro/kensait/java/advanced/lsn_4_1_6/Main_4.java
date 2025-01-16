package pro.kensait.java.advanced.lsn_4_1_6;

import java.util.function.Predicate;

public class Main_4 {
    public static void main(String[] args) {
        {
            System.out.println("***** snippet_1 *****");
            User alice = new User(1, 25);
            boolean flag = checkUserSpeck(alice, user -> user.isAdult());
            System.out.println(flag);
            System.out.println("=> end");
        }
        {
            System.out.println("***** snippet_2 *****");
            User alice = new User(1, 25);
            boolean flag = checkUserSpeck(alice, User::isAdult);
            System.out.println(flag);
            System.out.println("=> end");
        }
    }

    static boolean checkUserSpeck(User user, Predicate<User> userSpec) {
        return userSpec.test(user);
    }
}