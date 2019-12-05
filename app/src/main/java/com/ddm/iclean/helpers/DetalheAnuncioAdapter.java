package com.ddm.iclean.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.iclean.dto.DtoAnuncio;

import java.util.List;

public class DetalheAnuncioAdapter extends RecyclerView.Adapter<DetalheAnuncioAdapter.DetalheAnuncioHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<DtoAnuncio> lista;
    //swipe
    private DtoAnuncio mRecentlyDeletedItem;//elemento excluído da lista
    private int mRecentlyDeletedItemPosition;//posição do elemento excluído da lista

    public DetalheAnuncioAdapter(Context context, List<DtoAnuncio> lista) {
        this.context = context;
        this.lista = lista;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DetalheAnuncioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DetalheAnuncioHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DetalheAnuncioHolder extends RecyclerView.ViewHolder {
        public DetalheAnuncioHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
