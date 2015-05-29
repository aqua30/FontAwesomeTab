# FontAwesomeTab
Tabs with fontawesome support. This library is created to customize the feel for tabs. Now you can add images using fontawesome. Customize the color for the tab image and its indicator according to your need.

#How to use:

Import this library as a library project in your workspace and reference your project with this library.

<b>In XML:</b> Simply define

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


<b>In Code:</b>

TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
tabLayout.setTabImagesArray(getResources().getStringArray(R.array.image_array));
tabLayout.setTabClickListener(this);
tabLayout.attachViewPager(pager);
tabLayout.createTabs();

<b>In Assets:</b>
Add FontAwesome.otf file for fontawesome library

<b>In strings.xml:</b> Define your image array as
<string-array name="image_array">
        <item>&#xf009;</item>
        <item>&#xf0f3;</item>
        <item>&#xf073;</item>
        <item>&#xf007;</item>
</string-array>

<b>PS:</b> Make sure your view pager page count and images count should be same otherwise default image would be added.

<b>Sample project coming soon.</b>
