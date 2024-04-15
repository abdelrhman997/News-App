package com.example.newsapp.presentation.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text:String,
    readOnly :Boolean,
    onCLick :(() ->Unit)?=null,
    onValueChange:(String)->Unit,
    onSearch: ()->Unit
){
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value

    LaunchedEffect(key1 =isClicked ){
        if(isClicked){
            onCLick?.invoke()
        }
    }

    Box(modifier = modifier.background(MaterialTheme.colorScheme.background)){
        
        TextField(
            value = text,
            onValueChange = onValueChange,
            readOnly= readOnly,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier=Modifier.padding(16.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant)
            },
            placeholder = {
                          Text(
                              text ="Search",
                              style =MaterialTheme.typography.bodyMedium,
                              color =MaterialTheme.colorScheme.onSurfaceVariant
                          )
            },
            shape = CircleShape,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                textColor = if(isSystemInDarkTheme()) Color.White else Color.Black,
                cursorColor = if(isSystemInDarkTheme()) Color.White else Color.Black,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch={
                    onSearch()
                }
            ),
            textStyle = MaterialTheme.typography.bodySmall,
            interactionSource= interactionSource,
            modifier= Modifier
                .fillMaxWidth()
                .searchBarBorder())
    }
}

fun Modifier.searchBarBorder()=composed {
    if(!isSystemInDarkTheme()){
        border(
            width=1.dp,
            color = Color.Black,
            shape = CircleShape
        )
    }
    else{
        this
    }
}

