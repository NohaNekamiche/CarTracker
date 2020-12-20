package com.example.cartracker.authentification

import android.Manifest
import android.app.Activity
import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cartracker.R
import org.json.JSONObject

class Inscription_page : AppCompatActivity() {
    private val PERMISSION_CODE = 1000;
    private val IMAGE_CAPTURE_CODE = 1001
    var image_uri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription_page)
        val goLogin : Button
        goLogin = findViewById(R.id.go_to_login)
        val imgProfile = findViewById<ImageView>(R.id.imgProfile)
        val imgPermis = findViewById<ImageView>(R.id.imgPermis)
        takePic(imgProfile)
        takePic(imgPermis)
        goLogin.setOnClickListener {
            val nom =findViewById<EditText>(R.id.nom).text.toString().trim()
            val prenom =findViewById<EditText>(R.id.prenom).text.toString().trim()
            val email =findViewById<EditText>(R.id.email).text.toString().trim()
            val password =findViewById<EditText>(R.id.pw).text.toString().trim()
            val dateNais=findViewById<EditText>(R.id.dateNaiss).text.toString().trim()
            val numSerie =findViewById<EditText>(R.id.numSerie).text.toString().trim()
            if(nom.isEmpty()){
                findViewById<EditText>(R.id.nom).error= "Nom Erroner"
                findViewById<EditText>(R.id.nom).requestFocus()
                return@setOnClickListener
            }
            if(prenom.isEmpty()){
                findViewById<EditText>(R.id.prenom).error= "Prenom Erroner"
                findViewById<EditText>(R.id.prenom).requestFocus()
                return@setOnClickListener
            }
            if(email.isEmpty()){
                findViewById<EditText>(R.id.email).error= "Email Erroner"
                findViewById<EditText>(R.id.email).requestFocus()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                findViewById<EditText>(R.id.pw).error= "Password Erroner"
                findViewById<EditText>(R.id.pw).requestFocus()
                return@setOnClickListener
            }

            if(dateNais.isEmpty()) {
                findViewById<EditText>(R.id.dateNaiss).error= "Date Naissance Erroner"
                findViewById<EditText>(R.id.dateNaiss).requestFocus()
                return@setOnClickListener
            }
            if(numSerie.isEmpty()){
                findViewById<EditText>(R.id.numSerie).error= "N° Serie Erroner"
                findViewById<EditText>(R.id.numSerie).requestFocus()
                return@setOnClickListener
            }

           // val intent = Intent(this@Inscription_page, login_page::class.java)
            //startActivity(intent)
          /*  RetrofitInstance.api.createDriver(nom,prenom,dateNais,"","",
            "","",numSerie.toLong(),numSerie.toLong(),0,5,email,password)
                    .enqueue(object : retrofit2.Callback<DefaultReponse> {
                        override fun onFailure(call: Call<DefaultReponse>, t: Throwable) {
                           Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(call: Call<DefaultReponse>, response: Response<DefaultReponse>) {
                            Toast.makeText(applicationContext,response.body()?.message,Toast.LENGTH_LONG).show()
                        }

                    })*/
            var volleyRequestQueue : RequestQueue? =null
            var dialog: ProgressDialog? = null
            val serverAPIURL: String = "https://handyopinion.com/tutorials/signup.php"
            val TAG = "Handy Opinion Tutorials"

            fun SendSignUpDataToServer(firstName: String, lastName: String, email: String, password: String) {
                volleyRequestQueue = Volley.newRequestQueue(this)
                dialog = ProgressDialog.show(this, "", "Please wait...", true);
                val parameters: MutableMap<String, String> = HashMap()
                // Add your parameters in HashMap
                parameters.put("firstName",firstName);
                parameters.put("lastName",lastName);
                parameters.put("email",email);
                parameters.put("password",password);

                val strReq: StringRequest = object : StringRequest(
                        Method.POST,serverAPIURL,
                        Response.Listener { response ->
                            Log.e(TAG, "response: " + response)
                            dialog?.dismiss()

                            // Handle Server response here
                            try {
                                val responseObj = JSONObject(response)
                                val isSuccess = responseObj.getBoolean("isSuccess")
                                val code = responseObj.getInt("code")
                                val message = responseObj.getString("message")
                                if (responseObj.has("data")) {
                                    val data = responseObj.getJSONObject("data")
                                    // Handle your server response data here
                                }
                                Toast.makeText(this,message,Toast.LENGTH_LONG).show()

                            } catch (e: Exception) { // caught while parsing the response
                                Log.e(TAG, "problem occurred")
                                e.printStackTrace()
                            }
                        },
                        Response.ErrorListener { volleyError -> // error occurred
                            Log.e(TAG, "problem occurred, volley error: " + volleyError.message)
                        }) {

                    override fun getParams(): MutableMap<String, String> {
                        return parameters;
                    }

                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): Map<String, String> {

                        val headers: MutableMap<String, String> = HashMap()
                        // Add your Header paramters here
                        return headers
                    }
                }
                // Adding request to request queue
                volleyRequestQueue?.add(strReq)
            }


        }
    }
    private fun openCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        //camera intent
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //called when user presses ALLOW or DENY from Permission Request Popup
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    //permission from popup was granted
                    openCamera()
                }
                else{
                    //permission from popup was denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //called when image was captured from camera intent
        if (resultCode == Activity.RESULT_OK){
            //set image captured to image view
            val image_view :ImageView
            image_view= findViewById(R.id.imgProfile)
            image_view.setImageURI(image_uri)
        }else {
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
    private fun takePic(img: ImageView){
        img.setOnClickListener {
            //if system os is Marshmallow or Above, we need to request runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_DENIED ||
                        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_DENIED){
                    //permission was not enabled
                    val permission = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    //show popup to request permission
                    requestPermissions(permission, PERMISSION_CODE)
                }
                else{
                    //permission already granted
                    openCamera()
                }
            }
            else{
                //system os is < marshmallow
                openCamera()
            }
        }
    }

}