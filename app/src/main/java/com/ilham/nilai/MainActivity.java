package com.ilham.nilai;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText Nim;
    private EditText Nama;
    private RadioGroup jeniskelamin;
    private RadioButton Lakilaki;
    private RadioButton Perempuan;
    private EditText Kelas;
    private EditText Matakuliah;
    private EditText UAS;
    private EditText UTS;
    private EditText Lainlain;
    private EditText tampilGrade;
    private EditText tampilNilaiakhir;
    private EditText tampilMatakuliah;
    private EditText tampilKelas;
    private EditText tampilNim;
    private EditText tampilNama;
    private EditText tampilJeniskelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Nim = (EditText) findViewById(R.id.isinim);
        Nama = (EditText) findViewById(R.id.isinama);
        jeniskelamin = (RadioGroup) findViewById(R.id.radiogrup);
        Lakilaki = (RadioButton) findViewById(R.id.rdb1);
        Perempuan = (RadioButton) findViewById(R.id.rdb2);
        Kelas = (EditText) findViewById(R.id.isikelas);
        Matakuliah = (EditText) findViewById(R.id.isimatkul);
        UAS = (EditText) findViewById(R.id.isiuas);
        UTS = (EditText) findViewById(R.id.isiuts);
        Lainlain = (EditText) findViewById(R.id.isilain);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void hasil(View view) {
        setContentView(R.layout.halhasil);
        String nimValue = Nim.getText().toString();
//        NIM
        tampilNim = findViewById(R.id.tampilNim);
        tampilNim.setTextColor(Color.BLACK);
        tampilNim.setText(getMaskedString(nimValue));

//      NAMA
        tampilNama = (EditText) findViewById(R.id.tampilNama);
        tampilNama.setTextColor(Color.BLACK);
        if (Lakilaki.isChecked()) {
            tampilNama.setText("AA " + (Nama.getText()));
        }
        if (Perempuan.isChecked()) {
            tampilNama.setText("Teteh " + (Nama.getText()));
        }


//JENIS KELAMIN
        tampilJeniskelamin = (EditText) findViewById(R.id.tampiJeniskelamin);
        tampilJeniskelamin.setTextColor(Color.BLACK);
        if (Lakilaki.isChecked()) {
//            tampilJeniskelamin.setBackgroundColor(Color.LTGRAY);
            tampilJeniskelamin.setText("Laki-laki");
        }
        if (Perempuan.isChecked()) {
//            tampilJeniskelamin.setBackgroundColor(Color.LTGRAY);
            tampilJeniskelamin.setText("Perempuan");
        }

//        KELAS
        tampilKelas = (EditText) findViewById(R.id.tampilKelas);
        tampilKelas.setTextColor(Color.BLACK);
//        tampilKelas.setBackgroundColor(Color.LTGRAY);
        tampilKelas.setText((Kelas.getText()));

//        MATA KULIAH
        tampilMatakuliah = (EditText) findViewById(R.id.tampilMatakuliah);
        tampilMatakuliah.setTextColor(Color.BLACK);
//        tampilMatakuliah.setBackgroundColor(Color.LTGRAY);
        tampilMatakuliah.setText((Matakuliah.getText()));

//        NILAI AKHIR
        // Mendapatkan nilai-nilai yang diinputkan
        double nilaiUAS = Double.parseDouble(UAS.getText().toString());
        double nilaiUTS = Double.parseDouble(UTS.getText().toString());
        double nilaiLain = Double.parseDouble(Lainlain.getText().toString());

        // Menghitung nilai akhir berdasarkan bobot yang diberikan
        double nilaiAkhir = (nilaiUAS * 0.3) + (nilaiUTS * 0.3) + (nilaiLain * 0.4);

        // Menampilkan nilai akhir
        tampilNilaiakhir = findViewById(R.id.tampilNilaiakhir);
        tampilNilaiakhir.setText(String.valueOf(nilaiAkhir));
        tampilNilaiakhir.setTextColor(Color.BLACK);
//        tampilNilaiakhir.setBackgroundColor(Color.LTGRAY);

//        GRADE
        // Menentukan grade berdasarkan nilai akhir

        tampilGrade = findViewById(R.id.tampilGrade);
        tampilGrade.setTextColor(Color.RED);
        if (nilaiAkhir >= 80 && nilaiAkhir <= 100) {
            tampilGrade.setText("A");
        } else if (nilaiAkhir >= 70 && nilaiAkhir < 80) {
            tampilGrade.setText("AB");
        } else if (nilaiAkhir >= 60 && nilaiAkhir < 70) {
            tampilGrade.setText("B");
        } else if (nilaiAkhir >= 50 && nilaiAkhir < 60) {
            tampilGrade.setText("BC");
        } else if (nilaiAkhir >= 40 && nilaiAkhir < 50) {
            tampilGrade.setText("C");
        } else if (nilaiAkhir >= 30 && nilaiAkhir < 40) {
            tampilGrade.setText("D");
        } else {
            tampilGrade.setText("E");
        }

    }

    // Fungsi untuk menghasilkan string dengan simbol "*"
    private String getMaskedString(String original) {
        // Membuat objek StringBuilder untuk membangun string hasil masking
        StringBuilder maskedString = new StringBuilder();

        // Melakukan iterasi sepanjang panjang string original
        for (int i = 0; i < original.length(); i++) {
            // Menambahkan simbol "*" ke string hasil masking
            maskedString.append("*");
        }

        // Mengembalikan string hasil masking dalam bentuk String
        return maskedString.toString();
    }
}