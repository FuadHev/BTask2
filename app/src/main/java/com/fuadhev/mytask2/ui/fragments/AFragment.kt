package com.fuadhev.mytask2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fuadhev.mytask2.R
import com.fuadhev.mytask2.common.base.BaseFragment
import com.fuadhev.mytask2.databinding.FragmentABinding


class AFragment : BaseFragment<FragmentABinding>(FragmentABinding::inflate) {




    override fun onCreateFinish() {

    }

    override fun setupListeners() {
        binding.btnGoB.setOnClickListener{
            findNavController().navigate(AFragmentDirections.actionAFragmentToBFragment())
        }
    }
}