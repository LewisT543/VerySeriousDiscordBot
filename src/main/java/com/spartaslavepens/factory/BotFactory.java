package com.spartaslavepens.factory;

import com.spartaslavepens.demotivator.Demotivator;
import com.spartaslavepens.hg.HGRunner;
import com.spartaslavepens.pingpong.PingPong;
import com.spartaslavepens.utils.CommandErrorHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class BotFactory {
    public static void runBot(MessageReceivedEvent event) {
        String command = event.getMessage().getContentRaw().split(" ")[0];
        if (command.charAt(0) == ('!')) {
            System.out.println("command: " + command);

            switch (command) {
//            case "!ping" -> new PingPong().start(event);
//            case "!hg" -> new HGRunner().start(event);
                case "!demotivate" -> Demotivator.getInstance().start(event);
//            case "!dan" -> new PingPong().start(event);
                default -> new CommandErrorHandler().start(event);
            }
        }


    }
}
