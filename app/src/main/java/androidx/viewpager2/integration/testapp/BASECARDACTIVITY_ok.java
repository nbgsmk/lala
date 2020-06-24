package androidx.viewpager2.integration.testapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import androidx.viewpager2.integration.testapp.cards.CARD_ok;
import androidx.viewpager2.widget.ViewPager2;

import static androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL;
import static androidx.viewpager2.widget.ViewPager2.ORIENTATION_VERTICAL;

abstract class BASECARDACTIVITY_ok extends FragmentActivity {

    ViewPager2 viewPager;
    Spinner cardSelector;
    CheckBox smoothScrollCheckBox;
    CheckBox rotateCheckBox;
    CheckBox translateCheckBox;
    CheckBox scaleCheckBox;
    Button gotoPage;

//    private boolean translateX;
//    private boolean translateY;
//    int layoutId = R.layout.activity_no_tablayout;

    public boolean isTranslateX() {
        return viewPager.getOrientation() == ORIENTATION_VERTICAL && translateCheckBox.isChecked();
    }

    public boolean isTranslateY() {
        return viewPager.getOrientation() == ORIENTATION_HORIZONTAL && translateCheckBox.isChecked();
    }

    private final ViewPager2.PageTransformer mAnimator = new ViewPager2.PageTransformer() {
        @Override
        public void transformPage(@NonNull View page, float position) {
            float absPos = Math.abs(position);
            if (rotateCheckBox.isChecked()) { page.setRotation(position * 360); } else { page.setRotation(0f); }
            if (isTranslateX()) { page.setTranslationX(absPos * 500f); } else { page.setTranslationX(0f); }
            if (isTranslateY()) { page.setTranslationY(absPos * 350f); } else { page.setTranslationY(0f); }

            if (scaleCheckBox.isChecked()) {
                float scale;
                if (absPos > 1) {
                    scale = 0f;
                } else {
                    scale = 1 - absPos;
                }
                page.setScaleX(scale);
                page.setScaleY(scale);
            } else {
                page.setScaleX(1f);
                page.setScaleY(1f);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_tablayout);

        viewPager = findViewById(R.id.view_pager);
        cardSelector = findViewById(R.id.card_spinner);
        smoothScrollCheckBox = findViewById(R.id.smooth_scroll_checkbox);
        rotateCheckBox = findViewById(R.id.rotate_checkbox);
        translateCheckBox = findViewById(R.id.translate_checkbox);
        scaleCheckBox = findViewById(R.id.scale_checkbox);
        gotoPage = findViewById(R.id.jump_button);

        new USERINPUTCONTROLLER_ok(viewPager, findViewById(R.id.disable_user_input_checkbox)).setup();
        new ORIENTATIONCONTROLLER_ok(viewPager, findViewById(R.id.orientation_spinner)).setup();
        cardSelector.setAdapter(createCardAdapter());

        viewPager.setPageTransformer(mAnimator);
        gotoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int card = cardSelector.getSelectedItemPosition();
                boolean smoothScroll = smoothScrollCheckBox.isChecked();
                viewPager.setCurrentItem(card, smoothScroll);
            }
        });

        rotateCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.requestTransform();
            }
        });

        translateCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.requestTransform();
            }
        });

        scaleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.requestTransform();
            }
        });
    }


    private SpinnerAdapter createCardAdapter() {
        new CARD_ok.DECKKK().getDECK();

        ArrayAdapter<CARD_ok> adapter = new ArrayAdapter<CARD_ok>(this, android.R.layout.simple_spinner_item, CARD_ok.DECK);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }


}
