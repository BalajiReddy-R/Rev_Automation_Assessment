import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class sauceDemoAppAutomation {
    private static final String CHROME_DRIVER_PATH = "O:\\Balaji Automation Assessment\\Selenium Assessment\\Selenium_WebDriver_Practical_Assessment\\Driver\\chromedriver.exe";
    private static final String SAUCE_DEMO_URL = "https://www.saucedemo.com/";

    public static void main(String[] args) {
        // Setting chromedriver path
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        //Calling methods to main block, every method will run independently
        userLogin();
        filterFunctionality();
        addToCart();
        checkoutProcess();
    }

    // Scenario 1: User Login

    public static void userLogin() {
        WebDriver driver = new ChromeDriver();

        //Scenario 1: User Login
        driver.get(SAUCE_DEMO_URL);
        //Maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Entering user credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        System.out.println("Username entered Successfully");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("Password entered Successfully");

        // Select login button
        driver.findElement(By.id("login-button")).click();
        System.out.println("Clicked Login button Successfully");

        // validate with URL
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("inventory.html")) {
            System.out.println("Scenario 1 Passed: User successfully logged in.");
        } else {
            System.out.println("Scenario 1 Failed: Login did not lead to the expected page.");
        }
        driver.quit();
    }

    // Scenario 2: Filter Functionality
    public static void filterFunctionality() {
        WebDriver driver = new ChromeDriver();

        // a. Login to the application first
        driver.get(SAUCE_DEMO_URL);
        //Maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Entering user credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        System.out.println("Username entered Successfully");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("Password entered Successfully");

        // Select login button
        driver.findElement(By.id("login-button")).click();
        System.out.println("Clicked Login button Successfully");

        //Select filter option by price (high-to-low)
        Select filterDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        filterDropdown.selectByValue("hilo");
        System.out.println("High to low filter selected successfully");


        //Retrieve product prices and verify they are sorted in descending order.
        List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
        double previousPrice = Double.MAX_VALUE;
        boolean isSorted = true;
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "");
            double currentPrice = Double.parseDouble(priceText);
            if (currentPrice > previousPrice) {
                isSorted = false;
                break;
            }
            previousPrice = currentPrice;
        }
        if (isSorted) {
            System.out.println("Scenario 2 Passed: Filter is working (high-to-low ordering verified).");
        } else {
            System.out.println("Scenario 2 Failed: Products are not sorted as expected.");
        }

        //driver.quit();

    }

    // Scenario 3: Add to Cart
    public static void addToCart() {
        WebDriver driver = new ChromeDriver();
        // Login to the application.
        driver.get(SAUCE_DEMO_URL);
        //Maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Entering user credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        System.out.println("Username entered Successfully");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("Password entered Successfully");

        // Select login button
        driver.findElement(By.id("login-button")).click();
        System.out.println("Clicked Login button Successfully");

        //Click "Add to Cart" for a specific product
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //Navigate to the shopping cart page.
        driver.findElement(By.className("shopping_cart_link")).click();

        //Verify the product is in the cart.
        String productName = driver.findElement(By.className("inventory_item_name")).getText();
        if ("Sauce Labs Backpack".equalsIgnoreCase(productName)) {
            System.out.println("Scenario 3 Passed: Product is added to the cart.");
        } else {
            System.out.println("Scenario 3 Failed: Product not found in the cart.");
        }
        driver.quit();
    }

    // Scenario 4: Checkout Process
    public static void checkoutProcess() {
        WebDriver driver = new ChromeDriver();

        //Login and add a product (Sauce Labs Backpack) into the cart.
        driver.get(SAUCE_DEMO_URL);
        //Maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Entering user credentials
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        System.out.println("Username entered Successfully");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        System.out.println("Password entered Successfully");

        // Select login button
        driver.findElement(By.id("login-button")).click();
        System.out.println("Clicked Login button Successfully");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        //Click the "Checkout" button.
        driver.findElement(By.id("checkout")).click();
        System.out.println("Clicked Checkout button successfully");

        //Enter valid shipping information.
        driver.findElement(By.id("first-name")).sendKeys("Balaji");
        driver.findElement(By.id("last-name")).sendKeys("Reddy");
        System.out.println("Entered Firstname and Lastname Successfully");
        driver.findElement(By.id("postal-code")).sendKeys("D17CH00");
        System.out.println("Entered PinCode Successfully");
        driver.findElement(By.id("continue")).click();
        System.out.println("Clicked the Continue button Successfully");

        //Complete the checkout process.
        driver.findElement(By.id("finish")).click();
        System.out.println("Clicked the Finish button Successfully");

        //Verify the order confirmation message.
        String confirmationMsg = driver.findElement(By.className("complete-header")).getText();
        if ("THANK YOU FOR YOUR ORDER!".equalsIgnoreCase(confirmationMsg)) {
            System.out.println("Scenario 4 Passed: Checkout process completed successfully.");
        } else {
            System.out.println("Scenario 4 Failed: Order confirmation not found.");
        }
        driver.quit();
    }

}
