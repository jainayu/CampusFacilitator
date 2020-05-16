package com.example.campusfacilitator.ui.home.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.example.campusfacilitator.R
import com.example.campusfacilitator.databinding.FragmentSearchBinding
import org.kodein.di.android.x.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class SearchFragment: Fragment(), KodeinAware {

    override val kodein by kodein()
    //private val factory: ProfileViewModelFactory by instance()
    //private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentSearchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        binding.tech1.setOnClickListener {
            binding.linearLayout.visibility = View.GONE
            binding.linearLayout1.visibility = View.VISIBLE
        }
        binding.tech2.setOnClickListener {
            binding.linearLayout.visibility = View.GONE
            binding.linearLayout1.visibility = View.GONE
            binding.linearLayout2.visibility = View.VISIBLE
        }

        return binding.root
    }
}