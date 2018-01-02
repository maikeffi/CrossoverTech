package com.maikeffi.crossover.review.auto.page;


import com.maikeffi.crossover.review.auto.core.Manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageObject {
    protected final WebDriver webDriver;
    protected final String pageUrl;

    public AbstractPageObject(WebDriver webDriver, String pageUrlKey) {
        this.webDriver = webDriver;
        this.pageUrl = Manager.getManager().getProperty(pageUrlKey);;
        PageFactory.initElements(webDriver,this);
    }

    public void visitPage() {
        webDriver.get(pageUrl);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }
}
