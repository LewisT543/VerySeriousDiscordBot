package com.spartaslavepens.demotivator;

import com.spartaslavepens.CommandRunner;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Demotivator implements CommandRunner {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static HttpResponse<String> httpResponse = null;

    @Override
    public void start(MessageReceivedEvent event) {
        sendDemotivatingResponse(event);
    }

    private void sendDemotivatingResponse(MessageReceivedEvent event) {
        String name = event.getAuthor().getName();
        String negMessage = getDemotivationalMessage();
        event.getChannel().sendMessage(buildResponseString(name, negMessage)).queue();
    }

    private String getDemotivationalMessage() {
        HttpRequest request = HttpRequest.newBuilder(
                    URI.create("https://demotivational-quotes-api.herokuapp.com/api/quotes/random"))
                .header("accept", "application/json")
                .build();
        try {
            httpResponse = getClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return parseResponse(httpResponse.body());
    }

    private static String parseResponse(String body) {
        String quote = "When you try your best but you dont succeed, just stop and cry.";
        String author = " - Straight off the dome.";
        try {
            Object obj = new JSONParser().parse(body);
            JSONObject jo = (JSONObject) obj;
            quote = (String) jo.get("quote");
            String authorString = (String)jo.get("author");
            author = "\n - " + authorString;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return quote + author;
    }

    private static String buildResponseString(String name, String negMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n***Dear ").append(name).append("***").append("\n\n```").append(negMessage)
                .append("```").append("\nYours Sincerely, \n _ - Very Serious Discord Bot_");
        return sb.toString();
    }

    private static HttpClient getClient() {
        return client;
    }
}
