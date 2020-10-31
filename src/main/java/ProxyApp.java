import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ProxyApp {
    WebDriver driver;

    private String getIpAddress() {
        URL myIp;
        try {
            myIp = new URL("http://ifconfig.me/ip");
            BufferedReader in = new BufferedReader(new InputStreamReader(myIp.openStream()));
            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "::::";
    }


    public int startWithProxy(String url, String port) {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(url + ":" + port);
        ChromeOptions options = new ChromeOptions();
        options.setCapability("proxy", proxy);
        this.driver = new ChromeDriver(options);
        try {
            driver.get("http://ifconfig.me/ip");
            String rip = getIpAddress();
            String fip = driver.findElements(By.tagName("pre")).get(0).getText();
            if (fip.compareTo(rip) == 0) {
                throw new Exception("ERR_PROXY_CONNECTION_FAILED");
            } else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("alert(\"PROXY_CONNECTION_SUCCESS\");");
            }
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String message = e.getMessage();
            System.out.println(e.getMessage());
            js.executeScript("alert(\"ERR_PROXY_CONNECTION_FAILED\");");
            return -1;
        }
        return 0;
    }


}
