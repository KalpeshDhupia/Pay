package com.example.pay

import android.content.Context
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

        val sharedPreferences =
            this.activity?.getSharedPreferences("REM_BAL_INFO", Context.MODE_PRIVATE)

        val editor = sharedPreferences?.edit()
        editor?.putLong("Rem_Bal", remainingBal.toLong())
        editor?.apply()

        remainingBal = sharedPreferences?.getLong("Rem_Bal",0)?.toInt()!!

        val transactionAmount = arguments?.getLong("transAmt")
        remainingBal = (tvTotalBal.text.toString().toLong() - transactionAmount!!).toInt()
        tvTotalBal.text = remainingBal.toString()





    }
}