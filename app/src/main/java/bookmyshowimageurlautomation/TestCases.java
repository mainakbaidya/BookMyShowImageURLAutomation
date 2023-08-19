package bookmyshowimageurlautomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestCases {
    
    public void endTest(WebDriver driver)
    {
        System.out.println("End Test: TestCases");
        
        driver.quit();

    }

    
    public  void testCase01(WebDriver driver){

        try {

            System.out.println("Start Test case: testCase01");
            driver.get("https://in.bookmyshow.com/explore/home/chennai");
            Thread.sleep(2000);
         
           //Collect imageURL in a list
           List<String> imageURL = new ArrayList<>();
           List<WebElement> elements = new ArrayList<>();
           elements = driver.findElements(By.xpath("//div[contains(@class,'dXHMBz')]"));
      
          for(int i=0;i<5;i++){
            String emValue =  elements.get(i).findElement(By.tagName("img")).getAttribute("src");
            Thread.sleep(1000);
            imageURL.add(emValue);
           }
           System.out.println("imageURL size is " + imageURL.size());
        
          //click on ">" button
          WebElement button1 = driver.findElement(By.xpath("//div[contains(@class,'gFQbeq')]"));
          Actions actions = new Actions(driver);
          actions.click(button1).perform();
          Thread.sleep(3000);

          //Collect imageURL in a list
          List<WebElement> elements1 = new ArrayList<>();
          elements1 = driver.findElements(By.xpath("//div[contains(@class,'inImWF')]"));
       
          for(int i=0;i<5;i++){
            String emValue1 =  elements1.get(i).findElement(By.tagName("img")).getAttribute("src");
            Thread.sleep(1000);
            imageURL.add(emValue1);
           }
          System.out.println("imageURL size is " + imageURL.size());

           //click on "<" button
           WebElement button2 = driver.findElement(By.xpath("//div[contains(@class,'gFQbeq')]"));
           actions.click(button2).perform();
           Thread.sleep(3000);

           //Print imageUrl
          for(int i=0;i<imageURL.size();i++){
           System.out.println("Image url of " + String.valueOf(i+1) + "th movie is " + imageURL.get(i));
           }

         //Scroll to The Best Of Live Events
         JavascriptExecutor js = (JavascriptExecutor)driver;
         WebElement stream = driver.findElement(By.xpath("//h2[contains(text(),'The Best Of Live Events')]"));
         js.executeScript("arguments[0].scrollIntoView();", stream);
         Thread.sleep(4000);

         //Store 2nd movie name from Premiere
         String movieName = driver.findElement(By.xpath("//div[contains(@class,'cXeYvx')]/div[2]//div[contains(@class,'iHsoLV')]")).getText();
         Thread.sleep(2000);

         //Store language of 2nd movie name from Premiere
         String movielanguage = driver.findElement(By.xpath("//div[contains(@class,'cXeYvx')]/div[2]//div[contains(@class,'iHsoLV')]/../../div[2]/div")).getText();
         
         //Print movieName
         System.out.println("2nd movie name from Premieres is " + movieName);

         //Print movieLanguage
         System.out.println("Language of 2nd movie from Premieres is " + movielanguage);

            System.out.println("End Test case: testCase01");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


}
