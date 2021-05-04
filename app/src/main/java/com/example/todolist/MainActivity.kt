package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

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
    }
}