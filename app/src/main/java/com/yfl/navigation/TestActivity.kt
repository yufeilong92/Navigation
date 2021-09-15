package com.yfl.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yfl.navigation.databinding.ActivityTestBinding

class TestActivity : BaseActivity<ActivityTestBinding>() {
    override fun initCreate() {
        viewBinding.tvContent.setOnClickListener {
            Toast.makeText(this@TestActivity, "${viewBinding.tvContent.text}", Toast.LENGTH_SHORT)
                .show()
        }
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.add(R.id.fl, TestFragment())
        beginTransaction.commit()
    }
}