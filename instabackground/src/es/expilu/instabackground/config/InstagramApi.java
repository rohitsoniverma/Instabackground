package es.expilu.instabackground.config;

public class InstagramApi {
	
	public static final String API_BASE_URL = "https://api.instagram.com/v1";
	
	public static final String PARAM_CLIENT_ID = "client_id";
	public static final String PARAM_LATITUDE = "lat";
	public static final String PARAM_LONGITUDE = "lng";
	
	public static final String METHOD_POPULAR = API_BASE_URL + "/media/popular?" + PARAM_CLIENT_ID + "=%1$s";
	public static final String METHOD_NEAR = API_BASE_URL + "/media/search?" + PARAM_CLIENT_ID + "=%1$s&" + PARAM_LATITUDE + "=%2$s&" + PARAM_LONGITUDE + "=%3$s";
	
	
}
