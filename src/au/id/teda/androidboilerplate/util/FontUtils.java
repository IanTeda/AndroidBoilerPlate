package au.id.teda.androidboilerplate.util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.EnumMap;
import java.util.Map;

public class FontUtils {

	private FontUtils() {
	}

	private enum FontType {
		BOLD("fonts/Roboto-BoldCondensed.ttf"), 
		BOLD_ITALIC("fonts/Roboto-BoldCondensedItalic.ttf"), 
		NORMAL("fonts/Roboto-Condensed.ttf"), 
		ITALIC("fonts/Roboto-CondensedItalic.ttf");

		private final String path;

		FontType(String path) {
			this.path = path;
		}

		public String getPath() {
			return path;
		}
	}

	/* cache for loaded Roboto typefaces */
	private static Map<FontType, Typeface> typefaceCache = new EnumMap<FontType, Typeface>(
			FontType.class);

	/**
	 * Creates Roboto typeface and puts it into cache
	 */
	private static Typeface getRobotoTypeface(Context context, FontType fontType) {
		String fontPath = fontType.getPath();

		if (!typefaceCache.containsKey(fontType)) {
			typefaceCache.put(fontType,
					Typeface.createFromAsset(context.getAssets(), fontPath));
		}

		return typefaceCache.get(fontType);
	}

	/**
	 * Gets roboto typeface according to passed typeface style settings.
	 * <p/>
	 * Will get Roboto-Bold for Typeface.BOLD etc
	 */
	private static Typeface getRobotoTypeface(Context context,
			Typeface originalTypeface) {
		FontType robotoFontType = null;

		if (originalTypeface == null) {
			robotoFontType = FontType.NORMAL;
		} else {
			int style = originalTypeface.getStyle();

			switch (style) {
			case Typeface.BOLD:
				robotoFontType = FontType.BOLD;
				break;

			case Typeface.BOLD_ITALIC:
				robotoFontType = FontType.BOLD_ITALIC;
				break;

			case Typeface.ITALIC:
				robotoFontType = FontType.ITALIC;
				break;

			case Typeface.NORMAL:
				robotoFontType = FontType.NORMAL;
				break;
			}
		}

		return (robotoFontType == null) ? originalTypeface : getRobotoTypeface(
				context, robotoFontType);
	}

	/**
	 * Walks ViewGroups, finds TextViews and applies Typefaces taking styling in
	 * consideration
	 * 
	 * @param context
	 *            - to reach assets
	 * @param view
	 *            - root view to apply typeface to
	 */
	public static void setRobotoFont(Context context, View view) {
		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
				setRobotoFont(context, ((ViewGroup) view).getChildAt(i));
			}
		} else if (view instanceof TextView) {
			Typeface currentTypeface = ((TextView) view).getTypeface();
			((TextView) view).setTypeface(getRobotoTypeface(context,
					currentTypeface));
		}
	}

}

/**
And the last thing in your onCreate main activity:

	if (Build.VERSION.SDK_INT < 11) {
	    ViewGroup godfatherView = (ViewGroup) this.getWindow().getDecorView();
	    FontUtils.setRobotoFont(this, godfatherView);
	}
	
	
	 // And in my lists with custom views the code above didn't work, so I had to make this:
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	    // (...)
	
	    View view = // build your custom view here
	
	    if (Build.VERSION.SDK_INT < 11) {
	        FontUtils.setRobotoFont(activity, view);
	    }
	
	    return view;
	}
**/
