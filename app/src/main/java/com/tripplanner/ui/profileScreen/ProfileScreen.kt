package com.tripplanner.ui.profileScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import com.tripplanner.R
import com.tripplanner.routing.Screen
import com.tripplanner.ui.theme.TripPlannerAppTheme
import com.tripplanner.ui.theme.black
import com.tripplanner.ui.theme.green
import com.tripplanner.ui.theme.white
import com.tripplanner.utils.OutlineFormField
import com.tripplanner.utils.RoundedButton

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    var name by remember { mutableStateOf("Test") }
    var email by remember { mutableStateOf("Test@mail.com") }
    TripPlannerAppTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .background(color = green)
                    .fillMaxSize()
                    .padding(top = 40.dp)
            ) {
                SmallTopAppBar(
                    title = {
                        Text(
                            text = "Profile", color = Color.White,
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
                            Icon(imageVector = Icons.Rounded.ArrowBack,
                                tint = Color.White,
                                contentDescription = "Back")
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

                    Spacer(modifier = Modifier.height(20.dp))

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
                                    Toast.makeText(context,"Profile Update Successfully.",Toast.LENGTH_SHORT).show()
                                    navController.navigateUp()
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