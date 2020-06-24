package androidx.viewpager2.integration.testapp.cards;

import android.os.Bundle;
import android.text.BidiFormatter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CARD_ok {
    String suit;
    String value;

    private static final String ARGS_BUNDLE = CARD_ok.class.getCanonicalName() + ":Bundle";

    public static Set<String> SUITS;
    public static Set<String> VALUES;
    public static List<CARD_ok> DECK;

    public CARD_ok(String suit, String value) {
        this.suit = suit;
        this.value = value;

//        SUITS = new HashSet<>(Arrays.asList("♣"  clubs, "♦"  diamonds, "♥"  hearts, "♠" spades));
//        VALUES = new HashSet<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
//        DECK = new ArrayList<>();
//        for (String broj: VALUES){
//            for (String pinkla : SUITS){
//                CARD_ok c = new CARD_ok(broj, pinkla);
//                DECK.add(c);
//            }
//        }
    }




    public String getCornerlabel() {
        return value + "\n" + suit;
    }


    Bundle toBundle(){
        Bundle args = new Bundle(1);
        args.putStringArray(ARGS_BUNDLE, new String[]{suit, value});
        return args;
    }


    @NonNull
    @Override
    public String toString() {
        BidiFormatter bidi = BidiFormatter.getInstance();
        if (!bidi.isRtlContext()) {
            return bidi.unicodeWrap(value + suit);
        } else {
            return bidi.unicodeWrap(suit + value);
        }
    }



    public static CARD_ok find(List<CARD_ok> lista, String value, String suit){
        for (CARD_ok card : lista) {
            if (card.value.equals(value) && card.suit.equals(suit)) {
                return card;
            }
        }
        return null;
    }


    public static CARD_ok fromBundle(Bundle bundle){
        String[] spec = bundle.getStringArray(ARGS_BUNDLE);
        return new CARD_ok(spec[0], spec[1]);
    }


    public static class DECKKK{
        public DECKKK() {
            DECK = getDECK();
        }

        public List<CARD_ok> getDECK(){
            List<CARD_ok> dq;
            SUITS = new HashSet<>(Arrays.asList("♣" /* clubs*/, "♦" /* diamonds*/, "♥" /* hearts*/, "♠" /*spades*/));
            VALUES = new HashSet<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
            dq = new ArrayList<>();
            for (String broj: VALUES){
                for (String pinkla : SUITS){
                    CARD_ok c = new CARD_ok(broj, pinkla);
                    dq.add(c);
                }
            }
            return dq;
        }
    }
}
