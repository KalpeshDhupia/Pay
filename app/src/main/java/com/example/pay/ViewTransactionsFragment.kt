package com.example.pay

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.View

import androidx.navigation.fragment.navArgs

import kotlinx.android.synthetic.main.fragment_view_transactions.view.*


class ViewTransactionsFragment : Fragment(R.layout.fragment_view_transactions) {

    private val args: ViewTransactionsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transactionAmount = args.transcationAmt

        view.transactionAmt.text = transactionAmount.toString()

    }
}