package com.example.pay

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_view_balance.*


class ViewBalanceFragment : Fragment(R.layout.fragment_view_balance) {

    var remainingBal = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SharedPref.init(requireContext())


        val transactionAmount = arguments?.getLong("transAmt")
        remainingBal = (tvTotalBal.text.toString().toLong() - transactionAmount!!).toInt()
        tvTotalBal.text = remainingBal.toString()


    }
}