package com.example.sergio.todo_list_firebase;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sergio.todo_list_firebase.models.Reminder;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TodoListActivity extends AppCompatActivity{

    private static String FIREBASE_URL = "https://reminderslist.firebaseio.com/";
    private static String FIREBASE_CHILD = "reminders";

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.fab) FloatingActionButton fab;
    @Bind(R.id.remindersList) RecyclerView recyclerView;
    private Firebase firebase;
    private List<Reminder> reminders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        ButterKnife.bind(this);

        Firebase.setAndroidContext(this);
        setSupportActionBar(toolbar);

        Log.d("FIREBASE","Init Firebase");
        reminders = new ArrayList<Reminder>();
        firebase = new Firebase(FIREBASE_URL).child(FIREBASE_CHILD);
        firebase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.d("FIREBASE","There are " + snapshot.getChildrenCount() + " reminders");
                for (DataSnapshot reminderSnapshot: snapshot.getChildren()) {
                    Reminder reminder = reminderSnapshot.getValue(Reminder.class);
                    reminders.add(reminder);
                }
                //init recycler view
                initRecyclerView();
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initRecyclerView(){
        LinearLayoutManager llm = new LinearLayoutManager(this);
        RemindersRecyclerViewAdapter adapter = new RemindersRecyclerViewAdapter(reminders,this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_todo_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    static class ReminderViewHolder extends RecyclerView.ViewHolder{

        private ImageView icon;
        private CardView cv;
        private TextView name;
        private TextView desc;

        public ReminderViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardview);
            icon = (ImageView)itemView.findViewById(R.id.icon);
            name = (TextView)itemView.findViewById(R.id.remindername);
            desc = (TextView)itemView.findViewById(R.id.reminderdesc);
        }

        public CardView getCv() {
            return cv;
        }

        public void setCv(CardView cv) {
            this.cv = cv;
        }

        public TextView getName() {
            return name;
        }

        public void setName(String name) {
            this.name.setText(name);
        }

        public TextView getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc.setText(desc);
        }

        public ImageView getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon.setImageResource(icon);
        }
    }

    private class RemindersRecyclerViewAdapter extends RecyclerView.Adapter{

        private List<Reminder> reminders;
        private Context context;

        public RemindersRecyclerViewAdapter(List<Reminder> reminders, Context context) {
            this.reminders = reminders;
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reminder_card_view, parent, false);
            return  new ReminderViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Reminder reminder = reminders.get(position);
            ReminderViewHolder reminderHolder = (ReminderViewHolder)holder;
            reminderHolder.setName(reminder.getName());
            reminderHolder.setDesc(reminder.getDesc());
            reminderHolder.setIcon(R.drawable.warning);
            setAnimation(reminderHolder.getCv());
        }

        private void setAnimation(View viewToAnimate){
            Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
        }

        @Override
        public int getItemCount() {
            return reminders.size();
        }
    }
}
