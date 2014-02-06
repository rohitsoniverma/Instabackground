package es.expilu.instabackground.net;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import es.expilu.instabackground.model.Envelope;
import es.expilu.instabackground.net.event.NearRequestError;
import es.expilu.instabackground.net.event.NearRequestOk;
import es.expilu.instabackground.util.Globals;

public class NearRequest extends GsonRequest<Envelope> {

	public NearRequest(double lat, double lng) {		
		super(Method.GET, String.format(InstagramApi.METHOD_NEAR, InstagramClient.CLIENT_ID, lat, lng),
			Envelope.class, null,
			new Listener<Envelope>() {
				@Override
				public void onResponse(Envelope response) {
					Globals.getInstance().eventBus.post(new NearRequestOk(response));
				}
			},
			new ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
					Globals.getInstance().eventBus.post(new NearRequestError(error));
				}
			});
	}	

}
