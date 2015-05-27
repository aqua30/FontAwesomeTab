# FontAwesomeTab
Tabs with fontawesome support. This library is created to customize the feel for tabs. Now you can add images using fontawesome. Customize the color for the tab image and its indicator according to your need.

How to use:

Import this library as a library project in your workspace and reference your project with this library.

In XML: Simply define
<com.tabswithfontawesome.views.TabLayout
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
</com.tabswithfontawesome.views.TabLayout>

In Code:
