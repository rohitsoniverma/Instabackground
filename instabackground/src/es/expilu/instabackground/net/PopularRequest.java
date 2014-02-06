package es.expilu.instabackground.net;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

import es.expilu.instabackground.model.Envelope;
import es.expilu.instabackground.net.event.PopularRequestError;
import es.expilu.instabackground.net.event.PopularRequestOk;
import es.expilu.instabackground.util.Globals;

public class PopularRequest extends GsonRequest<Envelope> {

	public PopularRequest() {		
		super(Method.GET, String.format(InstagramApi.METHOD_POPULAR, InstagramClient.CLIENT_ID),
			Envelope.class, null,
			new Listener<Envelope>() {
				@Override
				public void onResponse(Envelope response) {
					Globals.getInstance().eventBus.post(new PopularRequestOk(response));
				}
			},
			new ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
					Globals.getInstance().eventBus.post(new PopularRequestError(error));
				}
			});
	}	

}
