package com.finance.calculator.Activities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.finance.calculator.MainActivity
import com.finance.calculator.R
import com.finance.calculator.Utils.AppConstants
import com.finance.calculator.Utils.Intent
import com.finance.calculator.Utils.SharedPref
import com.finance.calculator.Utils.showToast
import com.finance.calculator.databinding.ActivitySettingBinding


@SuppressLint("StaticFieldLeak")
lateinit var bindinggggggggg: ActivitySettingBinding

class SettingActivity : AppCompatActivity() {

    private var MainMenu: Menu? = null
    private lateinit var sharedPref: SharedPref


    override fun onCreate(savedInstanceState: Bundle?) {
        bindinggggggggg = ActivitySettingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindinggggggggg.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.set_your_tax)
        sharedPref = SharedPref(this)
        bindinggggggggg.settax.setText(sharedPref.getIntegerValue(AppConstants.TEXT_KEY).toString())
        bindinggggggggg.save.setOnClickListener {
            val set_Tax = bindinggggggggg.settax.text.toString().toDouble()
            sharedPref.setIntegerValue(AppConstants.TEXT_KEY, set_Tax)
            showToast(getString(R.string.gst_vat_value_saved_successfully))
        }
        bindinggggggggg.formula.setOnClickListener {
            Intent(FormulasActivity::class)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Intent(MainActivity::class)
        }
        if (item.itemId == R.id.setting_reviews) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.kachariya.smallbusinessplan")
                )
            )
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        MainMenu = menu
        menuInflater.inflate(R.menu.setting_review, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onBackPressed() {
        Intent(MainActivity::class)
    }
}