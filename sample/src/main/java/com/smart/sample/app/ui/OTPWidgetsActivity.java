package com.smart.sample.app.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.compact.widget.OTPView;
import com.smart.sample.R;

public class OTPWidgetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        OTPView.OnOTPCompleteListener listener = (view, otp) -> {
            if (!otp.toString().trim().equals("123456".trim())) {
                view.setError(true);
                System.out.println("FAIL otp = [" + otp + "]");
                Toast.makeText(OTPWidgetsActivity.this, "FAIL otp = [" + otp + "]", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(OTPWidgetsActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
            }
        };
        final OTPView otpView1 = findViewById(R.id.otp_1);
        final OTPView otpView2 = findViewById(R.id.otp_2);
        otpView1.addOnOTPCompleteListener(listener);
        otpView2.addOnOTPCompleteListener(listener);
    }

}
