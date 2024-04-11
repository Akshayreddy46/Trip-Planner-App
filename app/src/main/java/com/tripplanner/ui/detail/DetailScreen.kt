package com.tripplanner.ui.detail

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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
import com.tripplanner.utils.RoundedButton

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
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
                            text = "Detail", color = Color.White,
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
                    actions = {
                        IconButton(
                            onClick = {
                            }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_contact_us),
                                contentDescription = "Image",
                                contentScale = ContentScale.Fit,
                                colorFilter = ColorFilter.tint(Color.White),
                                modifier = Modifier
                                    .width(35.dp)
                                    .height(35.dp)
                                    .clickable {
                                        navController.navigate(Screen.ContactUsScreen.route)
                                    }
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = green,
                        titleContentColor = Color.White
                    )
                )

                Column(modifier = Modifier.fillMaxSize().background(color = white)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_trip_planner),
                        contentDescription = "Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Jaipur to Jaisalmar",
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Distance : 420 km",
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Budget : 1000/- per each" ,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Total Member : 5" ,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Vehicle : Traveller" ,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Total Budget : 5000/-" ,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                    )
                    Spacer(Modifier.height(10.dp))
                    Column(
                        modifier = Modifier.fillMaxSize().padding(bottom = 20.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {

                        Box(Modifier.padding(15.dp)) {
                            RoundedButton(
                                text = "Book Transportation",
                                textColor = white,
                                backgroundColor = green,
                                onClick = {

                                    navController.navigate(Screen.BookScreen.route)
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