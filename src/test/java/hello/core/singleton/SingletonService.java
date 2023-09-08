package hello.core.singleton;

//걍 테스트용
//static 영역에 객체 인스턴스를 오직 1개만 생성할수 있개 해줌
//오직 1개만 존재해야하기 때문에, 생성자를 private로 막아서 혹시라도 외부에서 new 로 객체 인스턴스가 생성하는 것을 막아줌

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
