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
import com.finance.calculator.databinding.FragmentTelesalesBinding


@SuppressLint("StaticFieldLeak")
lateinit var bindi: FragmentTelesalesBinding

class Telesales : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindi = FragmentTelesalesBinding.inflate(inflater, container, false)
        val view = bindi.root

        bindi.calculate.setOnClickListener {
            if (bindi.Leads.text.toString().isEmpty() || bindi.Leads.text.toString().isBlank()) {
                FragmentShowToast(getString(R.string.leads_must_be_required))
                return@setOnClickListener
            }
            if (bindi.Calls.text.toString().isEmpty() || bindi.Calls.text.toString().isBlank()) {
                FragmentShowToast(getString(R.string.calls_must_be_required))
                return@setOnClickListener
            }
            if (bindi.Answers.text.toString().isEmpty() || bindi.Answers.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.answers_must_be_required))
                return@setOnClickListener
            }
            if (bindi.Answers1.text.toString().isEmpty() || bindi.Answers1.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.empty_below_answers_must_be_required))
                return@setOnClickListener
            }
            if (bindi.BuyersActual.text.toString().isEmpty() || bindi.BuyersActual.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.actual_buyers_must_be_required))
                return@setOnClickListener
            }
            if (bindi.BuyersTarget.text.toString().isEmpty() || bindi.BuyersTarget.text.toString()
                    .isBlank()
            ) {
                FragmentShowToast(getString(R.string.buyers_target_must_be_required))
                return@setOnClickListener
            }
            val Stage1 = bindi.Leads.text.toString().toDouble()
            val Stage2 = bindi.Calls.text.toString().toDouble()
            val Stage3 = bindi.Answers.text.toString().toDouble()
            val Stage4 = bindi.Answers1.text.toString().toDouble()
            val ActualBuyer = bindi.BuyersActual.text.toString().toDouble()
            val TargetBuyer = bindi.BuyersTarget.text.toString().toDouble()

            val visitorCovert = (Stage1 / Stage1) * 100
            bindi.LeadsResult.text = visitorCovert.toString()
            val LoginsCovert = (Stage2 / Stage1 * 100)
            bindi.CallsResult.text = LoginsCovert.toString()
            val SHoppersCovert = (Stage3 / Stage1 * 100)
            bindi.AnswersResult.text = SHoppersCovert.toString()
            val SHoppers1Covert = (Stage4 / Stage1 * 100)
            bindi.Answers1Result.text = SHoppers1Covert.toString()

            val ActualBuyerConvert = (ActualBuyer / Stage1 * 100)
            bindi.BuyersActualResult.text = ActualBuyerConvert.toString()
            val TargetSt1 = (TargetBuyer / (ActualBuyerConvert / 100))
            bindi.tLeadsResult.text = TargetSt1.toString()
            val TargetSt2 = (TargetSt1 * (LoginsCovert / 100))
            bindi.tCallsResult.text = TargetSt2.toString()
            val TargetSt3 = (TargetSt1 * (SHoppersCovert / 100))
            bindi.tAnswersResult.text = TargetSt3.toString()
            val TargetSt4 = (TargetSt1 * (SHoppers1Covert / 100))
            bindi.tAnswers1Result.text = TargetSt4.toString()
            val TargetBuyersCal = (TargetSt1 * (ActualBuyerConvert / 100))
            bindi.BuyersTargetResult.text = TargetBuyersCal.toString()
        }

        bindi.clear.setOnClickListener {
            bindi.Leads.setText("")
            bindi.Calls.setText("")
            bindi.Answers.setText("")
            bindi.Answers1.setText("")
            bindi.BuyersActual.setText("")
            bindi.BuyersTarget.setText("")
        }
        bindi.formula.setOnClickListener {
            FragmentIntent(FormulasActivity::class)
        }
        return view
    }
}