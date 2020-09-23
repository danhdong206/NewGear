package com.newgear.android.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.newgear.android.R;
import com.newgear.android.model.timeline.Feed;
import com.newgear.android.model.timeline.NewTaskGroup;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridViewTimeLineAdapter extends RecyclerView.Adapter<StaggeredGridViewTimeLineAdapter.ViewHolder> {

    private Context mContext;
    private int mUpdatedTime;


    public StaggeredGridViewTimeLineAdapter(Context context, int updatedTime) {
        this.mContext = context;
        this.mUpdatedTime = updatedTime;
    }

//    public class StartedViewHolder extends RecyclerView.ViewHolder {
//
//        public final View mView;
//
//        TextView txtUpdatedAtTimeSeconds;
//        TextView txtAssignmentNumber;
//
//        public StartedViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            mView = itemView;
//
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_date_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_assignment_updated_at_time_seconds);
//            txtAssignmentNumber = mView.findViewById(R.id.txt_assignment_number);
//        }
//
//        public void bindViewFeed(Feed feed) {
//            txtUpdatedAtTimeSeconds.setText(feed.getUpdatedAtTimeSeconds());
//        }
//
//        public void bindViewNewTaskGroup(NewTaskGroup newTaskGroup) {
//            txtAssignmentNumber.setText(newTaskGroup.getAssignmentNumber());
//        }
//    }
//
//    public class OnHoldViewHolder extends RecyclerView.ViewHolder{
//        public final View mView;
//
//        TextView txtUpdatedAtTimeSeconds;
//        TextView txtAssignmentNumber;
//
//        public OnHoldViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            mView = itemView;
//
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_date_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_assignment_updated_at_time_seconds);
//            txtAssignmentNumber = mView.findViewById(R.id.txt_assignment_number);
//        }
//
//        public void bindViewFeed(Feed feed) {
//            txtUpdatedAtTimeSeconds.setText(feed.getUpdatedAtTimeSeconds());
//        }
//
//        public void bindViewNewTaskGroup(NewTaskGroup newTaskGroup) {
//            txtAssignmentNumber.setText(newTaskGroup.getAssignmentNumber());
//        }
//    }
//
//    public class NewViewHolder extends RecyclerView.ViewHolder{
//        public final View mView;
//
//        TextView txtUpdatedAtTimeSeconds;
//        TextView txtAssignmentNumber;
//
//        public NewViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            mView = itemView;
//
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_date_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_assignment_updated_at_time_seconds);
//            txtAssignmentNumber = mView.findViewById(R.id.txt_assignment_number);
//        }
//
//        public void bindViewFeed(Feed feed) {
//            txtUpdatedAtTimeSeconds.setText(feed.getUpdatedAtTimeSeconds());
//        }
//
//        public void bindViewNewTaskGroup(NewTaskGroup newTaskGroup) {
//            txtAssignmentNumber.setText(newTaskGroup.getAssignmentNumber());
//        }
//    }
//
//    public class LoadedViewHolder extends RecyclerView.ViewHolder{
//        public final View mView;
//
//        TextView txtUpdatedAtTimeSeconds;
//        TextView txtAssignmentNumber;
//
//        public LoadedViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            mView = itemView;
//
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_date_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_assignment_updated_at_time_seconds);
//            txtAssignmentNumber = mView.findViewById(R.id.txt_assignment_number);
//        }
//
//        public void bindViewFeed(Feed feed) {
//            txtUpdatedAtTimeSeconds.setText(feed.getUpdatedAtTimeSeconds());
//        }
//
//        public void bindViewNewTaskGroup(NewTaskGroup newTaskGroup) {
//            txtAssignmentNumber.setText(newTaskGroup.getAssignmentNumber());
//        }
//    }
//
//    public class FinishedViewHolder extends RecyclerView.ViewHolder{
//        public final View mView;
//
//        TextView txtUpdatedAtTimeSeconds;
//        TextView txtAssignmentNumber;
//
//        public FinishedViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            mView = itemView;
//
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_date_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_assignment_updated_at_time_seconds);
//            txtAssignmentNumber = mView.findViewById(R.id.txt_assignment_number);
//        }
//
//        public void bindViewFeed(Feed feed) {
//            txtUpdatedAtTimeSeconds.setText(feed.getUpdatedAtTimeSeconds());
//        }
//
//        public void bindViewNewTaskGroup(NewTaskGroup newTaskGroup) {
//            txtAssignmentNumber.setText(newTaskGroup.getAssignmentNumber());
//        }
//    }
//
//    public class DeliveredViewHolder extends RecyclerView.ViewHolder{
//        public final View mView;
//
//        TextView txtUpdatedAtTimeSeconds;
//        TextView txtAssignmentNumber;
//
//        public DeliveredViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            mView = itemView;
//
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_date_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_assignment_updated_at_time_seconds);
//            txtAssignmentNumber = mView.findViewById(R.id.txt_assignment_number);
//        }
//
//        public void bindViewFeed(Feed feed) {
//            txtUpdatedAtTimeSeconds.setText(feed.getUpdatedAtTimeSeconds());
//        }
//
//        public void bindViewNewTaskGroup(NewTaskGroup newTaskGroup) {
//            txtAssignmentNumber.setText(newTaskGroup.getAssignmentNumber());
//        }
//    }
//
//    public class ConfirmedViewHolder extends RecyclerView.ViewHolder{
//        public final View mView;
//
//        TextView txtUpdatedAtTimeSeconds;
//        TextView txtAssignmentNumber;
//
//        public ConfirmedViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            mView = itemView;
//
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_date_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_updated_at_time_seconds);
//            txtUpdatedAtTimeSeconds = mView.findViewById(R.id.txt_hours_assignment_updated_at_time_seconds);
//            txtAssignmentNumber = mView.findViewById(R.id.txt_assignment_number);
//        }
//
//        public void bindViewFeed(Feed feed) {
//            txtUpdatedAtTimeSeconds.setText(feed.getUpdatedAtTimeSeconds());
//        }
//
//        public void bindViewNewTaskGroup(NewTaskGroup newTaskGroup) {
//            txtAssignmentNumber.setText(newTaskGroup.getAssignmentNumber());
//        }
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDate;
        TextView txtHours;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.txtDate = itemView.findViewById(R.id.txt_date_updated_at_time_seconds);
            this.txtHours = itemView.findViewById(R.id.txt_hours_updated_at_time_seconds);
            this.txtHours = itemView.findViewById(R.id.txt_hours_assignment_updated_at_time_seconds);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staggered_grid_view_started, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtDate.setText(mUpdatedTime);
        holder.txtHours.setText(mUpdatedTime);
    }

    @Override
    public int getItemCount() {
        return mUpdatedTime;
    }
}
