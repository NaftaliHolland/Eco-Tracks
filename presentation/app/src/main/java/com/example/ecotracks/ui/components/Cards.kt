package com.example.ecotracks.ui.components
import android.graphics.Paint
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.res.stringResource
import com.example.ecotracks.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material3.Checkbox
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.foundation.layout.heightIn
import com.example.ecotracks.model.TextFieldState
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.Brush
import com.example.ecotracks.ui.components.ErrorTextComponent
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecotracks.ui.components.ArticleTitleComponent
import com.example.ecotracks.ui.components.ArticleCardContentComponent
import androidx.compose.material3.CardColors
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import com.example.ecotracks.data.DataSource
import com.example.ecotracks.ui.components.TransportDuration


@Composable
fun TransportActivity(
    modifier: Modifier = Modifier
) {
    val transportMethodsList = DataSource().loadTransportMethods()

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxSize()
        ) {
            //ArticleCardContentComponent(stringResource(id = R.string.how_did_you_travel))
            Text(stringResource(id = R.string.how_did_you_travel))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
            ) {
                items(transportMethodsList) { transportMethod ->
                    TransportMethod(
                        image = transportMethod.image,
                        name = stringResource(id = transportMethod.name)
                    )
                }
            }
            TransportDuration()
        }

    }
}

@Composable
fun TransportMethod(
    image: Int,
    name: String
) {
    Column(modifier = Modifier
        .size(width = 100.dp, height = 150.dp)
        .clickable(
            onClick = { /** TODO **/ }
        ))
    {
        Card(
            modifier = Modifier
                .size(height = 100.dp, width = 100.dp)
                .padding(bottom = dimensionResource(id = R.dimen.padding_small)),

        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = "",
                )
            }
        }

        NormalTextComponent(name)
    }
}
@Composable
fun ArticleCard(
    title: String,
    content: String,
    timeToRead: Int,
    modifier: Modifier = Modifier,
    image: Int,
    navController: NavHostController = rememberNavController()
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
        ,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_medium)),
        colors = CardColors(
            containerColor = Color(0xffbae5e9),
            contentColor = MaterialTheme.colorScheme.scrim,
            disabledContainerColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        onClick = {
            navController.navigate("article/${title}/${content}/${image}")
        }
    ) {
        Box(
            modifier = Modifier
                .background(brush = Brush.horizontalGradient(colors = listOf(Color(0xffd1edf0), Color(0xff8dd3db))))
                .fillMaxSize(),
        ){
            Column(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
            ) {
                ArticleTitleComponent(title)
                ArticleCardContentComponent(content)
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_height_small)))
                ArticleTime(timeToRead)
            }
        }
    }
}

@Composable
fun ActivityCard(
    image: Int,
    name: String,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
        ,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_medium)),
        /*colors = CardColors(
            containerColor = Color(0xffe2a128),
            //containerColor =  Color(0xFFFCB42C),
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary
        ),*/
        onClick = { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = image),
                contentDescription = "",
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
            ArticleCardContentComponent(name)
        }
    }

}

@Composable
fun ArticleTime(time: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.clock),
            contentDescription = "",
            tint = Color.Black
        )
        Text(
            //text = "Hello there"
            text = stringResource(id = R.string.time_to_read, time),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
    }
}


@Composable
fun HomeActivityCard(image: Int, name: String, amountEmitted: Double) {
    Card(
        modifier = Modifier
            .size(height = 150.dp, width = 180.dp),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_small)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp),
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.scrim,
            disabledContainerColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        //border = BorderStroke(width = 0.5.dp, color = MaterialTheme.colorScheme.primary),
        onClick = {}
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(id = image),
                contentDescription = "",
            )
            HeadingTextComponent(name)
            NormalTextComponent(stringResource(id = R.string.carbon_quantity, amountEmitted))
        }
    }

}

@Composable
fun HomeCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_small)),
        //shape = RoundedCornerShape(300.dp),
        //elevation = CardDefaults.cardElevation(
            //defaultElevation = 3.dp),
        /*colors = CardColors(
            containerColor = Color(0xff8dd3db),
            contentColor = MaterialTheme.colorScheme.scrim,
            disabledContainerColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.onPrimary
        ),*/
        //border = BorderStroke(width = 15.dp, color = MaterialTheme.colorScheme.primary),
        onClick = {}
    ) {
        Box(
            modifier = Modifier
                .background(brush = Brush.horizontalGradient(colors = listOf(Color(0xffd1edf0), Color(0xff8dd3db))))
                .fillMaxSize(),
        )
    }
}

@Preview
@Composable
fun TransportActivityPreview() {
    TransportActivity()
}
@Preview(showBackground = true)
@Composable
fun LearnCardPreview() {
    ArticleCard(
        title = "Address energy use and associated financial barriers",
        content = "Transitioning to renewable sources like solar, wind and hydroelectric power can involve significant financial investments and infrastructure changes. Even when implemented, renewable energy sources can be intermittent, making it crucial to develop efficient energy storage solutions for a consistent power supply.\n" +
                "\n" +
                "Some sectors lack well-developed technologies for decarbonization, creating challenges in finding suitable alternatives to high-emissions processes. SAP uses 100% green electricity to power the company’s data centres and is fitting solar across several operations.\n" +
                "\n" +
                "We also invest in collaborations to accelerate and scale green hydrogen production and other solutions. Every sector is different, so working with start-ups and other innovative organizations in your industry is important. Switching to low-carbon technologies and processes often requires substantial upfront investments that might not yield immediate returns, especially for smaller firms that may struggle to secure financing for net zero investments.\n" +
                "\n" +
                "Organizations can explore funding options like green bonds, government incentives and partnerships with sustainable investors. Prioritizing projects with short payback periods can ease financial strain and build confidence.",
        timeToRead = 3,
        image = R.drawable.karsten_wurth_0w_uta0xz7w_unsplash
    )
}

@Preview(showBackground = true)
@Composable
fun ActivityCardPreview() {
    ActivityCard(
        image = R.drawable.transport,
        name = stringResource(id = R.string.transport)
    )
}

@Preview
@Composable
fun TransportMethodPreview() {
    TransportMethod(
        image = R.drawable.transport,
        name = stringResource(id = R.string.transport)
    )
}


@Preview(showBackground = true)
@Composable
fun HomeActivityCardPreview() {
    HomeActivityCard(
        image = R.drawable.transport,
        name = stringResource(id = R.string.transport),
        amountEmitted = 23.23
    )
}

@Preview(showBackground = true)
@Composable
fun HomeCardPreview() {
    HomeCard()
}
