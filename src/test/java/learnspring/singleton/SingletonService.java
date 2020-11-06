package learnspring.singleton;

public class SingletonService {
    // 싱글톤 디자인 패턴
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
