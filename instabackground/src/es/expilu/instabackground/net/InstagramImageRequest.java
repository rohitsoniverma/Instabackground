package es.expilu.instabackground.net;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import es.expilu.instabackground.model.Image;
import es.expilu.instabackground.net.event.InstagramImageRequestError;
import es.expilu.instabackground.net.event.InstagramImageRequestOk;
import es.expilu.instabackground.util.Globals;

public class InstagramImageRequest extends ImageRequest {

	public InstagramImageRequest(Image image) {
		super(image.getUrl(),
			new Listener<Bitmap>() {
				@Override
				public void onResponse(Bitmap response) {
					Globals.getInstance().eventBus.post(new InstagramImageRequestOk(response));
				}
			},
			image.getWidth(), image.getHeight(), Config.ARGB_8888,
			new ErrorListener() {
				@Override
				public void onErrorResponse(VolleyError error) {
					Globals.getInstance().eventBus.post(new InstagramImageRequestError(error));
				}
			});
	}
}
