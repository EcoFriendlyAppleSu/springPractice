package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("Constructor url = " + url);
        connect();
        call("초기화 연결 메세지");
        disConnect();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Service Call when the service inits
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message : " + message);
    }

    // Service finish
    public void disConnect() {
        System.out.println("close : " + url);
    }


    /*
    * InitializingBean
    * */
    // @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }

    /*
    * DisposableBean
    * */
    // @Override
    public void destroy() throws Exception {
        disConnect();
        System.out.println("Bean Destory");
    }

    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disConnect();
    }
}
