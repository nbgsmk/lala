package androidx.viewpager2.integration.testapp;

import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.viewpager2.widget.ViewPager2;

public class USERINPUTCONTROLLER_ok {
    ViewPager2 viewPager;
    CheckBox disableBox;
    public USERINPUTCONTROLLER_ok(ViewPager2 viewPager, CheckBox disableBox) {
        this.viewPager = viewPager;
        this.disableBox = disableBox;
    }

    public void setup(){
        if (!viewPager.isUserInputEnabled()) {
            disableBox.setChecked(false);
        }
        disableBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                viewPager.setUserInputEnabled(isChecked);
            }
        });
    }
}
