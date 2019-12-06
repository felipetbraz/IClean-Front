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
import com.ddm.iclean.dto.DtoOrdemServico;

import java.util.List;

public class OrdemServicoAdapter extends RecyclerView.Adapter<OrdemServicoAdapter.OrdemServicoHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<DtoOrdemServico> listaOrdemServico;
    //swipe
    private DtoAnuncio mRecentlyDeletedItem;
    private int mRecentlyDeletedItemPosition;

    public OrdemServicoAdapter(Context context, List<DtoOrdemServico> listaOrdemServico) {
        this.context = context;
        this.listaOrdemServico = listaOrdemServico;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OrdemServicoAdapter.OrdemServicoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recyclerview_layout_item_todos_enderecos, parent, false);
        return new OrdemServicoAdapter.OrdemServicoHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(@NonNull OrdemServicoHolder holder, int position) {
        String status = listaOrdemServico.get(position).getStatus();
        String dataInclusao = listaOrdemServico.get(position).getDataInclusao().toString();
        holder.status.setText(logradouro);
        holder.dataInclusao.setText(numero);
    }

    @Override
    public int getItemCount() {
        return 0;
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
