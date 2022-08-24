package com.hyejis.composebasic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hyejis.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {  // xml
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

// 뷰
@Composable
fun Greeting(name: String) {
    Scaffold(topBar = { // material 디자인 삽입 (앱바, 플로팅버튼)
        TopAppBar(
            title = { Text("테스트앱") },
            backgroundColor = Color(0xfff25287)
        )
    },floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Text("click")
        } }
    ) {
       // Text(text = "안녕하세용 $name!")
        MyComposableView()
    }
}

@Composable
fun MyComposableView(){
    Log.d("tag","myComposableView : ")
    //vertical linearlayout
    Column (
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState())  // 스크롤 가능
            ){
        for (i in 1..20){
            MyRowItem()
        }
    }
}

@Composable
fun MyRowItem(){
    //horizental linearlayout
    Row(
        Modifier
            .padding(10.dp)
            .background(Color(0xffeaffd0))
            .fillMaxWidth()
        ,
        verticalAlignment = Alignment.CenterVertically// 간격, 위치
    ) {
        Text(text = "hello!!",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Red))
        Spacer(modifier = Modifier.size(10.dp))  //스페이스
        Text(text = "hello!!")
        Text(text = "hello!!")
    }
}

@Preview(showBackground = true)  //미리보기
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        Greeting("Android")
    }
}