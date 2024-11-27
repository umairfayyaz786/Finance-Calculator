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
import com.finance.calculator.Utils.AppConstants
import com.finance.calculator.Utils.Intent
import com.finance.calculator.Utils.SharedPref
import com.finance.calculator.Utils.showToast
import com.finance.calculator.databinding.ActivityMarginBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

@SuppressLint("StaticFieldLeak")
lateinit var bindingggg: ActivityMarginBinding

class Margin : AppCompatActivity() {
    private var MainMenu: Menu? = null
    private lateinit var sharedPref: SharedPref

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingggg = ActivityMarginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingggg.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_margin_small))
        sharedPref = SharedPref(this)

//        bannerAd=findViewById(R.id.MarginBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }

        bindingggg.tax.setText(sharedPref.getIntegerValue(AppConstants.TEXT_KEY).toString())
        bindingggg.calculate.setOnClickListener {
            if (bindingggg.salesGrossPrice.text.toString()
                    .isEmpty() || bindingggg.salesGrossPrice.text.toString().isBlank()
            ) {
                showToast(getString(R.string.sales_gross_price_must_be_required))
                return@setOnClickListener
            }
            if (bindingggg.tax.text.toString().isEmpty() || bindingggg.tax.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.gst_vst_must_be_required))
                return@setOnClickListener
            }
            if (bindingggg.costPrice.text.toString()
                    .isEmpty() || bindingggg.costPrice.text.toString().isBlank()
            ) {
                showToast(getString(R.string.cost_price_must_be_required))
                return@setOnClickListener
            }
            val sales_Gross_Pricee = bindingggg.salesGrossPrice.text.toString().toDouble()
            val taxx = bindingggg.tax.text.toString().toDouble()
            val cost_pricee = bindingggg.costPrice.text.toString().toDouble()
            sharedPref.setIntegerValue(AppConstants.TEXT_KEY, cost_pricee)

            val salesnetprice =
                (sales_Gross_Pricee - (sales_Gross_Pricee - (sales_Gross_Pricee / ((1 + (taxx) / 100)))))
            bindingggg.SalesNetPriceResult.text = salesnetprice.toString()
            val grossprofit = (salesnetprice - cost_pricee)
            bindingggg.GrossProfitResult.text = grossprofit.toString()
            val markup = (((salesnetprice - cost_pricee) / cost_pricee) * 100)
            bindingggg.MarkupPercentResult.text = markup.toString()
            val margin = (((salesnetprice - cost_pricee) / salesnetprice) * 100)
            bindingggg.MarginPercentResult.text = margin.toString()
        }
        bindingggg.formula.setOnClickListener {
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