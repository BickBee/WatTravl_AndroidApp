package com.example.wattravl.viewmodel

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.wattravl.LoginActivity
import com.sendgrid.helpers.mail.objects.Content
import com.sendgrid.helpers.mail.objects.Email
import uk.co.jakebreen.sendgridandroid.SendGrid
import uk.co.jakebreen.sendgridandroid.SendGridMail
import uk.co.jakebreen.sendgridandroid.SendTask
import java.time.Duration
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.random.Random


// TODO(SendGrid is not built for Android. Implement another service like AWS SES tomorrow)
// TODO(Add throttling code to prevent users for spam sending emails. Save the last sent time somewhere)
// Limit to sending 10 emails per day

private val logger = Logger.getLogger("EmailVerifier")
private val cap = 5

class EmailVerifier(
    private val activity: LoginActivity,
) {
    var secretCode = ""
    @RequiresApi(Build.VERSION_CODES.O)
    fun sendEmail(toEmailString: String): Boolean {
        val pref = activity.getSharedPreferences("LOGINS", Context.MODE_PRIVATE)
        var canSendEmail = false
        var moveEnd = 0

        // COMMENT OUT AFTER DEBUG

        /*
        val edit = pref.edit()
        edit.putLong("lastLogin1", 0L)
        edit.commit()
         */

        for (i in 1..cap) {
            if (pref.getLong("lastLogin$i", 0) == 0L) {
                // we permit sending a new email
                canSendEmail = true
                moveEnd = i - 1
                break
            }
        }
        if (!canSendEmail) {
            // Check if the 10th last login was a day ago
            val farLogin = pref.getLong("lastLogin$cap", 0)
            if (System.currentTimeMillis() - farLogin > Duration.ofDays(1).toMillis()) {
                canSendEmail = true
                moveEnd = cap - 1
            } else {
                Toast.makeText(activity, "Too many verifications, please wait 24 hours", Toast.LENGTH_SHORT).show()
                return false
            }
        }

        // move all emails from 1 to moveEnd to 2 to moveEnd + 1
        val editor = pref.edit()
        for (i in moveEnd downTo 1) {
            val loginTime = pref.getLong("lastLogin$i", 0)
            assert(loginTime != 0L)

            editor.putLong("lastLogin${i + 1}", loginTime)
        }
        editor.putLong("lastLogin1", System.currentTimeMillis())

        secretCode = ""
        for (i in 1..6) {
            secretCode += Random.nextInt(0, 10).digitToChar()
        }
        editor.putString("secretCode", secretCode)
        editor.apply()
        // logger.log(Level.INFO, "Secret code is $secretCode")

        val fromEmail = Email("pduc07622@gmail.com")
        val subject = "WatTravl verification code"
        val toEmail = Email(toEmailString)
        val content = Content("text/plain", "Verification code: $secretCode")

        // val mail = Mail(fromEmail, subject, toEmail, content)
        val mail = SendGridMail()
        mail.addRecipient(toEmailString, "User")
        mail.setFrom(fromEmail.email, "WatTravl")
        mail.setSubject(subject)
        mail.setContent("Verification code: $secretCode")

        val sendGrid = SendGrid.create("App won't work without the sendgrid API key here. Removed temporarily.")
        val task = SendTask(sendGrid)
        val response = task.send(mail)

        if (!response.isSuccessful) {
            logger.log(Level.WARNING, "Failed to send verification email, error code ${response.code}")
            return false
        } else {
            logger.log(Level.INFO, "Successfully sent verification email")
            Toast.makeText(activity, "Verification code sent to $toEmailString", Toast.LENGTH_SHORT).show()
        }

        return true

        /*
        // val sg = SendGrid("App won't work without the sendgrid API key here. Removed temporarily.")
        // val sg = SendGrid.create("App won't work without the sendgrid API key here. Removed temporarily.")
        val request = Request()
        try {
            request.method = Method.POST
            request.endpoint = "mail/send"
            request.body = mail.build()
            val resp = sg.api(request)
        } catch (e: Exception) {
            logger.log(Level.WARNING, "Cannot send verification email")
        }

         */
    }

    fun verifyCode(code: String): Boolean {
        val pref = activity.getSharedPreferences("LOGINS", Context.MODE_PRIVATE)
        val secretCode = pref.getString("secretCode", "")

        if (secretCode != "" && code == secretCode) return true
        else return false
    }
}