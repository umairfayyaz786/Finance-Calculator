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
import com.finance.calculator.databinding.ActivityDiscountBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


@SuppressLint("StaticFieldLeak")
lateinit var bi: ActivityDiscountBinding

class Discount : AppCompatActivity() {
    private var MainMenu: Menu? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        bi = ActivityDiscountBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bi.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_discount_small))


//        bannerAd=findViewById(R.id.DiscountBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }
        bi.calculate.setOnClickListener {
            if (bi.normalprice1.text.toString().isEmpty() || bi.normalprice1.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.normal_price_must_be_required))
                return@setOnClickListener
            }
            if (bi.DiscountPercent.text.toString().isEmpty() || bi.DiscountPercent.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.discount_must_be_required))
                return@setOnClickListener
            }
            val normalprice11 = bi.normalprice1.text.toString().toDouble()
            val DiscountPercent11 = bi.DiscountPercent.text.toString().toDouble()

            val Discount = ((normalprice11) * (DiscountPercent11 / 100))
            bi.Discount.text = Discount.toString()
            val Discprice = ((normalprice11) - (normalprice11 * (DiscountPercent11 / 100)))
            bi.DiscountPrice2.text = Discprice.toString()

        }
        bi.calculate2.setOnClickListener {
            if (bi.normalprice2.text.toString().isEmpty() || bi.normalprice2.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.normal_price_must_be_required))
                return@setOnClickListener
            }
            if (bi.DiscountPercent2.text.toString().isEmpty() || bi.DiscountPercent2.text.toString()
                    .isBlank()
            ) {
                showToast(getString(R.string.discount_must_be_required))
                return@setOnClickListener
            }
            val normalprice22 = bi.normalprice2.text.toString().toDouble()
            val Discount22 = bi.DiscountPercent2.text.toString().toDouble()

            val Discprice2 = normalprice22 - Discount22
            bi.DiscountPrice.text = Discprice2.toString()
            val Discount_percent = ((Discount22 / (normalprice22) * 100))
            bi.DiscountPercent3.text = Discount_percent.toString()
        }
        bi.formula.setOnClickListener {
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