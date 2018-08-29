
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ranjith-suranga
 */
public class TestClass2 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File file = new File("resources/application.properties");
        FileReader fileReader = new FileReader(file);
        
        Properties properties = new Properties();
        properties.load(fileReader);
        
        String property = properties.getProperty("user");
        System.out.println(property);
        
    }
    
}
