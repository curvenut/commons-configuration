package com.pragmaticqa.util;


import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PropertyLoaderTest {

    @Test
    public void testCiProperties(){
        System.setProperty("APP.ENV","ci");
        PropertyLoader propertyLoader = new PropertyLoader();

        assertThat("user name for ci:", propertyLoader.getSauceUrl(), equalTo("http://ondemand.saucelabs.com:80/wd/hub"));
        assertThat("user name for ci:", propertyLoader.getSauceUserName(), equalTo("sauceUsername"));
        assertThat("user name for ci:", propertyLoader.getSauceClientSecret(), equalTo("sauceSecretKey"));

        assertThat("app url for ci:", propertyLoader.getAppUrl(), equalTo("http://ci.app.com/"));
        assertThat("user name for ci:", propertyLoader.getUserName(), equalTo("ci.username"));
        assertThat("password for ci:", propertyLoader.getUserPassword(), equalTo("ci.password"));

    }


    @Test
    public void testStagingProperties(){
        System.setProperty("APP.ENV","staging");
        PropertyLoader propertyLoader = new PropertyLoader();

        assertThat("user name for staging:", propertyLoader.getSauceUrl(), equalTo("http://ondemand.saucelabs.com:80/wd/hub"));
        assertThat("user name for staging:", propertyLoader.getSauceUserName(), equalTo("sauceUsername"));
        assertThat("user name for staging:", propertyLoader.getSauceClientSecret(), equalTo("sauceSecretKey"));

        assertThat("app url for staging:", propertyLoader.getAppUrl(), equalTo("http://staging.app.com/"));
        assertThat("user name for staging:", propertyLoader.getUserName(), equalTo("staging.username"));
        assertThat("password for staging:", propertyLoader.getUserPassword(), equalTo("staging.password"));

    }

    @Test
    public void testOverrides(){

        System.setProperty("app.url","http://prod.app.com/");

        System.setProperty("APP.ENV","staging");
        PropertyLoader propertyLoader = new PropertyLoader();

        assertThat("user name for staging:", propertyLoader.getSauceUrl(), equalTo("http://ondemand.saucelabs.com:80/wd/hub"));
        assertThat("user name for staging:", propertyLoader.getSauceUserName(), equalTo("sauceUsername"));
        assertThat("user name for staging:", propertyLoader.getSauceClientSecret(), equalTo("sauceSecretKey"));

        assertThat("app url for staging:", propertyLoader.getAppUrl(), equalTo("http://prod.app.com/"));
        assertThat("user name for staging:", propertyLoader.getUserName(), equalTo("staging.username"));
        assertThat("password for staging:", propertyLoader.getUserPassword(), equalTo("staging.password"));

    }

}
