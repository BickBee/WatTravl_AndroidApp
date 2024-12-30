package com.example.wattravl

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.wattravl.viewmodel.EmailVerifier

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var verificationCodeEditText: EditText
    private lateinit var nextButton: Button
    private lateinit var loginButton: Button
    private lateinit var backButton: ImageButton
    private lateinit var resendCodeButton: Button

    private lateinit var sharedPref: SharedPreferences
    private lateinit var emailVerifier: EmailVerifier

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        emailVerifier = EmailVerifier(this)
        // Start with the email input step
        showEmailStep()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showEmailStep() {
        setContentView(R.layout.activity_login_step1)

        emailEditText = findViewById(R.id.emailEditText)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (isValidEmail(email) && email.endsWith("@uwaterloo.ca")) {
                // Save the email and move to the next step
                sharedPref.edit().putString("email", email).apply()

                // Send the verification code to the user's email
                sendVerificationCode(email)

                // Move to the next step
                showVerificationStep()
            } else {
                if (!email.endsWith("@uwaterloo.ca")) {
                    Toast.makeText(this, "Email is not a Waterloo email", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showVerificationStep() {
        setContentView(R.layout.activity_login_step2)

        verificationCodeEditText = findViewById(R.id.verificationCodeEditText)
        loginButton = findViewById(R.id.loginButton)
        backButton = findViewById(R.id.backButton)
        resendCodeButton = findViewById(R.id.resendCodeButton)

        backButton.setOnClickListener {
            // Go back to email input step
            showEmailStep()
        }

        resendCodeButton.setOnClickListener {
            val email = sharedPref.getString("email", null)
            if (email != null) {
                // Resend the verification code to the saved email
                sendVerificationCode(email)
            } else {
                Toast.makeText(this, "Error: No email found", Toast.LENGTH_SHORT).show()
            }
        }

        loginButton.setOnClickListener {
            val verificationCode = verificationCodeEditText.text.toString()

            if (isValidVerificationCode(verificationCode)) {
                // Save login state
                sharedPref.edit().putBoolean("isLoggedIn", true).apply()

                // Go to the main activity
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid verification code", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun sendVerificationCode(email: String): Boolean {
        // Logic to send a verification code to the provided email
        // This is just a placeholder. Implement actual email sending here.
        Toast.makeText(this, "Verification code sent to $email", Toast.LENGTH_SHORT).show()
        return emailVerifier.sendEmail(email)
        // return true
    }

    private fun isValidVerificationCode(code: String): Boolean {
        // Placeholder for actual verification logic

        //return code == "123456"
        return emailVerifier.verifyCode(code)
    }
}
