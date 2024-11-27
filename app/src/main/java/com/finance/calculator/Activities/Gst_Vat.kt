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
import com.finance.calculator.databinding.ActivityGstVatBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


@SuppressLint("StaticFieldLeak")
lateinit var bindinggg: ActivityGstVatBinding

class Gst_Vat : AppCompatActivity() {
    private var MainMenu: Menu? = null
    private lateinit var sharedPref: SharedPref

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        bindinggg = ActivityGstVatBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindinggg.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_gst_vat_small))
        sharedPref = SharedPref(this)

//        bannerAd=findViewById(R.id.GstBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }

        bindinggg.tax1.setText(sharedPref.getIntegerValue(AppConstants.TEXT_KEY).toString())
        bindinggg.taxPercent.setText(sharedPref.getIntegerValue(AppConstants.TEXT_KEY).toString())
        bindinggg.calculate.setOnClickListener {
            if (bindinggg.salesNetPrice.text.toString()
                    .isEmpty() || bindinggg.salesNetPrice.text.toString().isBlank()
            ) {
                showToast(getString(R.string.sales_net_price_must_be_required))
                return@setOnClickListener
            }
            if (bindinggg.tax1.text.toString().isEmpty() || bindinggg.tax1.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.gst_vst_must_be_required))
                return@setOnClickListener
            }

            val sales_net_pricee = bindinggg.salesNetPrice.text.toString().toDouble()
            val tax11 = bindinggg.tax1.text.toString().toDouble()

            val tax_one = ((sales_net_pricee) * (tax11 / 100))
            bindinggg.tax1Result.text = tax_one.toString()
            sharedPref.setIntegerValue(AppConstants.TEXT_KEY, tax_one)

            val salesgrossprice = sales_net_pricee + tax_one
            bindinggg.salesgrosspriceResult.text = salesgrossprice.toString()
        }

        bindinggg.calculate2.setOnClickListener {
            if (bindinggg.salesGrossProfit.text.toString()
                    .isEmpty() || bindinggg.salesGrossProfit.text.toString().isBlank()
            ) {
                showToast(getString(R.string.sales_gross_price_must_be_required))
                return@setOnClickListener
            }
            if (bindinggg.taxPercent.text.toString()
                    .isEmpty() || bindinggg.taxPercent.text.toString().isBlank()
            ) {
                showToast(getString(R.string.gst_vst_must_be_required))
                return@setOnClickListener
            }
            val sales_gross_profitt = bindinggg.salesGrossProfit.text.toString().toDouble()
            val tax_percentt = bindinggg.taxPercent.text.toString().toDouble()

            val tax_two =
                ((sales_gross_profitt) - (sales_gross_profitt / (1 + (tax_percentt / 100))))
            bindinggg.tax2Result.text = tax_two.toString()
            sharedPref.setIntegerValue(AppConstants.TEXT_KEY, tax_two)

            val salesnetprice = sales_gross_profitt - tax_two
            bindinggg.salesnetpriceResult.text = salesnetprice.toString()
        }
        bindinggg.formula.setOnClickListener {
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
}