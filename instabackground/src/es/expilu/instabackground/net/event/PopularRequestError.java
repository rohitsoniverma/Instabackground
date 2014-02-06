package es.expilu.instabackground.net.event;

import com.android.volley.VolleyError;

public class PopularRequestError extends RequestError {
	public PopularRequestError(VolleyError error) {
		super(error);
	}
}
