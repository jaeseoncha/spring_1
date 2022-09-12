package hello.core.singleton;

public class SingletonService {

    private static final SingletonService insance = new SingletonService();

    public static SingletonService getInsance(){
        return insance;
    }

    private SingletonService() {
    }

    public static void main(String[] args) {

    }
    
    public  void login(){
        System.out.println("싱클톤");
    }
    
}
