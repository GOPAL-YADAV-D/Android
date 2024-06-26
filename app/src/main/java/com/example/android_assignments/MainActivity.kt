package com.example.android_assignments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_assignments.ui.theme.Android_AssignmentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_AssignmentsTheme {
               DiceRollerApp()
            }
        }
    }
}


// Creating a Dice roller App
@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {

    var result:Int by remember {
        mutableStateOf(1)
    }

    val image = when(result){
        1 -> painterResource(id = R.drawable.dice_1)
        2 -> painterResource(id = R.drawable.dice_2)
        3 -> painterResource(id = R.drawable.dice_3)
        4 -> painterResource(id = R.drawable.dice_4)
        5 -> painterResource(id = R.drawable.dice_5)
        else -> painterResource(id = R.drawable.dice_6)
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = image,
            contentDescription ="1"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random()}) {
            Text(text = stringResource(id = R.string.roll))
        }
    }
}
