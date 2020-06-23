package androidx.viewpager2.integration.testapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.integration.testapp.cards.CARD_ok;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CARDVIEWTABLAYOUTACTIVITY_ok extends CARDVIEWACTIVITY_ok {
    TabLayout tabLayout;
    int layoutId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutId = R.layout.activity_tablayout;
        tabLayout = findViewById(R.id.tabs);


        new TabLayoutMediator(tabLayout, viewPager, false, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(CARD_ok.DECK.get(position).toString());
            }
        }).attach();
    }
}
