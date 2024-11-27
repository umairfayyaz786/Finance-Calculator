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
import android.widget.*

import com.finance.calculator.MainActivity
import com.finance.calculator.R
import com.finance.calculator.Utils.Intent
import com.finance.calculator.Utils.showToast
import com.finance.calculator.databinding.ActivityCashBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

@SuppressLint("StaticFieldLeak")
lateinit var bind: ActivityCashBinding

class Cash : AppCompatActivity() {
    private var MainMenu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        bind = ActivityCashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bind.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_cash_small))

//        bannerAd=findViewById(R.id.CashBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }

        bind.calculate.setOnClickListener {
            if (bind.saless.text.toString().isEmpty() || bind.saless.text.toString().isBlank()) {
                showToast(getString(R.string.sales_must_be_required))
                return@setOnClickListener
            }
            if (bind.days.text.toString().isEmpty() || bind.days.text.toString().isBlank()) {
                showToast(getString(R.string.customer_days_credit_must_be_required))
                return@setOnClickListener
            }
            if (bind.CostOfSaless.text.toString().isEmpty() || bind.CostOfSaless.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.cost_of_sales_must_be_required))
                return@setOnClickListener
            }
            if (bind.Expenses.text.toString().isEmpty() || bind.Expenses.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.expenses_must_be_required))
                return@setOnClickListener
            }
            if (bind.SuplierDaysCredit.text.toString()
                    .isEmpty() || bind.SuplierDaysCredit.text.toString().isBlank()
            ) {
                showToast(getString(R.string.supplier_days_credit_must_be_required))
                return@setOnClickListener
            }
            val sales_per_year = bind.saless.text.toString().toDouble()
            val Customer_Days_credit = bind.days.text.toString().toDouble()
            val Cost_of_sales_per_year = bind.CostOfSaless.text.toString().toDouble()
            val Expens = bind.Expenses.text.toString().toDouble()
            val Supplier_days_creditt = bind.SuplierDaysCredit.text.toString().toDouble()


            val Debtors = (((sales_per_year) / 365) * Customer_Days_credit) * -1
            bind.DebtorsResult.text = Debtors.toString()

            val creditors = (((Cost_of_sales_per_year) / 365) * Supplier_days_creditt)
            bind.CreditorResult.text = creditors.toString()

            val OperatingProfit = sales_per_year - Cost_of_sales_per_year - Expens

            val netCash = Debtors + creditors + OperatingProfit
            bind.NetcashResult.text = netCash.toString()
        }
        bind.formula.setOnClickListener {
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