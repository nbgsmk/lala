package androidx.viewpager2.integration.testapp;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ORIENTATIONCONTROLLER_ok {
    private final static String HORIZONTAL = "horizontal";
    private final static String VERTICAL = "vertical";

    ViewPager2 viewPager;
    Spinner spinner;

    public ORIENTATIONCONTROLLER_ok(ViewPager2 viewPager, Spinner spinner) {
        this.viewPager = viewPager;
        this.spinner = spinner;
    }

    public void setup(){
        int orientation = viewPager.getOrientation();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item, new String[]{HORIZONTAL, VERTICAL});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        int initialPosition = adapter.getPosition(orientationToString(orientation));
        if (initialPosition >= 0) {
            spinner.setSelection(initialPosition);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewPager.setOrientation(stringToOrientation(parent.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private String orientationToString(int orientation){
        if (orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
            return HORIZONTAL;
        }
        if (orientation == ViewPager2.ORIENTATION_VERTICAL) {
            return VERTICAL;
        }
        throw new IllegalArgumentException("Orientation " + orientation + " ne postoji!");
    }

    private int stringToOrientation(String string){
        if (string.equals(HORIZONTAL)) {
            return ViewPager2.ORIENTATION_HORIZONTAL;
        }
        if (string.equals(VERTICAL)) {
            return ViewPager2.ORIENTATION_VERTICAL;
        }
        throw new IllegalArgumentException("Orientation " + string + " ne postoji!");
    }


}
