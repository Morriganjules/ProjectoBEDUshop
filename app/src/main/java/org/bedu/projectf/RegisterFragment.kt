package org.bedu.projectf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class RegisterFragment : Fragment() {
    private lateinit var btnRegistrarse: MaterialButton
    private lateinit var name: EditText
    private lateinit var nameLayout: TextInputLayout
    private lateinit var email: EditText
    private lateinit var emailLayout: TextInputLayout
    private lateinit var telefono: EditText
    private lateinit var telefonoLayout: TextInputLayout
    private lateinit var password: EditText
    private lateinit var passwordLayout: TextInputLayout
    private lateinit var checkBox: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_register, container, false)
        btnRegistrarse = view.findViewById<MaterialButton>(R.id.btnRegistrarse)
        name =view.findViewById(R.id.textNombre)
        nameLayout = view.findViewById(R.id.nombre)
        email = view.findViewById(R.id.textEmail)
        emailLayout = view.findViewById(R.id.emailReg)
        telefono = view.findViewById(R.id.textTelefono)
        telefonoLayout = view.findViewById(R.id.telefono)
        password = view.findViewById(R.id.textPassword)
        passwordLayout = view.findViewById(R.id.passwordReg)
        checkBox =view.findViewById(R.id.checkbox)


        //Funcionalidades editTexts para registrarse

        btnRegistrarse?.setOnClickListener {
            if (name.text.toString().isEmpty() || email.text.toString().isEmpty() || telefono.text.toString().isEmpty() || password.text.toString().isEmpty() || !checkBox.isChecked ){
                if (name.text.toString().isEmpty()){
                    nameLayout.isErrorEnabled()
                    nameLayout.setError("Ingrese un usuario valido")
                } else if (email.text.toString().isEmpty()){
                    emailLayout.isErrorEnabled()
                    emailLayout.setError("Ingrese un email")
                } else if (telefono.text.toString().isEmpty()){
                    telefonoLayout.isErrorEnabled()
                    telefonoLayout.setError("Ingrese un numero de telefono")
                } else if (password.text.toString().isEmpty()){
                    passwordLayout.isErrorEnabled()
                    passwordLayout.setError("Ingrese una contraseña")
                } else if(!checkBox.isChecked){
                    checkBox.setError("Debe aceptar los terminos y condiciones")
                }
            } else {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment2, null)
            }
        }

        return view
    }


}