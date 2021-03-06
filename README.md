# FontAwesomeTab
Tabs with fontawesome support. This library is created to customize the feel for tabs. Now you can add images using fontawesome. Customize the color for the tab image and its indicator according to your need.
No need to use png files and hence reduce your apk size.

#Screenshot
Sample screen 1

![alt text][logo]

[logo]: https://www.dropbox.com/s/uwrk7c1ulx0d1iz/Image1.png

Sample screen 2

![alt text][logo1]

[logo1]: https://www.dropbox.com/s/xwf5phic4lime7j/Image2.png

#How to use:

Import this library as a library project in your workspace and reference your project with this library.

##In XML

```
com.tabswithfontawesome.views.TabLayout
        android:id="@+id/tabLayout"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        tab:tab_background_color="#95a5a6"
        tab:tab_child_count="5"
        tab:tab_image_focussed_color="#e74c3c"
        tab:tab_image_size="20"
        tab:tab_image_unfocussed_color="#bdc3c7"
        tab:tab_indicator_focussed_color="#e74c3c"
        tab:tab_indicator_unfocussed_color="#bdc3c7" >
```


##In Java

```
TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
tabLayout.setTabImagesArray(getResources().getStringArray(R.array.image_array));
tabLayout.setTabClickListener(this);
tabLayout.attachViewPager(pager);
tabLayout.createTabs();
```

##Assets:
Add FontAwesome.otf file for fontawesome library

##In strings.xml: Define your image array as
```
<string-array name="image_array">
        <item>&#xf009;</item>
        <item>&#xf0f3;</item>
        <item>&#xf073;</item>
        <item>&#xf007;</item>
</string-array>
```

##PS:Make sure your view pager page count and images count should be same otherwise default image would be added.

##Sample project coming soon.
