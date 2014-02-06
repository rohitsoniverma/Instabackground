package es.expilu.instabackground.net.event;

import com.android.volley.VolleyError;

public class InstagramImageRequestError extends RequestError {
	public InstagramImageRequestError(VolleyError error) {
		super(error);
	}
}
