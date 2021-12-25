package huce.it.baitaplon.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import huce.it.baitaplon.R;
import huce.it.baitaplon.databinding.FragmentProductBinding;

public class ProductFragment extends Fragment {
    private FragmentProductBinding binding;

    ArrayList<ProductModel> productModels = new ArrayList<>();

//    Toolbar toolbar;
    //action mode
    public static boolean isInActionMode = false;
    public static ArrayList<ProductModel> selectionList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProductBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        buildListData();
        // create data
//        String[] array = getResources().getStringArray(R.array.array_text);
//        for (String text : array) {
//            ProductModel model = new ProductModel(R.mipmap.ic_launcher, text);
//            productModels.add(model);
//        }

        //recyclerview
        initRecyclerView(root);

        return root;
    }

    private void initRecyclerView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewProduct);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ProductAdapter productAdapter = new ProductAdapter(this, productModels);
        recyclerView.setAdapter(productAdapter);
    }

    private void buildListData() {
//        pData.add(new ProductModel("Avengers"));
//        pData.add(new ProductModel("Black Panthers"));
        String[] array = getResources().getStringArray(R.array.array_text);
        for (String text : array) {
            ProductModel model = new ProductModel(R.mipmap.ic_launcher, text);
            productModels.add(model);
        }
    }

//    public void prepareToolbar(int position) {
//        toolbar.getMenu().clear();
//        toolbar.inflateMenu(R.menu.menu_action_mode);
//        isInActionMode = true;
//
//    }
//
//    public void prepareSelection(int position) {
//
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
