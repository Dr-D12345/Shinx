import com.github.jreddit.entity.User;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;

/**
 * Created by derekpastor on 8/19/17.
 */

public class Commands {
public static void main (String args[]){
    RedditSetup();
}
    public static void RedditSetup(){

        String userAgent = "Stinx";
        String clientID = "XBS4kKB2YJX6vi_IzF_M0yNSwxI";
        String redirectURI = "https://github.com/Dr-D12345/Shinx";
        RestClient restClient = new HttpRestClient();
        restClient.setUserAgent("bot/1.0 by name");
        User user = new User(restClient, "xXD00MXx", "March122001");
        try {
            user.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
