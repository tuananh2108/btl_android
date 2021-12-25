package huce.it.baitaplon.ui.product;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import huce.it.baitaplon.MainActivity;
import huce.it.baitaplon.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Fragment productFragment;
    private static ArrayList<ProductModel> pDataset;
    Activity mActivity;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

        ImageView pImageView;
        TextView pTextView;
        View pView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pTextView = itemView.findViewById(R.id.tvRowItem);
            pImageView = itemView.findViewById(R.id.ivRowItem);
            pView = itemView;
            itemView.setOnLongClickListener(this);
            pImageView.setOnClickListener(this);
        }

        @Override
        public boolean onLongClick(View view) {
//            ((MainActivity) mActivity).prepareToolbar(getAdapterPosition());
//            toolbar.getMenu().clear();
//            toolbar.inflateMenu(R.menu.menu_action_mode);
            return true;
        }

        @Override
        public void onClick(View view) {
//            if (ProductFragment.isInActionMode) {
//                ((ProductFragment) productFragment).prepareSelection(getAdapterPosition());
//                notifyItemChanged(getAdapterPosition());
//            }
        }
    }

    public ProductAdapter(Fragment fragment, ArrayList<ProductModel> myDataset) {
        this.productFragment = fragment;
        this.pDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_product, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductModel model = pDataset.get(position);
        holder.pView.setBackgroundResource(R.color.white);
        holder.pTextView.setText(model.getText());
        holder.pImageView.setImageResource(model.getImage());

        if (ProductFragment.isInActionMode) {
            if (ProductFragment.selectionList.contains(pDataset.get(position))) {
                holder.pView.setBackgroundResource(R.color.grey_200);
                holder.pImageView.setImageResource(R.drawable.ic_check_circle_24dp);
            }
        }
    }

    @Override
    public int getItemCount() {
        return pDataset.size();
    }

    public void removeData(ArrayList<ProductModel> list) {
        for (ProductModel model : list) {
            pDataset.remove(model);
        }
        notifyDataSetChanged();
    }

    public void changeDataItem(int position, ProductModel model) {
        pDataset.set(position, model);
        notifyDataSetChanged();
    }

    // for edit
    public static ArrayList<ProductModel> getDataSet() {
        return pDataset;
    }
}
