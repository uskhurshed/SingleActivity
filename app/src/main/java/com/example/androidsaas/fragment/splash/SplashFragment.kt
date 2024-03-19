package com.example.androidsaas.fragment.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.androidsaas.R
import com.example.androidsaas.extension.PreferencesUtil.getPrefBool
import com.example.androidsaas.manager.AuthManager


class SplashFragment : Fragment(R.layout.fragment_splash) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object : CountDownTimer(2500, 1000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {


                AuthManager.isAuthorized =  getPrefBool(requireContext(),"isAuthorized",false)

                val navController = findNavController()
                when {
                    AuthManager.isAuthorized -> {
                        navController.popBackStack()
                        navController.navigate(R.id.mainFlowFragment)
                        navController.graph.setStartDestination(R.id.mainFlowFragment)
                    }
                    !AuthManager.isAuthorized -> {
                        navController.popBackStack()
                        navController.navigate(R.id.loginFlowFragment)
                        navController.graph.setStartDestination(R.id.loginFlowFragment)
                    }
                }
            }
        }.start()


    }

}