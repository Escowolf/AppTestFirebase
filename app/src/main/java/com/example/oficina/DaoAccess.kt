package com.example.oficina

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DaoAccess : AppCompatActivity() {
    private var banco: SQLiteDatabase? = null
    //private var Saida: TextView? = null
    private var Resultado: TextView? = null
    private var btInserir: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dao_access)

        // obtém componentes
        //Saida = findViewById(R.id.txtMessage)
        Resultado = findViewById(R.id.textView)
        btInserir = findViewById(R.id.btInserir)

        val button: Button = findViewById(R.id.btPesquisa)


        // abre o banco de dados
        banco = openOrCreateDatabase("sqliteapp", MODE_PRIVATE, null)
    }

    fun inserir(view: View?) {
        if (banco != null) {
            banco!!.execSQL("CREATE TABLE IF NOT EXISTS Pessoa (ID INTEGER NOT NULL PRIMARY KEY, Nome VARCHAR NOT NULL)")
            banco!!.execSQL("INSERT INTO Pessoa (ID, Nome) values (1, 'Victor')")
            banco!!.execSQL("INSERT INTO Pessoa (ID, Nome) values (2, 'Singridy')")
            banco!!.execSQL("INSERT INTO Pessoa (ID, Nome) values (3, 'Gabriel')")
            banco!!.execSQL("INSERT INTO Pessoa (ID, Nome) values (4, 'Matheus')")
            banco!!.execSQL("INSERT INTO Pessoa (ID, Nome) values (5, 'Pedro')")
            banco!!.execSQL("CREATE TABLE IF NOT EXISTS Carro (ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, MODELO TEXT NOT NULL, ESTILO TEXT NOT NULL, ANO INTEGER NOT NULL, PROPRIETARIO INTEGER, FOREIGN KEY (PROPRIETARIO) REFERENCES Pessoa(ID))")
            banco!!.execSQL("CREATE INDEX idx_proprietario ON Carro (PROPRIETARIO)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Opala', 'Sedan', 1979, 1)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Maverick', 'Esportivo', 1974, 2)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Caravan', 'Perua', 1980, 3)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Passat', 'Hatch', 1982, 4)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Corcel II', 'Sedan', 1982, 5)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Jeep', 'Off Road', 1955, 3)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Corolla', 'Sedan', 2016, 1)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Camaro', 'Esportivo', 2015, 2)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Spin', 'Perua', 2017, 3)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('HB20', 'Hatch', 2019, 4)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('A3', 'Sedan', 2018, 5)")
            banco!!.execSQL("INSERT INTO Carro (MODELO, ESTILO, ANO, PROPRIETARIO) values ('Troller', 'Off Road', 1955, 3)")

            // desabilita botão após inserção
            btInserir!!.isEnabled = false
        }
    }


    fun pesquisar(view: View?) {
        if (banco != null) {
            val saida = StringBuffer(500)
            val cursor: Cursor = banco!!.rawQuery("SELECT ID, Nome FROM Pessoa", null )
            val indID: Int = cursor.getColumnIndex("ID")
            val indNome: Int = cursor.getColumnIndex("Nome")
            cursor.moveToFirst()
            do {
                saida.append(
                    """
                        ${cursor.getInt(indID).toString()}, ${cursor.getString(indNome).toString()}
                        
                        """.trimIndent()
                )
            } while (cursor.moveToNext())

            // exibe a saída
            //Saida!!.text = saida.toString()
        }
    }

    fun pesquisar2(view: View?) {
        if (banco != null) {
            val resultado = StringBuffer(500)
            var rId : Any? = findViewById(R.id.txtEditId)
            val cursor: Cursor = banco!!.rawQuery("SELECT ID, Nome FROM Pessoa id like ${rId}", null )
            val indID: Int = cursor.getColumnIndex("ID")
            val indNome: Int = cursor.getColumnIndex("Nome")
            resultado.append(
                    """
                        ${cursor.getInt(indID).toString()}, ${cursor.getString(indNome).toString()}
                        
                        """.trimIndent()
                )

            // exibe a saída
            Resultado!!.text = resultado.toString()
        }
    }
    fun acessarSqlite(view: View) {
        val intent = Intent(this, DaoAccess::class.java).apply {
            //
        }
        startActivity(intent)
    }

}

