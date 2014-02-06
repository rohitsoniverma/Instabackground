package es.expilu.instabackground.util;

import android.app.Application;

import com.android.volley.toolbox.Volley;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		
		Globals.initInstance();
		
		Globals.getInstance().requestQueue = Volley.newRequestQueue(getApplicationContext());
		Globals.getInstance().eventBus = new Bus(ThreadEnforcer.ANY);
	}
}
