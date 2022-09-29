package constants;

import java.util.Arrays;
import java.util.List;

public class SuiteTestCase {

    public static List<String> getSuite() {
        return Arrays.asList(
                "Registration",
                "Login",
                "Search",
                "Shopping Cart",
                "Checkout"
        );
    }
}