package com.example.tankcatalin


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.KeyEvent
import android.view.KeyEvent.*
import android.widget.FrameLayout

import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

@@ -12,6 +14,10 @@ const val TANK_SIDE_CELLS = 2

class MainActivity : AppCompatActivity() {

    private val gridDrawer by lazy {
        GridDrawer(container, cellSize)
    }

    private var cellSize = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        @@ -37,6 +43,20 @@ class MainActivity : AppCompatActivity() {

            private fun getTankSide() = cellSize * TANK_SIDE_CELLS

            override fun onCreateOptionsMenu(menu: Menu): Boolean {
                menuInflater.inflate(R.menu.settings, menu)
                return true
            }

            override fun onOptionsItemSelected(item: MenuItem): Boolean {
                return when (item.itemId) {
                    R.id.menu_settings -> {
                        gridDrawer.drawGrid()
                        return true
                    }
                    else -> super.onOptionsItemSelected(item)
                }
            }

            override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
                val layoutParams = myTank.layoutParams as FrameLayout.LayoutParams