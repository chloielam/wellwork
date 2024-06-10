package org.hcmut.wellwork.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.hcmut.wellwork.R;
import org.hcmut.wellwork.databinding.FragmentHomeBinding;
import org.hcmut.wellwork.model.Database;
import org.hcmut.wellwork.viewmodel.MainViewModel;

public class HomeFragment extends Fragment{

    MainViewModel mainViewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentHomeBinding to_return = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false);
        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        to_return.setMainViewModel(mainViewModel);


        Database.setListener(mainViewModel);

        to_return.setLifecycleOwner(this);
        return to_return.getRoot();
    }
    @Override
    public void onDetach(){
        super.onDetach();
        Database.eraseListener();
    }
}


