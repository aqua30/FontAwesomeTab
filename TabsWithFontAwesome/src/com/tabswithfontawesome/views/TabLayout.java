package com.tabswithfontawesome.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.tabswithfontawesome.R;
import com.tabswithfontawesome.listener.TabChangeListener;
import com.tabswithfontawesome.listener.TabClick;

public class TabLayout extends LinearLayout implements OnPageChangeListener,TabClick{

// --- total number of tabs to be added
	private int tabCount;
	
// --- size of the image of each tab
	private int tab_image_size;
	
// --- main tab layout background. Defined in xml
	private int tabParentBackground;
	
// --- tab image color when current tab is selected
	private int tab_image_focussed_color;
	
// --- tab image color when current tab is not selected
	private int tab_image_unfocussed_color;
	
// --- tab indicator color when current tab is selected
	private int tab_indicator_focussed_color;
	
// --- tab indicator color when current tab is not selected
	private int tab_indicator_unfocussed_color;
	
// --- image array for tabs. 
	private String[] images;
	
// --- View pager reference
	private ViewPager viewPager;

// --- Tab click listener
	private TabChangeListener listener;
	
	
	public TabLayout(Context context) {
		super(context);
		tabParentBackground = getResources().getColor(R.color.silver);
		tabCount            = 0;
		createView();
	}	

	public TabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setStyleableProperties(context,attrs);
	}



	public TabLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		setStyleableProperties(context,attrs);
	}

	private void setStyleableProperties(Context context,AttributeSet attrs) {
        try {
        	TypedArray attributes = context.obtainStyledAttributes(attrs,R.styleable.TabAttributes,0,0);
    		
    		/**
    		 * 
    		 * @description gettting the parent tab layout setting parameters
    		 * 
    		 * **/
    		tabCount            = attributes.getInt(R.styleable.TabAttributes_tab_child_count, 0);
    		tabParentBackground = attributes.getColor(R.styleable.TabAttributes_tab_background_color, 
    				                                  getResources().getColor(R.color.white));
    		
    		/**
    		 * 
    		 * @description gettting the tab item layout setting parameters
    		 * 
    		 * **/
    		tab_image_size                 = attributes.getInt(R.styleable.TabAttributes_tab_image_size, 18);
    		tab_image_focussed_color       = attributes.getColor(R.styleable.TabAttributes_tab_image_focussed_color, 
    				                                             getResources().getColor(R.color.midnight_blue));
    		tab_image_unfocussed_color     = attributes.getColor(R.styleable.TabAttributes_tab_image_unfocussed_color, 
                                                                 getResources().getColor(R.color.silver));
    		tab_indicator_focussed_color   = attributes.getColor(R.styleable.TabAttributes_tab_indicator_focussed_color,
                                                                 getResources().getColor(R.color.midnight_blue));
    		tab_indicator_unfocussed_color = attributes.getColor(R.styleable.TabAttributes_tab_indicator_unfocussed_color, 
                                                                 getResources().getColor(R.color.silver));
    		attributes.recycle();
		} catch (Exception e) {
			Log.d("Styleable error", e.getMessage());
		}
		createView();
	}



	private void createView() {
		setBackgroundColor(tabParentBackground);
	}
	
	/**
	 * 
	 * @params images: fontawesome images that will be displayed on each tab in the order provided in 
	 * the string array.
	 * 
	 * **/
	public void setTabImagesArray(String[] images){
		this.images = images;
	}

	public void createTabs(){
		
		for (int i = 0; i < tabCount; i++) {
			TabItemLayout tab = new TabItemLayout(getContext());
			tab.setLayoutId(i);
			tab.setImageFocussedColor(tab_image_focussed_color);
			tab.setImageUnfocussedColor(tab_image_unfocussed_color);
			tab.setIndicatorFocussedColor(tab_indicator_focussed_color);
			tab.setIndicatorUnfocussedColor(tab_indicator_unfocussed_color);
			tab.setImageSize(tab_image_size);
			if (images.length >= i+1) {
				tab.setImageText(images[i]);
				Log.d("TabImage", images[i]);
			}else {
				Log.d("TabDefaultImage", getResources().getString(R.string.tab_default_image));
				tab.setImageText(getResources().getString(R.string.tab_default_image));
			}
			tab.setTabState(i == 0 ? true:false);
			tab.setListener(this); 
			addView(tab, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT, 1)); 
		}
	}
	
	/**
	 * 
	 * @description Accepting the Viewpager with which we want to attach out tablayout.
	 * 
	 * **/
	public void attachViewPager(ViewPager viewPager){
		this.viewPager = viewPager;
		this.viewPager.setOnPageChangeListener(this);
	}

	public void setTabClickListener(TabChangeListener listener){
		this.listener = listener;
	}
	
	@Override
	public void onPageScrollStateChanged(int arg0) {}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {}

	@Override
	public void onPageSelected(int page) {
		if (listener != null) {
			listener.onTabChange(page);  
		}
		changeTab(page); 
	}

	@Override
	public void onTabClick(int tabPosition) {
		viewPager.setCurrentItem(tabPosition); 
	}
	
	private void changeTab(int tabPos){
		for (int i = 0; i < tabCount; i++) {
			((TabItemLayout)findViewById(i)).setTabState(i == tabPos ? true:false);
		}
	}
}
