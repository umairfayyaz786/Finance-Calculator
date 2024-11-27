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
import com.finance.calculator.databinding.FragmentEcommerceSalesBinding

@SuppressLint("StaticFieldLeak")
lateinit var bindingg: FragmentEcommerceSalesBinding

class EcommerceSales : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingg = FragmentEcommerceSalesBinding.inflate(inflater, container, false)
        val view = bindingg.root

        bindingg.calculate.setOnClickListener {
            if (bindingg.visitors.text.toString().isEmpty() || bindingg.visitors.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.visitors_must_be_required))
                return@setOnClickListener
            }
            if (bindingg.Logins.text.toString().isEmpty() || bindingg.Logins.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.logins_must_be_required))
                return@setOnClickListener
            }
            if (bindingg.Shoppers.text.toString().isEmpty() || bindingg.Shoppers.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.shoppers_must_be_required))
                return@setOnClickListener
            }
            if (bindingg.Shoppers1.text.toString().isEmpty() || bindingg.Shoppers1.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.empty_below_shoppers_must_be_required))
                return@setOnClickListener
            }
            if (bindingg.BuyersActual.text.toString()
                    .isEmpty() || bindingg.BuyersActual.text.toString().isBlank()
            ) {
                FragmentShowToast(getString(R.string.actual_buyers_must_be_required))
                return@setOnClickListener
            }
            if (bindingg.BuyersTarget.text.toString()
                    .isEmpty() || bindingg.BuyersTarget.text.toString().isBlank()
            ) {
                FragmentShowToast(getString(R.string.buyers_target_must_be_required))
                return@setOnClickListener
            }
            val Stage1 = bindingg.visitors.text.toString().toDouble()
            val Stage2 = bindingg.Logins.text.toString().toDouble()
            val Stage3 = bindingg.Shoppers.text.toString().toDouble()
            val Stage4 = bindingg.Shoppers1.text.toString().toDouble()
            val ActualBuyer = bindingg.BuyersActual.text.toString().toDouble()
            val TargetBuyer = bindingg.BuyersTarget.text.toString().toDouble()

            val visitorCovert = (Stage1 / Stage1) * 100
            bindingg.tvisitorsResult.text = visitorCovert.toString()
            val LoginsCovert = (Stage2 / Stage1 * 100)
            bindingg.tLoginsResult.text = LoginsCovert.toString()
            val SHoppersCovert = (Stage3 / Stage1 * 100)
            bindingg.ShoppersResult.text = SHoppersCovert.toString()
            val SHoppers1Covert = (Stage4 / Stage1 * 100)
            bindingg.Shoppers1Result.text = SHoppers1Covert.toString()

            val ActualBuyerConvert = (ActualBuyer / Stage1 * 100)
            bindingg.BuyersActualResult.text = ActualBuyerConvert.toString()
            val TargetSt1 = (TargetBuyer / (ActualBuyerConvert / 100))
            bindingg.tvisitorsResult.text = TargetSt1.toString()
            val TargetSt2 = (TargetSt1 * (LoginsCovert / 100))
            bindingg.tLoginsResult.text = TargetSt2.toString()
            val TargetSt3 = (TargetSt1 * (SHoppersCovert / 100))
            bindingg.tshoppersResult.text = TargetSt3.toString()
            val TargetSt4 = (TargetSt1 * (SHoppers1Covert / 100))
            bindingg.tshoppers1Result.text = TargetSt4.toString()
            val TargetBuyersCal = (TargetSt1 * (ActualBuyerConvert / 100))
            bindingg.BuyersTargetResult.text = TargetBuyersCal.toString()
        }

        bindingg.clear.setOnClickListener {
            bindingg.visitors.setText("")
            bindingg.Logins.setText("")
            bindingg.Shoppers.setText("")
            bindingg.Shoppers1.setText("")
            bindingg.BuyersActual.setText("")
            bindingg.BuyersTarget.setText("")
        }
        bindingg.formula.setOnClickListener {
            FragmentIntent(FormulasActivity::class)
        }
        return view
    }
}