package app.utilities;

import java.util.Properties;

/**
 *
 * @author Jason Zhuang
 */
public class KeyUtil 
{

    private Properties props;


    public String getValue(String input) {
        return props.getProperty(input);
    }

    public String getValue(String prefix,String country){
        return props.getProperty(prefix+country);
    }   

    
    public Properties getProps() {
        return props;
    }
   
    public void setProps(Properties props) {
        this.props = props;
    }
}
