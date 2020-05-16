package com.example.campusfacilitator.ui.home.freeslots

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import com.example.campusfacilitator.R
import com.example.campusfacilitator.databinding.FragmentFreeSlotsBinding
import kotlinx.android.synthetic.main.activity_login.*

class FreeSlotsFragment : Fragment() {
    lateinit var fileName: String
    lateinit var binding: FragmentFreeSlotsBinding
    var pressed: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_free_slots, container, false)

        binding.chooseFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            startActivityForResult(intent, 7)
        }
        binding.uploadFile.setOnClickListener{
            when(pressed) {
                0->binding.linearLayout1.visibility = View.VISIBLE

                1->{
                    binding.linearLayout1.visibility = View.GONE
                    binding.linearLayout2.visibility = View.VISIBLE
                }
            }
            pressed++
        }
        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            7 -> {
                if(resultCode==RESULT_OK){
                    fileName = data?.data?.lastPathSegment.toString()
                    binding.chooseFile.text = fileName
                    print(fileName)
                }
            }
        }
    }


}
