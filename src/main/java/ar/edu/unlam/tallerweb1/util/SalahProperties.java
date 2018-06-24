package ar.edu.unlam.tallerweb1.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class SalahProperties extends Properties {
    private Properties properties;
    private InputStream inputStream;

    public SalahProperties(){
        this.properties = new Properties();
        inputStream = this.getClass().getResourceAsStream("/salah.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getProperty(String property){
        return this.properties.getProperty(property);
    }

}
