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
import com.finance.calculator.databinding.ActivityGrossProfitBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


@SuppressLint("StaticFieldLeak")
lateinit var bindingg: ActivityGrossProfitBinding

class Gross_profit : AppCompatActivity() {
    private var MainMenu: Menu? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingg = ActivityGrossProfitBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingg.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_gross_profit_small))

//        bannerAd=findViewById(R.id.GrossProfitBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }
        bindingg.calculate.setOnClickListener {
            if (bindingg.sales.text.toString().isEmpty() || bindingg.sales.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.sales_must_be_required))
                return@setOnClickListener
            }
            if (bindingg.CostOfSales.text.toString()
                    .isEmpty() || bindingg.CostOfSales.text.toString().isBlank()
            ) {
                showToast(getString(R.string.cost_of_sales_must_be_required))
                return@setOnClickListener
            }
            val Cost_of_sales_per_year = bindingg.sales.text.toString().toDouble()
            val Cost_of_sales = bindingg.CostOfSales.text.toString().toDouble()
            val Gross_profit = Cost_of_sales_per_year - Cost_of_sales
            bindingg.GrossProfitResult.text = Gross_profit.toString()
            val Gross_profit_Percentage = (Gross_profit / Cost_of_sales_per_year) * 100
            bindingg.GrossProfitpercentageResult.text = Gross_profit_Percentage.toString()

        }
        bindingg.formula.setOnClickListener {
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