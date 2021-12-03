package com.spartaslavepens.demotivator;

import com.spartaslavepens.CommandRunner;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DemotivatorMain implements CommandRunner {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static HttpResponse<String> httpResponse = null;

    @Override
    public void start(MessageReceivedEvent event) {
        sendDemotivatingResponse(event);
    }

    public void sendDemotivatingResponse(MessageReceivedEvent event) {
        String name = event.getAuthor().getName();
        String negMessage = getDemotivationalMessage();
        event.getChannel().sendMessage(negMessage).queue();
    }

    public String getDemotivationalMessage() {
        HttpRequest request = HttpRequest.newBuilder(
                    URI.create("https://demotivational-quotes-api.herokuapp.com/api/quotes/random"))
                .header("accept", "application/json")
                .build();
        try {
            httpResponse = getClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return httpResponse.body();
    }

    public static HttpClient getClient() {
        return client;
    }
}
