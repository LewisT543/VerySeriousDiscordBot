package com.spartaslavepens.utils;

import com.spartaslavepens.CommandRunner;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandErrorHandler implements CommandRunner {

    @Override
    public void start(MessageReceivedEvent event) {
        event.getChannel()
                .sendMessage("Hmm something went wrong, try again.")
                .queue();
        System.out.println("made the call....");
    }
}
