package org.bedu.projectf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginFragment : Fragment() {
private lateinit var btnRegister: MaterialButton
private lateinit var btnLogin: MaterialButton
private lateinit var email: EditText
private lateinit var password: EditText
private lateinit var emailLayout: TextInputLayout
private lateinit var passwordLayout: TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menu de login

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        btnRegister = view.findViewById<MaterialButton>(R.id.btnRegister)
        btnLogin = view.findViewById<MaterialButton>(R.id.btnLogin)
        email = view.findViewById<EditText>(R.id.email)
        password = view.findViewById(R.id.contraseña)
        emailLayout = view.findViewById(R.id.emailLayout)
        passwordLayout = view.findViewById(R.id.contraseñaLayout)

        //Funcionalidad boton "registrarse"

        btnRegister?.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment2_to_registerFragment, null)
        }

        //Funcionalidades para acceder a la app

        btnLogin?.setOnClickListener {
            if(email.text.toString().isEmpty() || password.text.toString().isEmpty()){
               if(email.text.toString().isEmpty()){
                    emailLayout.isErrorEnabled()
                    emailLayout.setError("Ingrese un usuario valido")}
               else if(password.text.toString().isEmpty())
              {
                  passwordLayout.isErrorEnabled()
                  passwordLayout.setError("Ingrese su contraseña")
               }
            } else {
            findNavController().navigate(R.id.action_loginFragment2_to_menuActivity, null)
                Toast.makeText(view.context,"Welcome back bitch", Toast.LENGTH_SHORT).show()
            }
        }


        return view
    }




}