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
        CARDVIEW cvok = new CARDVIEW(LayoutInflater.from(parent.getContext()), parent);
        return new CARDVIEWHOLDER(cvok);
    }

    @Override
    public void onBindViewHolder(@NonNull CARDVIEWHOLDER holder, int position) {
        holder.bind(CARD.DECK.get(position));
    }


    @Override
    public int getItemCount() {
        return CARD.DECK.size();
    }



}


class CARDVIEWHOLDER extends RecyclerView.ViewHolder {
    private CARDVIEW cardView;
    public CARDVIEWHOLDER(@NonNull View itemView) {
        super(itemView);
        cardView = itemView;
    }

    void bind(CARD card){
        cardView.bind(card);
    }
}