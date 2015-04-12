package davidlevy.pollar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class CreateActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //TODO
    public void submitPoll(View view)
     {
         EditText qSub   = (EditText)findViewById(R.id.Qtext);
         EditText opt1 = (EditText)findViewById(R.id.option1);
         EditText opt2 = (EditText)findViewById(R.id.option2);
         EditText opt3 = (EditText)findViewById(R.id.option3);
         EditText opt4 = (EditText)findViewById(R.id.option4);
         EditText opt5 = (EditText)findViewById(R.id.option5);



         Option[] options = new Option[5];
         Option option1 =
         options[0]= new Option(opt1.getText().toString(), 0);
         options[1]=new Option(opt2.getText().toString(), 0);
         options[2]=new Option(opt3.getText().toString(), 0);
         options[3]=new Option(opt4.getText().toString(), 0);
         options[4]=new Option(opt5.getText().toString(), 0);

        Poll pollSub = new Poll(qSub.getText().toString(), options);
        Firebase userRef = new Firebase("https://pollarapp.firebaseio.com/polls/");
         Map<String, Poll> polls = new HashMap<String, Poll>();
         polls.put(qSub.getText().toString() + "Poll", pollSub);
         userRef.setValue(polls);
/*
        String queryText = "{question: \"" + qSub.getText().toString() +
        "\", option1: {  opttext:\"" + options[0] +
        "\", optvotes: 0  }, option2: {  opttext:\"" + options[1] +
        "\", optvotes: 0  }, option3: {  opttext:\" " + options[2] +
        "\", optvotes: 0  }, option4: {  opttext:\" " + options[3] +
        "\", optvotes: 0  }, option5: {  opttext:\"" + options[4] +
        "\", optvotes: 0  }  }";


         try{
             JSONObject queryObj = new JSONObject(queryText);
             Log.v("Json Object: ", queryObj.toString());

         }

         catch(Exception e){
            Log.e("Create Submit: ", e.getMessage(), e);
             e.printStackTrace();
         }
        */

         finish();

         /*
         Intent intent = new Intent(this, MainActivity.class);
         //EditText editText = (EditText) findViewById(R.id.edit_message);
         //String message = editText.getText().toString();
         intent.putExtra("EXTRA", "Extra Message2");
         startActivity(intent);
        */







         }
}
