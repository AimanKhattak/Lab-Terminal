package com.example.practice

import android.app.AlertDialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class StudentAdapter(private val context: Context, private val data: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val studentName: TextView = itemView.findViewById(R.id.studentName)
        val studentRegistrationNumber: TextView = itemView.findViewById(R.id.studentRegistrationNumber)
        val studentPhoneNumber: TextView = itemView.findViewById(R.id.studentPhoneNumberItem)
        val sendButton: Button = itemView.findViewById(R.id.sendButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.student_list, null, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = data[position]
        val alertDialog = AlertDialog.Builder(context)
        holder.apply {
            studentName.text = student.name
            studentRegistrationNumber.text = student.registrationNumber
            studentPhoneNumber.text = student.phoneNumber
            sendButton.setOnClickListener{
//                Log.d("Studentdapter", "$position")
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
