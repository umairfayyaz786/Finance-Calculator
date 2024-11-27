package com.finance.calculator.Activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
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
import com.finance.calculator.databinding.ActivityContractBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

@SuppressLint("StaticFieldLeak")
lateinit var bindin: ActivityContractBinding

class Contract : AppCompatActivity() {
    private lateinit var sharedPref: SharedPref
    private var MainMenu: Menu? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        bindin = ActivityContractBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindin.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_contract_validity_small))

        sharedPref = SharedPref(this)

//        bannerAd=findViewById(R.id.ContractBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }

        bindin.formula.setOnClickListener {
            Intent(FormulasActivity::class)
        }
        bindin.outputofcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
        if (sharedPref.getStringValue(AppConstants.SERVICE) == AppConstants.YES) {
            bindin.yesradio1.isChecked = true
            bindin.noradio1.isChecked = false
        } else {
            bindin.yesradio1.isChecked = false
            bindin.noradio1.isChecked = true
        }
        bindin.yesradio1.setOnClickListener {
            sharedPref.setStringValue(AppConstants.SERVICE, AppConstants.YES)
        }
        bindin.noradio1.setOnClickListener {
            sharedPref.setStringValue(AppConstants.SERVICE, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.AWFULL) == AppConstants.YES) {
            bindin.yesradio2.isChecked = true
            bindin.noradio2.isChecked = false
        } else {
            bindin.yesradio2.isChecked = false
            bindin.noradio2.isChecked = true
        }
        bindin.yesradio2.setOnClickListener {
            sharedPref.setStringValue(AppConstants.AWFULL, AppConstants.YES)
        }
        bindin.noradio2.setOnClickListener {
            sharedPref.setStringValue(AppConstants.AWFULL, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.COMPANY) == AppConstants.YES) {
            bindin.yesradio3.isChecked = true
            bindin.noradio3.isChecked = false
        } else {
            bindin.yesradio3.isChecked = false
            bindin.noradio3.isChecked = true
        }
        bindin.yesradio3.setOnClickListener {
            sharedPref.setStringValue(AppConstants.COMPANY, AppConstants.YES)
        }
        bindin.noradio3.setOnClickListener {
            sharedPref.setStringValue(AppConstants.COMPANY, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.OFFERED) == AppConstants.YES) {
            bindin.yesradio4.isChecked = true
            bindin.noradio4.isChecked = false
        } else {
            bindin.yesradio4.isChecked = false
            bindin.noradio4.isChecked = true
        }
        bindin.yesradio4.setOnClickListener {
            sharedPref.setStringValue(AppConstants.OFFERED, AppConstants.YES)
        }
        bindin.noradio4.setOnClickListener {
            sharedPref.setStringValue(AppConstants.OFFERED, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.FRIENDS) == AppConstants.YES) {
            bindin.yesradio5.isChecked = true
            bindin.noradio5.isChecked = false
        } else {
            bindin.yesradio5.isChecked = false
            bindin.noradio5.isChecked = true
        }
        bindin.yesradio5.setOnClickListener {
            sharedPref.setStringValue(AppConstants.FRIENDS, AppConstants.YES)
        }
        bindin.noradio5.setOnClickListener {
            sharedPref.setStringValue(AppConstants.FRIENDS, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.AGREEMENT) == AppConstants.YES) {
            bindin.yesradio6.isChecked = true
            bindin.noradio6.isChecked = false
        } else {
            bindin.yesradio6.isChecked = false
            bindin.noradio6.isChecked = true
        }
        bindin.yesradio6.setOnClickListener {
            sharedPref.setStringValue(AppConstants.AGREEMENT, AppConstants.YES)
        }
        bindin.noradio6.setOnClickListener {
            sharedPref.setStringValue(AppConstants.AGREEMENT, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.DURATION) == AppConstants.YES) {
            bindin.yesradio7.isChecked = true
            bindin.noradio7.isChecked = false
        } else {
            bindin.yesradio7.isChecked = false
            bindin.noradio7.isChecked = true
        }
        bindin.yesradio7.setOnClickListener {
            sharedPref.setStringValue(AppConstants.DURATION, AppConstants.YES)
        }
        bindin.noradio7.setOnClickListener {
            sharedPref.setStringValue(AppConstants.DURATION, AppConstants.NO)
        }

        bindin.btncalculate.setOnClickListener {
            if (bindin.yesradio1.isChecked && bindin.yesradio2.isChecked && bindin.yesradio3.isChecked && bindin.yesradio4.isChecked && bindin.yesradio6.isChecked && bindin.yesradio5.isChecked && bindin.yesradio7.isChecked) {
                sharedPref.setStringValue(
                    AppConstants.RESULT,
                    getString(R.string.probably_a_valid_contract_but_may_be_hard_to_enforce)
                )
                bindin.outputofcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
                bindin.outputofcalculation.setTextColor(Color.GRAY)
            } else if (bindin.yesradio1.isChecked && bindin.yesradio2.isChecked && bindin.yesradio3.isChecked && bindin.yesradio4.isChecked && bindin.yesradio6.isChecked && bindin.yesradio5.isChecked || bindin.noradio5.isChecked && bindin.yesradio7.isChecked || bindin.noradio5.isChecked) {
                sharedPref.setStringValue(
                    AppConstants.RESULT,
                    getString(R.string.probably_a_valid_contract_that_is_enforceable)
                )
                bindin.outputofcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
                bindin.outputofcalculation.setTextColor(Color.GRAY)
            } else {
                sharedPref.setStringValue(
                    AppConstants.RESULT,
                    getString(R.string.probably_invalid_contract)
                )
                bindin.outputofcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
                bindin.outputofcalculation.setTextColor(Color.RED)
            }
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