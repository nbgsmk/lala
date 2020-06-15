package androidx.viewpager2.integration.testapp;

import android.os.Bundle;

import androidx.annotation.Nullable;

public class CVACT extends BCA {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager.setAdapter(CVADP);
    }
}
