package com.pragmaticqa.util;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

public class PropertyLoader {

    CompositeConfiguration config;

    public PropertyLoader(){
        try{
            config = new CompositeConfiguration();
            config.addConfiguration(new SystemConfiguration());
            config.addConfiguration(new PropertiesConfiguration(PropertyLoader.class.getResource("/properties/functional-tests-"+ config.getString("APP.ENV") +".properties")));
            config.addConfiguration(new PropertiesConfiguration(PropertyLoader.class.getResource("/properties/functional-tests-common.properties")));
        }catch (ConfigurationException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    public String getApplicationEnvironment(){
        return config.getString("APP.ENV");
    }

    public String getAppUrl(){
        return config.getString("app.url");
    }

    public String getUserName(){
        return config.getString("username");
    }

    public String getUserPassword(){
        return config.getString("password");
    }

    public String getSauceUrl(){
        return config.getString("sauce.url");
    }

    public String getSauceUserName(){
        return config.getString("sauce.username");
    }

    public String getSauceClientSecret(){
        return config.getString("sauce.client.secret");
    }

}
