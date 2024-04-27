package com.tripplanner.ui.login

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tripplanner.R
import com.tripplanner.routing.Screen
import com.tripplanner.ui.TripPreference.TripPreference
import com.tripplanner.ui.theme.*
import com.tripplanner.utils.TripField
import com.tripplanner.utils.RoundedButton
import com.tripplanner.utils.isValidEmail

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val preference = remember {
        TripPreference(context)
    }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isUser by remember { mutableStateOf(false) }
    val firebaseAuth = FirebaseAuth.getInstance()
    TripPlannerAppTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(green)
                    .padding(10.dp)
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_trip_planner),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "Trip Planner App",
                    modifier =Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(color = white, fontSize = 18.sp)
                )

                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    "Email",
                    modifier =Modifier.fillMaxWidth(),
                    style = TextStyle(color = white)
                )
                Spacer(modifier = Modifier.height(10.dp))
                TripField(
                    value = email,
                    backgroundColor = white,
                    onValueChange = { text ->
                        email = text
                    },
                    placeholder = "Enter email",
                    keyboardType = KeyboardType.Email,
                )

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Password",
                    modifier =Modifier.fillMaxWidth(),
                    style = TextStyle(color = white)
                )
                Spacer(modifier = Modifier.height(10.dp))
                TripField(
                    value = password,
                    backgroundColor = white,
                    onValueChange = { text ->
                        password = text
                    },
                    placeholder = "Enter Password",
                    keyboardType = KeyboardType.Password,
                    visualTransformation = PasswordVisualTransformation(),
                )

                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                ) {
                    RoundedButton(
                        text = "Login",
                        backgroundColor = white,
                        textColor = green,
                        onClick = {
                            if (email.isNotEmpty()) {
                                if (!isValidEmail(email.toString())) {
                                    if (password.isNotEmpty()) {
                                        isUser = true
                                        firebaseAuth.signInWithEmailAndPassword(email.lowercase(), password)
                                            .addOnCompleteListener { task ->
                                                if (task.isSuccessful) {
                                                    preference.saveData(
                                                        "isLogin", true
                                                    )
                                                    Toast.makeText(
                                                        context, "Login successfully.", Toast.LENGTH_SHORT
                                                    ).show()
                                                    navController.navigate(
                                                        Screen.MainScreen.route
                                                    ) {
                                                        popUpTo(Screen.LoginScreen.route) {
                                                            inclusive = true
                                                        }
                                                    }
                                                    isUser = false
                                                } else {
                                                    Toast.makeText(
                                                        context, task.exception?.message.toString(), Toast.LENGTH_SHORT
                                                    ).show()
                                                    isUser = false
                                                }
                                            }
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "Please enter password.",
                                            Toast.LENGTH_LONG
                                        ).show()

                                    }
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Please enter valid email.",
                                        Toast.LENGTH_LONG
                                    ).show()

                                }
                            } else {
                                Toast.makeText(
                                    context,
                                    "Please enter email.",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    )
                }




            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Don't have an account?",
                        textAlign = TextAlign.End,
                        style = TextStyle(color = white)
                    )

                    Text(
                        " Register", modifier = Modifier.clickable {
                            navController.navigate(Screen.RegisterScreen.route)
                        }, textAlign = TextAlign.End,
                        style = TextStyle(color = white)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            if (isUser) {
                Dialog(
                    onDismissRequest = { },
                    DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(100.dp)
                            .background(white, shape = RoundedCornerShape(8.dp))
                    ) {
                        CircularProgressIndicator(color = green)
                    }
                }
            }

        }
    }
}