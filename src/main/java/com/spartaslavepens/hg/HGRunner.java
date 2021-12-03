package com.spartaslavepens.hg;

import com.spartaslavepens.CommandRunner;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HGRunner implements CommandRunner {

    @Override
    public void start(MessageReceivedEvent event) {
        // Create the EmbedBuilder instance
        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("Eat Ass", null);

        event.getChannel().sendMessageEmbeds(embed.build()).queue();

        System.out.println(event.getMessage().getContentRaw());
    }
}
