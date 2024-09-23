package com.example.searchbar

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

data class Country(val name: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchBar(this)
        }
    }
}

@Composable
fun SearchBar(context: Context) {
    val query = remember { mutableStateOf("") }
    val countries = listOf(
        Country("Afghanistan"),
        Country("Albania"),
        Country("Algeria"),
        Country("Andorra"),
        Country("Angola"),
        Country("Antigua and Barbuda"),
        Country("Argentina"),
        Country("Armenia"),
        Country("Australia"),
        Country("Austria"),
        Country("Azerbaijan"),
        Country("Bahamas"),
        Country("Bahrain"),
        Country("Bangladesh"),
        Country("Barbados"),
        Country("Belarus"),
        Country("Belgium"),
        Country("Belize"),
        Country("Benin"),
        Country("Bhutan"),
        Country("Bolivia"),
        Country("Bosnia and Herzegovina"),
        Country("Botswana"),
        Country("Brazil"),
        Country("Brunei"),
        Country("Bulgaria"),
        Country("Burkina Faso"),
        Country("Burundi"),
        Country("Côte d'Ivoire"),
        Country("Cambodia"),
        Country("Cameroon"),
        Country("Canada"),
        Country("Central African Republic"),
        Country("Chad"),
        Country("Chile"),
        Country("China"),
        Country("Colombia"),
        Country("Comoros"),
        Country("Congo"),
        Country("Costa Rica"),
        Country("Croatia"),
        Country("Cuba"),
        Country("Cyprus"),
        Country("Czech Republic"),
        Country("Denmark"),
        Country("Djibouti"),
        Country("Dominica"),
        Country("Dominican Republic"),
        Country("Ecuador"),
        Country("Egypt"),
        Country("El Salvador"),
        Country("Equatorial Guinea"),
        Country("Eritrea"),
        Country("Estonia"),
        Country("Ethiopia"),
        Country("Fiji"),
        Country("Finland"),
        Country("France"),
        Country("Gabon"),
        Country("Gambia"),
        Country("Georgia"),
        Country("Germany"),
        Country("Ghana"),
        Country("Greece"),
        Country("Grenada"),
        Country("Guatemala"),
        Country("Guinea"),
        Country("Guinea-Bissau"),
        Country("Guyana"),
        Country("Haiti"),
        Country("Honduras"),
        Country("Hungary"),
        Country("Iceland"),
        Country("India"),
        Country("Indonesia"),
        Country("Iran"),
        Country("Iraq"),
        Country("Ireland"),
        Country("Israel"),
        Country("Italy"),
        Country("Jamaica"),
        Country("Japan"),
        Country("Jordan"),
        Country("Kazakhstan"),
        Country("Kenya"),
        Country("Kiribati"),
        Country("North Korea"),
        Country("South Korea"),
        Country("Kuwait"),
        Country("Kyrgyzstan"),
        Country("Laos"),
        Country("Latvia"),
        Country("Lebanon"),
        Country("Lesotho"),
        Country("Liberia"),
        Country("Libya"),
        Country("Lithuania"),
        Country("Luxembourg"),
        Country("Macedonia"),
        Country("Madagascar"),
        Country("Malawi"),
        Country("Malaysia"),
        Country("Maldives"),
        Country("Mali"),
        Country("Malta"),
        Country("Marshall Islands"),
        Country("Mauritania"),
        Country("Mauritius"),
        Country("Mexico"),
        Country("Micronesia"),
        Country("Moldova"),
        Country("Monaco"),
        Country("Mongolia"),
        Country("Montenegro"),
        Country("Morocco"),
        Country("Mozambique"),
        Country("Myanmar"),
        Country("Namibia"),
        Country("Nauru"),
        Country("Nepal"),
        Country("Netherlands"),
        Country("New Zealand"),
        Country("Nicaragua"),
        Country("Niger"),
        Country("Nigeria"),
        Country("Norway"),
        Country("Oman"),
        Country("Pakistan"),
        Country("Palau"),
        Country("Panama"),
        Country("Papua New Guinea"),
        Country("Paraguay"),
        Country("Peru"),
        Country("Philippines"),
        Country("Poland"),
        Country("Portugal"),
        Country("Qatar"),
        Country("Romania"),
        Country("Russia"),
        Country("Rwanda"),
        Country("Saint Kitts and Nevis"),
        Country("Saint Lucia"),
        Country("Saint Vincent and the Grenadines"),
        Country("Samoa"),
        Country("San Marino"),
        Country("Sao Tome and Principe"),
        Country("Saudi Arabia"),
        Country("Senegal"),
        Country("Serbia"),
        Country("Seychelles"),
        Country("Sierra Leone"),
        Country("Singapore"),
        Country("Sint Maarten"),
        Country("Slovakia"),
        Country("Slovenia"),
        Country("Solomon Islands"),
        Country("Somalia"),
        Country("South Africa"),
        Country("South Sudan"),
        Country("Spain"),
        Country("Sri Lanka"),
        Country("Sudan"),
        Country("Suriname"),
        Country("Swaziland"),
        Country("Sweden"),
        Country("Switzerland"),
        Country("Syria"),
        Country("Tajikistan"),
        Country("Tanzania"),
        Country("Thailand"),
        Country("Timor-Leste"),
        Country("Togo"),
        Country("Tonga"),
        Country("Trinidad and Tobago"),
        Country("Tunisia"),
        Country("Turkey"),
        Country("Turkmenistan"),
        Country("Tuvalu"),
        Country("Uganda"),
        Country("Ukraine"),
        Country("United Arab Emirates"),
        Country("United Kingdom"),
        Country("United States"),
        Country("Uruguay"),
        Country("Uzbekistan"),
        Country("Vanuatu"),
        Country("Vatican City"),
        Country("Venezuela"),
        Country("Vietnam"),
        Country("Yemen"),
        Country("Zambia"),
        Country("Zimbabwe")
    )

    fun showCountryInToast(countryName: String) {
        val country = countries.find { it.name == countryName }
        if (country != null) {
            Toast.makeText(context, "Country: ${country.name}", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Country not found", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = query.value,
            onValueChange = { query.value = it },
            label = { Text("Search") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { /* handle done action */ })
        )

        if (query.value.isNotEmpty()) {
            val filteredCountries = countries.filter { it.name.contains(query.value, true) }

            filteredCountries.forEach { country ->
                Clickable(onClick = {
                    Toast.makeText(context, "You selected: ${country.name}", Toast.LENGTH_SHORT).show()
                }) {
                    Text(country.name)
                }
            }
        }
    }
}

@Composable
fun Clickable(onClick: () -> Unit, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        content()
    }
}

fun showToastFullScreenWidth(activity: Activity, message: String) {
    val toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
    val layoutParams = toast.view?.layoutParams as? WindowManager.LayoutParams
    layoutParams?.width = WindowManager.LayoutParams.MATCH_PARENT
    toast.show()
}




