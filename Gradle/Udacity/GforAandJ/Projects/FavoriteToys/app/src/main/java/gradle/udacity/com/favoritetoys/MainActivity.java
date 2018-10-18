package gradle.udacity.com.favoritetoys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // this xml layout resource inflates which converts everything in the xml file to a view objects in memory
    }
}
