package androidx.viewpager2.integration.testapp.cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.viewpager2.integration.testapp.R;

public class CARDVIEW_ok {
    public View view;
    TextView textSuite;
    TextView textCorner1;
    TextView textCorner2;


    public CARDVIEW_ok(LayoutInflater layoutInflater, ViewGroup container) {
        view = layoutInflater.inflate(R.layout.item_card_layout, container, false);
        textSuite = view.findViewById(R.id.label_center);
        textCorner1 = view.findViewById(R.id.label_top);
        textCorner2 = view.findViewById(R.id.label_bottom);
    }


    public void bind(CARD_ok card){
        textSuite.setText(card.suit);
        view.setBackgroundResource(getColorRes(card));
        String cornerLabel = card.getCornerlabel();
        textCorner1.setText(cornerLabel);
        textCorner2.setText(cornerLabel);
    }

    @ColorRes
    private int getColorRes(CARD_ok card){
        int shade = getShade(card);
        int color = getColor(card);
        return COLOR_MAP.cmap[color][shade];
    }

    private int getShade(CARD_ok card){
        switch (card.value){
            case "2":
            case "6":
            case "10":
            case "A":
                return 2;

            case "3":
            case "7":
            case "J":
                return 3;

            case "4":
            case "8":
            case "Q":
                return 0;

            case "5":
            case "9":
            case "K":
                return 1;
        }
        throw new  IllegalStateException("Card value can not be " + card.value);
    }

    private int getColor(CARD_ok card){
        switch (card.suit){
            case "♣":
                return 0;
            case "♦":
                return 1;
            case "♥":
                return 2;
            case "♠":
                return 3;
        }
        throw new IllegalStateException("CARD suit can not be " + card.suit);
    }


    private static class COLOR_MAP {
        private static int[][] cmap;

        private COLOR_MAP() {
            int[] A = new int[] {R.color.red_100, R.color.red_300, R.color.red_500, R.color.red_700};
            int[] B = new int[] {R.color.blue_100, R.color.blue_300, R.color.blue_500, R.color.blue_700};
            int[] C = new int[] {R.color.green_100, R.color.green_300, R.color.green_500, R.color.green_700};
            int[] D = new int[] {R.color.yellow_100, R.color.yellow_300, R.color.yellow_500, R.color.yellow_700};
            cmap = new int[][]{A, B, C, D};
        }
    }
}
