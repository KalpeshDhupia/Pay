package com.example.pay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        var transactionAmount = arguments?.getLong("amount")
        btn_view_balance.setOnClickListener {
            val bundle = Bundle()
            if (transactionAmount != null) {
                bundle.putLong("transAmt", transactionAmount)
            }
            /* val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment(transactionAmount)
             navController.navigate(action)*/
            findNavController().navigate(R.id.action_homeFragment_to_viewBalanceFragment, bundle)

            /* val action = transactionAmount?.let { it1 ->
                 HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment(
                     it1
                 )
             }
             if (action != null) {
                 navController.navigate(action)
             }*/
        }

        btn_transactions.setOnClickListener {

            val action = transactionAmount?.let { it1 ->
                HomeFragmentDirections.actionHomeFragmentToViewTransactionsFragment(
                    it1
                )
            }
            if (action != null) {
                navController.navigate(action)
            } else {
                Toast.makeText(requireContext(), "Please make transaction", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        btn_send_money.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navController.navigate(action)
        }


    }
}