package com.spartaslavepens;

import com.spartaslavepens.factory.Clairvoyant;
import com.spartaslavepens.utils.PropertyManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class App {

    public static void main( String[] args ) {
        try {
            JDA jdaBuilder = JDABuilder.createDefault(PropertyManager.getToken())
                    .setChunkingFilter(ChunkingFilter.ALL)
                    .setMemberCachePolicy(MemberCachePolicy.ALL)
                    .enableIntents(GatewayIntent.GUILD_MEMBERS)
                    .addEventListeners(new Clairvoyant())
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
