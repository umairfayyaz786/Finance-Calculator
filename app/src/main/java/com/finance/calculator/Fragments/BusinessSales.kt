package com.finance.calculator.Fragments

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
import com.finance.calculator.databinding.FragmentBusinessSalesBinding


@SuppressLint("StaticFieldLeak")
lateinit var binding: FragmentBusinessSalesBinding

class BusinessSales : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBusinessSalesBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.calculate.setOnClickListener {
            if (binding.sale1.text.toString().isEmpty() || binding.sale1.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.sales_stage_1_must_be_required))
                return@setOnClickListener
            }
            if (binding.sale2.text.toString().isEmpty() || binding.sale2.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.sales_stage_2_must_be_required))
                return@setOnClickListener
            }
            if (binding.sale3.text.toString().isEmpty() || binding.sale3.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.sales_stage_3_must_be_required))
                return@setOnClickListener
            }
            if (binding.sale4.text.toString().isEmpty() || binding.sale4.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.sales_stage_4_must_be_required))
                return@setOnClickListener
            }
            if (binding.BuyersActual.text.toString()
                    .isEmpty() || binding.BuyersActual.text.toString().isBlank()
            ) {
                FragmentShowToast(getString(R.string.actual_buyers_must_be_required))
                return@setOnClickListener
            }
            if (binding.BuyersTarget.text.toString()
                    .isEmpty() || binding.BuyersTarget.text.toString().isBlank()
            ) {
                FragmentShowToast(getString(R.string.buyers_target_must_be_required))
                return@setOnClickListener
            }
            val Stage1 = binding.sale1.text.toString().toDouble()
            val Stage2 = binding.sale2.text.toString().toDouble()
            val Stage3 = binding.sale3.text.toString().toDouble()
            val Stage4 = binding.sale4.text.toString().toDouble()
            val ActualBuyer = binding.BuyersActual.text.toString().toDouble()
            val TargetBuyer = binding.BuyersTarget.text.toString().toDouble()

            val stage1Covert = (Stage1 / Stage1) * 100
            binding.stage1Result.text = stage1Covert.toString()
            val stage2Covert = (Stage2 / Stage1 * 100)
            binding.stage2Result.text = stage2Covert.toString()
            val stage3Covert = (Stage3 / Stage1 * 100)
            binding.stage3Result.text = stage3Covert.toString()
            val stage4Covert = (Stage4 / Stage1 * 100)
            binding.Stage4Result.text = stage4Covert.toString()

            val ActualBuyerConvert = (ActualBuyer / Stage1 * 100)
            binding.BuyersActualResult.text = ActualBuyerConvert.toString()
            val TargetSt1 = (TargetBuyer / (ActualBuyerConvert / 100))
            binding.Stage21Result.text = TargetSt1.toString()
            val TargetSt2 = (TargetSt1 * (stage2Covert / 100))
            binding.Stage22Result.text = TargetSt2.toString()
            val TargetSt3 = (TargetSt1 * (stage3Covert / 100))
            binding.Stage23Result.text = TargetSt3.toString()
            val TargetSt4 = (TargetSt1 * (stage4Covert / 100))
            binding.Stage24Result.text = TargetSt4.toString()
            val TargetBuyersCal = (TargetSt1 * (ActualBuyerConvert / 100))
            binding.BuyersTargetResult.text = TargetBuyersCal.toString()
        }

        binding.clear.setOnClickListener {
            binding.sale1.setText("")
            binding.sale2.setText("")
            binding.sale3.setText("")
            binding.sale4.setText("")
            binding.BuyersActual.setText("")
            binding.BuyersTarget.setText("")
        }
        binding.formula.setOnClickListener {
            FragmentIntent(FormulasActivity::class)
        }
        // Inflate the layout for this fragment
        return view
    }


}