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

import androidx.viewpager2.integration.testapp.cards.CARD;
import androidx.viewpager2.widget.ViewPager2;

import static androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL;
import static androidx.viewpager2.widget.ViewPager2.ORIENTATION_VERTICAL;

public class BCA extends FragmentActivity {

    ViewPager2 viewPager;
    Spinner cardSelector;
    CheckBox smoothScrollCheckBox;
    CheckBox rotateCheckBox;
    CheckBox translateCheckBox;
    CheckBox scaleCheckBox;
    Button gotoPage;

    private boolean translateX;
    private boolean translateY;
    protected int layoutId = R.layout.activity_no_tablayout;

    public boolean isTranslateX() {
        return ( viewPager.getOrientation() == ORIENTATION_VERTICAL && translateCheckBox.isChecked());
    }

    public boolean isTranslateY() {
        return (viewPager.getOrientation() == ORIENTATION_HORIZONTAL && translateCheckBox.isChecked());
    }

    private final ViewPager2.PageTransformer mAnimator = new ViewPager2.PageTransformer() {
        @Override
        public void transformPage(@NonNull View page, float position) {
            float absPos = Math.abs(position);
            if (rotateCheckBox.isChecked()) { page.setRotation(position * 360); } else { page.setRotation(0f); }
            if (isTranslateX()) { page.setTranslationX(absPos * 500f); } else { page.setTranslationX(0f); }
            if (isTranslateY()) { page.setTranslationY(absPos * 350f); } else { page.setTranslationY(0f); }

            if (scaleCheckBox.isChecked()) {
                float scale = (absPos > 1) ? 0f : (1 - absPos);
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
        setContentView(layoutId);

        viewPager = findViewById(R.id.view_pager);
        cardSelector = findViewById(R.id.card_spinner);
        smoothScrollCheckBox = findViewById(R.id.smooth_scroll_checkbox);
        rotateCheckBox = findViewById(R.id.rotate_checkbox);
        translateCheckBox = findViewById(R.id.translate_checkbox);
        scaleCheckBox = findViewById(R.id.scale_checkbox);
        gotoPage = findViewById(R.id.jump_button);

        UIC uic = new UIC(viewPager, findViewById(R.id.disable_user_input_checkbox));
        OC oc = new OC(viewPager, findViewById(R.id.orientation_spinner));
        cardSelector.setAdapter(createCardAdapter());





    }


    private SpinnerAdapter createCardAdapter() {
        ArrayAdapter<CARD> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, CARD.DECK);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

// TODO CARD.DECK
}
