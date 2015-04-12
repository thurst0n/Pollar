package davidlevy.pollar;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by David on 4/11/2015.
 */
public class Poll {
    private String question;
    private Option[] opts;





    public Poll(){}

    public Poll(String qs, Option[] opts){
        this.question = qs;
        this.opts=opts;




    }

    public String getQuestion(){
        return question;
    }



   /* public static JSONObject getUserPolls(JSONObject rootJson) throws JSONException {
        try {
            return rootJson.getJSONObject("polls");
        }
        catch (JSONException e) {
            Log.e("POLL CLASS:", e.getMessage());
            e.printStackTrace();
        }

    }*/
}





