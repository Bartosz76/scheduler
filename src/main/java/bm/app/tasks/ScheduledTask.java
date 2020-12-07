package bm.app.tasks;

import bm.app.repositories.Sentences;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ScheduledTask {

    Sentences sentences;

    public ScheduledTask(Sentences sentences){
        this.sentences = sentences;
    }

    @Scheduled(fixedRate = 5000)
    public void saySomethingNice(){
        System.out.println(quotePuller());
    }

    private String quotePuller(){
        return sentences.sentenceList.get(indexGenerator());
    }

    private int indexGenerator(){
        int maxNumber = sentences.sentenceList.size();
        return ThreadLocalRandom.current().nextInt(0, maxNumber + 1);
    }
}
