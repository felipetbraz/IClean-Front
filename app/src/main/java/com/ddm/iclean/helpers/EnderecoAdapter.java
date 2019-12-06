package com.ddm.iclean.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ddm.iclean.R;
import com.ddm.iclean.dto.DtoEndereco;

import java.util.List;

public class EnderecoAdapter extends RecyclerView.Adapter <EnderecoAdapter.EnderecoHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<DtoEndereco> lista;
    //swipe
    private DtoEndereco mRecentlyDeletedItem;//elemento excluído da lista
    private int mRecentlyDeletedItemPosition;//posição do elemento excluído da lista

    public EnderecoAdapter(Context context, List<DtoEndereco> lista){
        this.context = context;
        this.lista = lista;
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public EnderecoAdapter.EnderecoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recyclerview_layout_item_todos_enderecos, parent, false);
        return new EnderecoHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull EnderecoAdapter.EnderecoHolder holder, int position) {
        String logradouro = lista.get(position).getLogradouro();
        holder.logradouro.setText(logradouro);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class EnderecoHolder extends RecyclerView.ViewHolder{
        final EnderecoAdapter enderecoAdapter;
        public final TextView logradouro;

        public EnderecoHolder (@NonNull View itemView, EnderecoAdapter enderecoAdapter){
            super(itemView);
            this.enderecoAdapter = enderecoAdapter;
            logradouro = itemView.findViewById(R.id.tv_recyclerview_logradouro_endereco);
        }
    }

}
