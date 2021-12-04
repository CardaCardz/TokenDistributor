import configuration.ConfigurationReader;
import configuration.ConfigurationReaderIT;

public class TokenDistributor {
    public static void main(String[] args) {
        ConfigurationReaderIT readerIT = new ConfigurationReader();
        System.out.println(readerIT.readSingleProperty("dbs"));
    }
}
