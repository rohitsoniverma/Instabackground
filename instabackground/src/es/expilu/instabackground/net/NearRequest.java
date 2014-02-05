package es.expilu.instabackground.net;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import es.expilu.instabackground.config.InstagramApi;
import es.expilu.instabackground.config.InstagramClient;
import es.expilu.instabackground.model.Envelope;

public class NearRequest extends GsonRequest<Envelope> {

	public NearRequest(double lat, double lng) {		
		super(Method.GET, InstagramApi.METHOD_NEAR + "?"
				+ InstagramApi.PARAM_CLIENT_ID + "=" + InstagramClient.CLIENT_ID
				+ InstagramApi.PARAM_LATITUDE + "=" + lat
				+ InstagramApi.PARAM_LONGITUDE + "=" + lng,
			Envelope.class, null,
			new Listener<Envelope>() {
				@Override
				public void onResponse(Envelope response) {}
			},
			new ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {}
			});
	}	

}
