package com.finance.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.finance.calculator.Activities.BreakEven
import com.finance.calculator.Activities.Cash
import com.finance.calculator.Activities.Contract
import com.finance.calculator.Activities.Creditor
import com.finance.calculator.Activities.Dabtors
import com.finance.calculator.Activities.Discount
import com.finance.calculator.Activities.Gross_profit
import com.finance.calculator.Activities.Gst_Vat
import com.finance.calculator.Activities.Margin
import com.finance.calculator.Activities.Market
import com.finance.calculator.Activities.Markup
import com.finance.calculator.Activities.NetProfit
import com.finance.calculator.Activities.Sales
import com.finance.calculator.Activities.SettingActivity
import com.finance.calculator.Utils.Intent
import com.finance.calculator.Utils.showToast
import com.finance.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var MainMenu: Menu? = null

    companion object {
        var buttonState: Boolean = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        MobileAds.initialize(this)
//        val adRequest = AdRequest.Builder().build()
//        binding.bannerAd.loadAd(adRequest)


//        if (NetworkUtils.isNetworkAvailable(this)) {
//            interstitialAds(this)
//        }
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_business_calculator_small))
        if (buttonState) {
            binding.fram1.visibility = View.GONE
            binding.fram2.visibility = View.VISIBLE
        } else {
            binding.fram2.visibility = View.GONE
            binding.fram1.visibility = View.VISIBLE
        }
        binding.creditor.setOnClickListener {
            binding.fram1.visibility = View.GONE
            binding.fram2.visibility = View.VISIBLE
            buttonState = true
        }
        binding.more2.setOnClickListener {
            binding.fram2.visibility = View.GONE
            binding.fram1.visibility = View.VISIBLE
            buttonState = false
        }
        binding.br.setOnClickListener {
            Intent(BreakEven::class)
        }
        binding.Sales.setOnClickListener {
            Intent(Sales::class)
        }
        binding.cas.setOnClickListener {
            Intent(Cash::class)
        }
        binding.cont.setOnClickListener {
            Intent(Contract::class)
        }
        binding.credit.setOnClickListener {
            Intent(Creditor::class)
        }
        binding.Debtor.setOnClickListener {
            Intent(Dabtors::class)
        }
        binding.Disc.setOnClickListener {
            Intent(Discount::class)
        }
        binding.contract.setOnClickListener {
            Intent(Gross_profit::class)
        }
        binding.margin.setOnClickListener {
            Intent(Margin::class)
        }
        binding.Market.setOnClickListener {
            Intent(Market::class)
        }
        binding.Markup.setOnClickListener {
            Intent(Markup::class)
        }
        binding.Netprofit.setOnClickListener {
            Intent(NetProfit::class)
        }
        binding.Gst.setOnClickListener {
            Intent(Gst_Vat::class)
        }
        binding.button.setOnClickListener {
            binding.editTextTextPersonName2.setText("")
            binding.editTextTextPersonName.setText("")
        }
        binding.button18.setOnClickListener {
            binding.editTextTextPersonName2.append("1")
        }
        binding.button15.setOnClickListener {
            binding.editTextTextPersonName2.append("2")
        }
        binding.button16.setOnClickListener {
            binding.editTextTextPersonName2.append("3")
        }
        binding.button14.setOnClickListener {
            binding.editTextTextPersonName2.append("4")
        }
        binding.button11.setOnClickListener {
            binding.editTextTextPersonName2.append("5")
        }
        binding.button12.setOnClickListener {
            binding.editTextTextPersonName2.append("6")
        }
        binding.button10.setOnClickListener {
            binding.editTextTextPersonName2.append("7")
        }
        binding.button7.setOnClickListener {
            binding.editTextTextPersonName2.append("8")
        }
        binding.button8.setOnClickListener {
            binding.editTextTextPersonName2.append("9")
        }
        binding.button20.setOnClickListener {
            binding.editTextTextPersonName2.append("0")
        }
        binding.button19.setOnClickListener {
            try {
                val lastIndex =
                    binding.editTextTextPersonName2.text.toString().toCharArray().size - 1
                val lastChar =
                    binding.editTextTextPersonName2.text.toString().toCharArray()[lastIndex]
                if ((lastChar.compareTo('.') == 0) or (lastChar.compareTo('-') == 0) or (lastChar.compareTo(
                        '+'
                    ) == 0) or (lastChar.compareTo('*') == 0) or (lastChar.compareTo('/') == 0)
                ) {
                    Log.d("Tag", "onCreate: $lastIndex  : $lastChar")
                } else {
                    binding.editTextTextPersonName2.append(".")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        binding.button22.setOnClickListener {
            try {
                val lastIndex =
                    binding.editTextTextPersonName2.text.toString().toCharArray().size - 1
                val lastChar =
                    binding.editTextTextPersonName2.text.toString().toCharArray()[lastIndex]
                if ((lastChar.compareTo('.') == 0) or (lastChar.compareTo('-') == 0) or (lastChar.compareTo(
                        '+'
                    ) == 0) or (lastChar.compareTo('*') == 0) or (lastChar.compareTo('/') == 0)
                ) {
                    Log.d("Tag", "onCreate: $lastIndex  : $lastChar")
                } else {
                    binding.editTextTextPersonName2.append("/")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        binding.button13.setOnClickListener {
            try {
                val lastIndex =
                    binding.editTextTextPersonName2.text.toString().toCharArray().size - 1
                val lastChar =
                    binding.editTextTextPersonName2.text.toString().toCharArray()[lastIndex]
                if ((lastChar.compareTo('.') == 0) or (lastChar.compareTo('-') == 0) or (lastChar.compareTo(
                        '+'
                    ) == 0) or (lastChar.compareTo('*') == 0) or (lastChar.compareTo('/') == 0)
                ) {
                    Log.d("Tag", "onCreate: $lastIndex  : $lastChar")
                } else {
                    binding.editTextTextPersonName2.append("+")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        binding.button9.setOnClickListener {
            try {
                val lastIndex =
                    binding.editTextTextPersonName2.text.toString().toCharArray().size - 1
                val lastChar =
                    binding.editTextTextPersonName2.text.toString().toCharArray()[lastIndex]
                if ((lastChar.compareTo('.') == 0) or (lastChar.compareTo('-') == 0) or (lastChar.compareTo(
                        '+'
                    ) == 0) or (lastChar.compareTo('*') == 0) or (lastChar.compareTo('/') == 0)
                ) {
                    Log.d("Tag", "onCreate: $lastIndex  : $lastChar")
                } else {
                    binding.editTextTextPersonName2.append("-")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                binding.editTextTextPersonName2.append("-")
            }
        }
        binding.button23.setOnClickListener {
            try {
                val lastIndex =
                    binding.editTextTextPersonName2.text.toString().toCharArray().size - 1
                val lastChar =
                    binding.editTextTextPersonName2.text.toString().toCharArray()[lastIndex]
                if ((lastChar.compareTo('.') == 0) or (lastChar.compareTo('-') == 0) or (lastChar.compareTo(
                        '+'
                    ) == 0) or (lastChar.compareTo('*') == 0) or (lastChar.compareTo('/') == 0)
                ) {
                    Log.d("Tag", "onCreate: $lastIndex  : $lastChar")
                } else {
                    binding.editTextTextPersonName2.append("*")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        binding.button6.setOnClickListener {
            binding.editTextTextPersonName2.append("/1.2")
        }
        binding.button5.setOnClickListener {
            binding.editTextTextPersonName2.append("*1.2")
        }

        binding.button21.setOnClickListener {
            if (binding.editTextTextPersonName2.text.toString()
                    .isEmpty() or binding.editTextTextPersonName2.text.toString().isBlank()
            ) {
                showToast(getString(R.string.please_enter_any_expression))
                return@setOnClickListener
            }

            try {
                val expression =
                    ExpressionBuilder(binding.editTextTextPersonName2.text.toString()).build()
                val result = expression.evaluate().toLong()
                val longresult = result
                if (result == longresult) {
                    binding.editTextTextPersonName.setText(longresult.toString())
                    binding.editTextTextPersonName2.text = (longresult.toString())
                } else {
                    binding.editTextTextPersonName.setText(result.toString())
                    binding.editTextTextPersonName2.text = (result.toString())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                showToast(getString(R.string.please_enter_valid_expression))
            }
        }
        binding.button4.setOnClickListener() {
            val v = binding.editTextTextPersonName2.text.toString()
            if (v.isNotEmpty()) {
                binding.editTextTextPersonName2.text = v.dropLast(1)
            }
            binding.editTextTextPersonName.setText("")
        }
        //Will clear input and ouput field

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.ReviewsAction) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.kachariya.smallbusinessplan")
                )
            )
        }
        if (item.itemId == R.id.SettingsAction) {
            Intent(SettingActivity::class)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        MainMenu = menu
        menuInflater.inflate(R.menu.calculator_action_items, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onBackPressed() {
//        val intent = Intent(this , Main::class.java)
//        startActivity(intent)
    }
}