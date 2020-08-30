package com.newgear.android.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.newgear.android.R;
import com.newgear.android.fragment.PasswordFragment;
import com.newgear.android.utils.Constants;

public class PasswordScreenActivity extends AppCompatActivity implements PasswordFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        //Get bundle from LoginScreenFragment and switch to PasswordScreenFragment
        String phoneNumber = getIntent().getStringExtra(Constants.PHONE_NUMBER_EXTRA);
        PasswordFragment passwordFragment = PasswordFragment.newInstance(phoneNumber);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.password_screen_fragment, passwordFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
