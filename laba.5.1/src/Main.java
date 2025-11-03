import di.Injector;
import somepackage.SomeBean;
//В файле application.properties если убрать строчку somepackage.SomeInterface=somepackage.OtherImpl
//и раскоментить строчку ниже все заработает(вместо BC ,будет AC) и на оборот
public class Main {
    public static void main(String[] args) {
        SomeBean sb = new Injector().inject(new SomeBean());
        sb.foo();
    }
}