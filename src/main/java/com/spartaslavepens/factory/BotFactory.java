package com.spartaslavepens.factory;

import com.spartaslavepens.demotivator.Demotivator;
import com.spartaslavepens.pingpong.PingPong;
import com.spartaslavepens.utils.CommandErrorHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class BotFactory {
    public static void runBot(MessageReceivedEvent event) {
        String command = event.getMessage().getContentRaw().split(" ")[0];

        System.out.println("command: " + command);

        switch (command) {
            case "!ping":
                //do something
                new PingPong().start(event);
                break;
            case "!natasha":
                new PingPong().start(event);
                break;
            case "!demotivate":
                new Demotivator().start(event);
                break;
            case "!dan":
                new PingPong().start(event);
                break;
            default:
                new CommandErrorHandler().start(event);
                break;
        }
    }
}
