package galassini.tecnology.modulo_8

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var numClicks = 0
    private lateinit var nameEditText: EditText
    private lateinit var displayTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout = findViewById<View>(R.id.mainLayout)
        nameEditText = findViewById<EditText>(R.id.nameEditText)
        val changeImageButton = findViewById<Button>(R.id.changeImageButton)
        displayTextView = findViewById<TextView>(R.id.displayTextView)

        changeImageButton.setOnClickListener {
            numClicks++
            setRandomBackground()
            val userName = nameEditText.text.toString()
            updateDisplayText(userName)
        }

        // Adiciona um ouvinte de texto ao EditText
        nameEditText.setOnEditorActionListener { _, _, _ ->
            val userName = nameEditText.text.toString()
            updateDisplayText(userName)
            true
        }
    }

    private fun setRandomBackground() {
        val backgrounds = arrayOf(
            R.drawable.tela1,
            R.drawable.tela2,
            R.drawable.tela3
        )
        val randomIndex = (0 until backgrounds.size).random()
        findViewById<ImageView>(R.id.backgroundImage).setImageResource(backgrounds[randomIndex])
    }

    private fun updateDisplayText(userName: String) {
        val textToShow = "Olá, $userName! Você clicou $numClicks vezes."
        displayTextView.text = textToShow
    }
}
