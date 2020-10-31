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

    @DisplayName("Should be to connect proxy success")
    @Test()
    void startWithProxySuccess() {
        assertEquals(0, app.startWithProxy("51.75.147.33", "3128"));
    }

    @DisplayName("Shouldn't be to connect proxy success")
    @Test()
    void startWithProxyFailed() {
        assertEquals(-1, app.startWithProxy("", ""));
    }
}
