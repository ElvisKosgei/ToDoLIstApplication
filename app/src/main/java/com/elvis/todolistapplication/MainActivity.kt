package com.elvis.todolistapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvAddTask : TextView = findViewById(R.id.tvAddTask)
        val etAddTask : EditText = findViewById(R.id.etAddTask)
        val btnAddTask : Button = findViewById(R.id.btnAddTask)
        val btnDeleteTask : Button = findViewById(R.id.btnDeleteTask)
        val btnClearTasks : Button = findViewById(R.id.btnClearTasks)
        val tvTitle : TextView = findViewById(R.id.tvTitle)
        val lvItems : ListView = findViewById(R.id.lvItems)
        // Initializing the array lists and the adapter
        var itemlist = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, itemlist)

        btnAddTask.setOnClickListener {
            itemlist.add(etAddTask.text.toString())
                lvItems.adapter = adapter
            adapter.notifyDataSetChanged()

            etAddTask.text.clear()

        }
        btnDeleteTask.setOnClickListener {
            val position : SparseBooleanArray = lvItems.checkedItemPositions
            val count = lvItems.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item)) {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()

        }
        btnClearTasks.setOnClickListener {
            itemlist.clear()
            adapter.notifyDataSetChanged()

        }
        lvItems.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "You selected an item --> ${itemlist.get(i)}", Toast.LENGTH_LONG).show()
        }





    }
}