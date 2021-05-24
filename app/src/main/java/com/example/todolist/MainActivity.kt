package com.example.todolist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    val launchSecondActivity = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvToDoItems.adapter = todoAdapter
        //todoAdapter takes info from default rv adapter
        //this rv adapter is singling out to use this specific adapter
        rvToDoItems.layoutManager = LinearLayoutManager(this)
        //linearlayourmanager = normal list

        btnAddToDo.setOnClickListener {
            val todoTitle = etToDoTitle.text.toString() //getting input from user
            //text is an "Editable" so we need to convert to string
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addToDo(todo)
                etToDoTitle.text.clear()
                //clearing entry in the EditText view (bottom left corner field
            }
        }
        
        btnDeleteDone.setOnClickListener {
            todoAdapter.deleteDoneToDos()
            //WHY DO I NEED AN ADAPTER
        }

        btnCal.setOnClickListener {
            val intent = Intent(this, calendarActivity::class.java)
            startActivityForResult(intent, launchSecondActivity)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //why did adding a question mark to the last Intent fix this issue?
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == launchSecondActivity) {
            if (resultCode == RESULT_OK) {
                //go to second activity - NOT COMPLETE YET
                val result = data?.getStringExtra("result")
            }
            /*if (resultCode == RESULT_CANCELED) {
                //do we need this one?
            }

             */
        }
    } //onActivityResult


    /*fun goToCal(view: View) {
        val launchSecondActivity = 1
        val intent = Intent(this, calendarActivity::class.java)
        //startActivity(intent)
        startActivityForResult(intent, launchSecondActivity)
    }
    */
}