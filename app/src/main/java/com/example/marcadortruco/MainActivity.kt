package com.example.marcadortruco

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var pontosNos = 0
    private var pontosEles = 0
    private var vitoriasNos = 0
    private var vitoriasEles = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pntNosTextView = findViewById<TextView>(R.id.pntnos)
        val pntElesTextView = findViewById<TextView>(R.id.pnteles)
        val winNosTextView = findViewById<TextView>(R.id.winnos)
        val winElesTextView = findViewById<TextView>(R.id.wineles)

        val btn1Nos = findViewById<Button>(R.id.btn1nos)
        val btn2Nos = findViewById<Button>(R.id.btn2nos)
        val btn1Eles = findViewById<Button>(R.id.btn1eles)
        val btn2Eles = findViewById<Button>(R.id.btn2eles)

        // Funções para atualizar a pontuação e verificar se algum time venceu
        fun atualizarPontos() {
            pntNosTextView.text = pontosNos.toString()
            pntElesTextView.text = pontosEles.toString()

            if (pontosNos >= 12) {
                pontosNos = 0
                vitoriasNos++
                winNosTextView.text = "Venceu ( $vitoriasNos )"
            }

            if (pontosEles >= 12) {
                pontosEles = 0
                vitoriasEles++
                winElesTextView.text = "Venceu ( $vitoriasEles )"
            }
        }

        // Botões para adicionar ou remover pontos do time "Nós"
        btn1Nos.setOnClickListener {
            pontosNos++
            atualizarPontos()
        }

        btn2Nos.setOnClickListener {
            if (pontosNos > 0) {
                pontosNos--
            }
            atualizarPontos()
        }

        // Botões para adicionar ou remover pontos do time "Eles"
        btn1Eles.setOnClickListener {
            pontosEles++
            atualizarPontos()
        }

        btn2Eles.setOnClickListener {
            if (pontosEles > 0) {
                pontosEles--
            }
            atualizarPontos()
        }
        atualizarPontos()
    }
}