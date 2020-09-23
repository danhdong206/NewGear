package com.newgear.android.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.newgear.android.R;
import com.newgear.android.adapter.ViewPagerMainAdapter;
import com.newgear.android.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    String mPassword;

    ViewPager mViewPager;
    BottomNavigationView mNavigationView;


    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String password) {
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(Constants.PASSWORD_EXTRA, password);
        mainFragment.setArguments(args);
        return mainFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
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

        //Receive password from MainActivity
        mPassword = getArguments().getString(Constants.PASSWORD_EXTRA);

        //Action Bar
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        //Change action bar text color
        activity.getSupportActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>TIMELINE </font>"));
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //Change action bar background color
        activity.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_background)));
        activity.getSupportActionBar().setElevation(0);

        //Viewpager Navigation Bar
        mNavigationView = getActivity().findViewById(R.id.navigation_bar);
        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager = getActivity().findViewById(R.id.viewpager); //Init Viewpager
        setUpFragment(getActivity().getSupportFragmentManager(), mViewPager); //Setup Fragment
        mViewPager.setCurrentItem(0); //Set Currrent Item When Activity Start
        mViewPager.setOnPageChangeListener(new pageChange()); //Listeners For Viewpager When Page Changed

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

    public static void setUpFragment(FragmentManager fragmentManager, ViewPager viewPager) {
        ViewPagerMainAdapter Adapter = new ViewPagerMainAdapter(fragmentManager);
        //Add All Fragment To List
        Adapter.add(new MainFragmentTimeline(), "Page One");
        Adapter.add(new MainFragmentInfomation(), "Page Two");
        Adapter.add(new MainFragmentChat(), "Page Three");
        viewPager.setAdapter(Adapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_timeline:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_information:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_chat:
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    public class pageChange implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mNavigationView.setSelectedItemId(R.id.navigation_timeline);
                    break;
                case 1:
                    mNavigationView.setSelectedItemId(R.id.navigation_information);
                    break;
                case 2:
                    mNavigationView.setSelectedItemId(R.id.navigation_chat);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
