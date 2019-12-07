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
import com.ddm.iclean.dto.DtoEndereco;
import com.ddm.iclean.dto.DtoOrdemServico;

import java.util.List;

public class OrdemServicoAdapter extends RecyclerView.Adapter <OrdemServicoAdapter.OrdemServicoHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<DtoOrdemServico> lista;
    //swipe
    private DtoOrdemServico mRecentlyDeletedItem;//elemento excluído da lista
    private int mRecentlyDeletedItemPosition;//posição do elemento excluído da lista

    public OrdemServicoAdapter(Context context, List<DtoOrdemServico> lista) {
        this.context = context;
        this.lista = lista;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OrdemServicoAdapter.OrdemServicoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recyclerview_layout_item_todos_ordem_servico, parent, false);
        return new OrdemServicoHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdemServicoHolder holder, int position) {
        String status = lista.get(position).getStatus();
        String dataInclusao = lista.get(position).getDataInclusao().toString();
        holder.status.setText(status);
        holder.dataInclusao.setText(dataInclusao);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class OrdemServicoHolder extends RecyclerView.ViewHolder {
        final OrdemServicoAdapter ordemServicoAdapter;
        public final TextView status;
        public final TextView dataInclusao;

        public OrdemServicoHolder(@NonNull View itemView, OrdemServicoAdapter ordemServicoAdapter) {
            super(itemView);
            this.ordemServicoAdapter = ordemServicoAdapter;
            status = itemView.findViewById(R.id.tv_recyclerview_status_ordemServico);
            dataInclusao = itemView.findViewById(R.id.tv_recyclerview_data_ordemServico);
        }
    }
}
