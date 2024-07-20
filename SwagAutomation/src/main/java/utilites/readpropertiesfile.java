package utilites;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class readpropertiesfile {
    public static void main(String[] args) throws IOException {

        FileReader Read=new FileReader("src\\test\\Resources\\configfiles\\config.properties");
        Properties prop=new Properties();
        prop.load(Read);
System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("browser"));
    }



}

