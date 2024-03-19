package com.example.androidsaas.fragment.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.androidsaas.R
import com.example.androidsaas.databinding.FragmentLoginBinding
import com.example.androidsaas.extension.NavigationExtensions.activityNavController
import com.example.androidsaas.extension.NavigationExtensions.navigateSafely
import com.example.androidsaas.extension.PreferencesUtil.setPrefBool


class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.bSignin.setOnClickListener {
            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
        }
        binding.tvSignup.setOnClickListener {
            setPrefBool(requireContext(),"isAuthorized",true)
        }
    }
}