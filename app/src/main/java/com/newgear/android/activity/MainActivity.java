package com.newgear.android.activity;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.newgear.android.R;
import com.newgear.android.fragment.MainFragment;
import com.newgear.android.utils.Constants;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get bundle from PasswordScreenFragment and switch to MainFragment
        String password = getIntent().getStringExtra(Constants.PASSWORD_EXTRA);
        MainFragment mainFragment = MainFragment.newInstance(password);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_fragment, mainFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
