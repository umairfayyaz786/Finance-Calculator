package com.finance.smallbusinessplan.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.finance.calculator.Activities.FormulasActivity
import com.finance.calculator.R
import com.finance.calculator.Utils.FragmentIntent
import com.finance.calculator.Utils.FragmentShowToast
import com.finance.calculator.databinding.FragmentRetailSalesBinding


@SuppressLint("StaticFieldLeak")
lateinit var bind: FragmentRetailSalesBinding

class RetailSales : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentRetailSalesBinding.inflate(inflater, container, false)
        val view = bind.root

        bind.calculate.setOnClickListener {
            if (bind.Lookers.text.toString().isEmpty() || bind.Lookers.text.toString().isBlank()) {
                FragmentShowToast(getString(R.string.windows_lookers_must_be_required))
                return@setOnClickListener
            }
            if (bind.Visitors.text.toString().isEmpty() || bind.Visitors.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.visitors_must_be_required))
                return@setOnClickListener
            }
            if (bind.Enquirers.text.toString().isEmpty() || bind.Enquirers.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.enquirers_must_be_required))
                return@setOnClickListener
            }
            if (bind.Enquirers1.text.toString().isEmpty() || bind.Enquirers1.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.empty_below_enquirers_must_be_required))
                return@setOnClickListener
            }
            if (bind.BuyersActual.text.toString().isEmpty() || bind.BuyersActual.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.actual_buyers_must_be_required))
                return@setOnClickListener
            }
            if (bind.BuyersTarget.text.toString().isEmpty() || bind.BuyersTarget.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.buyers_target_must_be_required))
                return@setOnClickListener
            }
            val Stage1 = bind.Lookers.text.toString().toDouble()
            val Stage2 = bind.Visitors.text.toString().toDouble()
            val Stage3 = bind.Enquirers.text.toString().toDouble()
            val Stage4 = bind.Enquirers1.text.toString().toDouble()
            val ActualBuyer = bind.BuyersActual.text.toString().toDouble()
            val TargetBuyer = bind.BuyersTarget.text.toString().toDouble()

            val visitorCovert = (Stage1 / Stage1) * 100
            bind.LookersResult.text = visitorCovert.toString()
            val LoginsCovert = (Stage2 / Stage1 * 100)
            bind.VisitorResult.text = LoginsCovert.toString()
            val SHoppersCovert = (Stage3 / Stage1 * 100)
            bind.EnquirersResult.text = SHoppersCovert.toString()
            val SHoppers1Covert = (Stage4 / Stage1 * 100)
            bind.Enquirers1Result.text = SHoppers1Covert.toString()

            val ActualBuyerConvert = (ActualBuyer / Stage1 * 100)
            bind.BuyersActualResult.text = ActualBuyerConvert.toString()
            val TargetSt1 = (TargetBuyer / (ActualBuyerConvert / 100))
            bind.tLookersResult.text = TargetSt1.toString()
            val TargetSt2 = (TargetSt1 * (LoginsCovert / 100))
            bind.tvisitorResult.text = TargetSt2.toString()
            val TargetSt3 = (TargetSt1 * (SHoppersCovert / 100))
            bind.tEnquirersResult.text = TargetSt3.toString()
            val TargetSt4 = (TargetSt1 * (SHoppers1Covert / 100))
            bind.tEnquirers1Result.text = TargetSt4.toString()
            val TargetBuyersCal = (TargetSt1 * (ActualBuyerConvert / 100))
            bind.BuyersTargetResult.text = TargetBuyersCal.toString()
        }

        bind.clear.setOnClickListener {
            bind.Lookers.setText("")
            bind.Visitors.setText("")
            bind.Enquirers.setText("")
            bind.Enquirers1.setText("")
            bind.BuyersActual.setText("")
            bind.BuyersTarget.setText("")
        }
        bind.formula.setOnClickListener {
            FragmentIntent(FormulasActivity::class)
        }
        return view
    }
}