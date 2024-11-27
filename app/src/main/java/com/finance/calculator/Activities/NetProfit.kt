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
import com.finance.calculator.databinding.ActivityNetProfitBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


@SuppressLint("StaticFieldLeak")
lateinit var bindinggggggg: ActivityNetProfitBinding

class NetProfit : AppCompatActivity() {
    private var MainMenu: Menu? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        bindinggggggg = ActivityNetProfitBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindinggggggg.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_net_profit_small))

//        bannerAd=findViewById(R.id.NetProfitBannerAd)
////        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }
        bindinggggggg.calculate.setOnClickListener {
            if (bindinggggggg.Saless.text.toString()
                    .isEmpty() || bindinggggggg.Saless.text.toString().isBlank()
            ) {
                showToast(getString(R.string.sales_must_be_required))
                return@setOnClickListener
            }
            if (bindinggggggg.COstOfSalesss.text.toString()
                    .isEmpty() || bindinggggggg.COstOfSalesss.text.toString().isBlank()
            ) {
                showToast(getString(R.string.cost_of_sales_credit_must_be_required))
                return@setOnClickListener
            }
            if (bindinggggggg.Depreciation.text.toString()
                    .isEmpty() || bindinggggggg.Depreciation.text.toString().isBlank()
            ) {
                showToast(getString(R.string.depreciation_must_be_required))
                return@setOnClickListener
            }
            if (bindinggggggg.Expenses.text.toString()
                    .isEmpty() || bindinggggggg.Expenses.text.toString().isBlank()
            ) {
                showToast(getString(R.string.expenses_must_be_required))
                return@setOnClickListener
            }
            val sales_per_year = bindinggggggg.Saless.text.toString().toDouble()
            val Cost_of_sales_per_year = bindinggggggg.COstOfSalesss.text.toString().toDouble()
            val Expense = bindinggggggg.Expenses.text.toString().toDouble()
            val Dep = bindinggggggg.Depreciation.text.toString().toDouble()


            val Gross_Profit = sales_per_year - Cost_of_sales_per_year

            val Total_Expenses = Expense + Dep

            val Net_Profitt = Gross_Profit - Total_Expenses
            bindinggggggg.NetProfit.text = Net_Profitt.toString()

            val Net_Profit_Percentage = (Net_Profitt / sales_per_year) * 100
            bindinggggggg.NetProfitPercent.text = Net_Profit_Percentage.toString()
        }
        bindinggggggg.formula.setOnClickListener {
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