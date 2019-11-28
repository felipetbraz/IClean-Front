package com.ddm.iclean.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoAnuncio;

import java.util.List;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.AnuncioHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<DtoAnuncio> lista;
    //swipe
    private DtoAnuncio mRecentlyDeletedItem;//elemento excluído da lista
    private int mRecentlyDeletedItemPosition;//posição do elemento excluído da lista

    public AnuncioAdapter(Context context, List<DtoAnuncio> lista) {
        this.context = context;
        this.lista = lista;
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public AnuncioAdapter.AnuncioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recyclerview_layout_item_todos_anuncios, parent, false);
        return new AnuncioHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull AnuncioAdapter.AnuncioHolder holder, int position) {
        String titulo = lista.get(position).getTitulo();
        holder.titulo.setText(titulo);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class AnuncioHolder extends RecyclerView.ViewHolder {
        final AnuncioAdapter anuncioAdapter;
        public final TextView titulo;

        public AnuncioHolder(@NonNull View itemView, AnuncioAdapter anuncioAdapter) {
            super(itemView);
            this.anuncioAdapter = anuncioAdapter;
            titulo = itemView.findViewById(R.id.tv_recyclerview_titulo_anuncio);
        }

    }
}
