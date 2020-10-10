package com.newgear.android.ui.login.view;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.newgear.android.R;
import com.newgear.android.ui.GearFragment;
import com.newgear.android.ui.login.presenter.LoginPresenter;
import com.newgear.android.ui.password.PasswordActivity;
import com.newgear.android.utils.Constants;

import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

import javax.inject.Inject;


public class LoginFragment extends GearFragment implements LoginView {

    private static final String TAG = LoginFragment.class.getSimpleName();

    TextView mTextViewTermsOfUse;
    EditText mEditTextPhoneNumber;
    TextView mCodeCountry;
    Button mButtonTypePassword;
    ProgressDialog progressDialog;

    @Inject
    protected LoginPresenter mLoginPresenter;

    private OnFragmentInteractionListener mListener;


    public static LoginFragment newInstance(int someInt, String someTitle) {
        LoginFragment loginFragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        args.putString("someTitle", someTitle);
        loginFragment.setArguments(args);
        return loginFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
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

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        //Spinner items country
        spinnerCountry();
        //Clickable TERMS OF USE
        termsOfUse();

        //Login with type password
        loginWithPhoneNumber();
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

    private void spinnerCountry() {
        Spinner spinner = getActivity().findViewById(R.id.spinner_country);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.spinner_item_country, R.layout.spinner_item_country);
        adapter.setDropDownViewResource(R.layout.spinner_item_dropdown_country);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCodeCountry = getActivity().findViewById(R.id.txt_code_country);
                if (position == 0) {
                    mCodeCountry.setText("+84");
                } else if (position == 1) {
                    mCodeCountry.setText("+1");
                } else {
                    mCodeCountry.setText("+91");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void termsOfUse() {
        mTextViewTermsOfUse = getActivity().findViewById(R.id.txt_terms_of_use);

        String text = "TERMS OF USE";

        SpannableString spannableString = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                String url = "http://www.vnexpress.net";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#F1ADB2"));
                ds.setUnderlineText(false);
            }
        };

        spannableString.setSpan(clickableSpan, 0, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextViewTermsOfUse.setText(spannableString);
        mTextViewTermsOfUse.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private void loginWithPhoneNumber() {
        mEditTextPhoneNumber = getActivity().findViewById(R.id.edit_text_phone_number);
        mButtonTypePassword = getActivity().findViewById(R.id.btn_type_password);
        mButtonTypePassword.setOnClickListener(v -> {
            if (mEditTextPhoneNumber.length() >= 6 && mEditTextPhoneNumber.length() <= 12) {
                mLoginPresenter.loadPhoneNumber(mCodeCountry.getText().toString() + mEditTextPhoneNumber.getText().toString());
                UIUtil.hideKeyboard(getActivity());
            } else {
                mLoginPresenter.onLoginPhoneNumber(mEditTextPhoneNumber.getText().toString());
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
    public void showComplete() {
        Intent intent = new Intent(getContext(), PasswordActivity.class);
        //Save phone number and switch to PasswordActivity
        Bundle bundle = new Bundle();
        bundle.putString(Constants.PHONE_NUMBER_EXTRA, mCodeCountry.getText().toString() + mEditTextPhoneNumber.getText().toString());
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
