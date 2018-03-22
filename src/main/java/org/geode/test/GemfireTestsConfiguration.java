package org.geode.test;
import org.springframework.stereotype.Component;

@Component
public class GemfireTestsConfiguration   {

    public String getHostname()  {
        return hostname;
    }

    public String getPort()  {
        return port;
    }

    public void settHostname(String hostname)  {
        this.hostname = hostname;
    }

    public void setPort(String port)  {
        this.port = port;
    }

    private String hostname = "127.0.0.1";
    private String port = "10334";

}