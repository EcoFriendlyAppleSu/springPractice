package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 static으로 갖고 있기 때문에 아래와 같이 사용한다면 하나의 객체만 생성됨
    // 프로젝트 실행 시 instance를 하나 생성해서 넣어둠
    private static final SingletonService instance = new SingletonService();

    // singleton 객체 생성
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){}

    public void logic() {
        System.out.println("Singleton Class Call");
    }
}
