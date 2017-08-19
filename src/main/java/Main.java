import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;


import javax.security.auth.login.LoginException;

/**
 * Created by derekpastor on 8/19/17.
 */

public class Main {
    public static void main(String args[]) throws LoginException, RateLimitedException, InterruptedException {
        JDA jda = new JDABuilder(AccountType.BOT).setToken("MzQ4NTI3MTAwMzE3NDAxMDk5.DHoPWw.VW5q4zAFUjLbdC1H8sC2GXjtGDA").buildBlocking();
        
        jda.addEventListener(new ListenerAdapter() {
            @Override
            public void onMessageReceived(MessageReceivedEvent event) {
                if (event.getAuthor().isBot()) return;
                Message message = event.getMessage();
                String content = message.getRawContent();
                if (content.equals("!ping")) {
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage("Pong!").queue();
                }
            }

        });
    }
}
