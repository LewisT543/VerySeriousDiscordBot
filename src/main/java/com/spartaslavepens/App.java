package com.spartaslavepens;

import com.spartaslavepens.utils.PropertyManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class App {

    public static void main( String[] args ) {
        try {
            JDA jdaBuilder = JDABuilder.createDefault(PropertyManager.getToken())
                    .addEventListeners(new Clairvoyant())
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
