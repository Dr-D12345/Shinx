
import com.github.jreddit.entity.User;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by derekpastor on 8/19/17.
 */

public class Commands {
public static void main (String args[]){
    System.out.println(Weather(11379));
}
    public static void RedditSetup(){

    }

    public static String Weather(int zip){
      JSONObject result;
        try{

            StringBuilder sb = new StringBuilder();
           ArrayList<String> listdata = new ArrayList<String>();

            URL url = new URL("http://samples.openweathermap.org/data/2.5/weather?zip="+zip+",us,uk&APPID=285d478761bcc2586cebf122a6c8b1e1");
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader
                        (url.openStream(), "UTF-8"));
                for (String line; (line = reader.readLine()) != null;) {
                    listdata.add(line);
                    sb.append(line);
                }
                String[] splitArray = sb.toString().split("\"");

                for (int i=0;i<splitArray.length; i++){

                    splitArray[i]=splitArray[i].replace("}","");
                    splitArray[i]=splitArray[i].replace("{","");
                    splitArray[i]=splitArray[i].replace(":","");
                    splitArray[i]=splitArray[i].replace(",","");

                    System.out.println(i+ " "+splitArray[i]);
                }
                DateFormat dateFormat = new SimpleDateFormat("hh:mm a");


                return "Weather\n"+"Lat:"+splitArray[6]+" " +
                        "Long:"+splitArray[4]+"\n"+splitArray[17]+"\n"+
                        "Temperature: "+splitArray[46];


            }catch(IOException io){

                }
            }catch (MalformedURLException me){

        }

        return "Couldnt find it :(";
    }
}
