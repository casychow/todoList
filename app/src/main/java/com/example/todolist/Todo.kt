package com.example.todolist

data class Todo(
    //data class means we won't write any logic in this class - only contain properties
    val title: String,
    var isChecked: Boolean = false
)