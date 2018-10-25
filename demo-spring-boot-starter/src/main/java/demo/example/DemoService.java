package demo.example;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("amazon")
public class DemoService {
    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    private String associateId;


    public void run(){
        System.out.println("Hello " + associateId + ",this is DemoService!");
    }
}
