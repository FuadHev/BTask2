package com.fuadhev.mytask2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fuadhev.mytask2.R
import com.fuadhev.mytask2.common.base.BaseFragment
import com.fuadhev.mytask2.databinding.FragmentDBinding
import com.google.android.material.tabs.TabLayoutMediator


class DFragment : BaseFragment<FragmentDBinding>(FragmentDBinding::inflate) {


    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentList.add(EFragment())
        fragmentList.add(FFragment())

        fragmentTitleList.add("E Fragment")
        fragmentTitleList.add("F Fragment")
    }

    override fun onCreateFinish() {
        setTabLayoutManager()


    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
    }

    private fun setTabLayoutManager() {
        val adapter = MyViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = fragmentTitleList[position]

        }.attach()

    }

}