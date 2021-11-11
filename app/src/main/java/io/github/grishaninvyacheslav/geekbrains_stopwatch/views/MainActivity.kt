package io.github.grishaninvyacheslav.geekbrains_stopwatch.views

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.github.grishaninvyacheslav.geekbrains_stopwatch.*
import io.github.grishaninvyacheslav.geekbrains_stopwatch.view_models.MainViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_time)
        CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
        ).launch {
            viewModel.getData().collect {
                textView.text = it
            }
        }

        findViewById<Button>(R.id.button_start).setOnClickListener {
            viewModel.start()
        }
        findViewById<Button>(R.id.button_pause).setOnClickListener {
            viewModel.pause()
        }
        findViewById<Button>(R.id.button_stop).setOnClickListener {
            viewModel.stop()
        }

    }
}
