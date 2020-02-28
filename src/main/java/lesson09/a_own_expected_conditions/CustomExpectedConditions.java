package lesson09.a_own_expected_conditions;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class CustomExpectedConditions {
    public static ExpectedCondition<WebElement> listNthElementText(By locator, int no, String expTextPart) {
        return new ExpectedCondition<WebElement>() {
            private String nthElementText="";

            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver driver) {
                try {WebElement element = driver.findElements(locator).get(no);
                    nthElementText = element.getText();
                    return nthElementText.contains(expTextPart) ? element : null;

                } catch (IndexOutOfBoundsException e) {
                    return null;
                }

            }

            @Override
            public String toString() {
                return String.format("%dth element \n of list \n to have text: %s \n while actual text was %s \n",
                no, expTextPart, nthElementText);
            }
        };
    }
}
