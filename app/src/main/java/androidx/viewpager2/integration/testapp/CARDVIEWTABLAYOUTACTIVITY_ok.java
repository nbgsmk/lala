package androidx.viewpager2.integration.testapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

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
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View vv = inflater.inflate(R.layout.activity_tablayout, null);
//        setContentView(R.layout.activity_tablayout);
//        tabLayout = vv.findViewById(R.id.tabs);
//        viewPager = vv.findViewById(R.id.view_pager);

        new TabLayoutMediator(tabLayout, viewPager, false, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(CARD_ok.DECK.get(position).toString());
            }
        }).attach();
    }
}
