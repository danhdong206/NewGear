package com.newgear.android.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
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
import android.widget.Toast;

import com.newgear.android.R;
import com.newgear.android.activity.PasswordScreenActivity;
import com.newgear.android.retrofit.JsonPlaceHolderApi;
import com.newgear.android.retrofit.RetrofitClientInstance;
import com.newgear.android.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginScreenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView mTextViewTermsOfUse;
    EditText mEditTextPhoneNumber;
    TextView mCodeCountry;
    Button mButtonTypePassword;

    ProgressDialog progressDialog;

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public LoginScreenFragment() {
        // Required empty public constructor
    }

    public static LoginScreenFragment newInstance(int someInt, String someTitle) {
        LoginScreenFragment loginScreenFragment = new LoginScreenFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        args.putString("someTitle", someTitle);
        loginScreenFragment.setArguments(args);
        return loginScreenFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_screen, container, false);
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
        //Login with type password
        loginWithPhoneNumber();
        //Clickable TERMS OF USE
        termsOfUse();
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void spinnerCountry() {
        Spinner spinner = getActivity().findViewById(R.id.spinner_country);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.spinner_item_country, R.layout.spinner_item_country);
        adapter.setDropDownViewResource(R.layout.spinner_item_dropdown_country);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    private void getPhoneNumberFromServer(String phoneNumber) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        /*Create handle for the RetrofitInstance interface*/
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        JsonPlaceHolderApi service = RetrofitClientInstance.getRetrofitInstance().create(JsonPlaceHolderApi.class);
        Call call = service.getPhoneNumber(phoneNumber);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, retrofit2.Response<Void> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()) {
                    Intent intent = new Intent(getContext(), PasswordScreenActivity.class);
                    //Save phone number and switch to PasswordActivity
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.PHONE_NUMBER_EXTRA, mCodeCountry.getText().toString() + mEditTextPhoneNumber.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    builder.setTitle("Error !!!");
                    builder.setMessage("Phone number not exist");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loginWithPhoneNumber() {
        mEditTextPhoneNumber = getActivity().findViewById(R.id.edit_text_phone_number);
        mButtonTypePassword = getActivity().findViewById(R.id.btn_type_password);
        mButtonTypePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                if (mEditTextPhoneNumber.length() <= 5) {
                    builder.setTitle("Error !!!");
                    builder.setMessage("Please try again");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if (mEditTextPhoneNumber.length() == 0) {
                    builder.setTitle("Error !!!");
                    builder.setMessage("Please enter your phone number");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if (mEditTextPhoneNumber.length() >= 6 && mEditTextPhoneNumber.length() <= 12) {
                    getPhoneNumberFromServer(mCodeCountry.getText().toString() + mEditTextPhoneNumber.getText().toString());
                }
            }
        });
    }

}
