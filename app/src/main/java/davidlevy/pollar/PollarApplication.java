package davidlevy.pollar;

/**
 * Created by David on 4/11/2015.
 */
import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Initialize Firebase with the application context. This must happen before the client is used.
 *
 * @author mimming
 * @since 12/17/14
 */
public class PollarApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}