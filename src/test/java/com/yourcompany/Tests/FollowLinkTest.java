package com.yourcompany.Tests;

import com.yourcompany.Pages.GuineaPigPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;

import static org.junit.Assert.assertFalse;

public class FollowLinkTest extends TestBase {

    public FollowLinkTest(String os,
                          String version, String browser, String deviceName, String deviceOrientation) {
            super(os, version, browser, deviceName, deviceOrientation);
    }

    /**
     * Runs a simple test verifying link can be followed.
     * @throws InvalidElementStateException
     */
    @Test
    public void verifyLinkTest() throws InvalidElementStateException, InterruptedException {
        GuineaPigPage page = new GuineaPigPage(driver);

        for (int i = 0; i < 25; i++) {
            driver.findElement(By.id("i_am_a_link"));
            Thread.sleep(10000);

        }

        page.followLink();

        assertFalse(page.isOnPage());
    }
}
