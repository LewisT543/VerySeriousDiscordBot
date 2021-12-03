package com.spartaslavepens;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface CommandRunner {
    static String start(MessageReceivedEvent event) {
        return null;
    }
}
