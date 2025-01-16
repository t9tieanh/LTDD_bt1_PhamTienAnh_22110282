package com.example.my_project;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ẩn tiêu đề và chuyển sang chế độ fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Gắn layout cho SecondActivity
        setContentView(R.layout.activity_second);

        // Tìm nút và TextView từ layout
        Button backButton = findViewById(R.id.buttonBack);
        TextView textView = findViewById(R.id.textViewSecond);

        // Thiết lập sự kiện cho nút "Quay lại"
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kết thúc SecondActivity và quay lại MainActivity
                finish();
            }
        });

        bt3Prime();
    }

    private void bt3Prime () {
        int listSize = 10; // Số lượng phần tử trong ArrayList
        ArrayList<Integer> randomList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < listSize; i++) {
            randomList.add(random.nextInt(100)); // Random số từ 0 đến 99
        }

        for (int number : randomList) {
            if (isPrime(number)) {
                Log.d("PrimeNumber", "Số nguyên tố: " + number);
            } else Log.d("PrimeNumber", "Số " + number +" không phải là số nguyên tố");
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
