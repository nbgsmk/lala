package androidx.viewpager2.integration.testapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager2.integration.testapp.cards.CARDVIEWADAPTER;

public class CARDVIEWACTIVITY_ok extends BASECARDACTIVITY_ok {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager.setAdapter(new CARDVIEWADAPTER());
    }
}
