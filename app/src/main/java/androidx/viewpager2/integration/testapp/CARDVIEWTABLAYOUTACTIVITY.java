package androidx.viewpager2.integration.testapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewpager2.integration.testapp.cards.CARD;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CARDVIEWTABLAYOUTACTIVITY extends CARDVIEWACTIVITY {
    TabLayout tabLayout;
    int layoutId = R.layout.activity_tablayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabLayout = findViewById(R.id.tabs);
        new TabLayoutMediator(tabLayout, viewPager, ((tab, position) -> tab.setText(CARD.DECK[position]).toString())).attach();
    }
}
