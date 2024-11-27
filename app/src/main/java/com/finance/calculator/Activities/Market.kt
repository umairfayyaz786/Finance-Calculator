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
import com.finance.calculator.databinding.ActivityMarketBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


@SuppressLint("StaticFieldLeak")
lateinit var bindinggggg: ActivityMarketBinding

class Market : AppCompatActivity() {
    private var MainMenu: Menu? = null
    private lateinit var sharedPref: SharedPref

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        bindinggggg = ActivityMarketBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindinggggg.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = Html.fromHtml(getString(R.string.small_market_validity_small))
        sharedPref = SharedPref(this)

//        bannerAd=findViewById(R.id.MarketBannerAd)
//        if (NetworkUtils.isNetworkAvailable(this)) {
//            bannerAd.visible()
//            bannerAds(this, bannerAd, "SMALL_BANNER")
//        } else {
//            bannerAd.gone()
//        }


        if (sharedPref.getStringValue(AppConstants.GEOGRAPHIC) == AppConstants.YES) {
            bindinggggg.Narrowradio.isChecked = true
            bindinggggg.Wideradio.isChecked = false
        } else {
            bindinggggg.Narrowradio.isChecked = false
            bindinggggg.Wideradio.isChecked = true
        }
        bindinggggg.Narrowradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.GEOGRAPHIC, AppConstants.YES)
        }
        bindinggggg.Wideradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.GEOGRAPHIC, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.POTENTIAL) == AppConstants.YES) {
            bindinggggg.Specificradio.isChecked = true
            bindinggggg.Everyoneradio.isChecked = false
        } else {
            bindinggggg.Specificradio.isChecked = false
            bindinggggg.Everyoneradio.isChecked = true
        }
        bindinggggg.Specificradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.POTENTIAL, AppConstants.YES)
        }
        bindinggggg.Everyoneradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.POTENTIAL, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.PRODUCTS) == AppConstants.YES) {
            bindinggggg.Fewradio.isChecked = true
            bindinggggg.Manyradio.isChecked = false
        } else {
            bindinggggg.Fewradio.isChecked = false
            bindinggggg.Manyradio.isChecked = true
        }
        bindinggggg.Fewradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.COMPANY, AppConstants.YES)
        }
        bindinggggg.Manyradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.COMPANY, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.COMPETITORS) == AppConstants.YES) {
            bindinggggg.Lowerradio.isChecked = true
            bindinggggg.Higherradio.isChecked = false
        } else {
            bindinggggg.Lowerradio.isChecked = false
            bindinggggg.Higherradio.isChecked = true
        }
        bindinggggg.Lowerradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.COMPETITORS, AppConstants.YES)
        }
        bindinggggg.Higherradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.COMPETITORS, AppConstants.NO)
        }

        if (sharedPref.getStringValue(AppConstants.QUALITY) == AppConstants.YES) {
            bindinggggg.Similarradio.isChecked = true
            bindinggggg.Betterradio.isChecked = false
        } else {
            bindinggggg.Similarradio.isChecked = false
            bindinggggg.Betterradio.isChecked = true
        }
        bindinggggg.Similarradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.QUALITY, AppConstants.YES)
        }
        bindinggggg.Betterradio.setOnClickListener {
            sharedPref.setStringValue(AppConstants.QUALITY, AppConstants.NO)
        }
        bindinggggg.formula.setOnClickListener {
            Intent(FormulasActivity::class)
        }
        bindinggggg.btncalculate.setOnClickListener {
            if (bindinggggg.Narrowradio.isChecked && bindinggggg.Specificradio.isChecked && bindinggggg.Fewradio.isChecked && bindinggggg.Lowerradio.isChecked && bindinggggg.Similarradio.isChecked) {
                sharedPref.setStringValue(
                    AppConstants.RESULT,
                    getString(R.string.a_narrow_geographic_market_can_be_a_successful_market_position_for_a_small_business_this_is_especially_the_case_if_there_are_opportunities_to_customize_product_or_services_to_the_specific_needs_of_the_local_market_larger_businesses_can_find_local_knowledge_difficult_to_obtain_and_the_cost_of_adapting_to_the_local_market_prohibitive_targetting_specific_customers_can_be_a_successful_strategyfor_small_businesses_it_can_allow_them_to_adapt_their_products_or_services_so_they_are_better_suited_to_the_needs_of_their_targetted_customers_the_internet_has_provided_the_opportunity_for_small_scale_firms_to_customise_their_products_and_services_to_very_focused_customer_niches_and_then_to_service_wide_geographic_areas_large_firms_can_find_it_hard_to_adapt_their_product_and_services_to_very_focused_customer_segments) + getString(
                        R.string.offering_few_products_or_services_can_be_successful_strategy_for_small_businesses_having_a_small_range_allows_them_to_customize_their_products_and_services_to_particular_customers_and_local_markets_larger_firms_are_less_likely_to_be_so_focused_and_may_find_it_hard_to_compete
                    ) + getString(R.string.providing_goods_or_services_of_a_similar_quality_to_competitors_at_a_lower_price_ca_in_some_circumstances_be_successful_for_small_businesses_larger_businesses_are_often_better_suited_to_competing_on_price_to_a_broad_market_as_they_can_achieve_lower_costs_through_scale_however_sma_firms_maybe_able_to_compete_on_price_where_they_adapt_there_product_or_service_to_a_particular_customer_segment_or_geographic_area_that_has_been_ignored_by_larger_firms_also_opportunities_may_existfor_small_firms_where_labour_costs_are_lov_or_transportation_costs_are_high)
                )
                bindinggggg.outputofMarketcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
                bindinggggg.outputofMarketcalculation.setTextColor(Color.GRAY)
            } else if (bindinggggg.Wideradio.isChecked && bindinggggg.Specificradio.isChecked && bindinggggg.Fewradio.isChecked && bindinggggg.Lowerradio.isChecked && bindinggggg.Similarradio.isChecked) {
                sharedPref.setStringValue(
                    AppConstants.RESULT,
                    getString(R.string.targetting_specific_customers_can_be_a_successful_strategy_for_small_businesses_it_can_allow_them_to_adapt_their_products_or_services_so_they_are_better_suited_to_the_needs_of_their_targetted_customers_the_internet_has_provided_the_opportunity_for_small_scale_firms_to_customise_their_products_and_services_to_very_focused_customer_niches_and_then_to_service_wide_geographic_areas_large_firms_can_find_it_hard_to_adapt_their_product_and_services_to_very_focused_customer_segments) + getString(
                        R.string.offering_few_products_or_services_can_be_successful_strategy_for_small_businesses_having_a_small_range_allows_them_to_customize_their_products_and_services_to_particular_customers_and_local_markets_larger_firms_are_less_likely_to_be_so_focused_and_may_find_it_hard_to_compete
                    ) + getString(
                        R.string.providing_goods_or_services_of_a_similar_quality_to_competitors_at_a_lower_price_ca_in_some_circumstances_be_successful_for_small_businesses_larger_businesses_are_often_better_suited_to_competing_on_price_to_a_broad_market_as_they_can_achieve_lower_costs_through_scale_however_sma_firms_maybe_able_to_compete_on_price_where_they_adapt_there_product_or_service_to_a_particular_customer_segment_or_geographic_area_that_has_been_ignored_by_larger_firms_also_opportunities_may_exist_for_small_firms_where_labour_costs_are_lov_or_transportation_costs_are_high
                    )
                )
                bindinggggg.outputofMarketcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
                bindinggggg.outputofMarketcalculation.setTextColor(Color.GRAY)
            } else if (bindinggggg.Wideradio.isChecked && bindinggggg.Everyoneradio.isChecked && bindinggggg.Manyradio.isChecked && bindinggggg.Higherradio.isChecked && bindinggggg.Betterradio.isChecked) {
                sharedPref.setStringValue(
                    AppConstants.RESULT,
                    getString(R.string.a_combination_of_wide_geographic_market_and_trying_to_sell_to_everyone_is_less_likely_to_be_a_successful_strategy_for_small_firms_large_firms_are_better_suited_to_selling_to_such_customers_as_they_can_achieve_lower_costs_from_their_scale_small_firms_are_better_suited_to_customising_their_products_or_services_to_suit_specific_customers_or_a_particular_narrow_geographic_area) + getString(
                        R.string.offering_few_products_or_services_can_be_successful_strategy_for_small_businesses_having_a_small_range_allows_them_to_customize_their_products_and_services_to_particular_customers_and_local_markets_larger_firms_are_less_likely_to_be_so_focused_and_may_find_it_hard_to_compete
                    ) + getString(R.string.providing_goods_or_services_of_a_similar_quality_to_competitors_at_a_lower_price_ca_in_some_circumstances_be_successful_for_small_businesses_larger_businesses_are_often_better_suited_to_competing_on_price_to_a_broad_market_as_they_can_achieve_lower_costs_through_scale_however_sma_firms_maybe_able_to_compete_on_price_where_they_adapt_there_product_or_service_to_a_particular_customer_segment_or_geographic_area_that_has_been_ignored_by_larger_firms_also_opportunities_may_exist_for_small_firms_where_labour_costs_are_lov_or_transportation_costs_are_high)
                )
                bindinggggg.outputofMarketcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
                bindinggggg.outputofMarketcalculation.setTextColor(Color.GRAY)
            } else if (bindinggggg.Narrowradio.isChecked && bindinggggg.Everyoneradio.isChecked || bindinggggg.Specificradio.isChecked && bindinggggg.Manyradio.isChecked && bindinggggg.Higherradio.isChecked && bindinggggg.Betterradio.isChecked) {
                sharedPref.setStringValue(
                    AppConstants.RESULT,
                    getString(R.string.a_narrow_geographic_market_can_be_a_successful_market_position_for_a_small_business_this_is_especially_the_case_if_there_are_opportunities_to_customize_product_or_services_to_the_specific_needs_of_the_local_market_larger_businesses_can_find_local_knowledge_difficult_to_obtain_and_the_cost_of_adapting_to_the_local_market_prohibitive_targetting_specific_customers_can_be_a_successful_strategyfor_small_businesses_it_can_allow_them_to_adapt_their_products_or_services_so_they_are_better_suited_to_the_needs_of_their_targetted_customers_the_internet_has_provided_the_opportunity_for_small_scale_firms_to_customise_their_products_and_services_to_very_focused_customer_niches_and_then_to_service_wide_geographic_areas_large_firms_can_find_it_hard_to_adapt_their_product_and_services_to_very_focused_customer_segments) + getString(
                        R.string.providing_goods_or_services_of_a_similar_quality_to_competitors_at_a_lower_price_ca_in_some_circumstances_be_successful_for_small_businesses_larger_businesses_are_often_better_suited_to_competing_on_price_to_a_broad_market_as_they_can_achieve_lower_costs_through_scale_however_sma_firms_maybe_able_to_compete_on_price_where_they_adapt_there_product_or_service_to_a_particular_customer_segment_or_geographic_area_that_has_been_ignored_by_larger_firms_also_opportunities_may_exist_for_small_firms_where_labour_costs_are_lov_or_transportation_costs_are_high
                    )
                )
                bindinggggg.outputofMarketcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
                bindinggggg.outputofMarketcalculation.setTextColor(Color.GRAY)
            } else if (bindinggggg.Wideradio.isChecked && bindinggggg.Specificradio.isChecked && bindinggggg.Manyradio.isChecked && bindinggggg.Higherradio.isChecked && bindinggggg.Betterradio.isChecked) {
                sharedPref.setStringValue(
                    AppConstants.RESULT,
                    getString(R.string.targetting_specific_customers_can_be_a_successful_strategy_for_small_businesses_it_can_allow_them_to_adapt_their_products_or_services_so_they_are_better_suited_to_the_needs_of_their_targetted_customers_the_internet_has_provided_the_opportunity_for_small_scale_firms_to_customise_their_products_and_services_to_very_focused_customer_niches_and_then_to_service_wide_geographic_areas_large_firms_can_find_it_hard_to_adapt_their_product_and_services_to_very_focused_customer_segments) + getString(
                        R.string.offering_few_products_or_services_can_be_successful_strategy_for_small_businesses_having_a_small_range_allows_them_to_customize_their_products_and_services_to_particular_customers_and_local_markets_larger_firms_are_less_likely_to_be_so_focused_and_may_find_it_hard_to_compete
                    ) + getString(R.string.providing_goods_or_services_of_a_similar_quality_to_competitors_at_a_lower_price_ca_in_some_circumstances_be_successful_for_small_businesses_larger_businesses_are_often_better_suited_to_competing_on_price_to_a_broad_market_as_they_can_achieve_lower_costs_through_scale_however_sma_firms_maybe_able_to_compete_on_price_where_they_adapt_there_product_or_service_to_a_particular_customer_segment_or_geographic_area_that_has_been_ignored_by_larger_firms_also_opportunities_may_existfor_small_firms_where_labour_costs_are_lov_or_transportation_costs_are_high)
                )
                bindinggggg.outputofMarketcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
                bindinggggg.outputofMarketcalculation.setTextColor(Color.GRAY)
            } else {
                sharedPref.setStringValue(
                    AppConstants.RESULT,
                    getString(R.string.targetting_specific_customers_can_be_a_successful_strategy_for_small_businesses_it_can_allow_them_to_adapt_their_products_or_services_so_they_are_better_suited_to_the_needs_of_their_targetted_customers_the_internet_has_provided_the_opportunity_for_small_scale_firms_to_customise_their_products_and_services_to_very_focused_customer_niches_and_then_to_service_wide_geographic_areas_large_firms_can_find_it_hard_to_adapt_their_product_and_services_to_very_focused_customer_segments) + getString(
                        R.string.offering_few_products_or_services_can_be_successful_strategy_for_small_businesses_having_a_small_range_allows_them_to_customize_their_products_and_services_to_particular_customers_and_local_markets_larger_firms_are_less_likely_to_be_so_focused_and_may_find_it_hard_to_compete
                    ) + getString(R.string.providing_goods_or_services_of_a_similar_quality_to_competitors_at_a_lower_price_ca_in_some_circumstances_be_successful_for_small_businesses_larger_businesses_are_often_better_suited_to_competing_on_price_to_a_broad_market_as_they_can_achieve_lower_costs_through_scale_however_sma_firms_maybe_able_to_compete_on_price_where_they_adapt_there_product_or_service_to_a_particular_customer_segment_or_geographic_area_that_has_been_ignored_by_larger_firms_also_opportunities_may_existfor_small_firms_where_labour_costs_are_lov_or_transportation_costs_are_high)
                )
                bindinggggg.outputofMarketcalculation.setText(sharedPref.getStringValue(AppConstants.RESULT))
                bindinggggg.outputofMarketcalculation.setTextColor(Color.GRAY)
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