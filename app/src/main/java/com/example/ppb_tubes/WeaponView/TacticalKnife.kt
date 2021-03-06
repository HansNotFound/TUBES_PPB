package com.example.ppb_tubes.WeaponView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.transition.TransitionManager
import com.example.ppb_tubes.R
import com.example.ppb_tubes.SideNavFragment

//import com.example.ppb_tubes.ui.skins.AllSkins.SkinActivity
//import com.example.ppb_tubes.ui.skins.UUID.SkinByUuidActivity

class TacticalKnife : AppCompatActivity(), View.OnClickListener {

    val weaponUuid : String = "2f59173c-4bed-b6c3-2191-dea9b58be9c7"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tactical_knife)

        val sideNav: ImageView = findViewById(R.id.side_nav)
        sideNav.setOnClickListener(this)

//        val seeSkin: Button = findViewById(R.id.see_skin)
//        seeSkin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.side_nav -> {
                val mFragmentManager = supportFragmentManager
                val mSideNavFragment = SideNavFragment()

                val rootView: ViewGroup = findViewById(R.id.tk_layout)
                val mFade: androidx.transition.Fade =
                    androidx.transition.Fade(androidx.transition.Fade.IN)
                TransitionManager.beginDelayedTransition(rootView, mFade)

                mFragmentManager
                    .beginTransaction()
                    .add(
                        R.id.tk_layout, mSideNavFragment,
                        SideNavFragment::class.java.simpleName
                    )
                    .addToBackStack(null)
                    .commit()
            }
//            R.id.see_skin -> {
//                val skinIntent = Intent(
//                    this@TacticalKnife,
//                    SkinByUuidActivity::class.java)
//                skinIntent.putExtra(SkinByUuidActivity.EXTRA_WEAPONUUID, weaponUuid)
//                startActivity(skinIntent)
//            }
        }
    }
}