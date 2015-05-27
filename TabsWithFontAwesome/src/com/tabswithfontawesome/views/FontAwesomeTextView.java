package com.tabswithfontawesome.views;

import com.tabswithfontawesome.util.FontTypeface;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/**
 * 
 * @author Sau
 * A textview whose typeface is set to FontAwesome to support text as images.
 * We will use this textview as our default view for displaying the fontawesome images.
 * 
 * **/
public class FontAwesomeTextView extends TextView{

	public FontAwesomeTextView(Context context) {
		super(context);
		setView(context);
	}

	public FontAwesomeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setView(context);
	}
	
	public FontAwesomeTextView(Context context, AttributeSet attrs,int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setView(context);
	}

	private void setView(Context context) {
		setGravity(Gravity.CENTER);
		setTypeface(FontTypeface.get("FontAwesome.otf", context));
	}
	
	public void setImage(String image){
		setText(image); 
	}

}
