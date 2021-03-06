package com.example.campusfacilitator.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.campusfacilitator.R
import com.example.campusfacilitator.data.db.entities.User
import com.example.campusfacilitator.databinding.ActivitySignupBinding
import com.example.campusfacilitator.ui.home.HomeActivity
import com.example.campusfacilitator.util.hide
import com.example.campusfacilitator.util.show
import com.example.campusfacilitator.util.snackbar
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SignupActivity : AppCompatActivity(),AuthListener, KodeinAware {
    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignupBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user->
            if(user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }
    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {

        progress_bar.hide()

        /*
        loginResponse.observe(this, Observer {
            progress_bar.hide()
            toast(it)
        })
        */
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}
