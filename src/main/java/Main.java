import net.dv8tion.jda.core.JDA;

/**
 * Created by derekpastor on 8/19/17.
 */
public class Main {
    public static void main(String args[]){
        JDA jda = new JDABuilder(AccountType.BOT).setToken("token").buildBlocking();
    }
}
