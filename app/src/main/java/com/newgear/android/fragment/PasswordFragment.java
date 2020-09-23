package com.newgear.android.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.newgear.android.R;
import com.newgear.android.activity.MainActivity;
import com.newgear.android.di.component.ApplicationComponent;
import com.newgear.android.di.component.MyApplication;
import com.newgear.android.di.component.password.DaggerPasswordFragmentComponent;
import com.newgear.android.di.component.password.PasswordFragmentComponent;
import com.newgear.android.di.module.password.PasswordFragmentMVPModule;
import com.newgear.android.model.Response;
import com.newgear.android.mvp.password.PasswordViewPresenter;
import com.newgear.android.mvp.password.PresenterPasswordImpl;
import com.newgear.android.retrofit.APIInterface;
import com.newgear.android.utils.Constants;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class PasswordFragment extends Fragment implements PasswordViewPresenter.View {

    private static final String TAG = PasswordFragment.class.getSimpleName();

    EditText mEditTextPassword;
    Button mButtonSend;

    ProgressDialog progressDialog;
    String mPhoneNumber;

    PasswordFragmentComponent passwordFragmentComponent;

    @Inject
    PresenterPasswordImpl presenter;


    private OnFragmentInteractionListener mListener;

    public PasswordFragment() {

    }

    public static PasswordFragment newInstance(String phoneNumber) {
        PasswordFragment passwordFragment = new PasswordFragment();
        Bundle args = new Bundle();
        args.putString(Constants.PHONE_NUMBER_EXTRA, phoneNumber);
        passwordFragment.setArguments(args);
        return passwordFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_password, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Receive phone number from PasswordActivity
        mPhoneNumber = getArguments().getString(Constants.PHONE_NUMBER_EXTRA);

        //Action Bar
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle("VERIFICATION");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Change back arrow
        final Drawable backArrow = getResources().getDrawable(R.drawable.chevron_left);
        backArrow.setColorFilter(getResources().getColor(R.color.color_background), PorterDuff.Mode.SRC_ATOP);
        activity.getSupportActionBar().setHomeAsUpIndicator(backArrow);

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        passwordFragmentComponent = DaggerPasswordFragmentComponent.builder()
                .passwordFragmentMVPModule(new PasswordFragmentMVPModule(this))
                .applicationComponent(applicationComponent)
                .build();

        passwordFragmentComponent.injectPasswordFragment(this);

        //Type password
        loginWithPhoneNumberAndPassword();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void loginWithPhoneNumberAndPassword() {
        mEditTextPassword = getActivity().findViewById(R.id.edit_text_password);
        mButtonSend = getActivity().findViewById(R.id.btn_send);
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditTextPassword.length() >= 6 && mEditTextPassword.length() <= 127) {
                    presenter.loadPassword(mPhoneNumber, mEditTextPassword.getText().toString());
                } else {
                    presenter.onLoginPassword(mEditTextPassword.getText().toString());
                }
            }
        });

    }

    @Override
    public void showError(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Error!");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void showComplete() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        //Save phone number and switch to MainActivity
        Bundle bundle = new Bundle();
        bundle.putString(Constants.PASSWORD_EXTRA, mEditTextPassword.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }


}
