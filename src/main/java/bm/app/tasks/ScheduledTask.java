package bm.app.tasks;

import bm.app.repositories.Sentences;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ScheduledTask {

    Sentences sentences;

    public ScheduledTask(Sentences sentences){
        this.sentences = sentences;
    }

    @Scheduled(fixedRate = 10000)
    public void generateARandomCatFact() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://cat-fact.herokuapp.com/facts/random"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject jsonObject = new JSONObject(response.body());
        String text = jsonObject.getString("text");
        System.out.println(text);
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
        return ThreadLocalRandom.current().nextInt(0, maxNumber);
    }
}
