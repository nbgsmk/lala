package androidx.viewpager2.integration.testapp.cards;

import android.icu.text.UFormat;
import android.text.BidiFormatter;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CARD {
    String suit;
    String value;
    public CARD(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    String cornerlabel;
    public String getCornerlabel() {
        return value + "\n" + suit;
    }

    // TODO toBundle


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

    public class PATKA{
        Set<String> SUITS;
        Set<String> VALUES;
        List<CARD> DECK;
        public PATKA() {
            this.SUITS = getSUITS();
            this.VALUES = getVALUES();
        }

        public Set<String> getSUITS(){
            Set<String> SUITS = new HashSet<>();
            SUITS.add("♣");     /* clubs*/
            SUITS.add("♦");     /* diamonds*/
            SUITS.add("♥");     /* hearts*/
            SUITS.add("♠");     /*spades*/
            return SUITS;
        }

        public Set<String> getVALUES(){
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

        public List<CARD> GetDECK(){
            for (String broj: VALUES){
                for (String pinkla : SUITS){
                    CARD c = new CARD(broj, pinkla);
                    DECK.add(c);
                }
            }
            return DECK;
        };


    }


}
