package androidx.viewpager2.integration.testapp.cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CARDVIEWADAPTER extends RecyclerView.Adapter<CARDVIEWHOLDER> {


    @NonNull
    @Override
    public CARDVIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CARDVIEWHOLDER(new CARDVIEW_ok(LayoutInflater.from(parent.getContext()), parent));
    }

    @Override
    public void onBindViewHolder(@NonNull CARDVIEWHOLDER holder, int position) {
        holder.bind(CARD_ok.DECK.get(position));
    }


    @Override
    public int getItemCount() {
        return CARD_ok.DECK.size();
    }


}


class CARDVIEWHOLDER extends RecyclerView.ViewHolder {
    private final CARDVIEW_ok cardView;

    CARDVIEWHOLDER(@NonNull CARDVIEW_ok itemViev) {
        super(itemViev.view);
        cardView = itemViev;
    }


    void bind(CARD_ok card){
        cardView.bind(card);
    }
}