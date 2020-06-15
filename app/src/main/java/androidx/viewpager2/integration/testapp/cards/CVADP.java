package androidx.viewpager2.integration.testapp.cards;

import androidx.recyclerview.widget.RecyclerView;

public class CVADP extends RecyclerView.Adapter<CVHOLDER>() {



    public class CVHOLDER extends RecyclerView.ViewHolder(cardView.view){
        void bind(CARD card{
            cardView.bind(card);
        }
    }
}
