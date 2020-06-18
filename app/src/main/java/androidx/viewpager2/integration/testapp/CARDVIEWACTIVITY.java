package androidx.viewpager2.integration.testapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager2.integration.testapp.cards.CARDVIEWADAPTER;

public class CARDVIEWACTIVITY extends BASECARDACTIVITY {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager.setAdapter(CARDVIEWADAPTER);
    }
}
