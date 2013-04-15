import org.openqa.selenium.firefox.FirefoxDriver

baseUrl = "http://localhost:12080/"
driver = { new FirefoxDriver() }
reportsDir = "target/geb-reports"
reportOnTestFailureOnly = false