package com.finance.calculator.Activities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.finance.calculator.MainActivity
import com.finance.calculator.R
import com.finance.calculator.Utils.Intent
import com.finance.calculator.Utils.showToast
import com.finance.calculator.databinding.ActivityBreakEvenBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityBreakEvenBinding

class BreakEven : AppCompatActivity() {
    private var MainMenu: Menu? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBreakEvenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_breakeven_small))


//        bannerAd = findViewById(R.id.BreakEvenBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }

        binding.calculate.setOnClickListener {
            if (binding.sale.text.toString().isEmpty() || binding.sale.text.toString().isBlank()) {
                showToast(getString(R.string.sales_must_be_required))
                return@setOnClickListener
            }
            if (binding.CostOfSale.text.toString().isEmpty() || binding.CostOfSale.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.cost_of_sales_must_be_required))
                return@setOnClickListener
            }
            if (binding.Expenses.text.toString().isEmpty() || binding.Expenses.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.expenses_must_be_required))
                return@setOnClickListener
            }
            if (binding.depreciation.text.toString()
                    .isEmpty() || binding.depreciation.text.toString().isBlank()
            ) {
                showToast(getString(R.string.depreciation_must_be_required))
                return@setOnClickListener
            }

            val ssales = binding.sale.text.toString().toDouble()
            val sales_costt = binding.CostOfSale.text.toString().toDouble()
            val Expensess = binding.Expenses.text.toString().toDouble()
            val depreciationn = binding.depreciation.text.toString().toDouble()

            val Total_Expenses = Expensess + depreciationn

            val Gross_profit = ssales - sales_costt
            val Gross_profit_Percentage = (Gross_profit / ssales) * 100

            val BreakEven_Sales = (Total_Expenses / (Gross_profit_Percentage / 100))
            binding.BreakevensalesResult.text = BreakEven_Sales.toString()

            val BreakEven_Sales_Percent = ((BreakEven_Sales / ssales) * 100)
            binding.BreakevensalespercentResult.text = BreakEven_Sales_Percent.toString()
            val BreakEven_Days = (BreakEven_Sales / (ssales / 365))
            binding.BreakevendaysResult.text = BreakEven_Days.toString()
        }
        binding.formula.setOnClickListener {
            Intent(FormulasActivity::class)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Intent(MainActivity::class)
        }
        if (item.itemId == R.id.ReviewsAction) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.kachariya.smallbusinessplan")
                )
            )
        }
        if (item.itemId == R.id.QuestionAction) {
            showBottomSheetDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    fun showBottomSheetDialog() {

        val bottomSheetDialog = BottomSheetDialog(this)
        val viewLayout = LayoutInflater.from(this).inflate(R.layout.bottom_sheet, null)
        bottomSheetDialog.setContentView(viewLayout)
        bottomSheetDialog.show()
        val close: TextView = viewLayout.findViewById(R.id.close_bottom_sheet)
        close.setOnClickListener {
            bottomSheetDialog.dismiss()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        MainMenu = menu
        menuInflater.inflate(R.menu.calculator_activities_items, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        Intent(MainActivity::class)
    }
}