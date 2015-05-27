package com.tabswithfontawesome.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.tabswithfontawesome.R;
import com.tabswithfontawesome.listener.TabClick;

/**
 * 
 * @author Sau
 * TabItemLayout is the building block for each tab. 
 * 
 * **/
public class TabItemLayout extends LinearLayout implements OnClickListener{

	private FontAwesomeTextView tabImage;
	private View indicator;
	
	private int tab_image_focussed_color,tab_image_unfocussed_color;
	private int indicator_focussed_color,indicator_unfocussed_color;
	private TabClick listener; 
	
	public TabItemLayout(Context context) {
		super(context);
		createView(context);
	}

	public TabItemLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		createView(context);
	}

	private void createView(Context context) {
		inflate(context, R.layout.layout_tab_item, this);
		setOrientation(LinearLayout.VERTICAL);
		setOnClickListener(this);
		tabImage  = (FontAwesomeTextView)this.findViewById(R.id.fontAwesomeImage);
		indicator = (View)this.findViewById(R.id.indicatorBar);
	}
	
	/**
	 * 
	 * @param imagetext: set image for tab image
	 * 
	 * **/
	public void setImageText(String imagetext){
		tabImage.setImage(imagetext); 
	}
	
	/**
	 * 
	 * @param size: set image size for tab image in dp
	 * 
	 * **/
	public void setImageSize(int size){
		tabImage.setTextSize(size);
	}

	/**
	 * 
	 * @param color: set color for selected state of this tab image
	 * 
	 * **/
	public void setImageFocussedColor(int color){
		this.tab_image_focussed_color = color;
	}
	
	/**
	 * 
	 * @param color: set color for unselected state of this tab image
	 * 
	 * **/
	public void setImageUnfocussedColor(int color){
		this.tab_image_unfocussed_color = color;
	}
	
	/**
	 * 
	 * @param color: set color for selected state of this tab indicator
	 * 
	 * **/
	public void setIndicatorFocussedColor(int color){
		this.indicator_focussed_color = color;
	}

	/**
	 * 
	 * @param color: set color for unselected state of this tab indicator
	 * 
	 * **/
	public void setIndicatorUnfocussedColor(int color){
		this.indicator_unfocussed_color = color;
	}
	
	/**
	 * 
	 * @param id The tab unique identifier
	 * 
	 * **/
	public void setLayoutId(int id){
		setId(id);
	}
	
	public int getLayoutId(){
		return getId();
	}
	
	/**
	 * 
	 * @param state: set state for this tab
	 *               true  = selected
	 *               false = unselected
	 * 
	 * **/
    public void setTabState(boolean state){
		tabImage.setTextColor(state ? tab_image_focussed_color:tab_image_unfocussed_color);
		indicator.setBackgroundColor(state ? indicator_focussed_color:indicator_unfocussed_color);
	}
    
    /**
	 * 
	 * @param listener:interface for listening tab item click
	 * 
	 * **/
    public void setListener(TabClick listener){
    	this.listener = listener;
    }

    /**
     * 
     * @param To listen clicks on tabs
     * 
     * **/
    @Override
	public void onClick(View v) {
    	if (listener != null) {
    		listener.onTabClick(getLayoutId());
		}
	}

}
