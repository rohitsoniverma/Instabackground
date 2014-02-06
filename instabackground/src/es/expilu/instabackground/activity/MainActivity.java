package es.expilu.instabackground.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.squareup.otto.Subscribe;

import es.expilu.instabackground.R;
import es.expilu.instabackground.net.InstagramImageRequest;
import es.expilu.instabackground.net.PopularRequest;
import es.expilu.instabackground.net.event.InstagramImageRequestError;
import es.expilu.instabackground.net.event.InstagramImageRequestOk;
import es.expilu.instabackground.net.event.PopularRequestError;
import es.expilu.instabackground.net.event.PopularRequestOk;
import es.expilu.instabackground.util.Fun;
import es.expilu.instabackground.util.Globals;

public class MainActivity extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Globals.getInstance().eventBus.register(this);
        setContentView(R.layout.activity_main);
        
//        queue.add(new NearRequest(28.116667, -15.433333));
        Globals.getInstance().requestQueue.add(new PopularRequest());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Subscribe
    public void popularRequestOk(PopularRequestOk e) {
    	Globals.getInstance().requestQueue.add(new InstagramImageRequest(e.envelope.getData()[0].getImages().getStandard_resolution()));
    }
    
    @Subscribe
    public void popularRequestError(PopularRequestError e) {
    	
    }
    
    @Subscribe
    public void instagramImageRequestOk(InstagramImageRequestOk e) {
    	Fun.changeWallpaper(this, e.bmp);
    }
    
    @Subscribe
    public void instagramImageRequestError(InstagramImageRequestError e) {
    	
    }
}
