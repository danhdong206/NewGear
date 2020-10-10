package com.newgear.android.ui.password.view;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.newgear.android.R;
import com.newgear.android.ui.GearFragment;
import com.newgear.android.ui.login.view.LoginFragment;
import com.newgear.android.ui.password.presenter.PasswordPresenter;
import com.newgear.android.utils.Constants;

import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

import javax.inject.Inject;

public class PasswordFragment extends GearFragment implements PasswordView {

    private static final String TAG = LoginFragment.class.getSimpleName();

    EditText mEditTextPassword;
    Button mButtonSend;

    ProgressDialog progressDialog;
    String mPhoneNumber;

    @Inject
    protected PasswordPresenter presenter;

    private OnFragmentInteractionListener mListener;


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
        mButtonSend.setOnClickListener(v -> {
            if (mEditTextPassword.length() >= 6 && mEditTextPassword.length() <= 127) {
                presenter.loadPassword(mPhoneNumber, mEditTextPassword.getText().toString());
                UIUtil.hideKeyboard(getActivity());
            } else {
                presenter.onLoginPassword(mEditTextPassword.getText().toString());
                UIUtil.hideKeyboard(getActivity());
            }
        });

    }

    @Override
    public void showError(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Error!");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", (dialog, which) -> {

        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void showComplete(String message) {
//        Intent intent = new Intent(getContext(), MainActivity.class);
//        //Save phone number and switch to MainActivity
//        Bundle bundle = new Bundle();
//        bundle.putString(Constants.PASSWORD_EXTRA, mEditTextPassword.getText().toString());
//        intent.putExtras(bundle);
//        startActivity(intent);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Success");
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", (dialog, which) -> {

        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
