import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyAppTest {
    ProxyApp app;

    @BeforeEach
    void initAll() {
        app = new ProxyApp();
    }

    @DisplayName("The proxy server should be alive")
    @Test()
    void startWithProxySuccess() {
        assertEquals(0, app.startWithProxy("51.75.147.33", "3128"));
    }

    @DisplayName("The proxy shouldn't be alive")
    @Test()
    void startWithProxyFailed() {
        assertEquals(-1, app.startWithProxy("", ""));
    }
}
