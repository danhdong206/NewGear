package com.newgear.android.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.newgear.android.R;
import com.newgear.android.activity.MainActivity;
import com.newgear.android.activity.PasswordScreenActivity;
import com.newgear.android.model.Location;
import com.newgear.android.model.Response;
import com.newgear.android.model.User;
import com.newgear.android.retrofit.JsonPlaceHolderApi;
import com.newgear.android.retrofit.RetrofitClientInstance;
import com.newgear.android.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PasswordScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PasswordScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PasswordScreenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText mEditTextPhoneNumber;
    EditText mEditTextPassword;
    Button mButtonSend;

    ProgressDialog progressDialog;
    String mPhoneNumber;

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public PasswordScreenFragment() {
        // Required empty public constructor
    }

    public static PasswordScreenFragment newInstance(String phoneNumber) {
        PasswordScreenFragment passwordScreenFragment = new PasswordScreenFragment();
        Bundle args = new Bundle();
        args.putString(Constants.PHONE_NUMBER_EXTRA, phoneNumber);
        passwordScreenFragment.setArguments(args);
        return passwordScreenFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password_screen, container, false);
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

        //Receive phone number from PasswordScreenActivity
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

    private void getPhoneNumberAndPasswordFromServer(String phoneNumber, String password) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        /*Create handle for the RetrofitInstance interface*/
        JsonPlaceHolderApi service = RetrofitClientInstance.getRetrofitInstance().create(JsonPlaceHolderApi.class);
        Call<Response> call = service.getLogin(phoneNumber, password);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                progressDialog.dismiss();

                if (response.isSuccessful()) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    //Save phone number and switch to MainActivity
                    Bundle bundle = new Bundle();
                    bundle.putString(Constants.PASSWORD_EXTRA, mEditTextPassword.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else {
                    builder.setTitle("Error!");
                    builder.setMessage("Wrong password, please try again");
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
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
                progressDialog.dismiss();
                Toast.makeText(getContext(), "No Internet Connection. Please try again.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loginWithPhoneNumberAndPassword() {
        mEditTextPassword = getActivity().findViewById(R.id.edit_text_password);
        mButtonSend = getActivity().findViewById(R.id.btn_send);
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                if (mEditTextPassword.length() <= 5 && mEditTextPassword.length() >= 1) {
                    builder.setTitle("Error!");
                    builder.setMessage("Password must at least 6 characters");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if (mEditTextPassword.length() == 0) {
                    builder.setTitle("Error!");
                    builder.setMessage("Please enter your password");
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                    getPhoneNumberAndPasswordFromServer(mPhoneNumber, mEditTextPassword.getText().toString());
                }
            }
        });
    }

}
