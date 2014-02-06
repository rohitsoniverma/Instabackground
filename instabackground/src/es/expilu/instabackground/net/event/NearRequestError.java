package es.expilu.instabackground.net.event;

import com.android.volley.VolleyError;

public class NearRequestError extends RequestError {
	public NearRequestError(VolleyError error) {
		super(error);
	}
}
