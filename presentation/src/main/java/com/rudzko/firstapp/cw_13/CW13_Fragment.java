package com.rudzko.firstapp.cw_13;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rudzko.firstapp.R;

/**
 * @author Olga Rudzko
 */

public class CW13_Fragment extends Fragment {

    public static final String TEXT_KEY = "TEXT_KEY";
    private String text;


    public static CW13_Fragment newInstance(FragmentManager fm, String s) {

        Fragment fragment = fm.findFragmentByTag(CW13_Fragment.class.getName());

        CW13_Fragment fr;
        if (fragment != null && fragment instanceof CW13_Fragment) {
            fr = (CW13_Fragment) fragment;
        } else {
            fr = new CW13_Fragment();
            Bundle b = new Bundle();
            b.putString(TEXT_KEY, s);
            fr.setArguments(b);
        }
        return fr;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            text = bundle.getString(TEXT_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cw13, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        view.findViewById()
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //        getActivity()
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //is always called
    }
}
