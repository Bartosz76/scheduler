package bm.app.repositories;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Sentences {

    public static ArrayList<String> sentenceList = new ArrayList<>();

    static {
        sentenceList.add(0, "You look very nice today.");
        sentenceList.add(1, "I hope all your dreams comes true.");
        sentenceList.add(2, "May your hardships be few.");
        sentenceList.add(3, "You will make it. Don't give up.");
        sentenceList.add(4, "You deserve to be happy.");
        sentenceList.add(5, "You're making this world a better place.");
    }
}
