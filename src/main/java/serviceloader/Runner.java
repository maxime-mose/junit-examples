package serviceloader;

import examples.QA;

import java.util.Arrays;
import java.util.ServiceLoader;

public class Runner {

    public static void main(String[] args) {
        QA qa = null;
//        qa = new QA();

        ServiceLoader<QA> loader = ServiceLoader.load(QA.class);
        var qaList = loader.stream().toList();

        qaList.forEach(e -> System.out.println(e.get().introduceYourSelf()));
    }
}
