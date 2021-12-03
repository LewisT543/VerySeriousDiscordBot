package com.spartaslavepens;

import com.spartaslavepens.utils.PropertyManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class App {
    public static JDA jda;
    public static void main( String[] args ) {
        try {
            jda = JDABuilder.createDefault(PropertyManager.getToken()).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
