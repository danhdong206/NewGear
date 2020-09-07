package com.newgear.android.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.newgear.android.R;
import com.newgear.android.adapter.StaggeredGridViewTimeLineAdapter;
import com.newgear.android.model.timeline.Feed;
import com.newgear.android.retrofit.JsonPlaceHolderApi;
import com.newgear.android.retrofit.RetrofitClientInstance;

import java.util.ArrayList;

import javax.annotation.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragmentTimeline extends Fragment {

    private StaggeredGridViewTimeLineAdapter staggeredGridViewTimeLineAdapter;
    private static final int NUM_COLUMNS = 1;
    ProgressDialog progressDialog;

    private ArrayList<String> mDates = new ArrayList<>();
    private ArrayList<String> mHours = new ArrayList<>();
    private ArrayList<String> mHoursAssignment = new ArrayList<>();
    private ArrayList<String> mAssignmentNumbers = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentTimeline = inflater.inflate(R.layout.fragment_main_timeline, container, false);
        return fragmentTimeline;
    }

    @Override
    public void onActivityCreated(@android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Save Database Driver Info
//        DriverInfo driverInfo = new DriverInfo();
//        driverInfo.setTrailerNumber("1234567890");
//        driverInfo.setUserName("Danh Driver Indian");
//        driverInfo.setUserRole("driver");
//        driverInfo.setUserImage(null);
//        driverInfo.setEta(1563926400);
//        driverInfo.save();
//
//        //Save Database Partner Rating
//        PartnerRating partnerRating = new PartnerRating();
//        partnerRating.setInspectationGroupID(885);
//        partnerRating.setFinishedAtTimeSeconds(1563936926);
//        partnerRating.setLocationName("Scepta");
//        partnerRating.setTaskType("inspection_group_discharging");
//        partnerRating.setUserName("Danh Driver Indian");
//        partnerRating.setUserRole("driver");
//        partnerRating.setUserImage(null);
//        partnerRating.setId(1235);
//        partnerRating.setRatingScore("-1");
//        partnerRating.setRatingComment(null);
//        partnerRating.setSkipSignature(false);
//        partnerRating.setSkipInspection(false);
//        partnerRating.save();
//
//        //Save Database Task Mini
//        TasksMini tasksMini = new TasksMini();
//        tasksMini.setId(1235);
//        tasksMini.setSequence(1);
//        tasksMini.setTaskType("inspection_group_discharging");
//        tasksMini.setUpdatedAtTimeSeconds(0);
//        tasksMini.setReceivedCargoAtTimeSeconds(1563936917);
//        tasksMini.setInspectionGroupStatus("confirmed");
//        tasksMini.setInspectionGroupType("automobile_nali");
//        tasksMini.setLocation("Scepta");
//        tasksMini.setHandler(true);
//        tasksMini.setTaskStatus("finished");
//        tasksMini.save();
//
//        //Save Database New Task Group
//        NewTaskGroup newTaskGroup = new NewTaskGroup();
//        newTaskGroup.setId(785);
//        newTaskGroup.setRejectReason(null);
//        newTaskGroup.setStatus("finished");
//        newTaskGroup.setUpdatedAtTimeSeconds(1563936889);
//        newTaskGroup.setAssignmentNumber("000062019072400096");
//        newTaskGroup.setSentAtTimeSeconds(1563936340);
//        newTaskGroup.setConfirmedAtTimeSeconds(1563936912);
//        newTaskGroup.setStartedAtTimeSeconds(1563936912);
//        newTaskGroup.setCargosNumber(1);
//        newTaskGroup.setCancelledCargosNumber(0);
//        newTaskGroup.setDelivered(true);
//        newTaskGroup.setTransportationCompanyName("VN Auto Logistics (Indian) Co.,Ltd.");
//        newTaskGroup.save();
//
//        //Save Database Feed
//        Feed feed = new Feed();
//        feed.setId(831);
//        feed.setFeedType("new_task_group");
//        feed.setTransportationCompanyID(6);
//        feed.setCreatedAtTimeSeconds(1563936340);
//        feed.setUpdatedAtTimeSeconds(1563936937);
//        feed.setConfirmedAtTimeSeconds(1563936912);
//        feed.save();
//
//        //Save Database User
//        User user = new User();
//        user.setId(9);
//        user.setName("Danh VDC Indian");
//        user.setApiToken("e6b70129b2a5bcc5e5d7247145da2bd476131ec913af99785e3b08c5592132e8d9800c4272d1cd209e833e943b537c8d67b3672265fc31d94543068ecb8667a4");
//        user.setRole("non_driver");
//        user.setSubRole(null);
//        user.setImageID(null);
//        user.setTmsAPIToken(null);
//        user.setFirebaseToken(null);
//        user.setGender(-1);
//        user.setLocale("en");
//        user.setImage(null);
//        user.setPhoneNumber("+8411652679158");
//        user.setDateOfBirthday(null);
//        user.setQualification("N/A");
//        user.setWorkingInfo(0);
//        user.setTotalPoint(0);
//        user.save();

//        staggeredGridView();
    }

