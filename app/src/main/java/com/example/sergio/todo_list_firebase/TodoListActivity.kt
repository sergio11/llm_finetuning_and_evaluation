package com.example.sergio.todo_list_firebase

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.sergio.todo_list_firebase.domain.models.Reminder

import java.util.ArrayList

class TodoListActivity : AppCompatActivity() {

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar
    @BindView(R.id.fab)
    lateinit var fab: FloatingActionButton
    @BindView(R.id.remindersList)
    lateinit var recyclerView: RecyclerView
    private var reminders: MutableList<Reminder> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)
        val llm = LinearLayoutManager(this)
        val adapter = RemindersRecyclerViewAdapter(reminders, this)
        recyclerView!!.layoutManager = llm
        recyclerView!!.adapter = adapter

        fab?.setOnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_todo_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    internal class ReminderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val icon: ImageView
        var cv: CardView? = null
        val name: TextView
        val desc: TextView

        init {
            cv = itemView.findViewById(R.id.cardview) as CardView
            icon = itemView.findViewById(R.id.icon) as ImageView
            name = itemView.findViewById(R.id.remindername) as TextView
            desc = itemView.findViewById(R.id.reminderdesc) as TextView
        }

        fun setName(name: String?) {
            this.name.text = name
        }

        fun setDesc(desc: String?) {
            this.desc.text = desc
        }

        fun setIcon(icon: Int) {
            this.icon.setImageResource(icon)
        }
    }

    private inner class RemindersRecyclerViewAdapter(private val reminders: MutableList<Reminder>, private val context: Context) : RecyclerView.Adapter<ReminderViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.reminder_card_view, parent, false)
            return ReminderViewHolder(view)
        }

        override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
            val reminder = reminders[position]
            holder.setName(reminder.name)
            holder.setDesc(reminder.desc)
            holder.setIcon(R.drawable.warning)
            setAnimation(holder.cv)
        }

        private fun setAnimation(viewToAnimate: View?) {
            val animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            viewToAnimate?.startAnimation(animation)
        }

        override fun getItemCount(): Int {
            return reminders.size
        }
    }
}
