package constants;

import java.util.Arrays;
import java.util.List;

public class StatusTestCase {
    public static List<String> getStatus() {
        return Arrays.asList(
                "Actual",
                "Draft",
                "Deprecated"
        );
    }
}