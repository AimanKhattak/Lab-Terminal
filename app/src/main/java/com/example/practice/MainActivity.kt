package com.example.practice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View.inflate
import android.widget.Adapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.practice.databinding.ActivityAirplaneMode2Binding.inflate
import com.example.practice.databinding.ActivityMainBinding.inflate
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    BroadcastReceiver receiver = new BroadcastReceiver()

    companion object{
        private const val HOST_URL = "https://run.mocky.io/v3/248900cb-ec8f-4290-a4f8-f90ef42f7655"
        
    }
    private lateinit var binding : ActivityMainbinding

    private lateinit var volleyQueue: RequestQueue
    private lateinit var sendButton : Button

    private lateinit var studentAdapter: Adapter: StudentAdapter
            private var data = mutableListOf<Student>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        studentAdapter = StudentAdapter(this, data)
        volleyQueue = Volley.newRequestQueue(this)

        volleyRequestQueue.add(JsonArrayRequest(
            Request.Method.GET,
            HOST_URL,
            null, { jsonArray->
                data.addAll(NetworkResponseParser.parseStudentsList(jsonArray))
                studentAdapter.notifyItemInserted(0)
                binding.requestStatusText.visibility = View.GONE
            }, {
                val errorMessage = getString(R.string.loading_students_error)
                Snackbar.make(this, binding.root,
                    errorMessage, Snackbar.LENGTH_SHORT).show()
                binding.requestStatusText.text = errorMessage
            }
        ))

        binding.studentRecyclerView.apply {
            adapter = studentAdapter
            val context = null
            val layoutManager = LinearLayoutManager(context)
            this.layoutManager = layoutManager
            addItemDecoration(
                DividerItemDecoration(
                    this.context,
                    layoutManager.orientation
                )
            )
        }


        sendButton.setOnClickListener{
            Intent(this,ServiceClass::class.java).also {
                startService(it)
                val txt1 = null
                txt1.text="Service started"
            }
        }
        sendButton.setOnClickListener{
            Intent(this,ServiceClass::class.java).also {
                stopService(it)

                val txt1 = null
                txt1.text="Service stoped"
            }
        }
        sendButton.setOnClickListener{
            Intent(this,ServiceClass::class.java).also{
                val edit = null
                val data= edit.text.toString()
                it.putExtra("Extra data",data)
                startService(it)

            }
        }



    }




    }
}