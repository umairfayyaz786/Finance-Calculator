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
import android.view.View
import android.widget.*
import com.finance.calculator.Fragments.BusinessSales
import com.finance.calculator.MainActivity
import com.finance.calculator.R
import com.finance.calculator.Utils.AppConstants
import com.finance.calculator.Utils.Intent
import com.finance.calculator.databinding.ActivitySalesBinding
import com.finance.smallbusinessplan.Fragments.*
import com.finance.smallbusinessplan.replaceFragmentSafely
import com.google.android.material.bottomsheet.BottomSheetDialog


@SuppressLint("StaticFieldLeak")
lateinit var bindingggggggg: ActivitySalesBinding

class Sales : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var MainMenu: Menu? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingggggggg = ActivitySalesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingggggggg.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_sales_funnel_small))

//        bannerAd=findViewById(R.id.SalesBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }

        bindingggggggg.spinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            bindingggggggg.spinner.adapter = adapter
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, itemCounter: Int, p3: Long) {
        when (itemCounter) {
            AppConstants.Fragment_Zero -> {
                replaceFragmentSafely(BusinessSales())
            }

            AppConstants.Fragment_One -> {
                replaceFragmentSafely(BusinessSales())
            }

            AppConstants.Fragment_Two -> {
                replaceFragmentSafely(EcommerceSales())
            }

            AppConstants.Fragment_Three -> {
                replaceFragmentSafely(FacetoFaceSales())
            }

            AppConstants.Fragment_Four -> {
                replaceFragmentSafely(RetailSales())
            }

            AppConstants.Fragment_Five -> {
                replaceFragmentSafely(Telesales())
            }
        }

        true
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        true
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