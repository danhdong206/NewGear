package com.newgear.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newgear.android.R;

import javax.annotation.Nullable;

public class MainFragmentChat extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentChat = inflater.inflate(R.layout.fragment_main_chat, container, false);
        return fragmentChat;
    }
}
