/**
 * Created by anders on 5/26/15.
 */
import grails.util.BuildSettings
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import java.awt.*

System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
System.setProperty(BuildSettings.FUNCTIONAL_BASE_URL_PROPERTY, 'http://localhost:8088/webshop')

def chromeDriver = new File('target/drivers/chrome/chromedriver')
downloadDriver(chromeDriver, driverLocationDependingOnOperatingSystem())
System.setProperty('webdriver.chrome.driver', chromeDriver.absolutePath)

driver = {
    def driverInstance = new ChromeDriver()
    def screenSize = Toolkit.defaultToolkit.screenSize
    def browserWindow = driverInstance.manage().window()
    browserWindow.size = new Dimension(screenSize.width.toInteger(), screenSize.height.toInteger())
    browserWindow.position = new Point(0, 0)
    driverInstance
}

private void downloadDriver(File file, String path) {
    if (!file.exists()) {
        println "Downloading chrome driver: ${path}"
        def ant = new AntBuilder()
        ant.get(src: path, dest: 'driver.zip')
        ant.unzip(src: 'driver.zip', dest: file.parent)
        ant.delete(file: 'driver.zip')
        ant.chmod(file: file, perm: '700')
    }
}

private String driverLocationDependingOnOperatingSystem() {
    String os = System.getProperty("os.name").toLowerCase();
    if( os.contains('mac')) {
        return "http://chromedriver.storage.googleapis.com/2.9/chromedriver_mac32.zip"
    }
    if( os.contains('win')) {
        return "http://chromedriver.storage.googleapis.com/2.9/chromedriver_win32.zip"
    }
    return "http://chromedriver.storage.googleapis.com/2.9/chromedriver_linux64.zip"

}