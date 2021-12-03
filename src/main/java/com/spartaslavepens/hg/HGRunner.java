package com.spartaslavepens.hg;

import com.spartaslavepens.CommandRunner;
import com.spartaslavepens.hg.model.Contestant;
import com.spartaslavepens.hg.model.Match;
import com.spartaslavepens.hg.model.Tournament;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;

public class HGRunner implements CommandRunner {

    @Override
    public void start(MessageReceivedEvent event) {
        String fullMessage = event.getMessage().getContentRaw();
        System.out.println(fullMessage);

        if (fullMessage.equals("!hg")) {
            System.out.println("Using preset contestants");
        } else {
            System.out.println("Using custom contestants");
            String content = fullMessage.split(" ")[1];
            String[] names = content.replaceAll(" ", "").split(",");
            for (String n : names) {
                System.out.println(">" + n);
            }
        }

        // Create the EmbedBuilder instance
        //EmbedBuilder embed = new EmbedBuilder();
        //event.getChannel().sendMessageEmbeds(embed.build()).queue();

    }
}
