package com.finance.calculator.Activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.MenuItem
import com.finance.calculator.MainActivity
import com.finance.calculator.R
import com.finance.calculator.Utils.Intent
import com.finance.calculator.databinding.ActivityFormulasBinding

@SuppressLint("StaticFieldLeak")
lateinit var b: ActivityFormulasBinding

class FormulasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        b = ActivityFormulasBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(b.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.formulas)

        b.tv2.movementMethod = LinkMovementMethod.getInstance()

        b.tv10.movementMethod = LinkMovementMethod.getInstance()

        b.tv12.movementMethod = LinkMovementMethod.getInstance()

        b.tv14.movementMethod = LinkMovementMethod.getInstance()

        b.tv18.movementMethod = LinkMovementMethod.getInstance()

        b.tv20.movementMethod = LinkMovementMethod.getInstance()

        b.tv24.movementMethod = LinkMovementMethod.getInstance()

        b.tv26.movementMethod = LinkMovementMethod.getInstance()

        b.tv22.movementMethod = LinkMovementMethod.getInstance()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            Intent(MainActivity::class)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        Intent(MainActivity::class)
    }
}