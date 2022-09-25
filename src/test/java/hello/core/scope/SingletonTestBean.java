package hello.core.scope;

import org.springframework.stereotype.Component;

import javax.inject.Provider;

@Component
public class SingletonTestBean {

    // private final PrototypeTestBean prototypeTestBean; // 생성 시점에 이미 주입이 되어 있습니다.
    // private final ObjectProvider<PrototypeTestBean> prototypeTestBean;
    private final Provider<PrototypeTestBean> prototypeTestBean;

    public SingletonTestBean(Provider<PrototypeTestBean> prototypeTestBean) {
        this.prototypeTestBean = prototypeTestBean;
    }

    /*public SingletonTestBean(ObjectProvider<PrototypeTestBean> prototypeTestBean) {
        this.prototypeTestBean = prototypeTestBean;
    }*/

    /*
    @Autowired
    public SingletonTestBean(PrototypeTestBean prototypeTestBean) {
        this.prototypeTestBean = prototypeTestBean;
    }
    // 던져진 Prototype Bean은 Singleton Bean과 생명 주기를 같이 한다.
    // 이건 의도한게 아닙니다. 이럴거면 싱글톤으로 사용하는게 낫다.
    */

    public int logic() {
        // PrototypeTestBean prototypeTestBeanObject = prototypeTestBean.getObject();
        PrototypeTestBean prototypeTestBeanObject = prototypeTestBean.get();
        System.out.println("prototypeTestBeanObject = " + prototypeTestBeanObject);
        prototypeTestBeanObject.addCount();
        return prototypeTestBeanObject.getCount();
    }
}
