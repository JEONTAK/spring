package hello.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    /*롬복을 사용 하는 이유!
    롬복은 Getter, Setter method를 자동으로 annotation processing으로 만들어 줌
    기존에는 getter, setter 코드를 직접 짜줬어야되는데,
    롬복을 사용하면 @Getter, @Setter를 사용하여 자동으로 쓸수 있게 해줌
    그 외에도 다양한 기능 있으니 찾아서 잘 써보길!
    */
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("name");

        /*String name = helloLombok.getName();
        System.out.println("name = " + name);*/

        System.out.println("helloLombok = " + helloLombok);

    }
}
