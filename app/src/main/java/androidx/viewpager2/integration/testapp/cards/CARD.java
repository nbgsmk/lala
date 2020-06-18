package androidx.viewpager2.integration.testapp.cards;

import android.text.BidiFormatter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CARD {
    String suit;
    String value;
    public static List<CARD> DECK;
    public CARD(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    String cornerlabel;
    public String getCornerlabel() {
        return value + "\n" + suit;
    }

    public String getValue() {
        return value;
    }

    // TODO toBundle


    public static Set<String> SUITS(){
        Set<String> SUITS = new HashSet<>();
        SUITS.add("♣");     /* clubs*/
        SUITS.add("♦");     /* diamonds*/
        SUITS.add("♥");     /* hearts*/
        SUITS.add("♠");     /*spades*/
        return SUITS;
    }


    public static Set<String> VALUES(){
        Set<String> VALUES = new HashSet<>();
        VALUES.add("2");
        VALUES.add("3");
        VALUES.add("4");
        VALUES.add("5");
        VALUES.add("6");
        VALUES.add("7");
        VALUES.add("8");
        VALUES.add("9");
        VALUES.add("10");
        VALUES.add("J");
        VALUES.add("Q");
        VALUES.add("K");
        VALUES.add("A");
        return VALUES;
    }



    public static List<CARD> getDECK(){
        DECK = new ArrayList<>();
        for (String broj: VALUES()){
            for (String pinkla : SUITS()){
                CARD c = new CARD(broj, pinkla);
                DECK.add(c);
            }
        }
        return DECK;
    };


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



}
