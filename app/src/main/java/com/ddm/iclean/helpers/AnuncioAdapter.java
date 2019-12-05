package com.ddm.iclean.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.iclean.R;
import com.ddm.iclean.activities.CadastroDeAnuncioActivity;
import com.ddm.iclean.activities.DetalheAnuncioActivity;
import com.ddm.iclean.activities.LoginActivity;
import com.ddm.iclean.activities.MainActivity;
import com.ddm.iclean.dto.DtoAnuncio;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

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
        Integer id = lista.get(position).getId();
        String titulo = lista.get(position).getTitulo();
        String preco = lista.get(position).getPreco().toString();
        holder.id.setText(id.toString());
        holder.titulo.setText(titulo);
        holder.preco.setText(preco);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class AnuncioHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final AnuncioAdapter anuncioAdapter;
        public final TextView titulo;
        public final TextView preco;
        public final TextView id;

        public AnuncioHolder(@NonNull View itemView, AnuncioAdapter anuncioAdapter) {
            super(itemView);
            this.anuncioAdapter = anuncioAdapter;
            id = itemView.findViewById(R.id.tv_recyclerview_id_anuncio);
            titulo = itemView.findViewById(R.id.tv_recyclerview_titulo_anuncio);
            preco = itemView.findViewById(R.id.tv_recyclerview_preco_anuncio);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();

            Intent intent = new Intent(context, DetalheAnuncioActivity.class);
            intent.putExtra("id",lista.get(mPosition).getId());
            intent.putExtra("preco",lista.get(mPosition).getPreco());
            intent.putExtra("titulo",lista.get(mPosition).getTitulo());
            intent.putExtra("descricao",lista.get(mPosition).getDescricao());

            context.startActivity(intent);
        }
    }
}

