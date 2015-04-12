package davidlevy.pollar;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends ActionBarActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    private ArrayAdapter<String> userDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Firebase myFirebaseRef = new Firebase("https://pollarapp.firebaseio.com/polls");
        Log.v(LOG_TAG, "Establish Firebase");

        userDataAdapter =
                new ArrayAdapter<>(
                        this.getBaseContext(), // The current context (this activity)
                        R.layout.list_item_poll, // The name of the layout ID.
                        R.id.list_item_poll_textview, // The ID of the textview to populate.
                        new ArrayList<String>());



        myFirebaseRef.addValueEventListener(new ValueEventListener()  {
            @Override
            public void onDataChange(DataSnapshot snapshot)  {
                Log.v(LOG_TAG, snapshot.getValue().toString());

                    //JSONObject root = new JSONObject(snapshot.getValue().toString());
                    //DataSnapshot myPolls = snapshot.child("question");
                    userDataAdapter.clear();
                    for(DataSnapshot poll: snapshot.getChildren()){
                        //Log.v(LOG_TAG + "val: ",poll.child("question").getValue().toString());
                        if(poll.child("question").getValue()!=null) {
                            userDataAdapter.add(poll.child("question").getValue().toString());

                            //Log.v(LOG_TAG + "str: ", (String)polls.child("question").getValue());
                        }

                    }
                    Log.v(LOG_TAG, userDataAdapter.toString());

            }

        @Override
        public void onCancelled(FirebaseError firebaseError) {
            System.out.println("The read failed: " + firebaseError.getMessage());
        }
    });
        ListView moduleListView = (ListView) findViewById(R.id.listview_poll);
        moduleListView.setAdapter(userDataAdapter);
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void createPoll(View view){
        Intent intent = new Intent(this, CreateActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, "Extra Message2");
        startActivity(intent);
    }
}









