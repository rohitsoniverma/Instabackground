package es.expilu.instabackground.util;

import java.io.IOException;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;

public class Fun {

	public static boolean changeWallpaper(Context context, Bitmap bmp) {
		WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
		try {
			wallpaperManager.setBitmap(bmp);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
