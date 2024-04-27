package com.tripplanner.ui.searchListing

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import com.tripplanner.R
import com.tripplanner.routing.Screen
import com.tripplanner.ui.model.TripModel
import com.tripplanner.ui.theme.TripPlannerAppTheme
import com.tripplanner.ui.theme.black
import com.tripplanner.ui.theme.green
import com.tripplanner.ui.theme.white
import com.tripplanner.utils.GradientButton

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val list = arrayListOf<TripModel>().apply {
        add(TripModel(name = "New Delhi to Europe Trip"))
        add(TripModel(name = "New Delhi to Paris Trip"))
        add(TripModel(name = "New Delhi to Amsterdam Trip"))
        add(TripModel(name = "New Delhi to Switzerland Trip"))
        add(TripModel(name = "New Delhi to London Trip"))

    }
    TripPlannerAppTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .background(color = green)
                    .padding(top = 40.dp)
                    .verticalScroll(scrollState)
            ) {
                SmallTopAppBar(
                    title = {
                        Text(
                            text = "Search Trip", color = Color.White,
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
                Spacer(Modifier.height(10.dp))
                Column {
                    list.forEachIndexed { index, model ->
                        var isTaveller by rememberSaveable {
                            mutableStateOf(false)
                        }
                        val taveller = arrayListOf(
                            "1","2", "3",
                            "4", "5",
                            "6"
                        )
                        var selectedTraveller by remember { mutableStateOf("") }
                        Card(
                            modifier = Modifier
                                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_trip_planner),
                                contentDescription = "Image",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
                            )
                            Text(
                                model.name ?: "",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(vertical = 5.dp, horizontal = 10.dp)
                            )
                            Spacer(Modifier.height(10.dp))
                            OutlinedTextField(
                                value = if (selectedTraveller != "") selectedTraveller else "Select Number of travellers",
                                onValueChange = { selectedTraveller = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .clickable { isTaveller = !isTaveller },
                                enabled = false,
                                trailingIcon = {
                                    Icon(
                                        if (isTaveller)
                                            Icons.Filled.KeyboardArrowUp
                                        else
                                            Icons.Filled.KeyboardArrowDown,
                                        "contentDescription",

                                        )
                                },
                                textStyle = TextStyle(color = black)
                            )
                            Box {
                                if (isTaveller) {
                                    Popup(
                                        alignment = Alignment.TopCenter,
                                        properties = PopupProperties(
                                            excludeFromSystemGesture = true,
                                        ),
                                        onDismissRequest = { isTaveller = false }
                                    ) {

                                        Column(
                                            modifier = Modifier
                                                .border(width = 1.dp, color = Color.Gray)
                                                .background(white),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                        ) {

                                            taveller.onEachIndexed { index, item ->
                                                if (index != 0) {
                                                    Divider(thickness = 1.dp, color = Color.LightGray)
                                                }
                                                Box(
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(10.dp)
                                                        .clickable {
                                                            selectedTraveller = item
                                                            isTaveller = !isTaveller
                                                        },
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text(text = item, style = TextStyle(color = black))
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                            Spacer(Modifier.height(10.dp))
                            Row(
                                modifier = Modifier
                            ) {
                                GradientButton(
                                    onClick = {
                                        if(selectedTraveller.isEmpty()) {
                                            Toast.makeText(context, "Please select number of travellers.", Toast.LENGTH_SHORT).show()
                                        }else {
                                            navController.navigate(Screen.Detail.route + "/${model.name}" + "/${index}")
                                        }

                                    },
                                    modifier = Modifier
                                        .padding(vertical = 5.dp)
                                        .fillMaxWidth(),
                                    textColor = white,
                                    isEnabled = true,
                                    gradient = Brush.horizontalGradient(listOf(green, green)),
                                    text = "Select Trip"
                                )
                            }

                        }
                    }
                }
            }
        }


    }

}