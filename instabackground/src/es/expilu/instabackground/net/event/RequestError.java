package es.expilu.instabackground.net.event;

import com.android.volley.VolleyError;

public class RequestError {

	public VolleyError error;

	public RequestError(VolleyError error) {
		this.error = error;
	}
}