//    private void addDataListStaggered(){
//        mDates.add("5/07/2019");
//        mHours.add("09:06 AM");
//        mHoursAssignment.add("09:06 AM");
//        mAssignmentNumbers.add("000052019072200059");
//
//        mDates.add("5/07/2019");
//        mHours.add("09:10 AM");
//        mHoursAssignment.add("09:10 AM");
//        mAssignmentNumbers.add("000052019072200059");
//
//        mDates.add("8/07/2019");
//        mHours.add("09:23 AM");
//        mHoursAssignment.add("09:23 AM");
//        mAssignmentNumbers.add("000052019072200059");
//
//        mDates.add("1/07/2019");
//        mHours.add("05:06 PM");
//        mHoursAssignment.add("05:06 PM");
//        mAssignmentNumbers.add("000052019072200059");
//
//        mDates.add("10/07/2019");
//        mHours.add("7:00 PM");
//        mHoursAssignment.add("7:00 PM");
//        mAssignmentNumbers.add("000052019072200059");
//
//        mDates.add("12/07/2019");
//        mHours.add("9:46 PM");
//        mHoursAssignment.add("9:46 PM");
//        mAssignmentNumbers.add("000052019072200059");
//
//        mDates.add("6/06/2019");
//        mHours.add("3:48 PM");
//        mHoursAssignment.add("3:48 PM");
//        mAssignmentNumbers.add("000052019072200059");
//
//        mDates.add("4/10/2019");
//        mHours.add("0:30 PM");
//        mHoursAssignment.add("0:30 PM");
//        mAssignmentNumbers.add("000052019072200059");
//
//    }

//    private void staggeredGridView() {
//        progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setMessage("Loading...");
//        progressDialog.show();
//
//        /*Create handle for the RetrofitInstance interface*/
//        JsonPlaceHolderApi service = RetrofitClientInstance.getRetrofitInstance().create(JsonPlaceHolderApi.class);
//        Call<Feed> call = service.getFeeds();
//        call.enqueue(new Callback<Feed>() {
//            @Override
//            public void onResponse(Call<Feed> call, Response<Feed> response) {
//                progressDialog.dismiss();
//                generateDataListStaggered(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Feed> call, Throwable t) {
//                progressDialog.dismiss();
//                Toast.makeText(getContext(), "No Internet Connection. Please try again.", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void generateDataListStaggered(Feed feed) {
//        RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerview_items_timeline);
//        staggeredGridViewTimeLineAdapter = new StaggeredGridViewTimeLineAdapter(getContext(), feed.getUpdatedAtTimeSeconds());
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//        recyclerView.setAdapter(staggeredGridViewTimeLineAdapter);
//    }
}
