import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyAppTest {
    static ProxyApp app;

    @BeforeAll
    static void initAll() {
        app = new ProxyApp();
    }

    @Test()
    void startWithProxySuccess() {
        assertEquals(0, app.startWithProxy("192.41.13.71", "3128"));
    }

    @Test()
    void startWithProxyFailed() {
        assertEquals(-1, app.startWithProxy("", ""));
    }
}
