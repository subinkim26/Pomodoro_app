package com.example.pomodoro_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var pomodoroFragment: PomodoroFragment
    private lateinit var calendarFragment: CalendarFragment
    private lateinit var preferenceFragment: PreferenceFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pomodoroFragment = PomodoroFragment()
        calendarFragment = CalendarFragment()
        preferenceFragment = PreferenceFragment()

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_pomodoro -> {
                    loadFragment(pomodoroFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_calendar -> {
                    loadFragment(calendarFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_preference -> {
                    loadFragment(preferenceFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        //앱 시작시 첫번째 프래그먼트 보여주기
        loadFragment(pomodoroFragment)
    }

    //mainactivity에 있는 container 프레임뷰를 프래그먼트 xml로 바꿔주는것
    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}