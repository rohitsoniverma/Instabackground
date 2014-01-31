package es.expilu.instabackground.activity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import es.expilu.instabackground.R;
import es.expilu.instabackground.net.PopularRequest;

public class MainActivity extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(new PopularRequest());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
