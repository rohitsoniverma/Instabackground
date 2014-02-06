package es.expilu.instabackground.util;

import com.android.volley.RequestQueue;
import com.squareup.otto.Bus;

/**
 * Class used to implement singleton design pattern
 */
public class Globals {

	private static Globals instance;
	
	public RequestQueue requestQueue;
	public Bus eventBus;	
	
	public static void initInstance() {
		if(instance == null) instance = new Globals();
	}
	
	public static synchronized Globals getInstance() {
		initInstance();
		return instance;
	}
}
