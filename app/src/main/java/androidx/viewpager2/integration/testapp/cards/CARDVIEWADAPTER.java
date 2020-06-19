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
        return CARDVIEWHOLDER(CARDVIEW(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull CARDVIEWHOLDER holder, int position) {
        holder.bind(CARD.DECK.get(position));
    }


    @Override
    public int getItemCount() {
        return CARD.DECK.size();
    }


    public class CARDVIEWHOLDER extends RecyclerView.ViewHolder {
        public CARDVIEWHOLDER(@NonNull CARDVIEW cardView) {
            super(cardView);
            cardView.bind(card);
        }
    }

}
