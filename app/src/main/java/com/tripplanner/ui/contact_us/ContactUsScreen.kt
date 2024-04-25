package com.tripplanner.ui.contact_us

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tripplanner.ui.theme.TripPlannerAppTheme
import com.tripplanner.ui.theme.black
import com.tripplanner.ui.theme.green
import com.tripplanner.ui.theme.white
import com.tripplanner.utils.OutlineFormField
import com.tripplanner.utils.RoundedButton

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContactUsScreen(navController: NavController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    TripPlannerAppTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = green)
                    .padding(top = 40.dp)
            ) {
                SmallTopAppBar(
                    title = {
                        Text(
                            text = "Contact Us", color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navController.navigateUp()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBack,
                                tint = Color.White,
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = green,
                        titleContentColor = Color.White
                    )
                )

                Column(modifier = Modifier.fillMaxSize().background(color = white).padding(10.dp)) {
                    Text(
                        "Name",
                        modifier =Modifier.fillMaxWidth(),
                        style = TextStyle(color = black)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlineFormField(
                        value = name,
                        backgroundColor = black,
                        onValueChange = { text ->
                            name = text
                        },
                        placeholder = "Enter name",
                        keyboardType = KeyboardType.Text,
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        "Email",
                        modifier =Modifier.fillMaxWidth(),
                        style = TextStyle(color = black)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlineFormField(
                        value = email,
                        backgroundColor = black,
                        onValueChange = { text ->
                            email = text
                        },
                        placeholder = "Enter email",
                        keyboardType = KeyboardType.Email,
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Message",
                        modifier =Modifier.fillMaxWidth(),
                        style = TextStyle(color = black)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlineFormField(
                        value = message,
                        backgroundColor = black,
                        onValueChange = { text ->
                            message = text
                        },
                        placeholder = "Enter full message",
                        keyboardType = KeyboardType.Text,
                    )

                    Spacer(modifier = Modifier.height(30.dp))
                    Column(
                        modifier = Modifier.fillMaxSize().padding(bottom = 20.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {

                        Box(Modifier.padding(15.dp)) {
                            RoundedButton(
                                text = "Submit",
                                textColor = white,
                                backgroundColor = green,
                                onClick = {
                                    if (name.isNotEmpty()) {
                                        if (email.isNotEmpty()) {
                                            if (message.isNotEmpty()) {
                                                Toast.makeText(
                                                    context,
                                                    "Successfully submitted..",
                                                    Toast.LENGTH_LONG
                                                ).show()
                                                navController.navigateUp()
                                            } else {
                                                Toast.makeText(
                                                    context,
                                                    "Please enter message.",
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
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "Please enter name.",
                                            Toast.LENGTH_LONG
                                        ).show()
                                    }
                                }
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }

            }
        }


    }
}