package com.example.pomodoro_app

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class PomodoroFragment : Fragment(), View.OnClickListener {


    private var timeCountInMilliSeconds : Long = 1 * 6000;

    private enum class TimerStatus {
        STARTED, STOPPED
    }

    private val timerStatus = TimerStatus.STOPPED

    private lateinit var progressBarCircle : ProgressBar
    private lateinit var editTextMinute : EditText
    private lateinit var textViewTime : TextView
    private lateinit var imageViewReset : ImageView
    private lateinit var imageViewStartStop : ImageView
    private lateinit var countDownTimer: CountDownTimer



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_pomodoro, container, false)

        initViews(view);

        initListeners();

        return view
    }

    private fun initViews(view : View) {
        progressBarCircle = view.findViewById(R.id.progressBarCircle)
        editTextMinute = view.findViewById(R.id.editTextMinute)
        textViewTime = view.findViewById(R.id.textViewTime)
        imageViewReset = view.findViewById(R.id.imageViewReset)
        imageViewStartStop = view.findViewById(R.id.imageViewStartStop)
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PomodoroFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}