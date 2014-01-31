package es.expilu.instabackground.net;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import es.expilu.instabackground.model.Envelope;

public class PopularRequest extends GsonRequest<Envelope> {

	public PopularRequest() {
		super(Method.GET, "https://api.instagram.com/v1/media/search?lat=28.116667&lng=-15.433333&client_id=e93d1f82448d4073986e8a9ffe254c3d", Envelope.class, null,
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
