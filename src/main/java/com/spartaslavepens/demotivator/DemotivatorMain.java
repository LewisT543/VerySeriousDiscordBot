package com.spartaslavepens.demotivator;

import com.spartaslavepens.CommandRunner;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DemotivatorMain implements CommandRunner {

    @Override
    public void start(MessageReceivedEvent event) {
        sendNegativeResponse(event);
    }

    public void sendNegativeResponse(MessageReceivedEvent event) {
        String name = event.getAuthor().getName();
        String negMessage = getNegativeMessage();
        event.getChannel().sendMessage("Negative Message").queue();
    }

    public String getNegativeMessage() {

    }
}
