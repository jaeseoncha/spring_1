package hello.core.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("url = " + url);
        connect();
        call("초기화연결메시지");
    }

    public void setUrl(String url){
        this.url=url;
    }

    public void connect(){
        System.out.println("connect = " + url);
    }

    public void call(String message){
        System.out.println("url = " + url);
    }
    public void disconnect(){
        System.out.println("close"+url);
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
        connect();
    }
    @PreDestroy
    public void close(){
        System.out.println("close");

        disconnect();

    }}
