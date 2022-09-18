package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value="request")
public class MyLogger {

    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String log(String message){
        System.out.println(uuid +":"+ requestUrl+":"+message);
        return uuid +":"+ requestUrl+":"+message;
    }
    
    @PostConstruct
    public void init(){
        uuid=UUID.randomUUID().toString();
        System.out.println("init : uuid  = " + uuid +this);
    }
    
    
    @PreDestroy
    public void close(){
        System.out.println("close : uuid  = " + uuid +this);
    }
}
