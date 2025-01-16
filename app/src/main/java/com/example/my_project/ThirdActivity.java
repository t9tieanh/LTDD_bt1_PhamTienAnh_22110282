package com.example.my_project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private EditText edtNumberOfElements;
    private Button btnProcess;
    private TextView txtResult;

    private TextView txtRandomList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Khởi tạo các view
        edtNumberOfElements = findViewById(R.id.edtNumberOfElements);
        btnProcess = findViewById(R.id.btnProcess);
        txtResult = findViewById(R.id.txtResult);
        txtRandomList = findViewById(R.id.txtRandomList);

        Button backButton = findViewById(R.id.buttonBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy số phần tử từ EditText
                String inputText = edtNumberOfElements.getText().toString();
                if (inputText.isEmpty()) {
                    Toast.makeText(ThirdActivity.this, "Vui lòng nhập số phần tử", Toast.LENGTH_SHORT).show();
                    return;
                }



                int numberOfElements = Integer.parseInt(inputText);
                ArrayList<Integer> numbers = randomArray(numberOfElements);

                displayRandomList(numbers);

                // Kiểm tra và hiển thị các số chính phương
                ArrayList<Integer> perfectSquares = checkPerfectSquares(numbers);
                displayResults(perfectSquares);
            }
        });
    }


    private ArrayList<Integer> randomArray(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add((int) (Math.random() * 100) + 1);  // Các số từ 1 đến 100
        }
        return arrayList;
    }

    // Kiểm tra các số chính phương
    private ArrayList<Integer> checkPerfectSquares(ArrayList<Integer> numbers) {
        ArrayList<Integer> perfectSquares = new ArrayList<>();
        for (int number : numbers) {
            if (isPerfectSquare(number)) {
                perfectSquares.add(number);
            }
        }
        return perfectSquares;
    }

    // Hàm kiểm tra số chính phương
    private boolean isPerfectSquare(int number) {
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }

    // Hiển thị kết quả lên TextView và Toast
    private void displayResults(ArrayList<Integer> perfectSquares) {
        if (perfectSquares.isEmpty()) {
            txtResult.setText("Không có số chính phương.");
            Toast.makeText(ThirdActivity.this, "Không có số chính phương.", Toast.LENGTH_SHORT).show();
        } else {
            StringBuilder result = new StringBuilder("Số chính phương: ");
            for (int number : perfectSquares) {
                result.append(number).append(" ");
            }
            txtResult.setText(result.toString());
            Toast.makeText(ThirdActivity.this, "Có số chính phương!", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayRandomList (ArrayList<Integer> randomLst) {
        txtRandomList.setText("Các số được random : " + randomLst.toString());
    }
}
