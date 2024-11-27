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
import com.finance.calculator.databinding.ActivityMarkupBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


@SuppressLint("StaticFieldLeak")
lateinit var bindingggggg: ActivityMarkupBinding

class Markup : AppCompatActivity() {
    private var MainMenu: Menu? = null
    private lateinit var sharedPref: SharedPref

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingggggg = ActivityMarkupBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingggggg.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_markup_small))
        sharedPref = SharedPref(this)

//        bannerAd=findViewById(R.id.MarkupBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }
        bindingggggg.tax.setText(sharedPref.getIntegerValue(AppConstants.TEXT_KEY).toString())
        bindingggggg.calculate.setOnClickListener {
            if (bindingggggg.costPrice.text.toString()
                    .isEmpty() || bindingggggg.costPrice.text.toString().isBlank()
            ) {
                showToast(getString(R.string.cost_price_must_be_required))
                return@setOnClickListener
            }
            if (bindingggggg.Markuppercent.text.toString()
                    .isEmpty() || bindingggggg.Markuppercent.text.toString().isBlank()
            ) {
                showToast(getString(R.string.markup_must_be_required))
                return@setOnClickListener
            }
            if (bindingggggg.tax.text.toString().isEmpty() || bindingggggg.tax.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.gst_vst_must_be_required))
                return@setOnClickListener
            }

            val cost_pricee = bindingggggg.costPrice.text.toString().toDouble()
            val Markuppercentt = bindingggggg.Markuppercent.text.toString().toDouble()
            val taxxx = bindingggggg.tax.text.toString().toDouble()
            sharedPref.setIntegerValue(AppConstants.TEXT_KEY, taxxx)

            val salesnetprice = (cost_pricee + (cost_pricee * (Markuppercentt / 100)))
            bindingggggg.SalesnetpriceResult.text = salesnetprice.toString()
            val tax = salesnetprice * (taxxx / 100)
            bindingggggg.taxResult.text = tax.toString()
            val Marginpercent = ((salesnetprice - cost_pricee) / salesnetprice) * 100
            bindingggggg.MarginpercentResult.text = Marginpercent.toString()
            val Grossprofitpercent = (salesnetprice - cost_pricee)
            bindingggggg.GrossprofittResult.text = Grossprofitpercent.toString()
            val SalesGrossPrice = (salesnetprice + tax)
            bindingggggg.SalesgrosspriceResult.text = SalesGrossPrice.toString()
        }
        bindingggggg.formula.setOnClickListener {
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