package com.spartaslavepens.demotivator;

import com.spartaslavepens.CommandRunner;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Demotivator implements CommandRunner {
    private static final HttpClient client = HttpClient.newHttpClient();
    private static HttpResponse<String> httpResponse = null;

    @Override
    public void start(MessageReceivedEvent event) {
        sendDemotivatingResponse(event);
    }

    private void sendDemotivatingResponse(MessageReceivedEvent event) {
        List<Member> users = event.getGuild().getMembers();
        String name = event.getGuild().getMember(event.getAuthor()).getEffectiveName();
        String message = event.getMessage().getContentRaw();
        String targetName = name;
        String[] splitMessage = message.split(" ");
        if (splitMessage.length > 1) {
            for (Member member : users) {
                if (member.getEffectiveName().equals(splitMessage[1]))
                    targetName = "<@" + member.getId() + ">";
            }
        }
        List<String> negMessage = new ArrayList<>(getDemotivationalMessage());
        if (negMessage.get(1).equals("\n - unknown")) {
            negMessage.set(1, "\n - " + Objects.requireNonNull(event.getGuild().getMember(event.getAuthor())).getEffectiveName());
        }
        event.getChannel().sendMessage(buildResponseString(targetName, negMessage.get(0), negMessage.get(1))).queue();
    }

    private List<String> getDemotivationalMessage() {
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

    private static List<String> parseResponse(String body) {
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
        return List.of(quote, author);
    }

    private static String buildResponseString(String name, String quote, String author) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n***Dear ").append(name).append("***").append("\n\n```").append(quote).append(author)
                .append("```").append("\nYours Sincerely, \n _ - Very Serious Discord Bot_ xoxo");
        return sb.toString();
    }

    private static HttpClient getClient() {
        return client;
    }
}
