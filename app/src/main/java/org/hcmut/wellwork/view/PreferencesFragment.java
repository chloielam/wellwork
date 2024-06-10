package org.hcmut.wellwork.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.hcmut.wellwork.R;
import org.hcmut.wellwork.databinding.FragmentPreferencesBinding;
import org.hcmut.wellwork.viewmodel.PreferencesViewModel;


public class PreferencesFragment extends Fragment {



    public PreferencesFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    PreferencesViewModel preferencesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentPreferencesBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_preferences, container, false);
        preferencesViewModel = new ViewModelProvider(requireActivity()).get(PreferencesViewModel.class);
        preferencesViewModel.onAttach();
        binding.setLifecycleOwner(this);
        binding.setViewModel1(preferencesViewModel);

        return binding.getRoot();

    }



    @Override
    public void onDetach(){
        super.onDetach();

    }
}