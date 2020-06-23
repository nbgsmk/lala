package androidx.viewpager2.integration.testapp.cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CARDVIEWADAPTER extends RecyclerView.Adapter<CARDVIEWADAPTER.CARDVIEWHOLDER> {


    @NonNull
    @Override
    public CARDVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CARDVIEW_ok cvok = new CARDVIEW_ok(LayoutInflater.from(parent.getContext()), parent);
        return new CARDVIEWHOLDER(cvok);
    }

    @Override
    public void onBindViewHolder(@NonNull CARDVIEWHOLDER holder, int position) {
        holder.bind(CARD_ok.DECK.get(position));
    }


    @Override
    public int getItemCount() {
        return CARD_ok.DECK.size();
    }


    class CARDVIEWHOLDER extends RecyclerView.ViewHolder {
        CARDVIEW_ok cardView;
        public CARDVIEWHOLDER(@NonNull View itemView) {
            super(itemView);
        }

        private CARDVIEWHOLDER(CARDVIEW_ok cardview){
            this.cardView = cardview;
        }
        void bind(CARD_ok card){
            cardView.bind(card);
        }
    }

}


