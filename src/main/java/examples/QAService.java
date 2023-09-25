package examples;

import java.util.ArrayList;
import java.util.List;

public class QAService {

    private final List<QA> qaList = new ArrayList<>();

    public List<QA> getAll() {
        return qaList;
    }

    public void add(QA qa) {
        qaList.add(qa);
    }

    public void remove(QA qa) { qaList.remove(qa);}
}
