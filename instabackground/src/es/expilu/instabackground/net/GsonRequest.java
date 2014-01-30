package es.expilu.instabackground.net;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/** Volley adapter for JSON requests that will be parsed into Java objects by Gson. */
public abstract class GsonRequest<T> extends Request<T> {
	
	private final Class<T> mClass;
	private final Map<String, String> mHeaders;
	private final Listener<T> mListener;
	private final Gson mGson;

	/**
	 * Constructor 
	 */
	public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> headers, Listener<T> listener, ErrorListener errorListener) {
		super(method, url, errorListener);

		mClass = clazz;
		mHeaders = headers;
		mListener = listener;
		JsonDeserializer<Date> dateDeserializer = new JsonDeserializer<Date>() {
			@Override
			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				return json == null ? null : new Date(json.getAsLong());
			}
		};
		mGson = new GsonBuilder().registerTypeAdapter(Date.class, dateDeserializer).create();
	}
	
	/* (non-Javadoc)
	 * @see com.android.volley.Request#getHeaders()
	 */
	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return mHeaders != null ? mHeaders : super.getHeaders();
	}

	/* (non-Javadoc)
	 * @see com.android.volley.Request#parseNetworkResponse(com.android.volley.NetworkResponse)
	 */
	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String json =  new String(response.data, HttpHeaderParser.parseCharset(response.headers));
			return Response.success(mGson.fromJson(json, mClass), HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		}
	}

	/* (non-Javadoc)
	 * @see com.android.volley.Request#deliverResponse(java.lang.Object)
	 */
	@Override
	protected void deliverResponse(T response) {
		mListener.onResponse(response);
	}
	

}
