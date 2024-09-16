package com.example.searchbar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Country(val name: String, val code: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchBar()
        }
    }
}

@Composable
fun SearchBar() {
    val query = remember { mutableStateOf("") }
    val countries = listOf(
        Country("Afghanistan", "AFG"),
        Country("Albania", "ALB"),
        Country("Algeria", "DZA"),
        Country("Andorra", "AND"),
        Country("Angola", "AGO"),
        Country("Antigua and Barbuda", "ATG"),
        Country("Argentina", "ARG"),
        Country("Armenia", "ARM"),
        Country("Australia", "AUS"),
        Country("Austria", "AUT"),
        Country("Azerbaijan", "AZE"),
        Country("Bahamas", "BHS"),
        Country("Bahrain", "BHR"),
        Country("Bangladesh", "BGD"),
        Country("Barbados", "BRB"),
        Country("Belarus", "BLR"),
        Country("Belgium", "BEL"),
        Country("Belize", "BLZ"),
        Country("Benin", "BEN"),
        Country("Bhutan", "BTN"),
        Country("Bolivia", "BOL"),
        Country("Bosnia and Herzegovina", "BIH"),
        Country("Botswana", "BWA"),
        Country("Brazil", "BRA"),
        Country("Brunei", "BRN"),
        Country("Bulgaria", "BGR"),
        Country("Burkina Faso", "BFA"),
        Country("Burundi", "BDI"),
        Country("Cabo Verde", "CPV"),
        Country("Cambodia", "KHM"),
        Country("Cameroon", "CMR"),
        Country("Canada", "CAN"),
        Country("Central African Republic", "CAF"),
        Country("Chad", "TCD"),
        Country("Chile", "CHL"),
        Country("China", "CHN"),
        Country("Colombia", "COL"),
        Country("Comoros", "COM"),
        Country("Congo", "COG"),
        Country("Costa Rica", "CRI"),
        Country("Croatia", "HRV"),
        Country("Cuba", "CUB"),
        Country("Cyprus", "CYP"),
        Country("Czechia", "CZE"),
        Country("Democratic Republic of the Congo", "COD"),
        Country("Denmark", "DNK"),
        Country("Djibouti", "DJI"),
        Country("Dominica", "DMA"),
        Country("Dominican Republic", "DOM"),
        Country("Ecuador", "ECU"),
        Country("Egypt", "EGY"),
        Country("El Salvador", "SLV"),
        Country("Equatorial Guinea", "GNQ"),
        Country("Eritrea", "ERI"),
        Country("Estonia", "EST"),
        Country("Eswatini", "SWZ"),
        Country("Ethiopia", "ETH"),
        Country("Fiji", "FJI"),
        Country("Finland", "FIN"),
        Country("France", "FRA"),
        Country("Gabon", "GAB"),
        Country("Gambia", "GMB"),
        Country("Georgia", "GEO"),
        Country("Germany", "DEU"),
        Country("Ghana", "GHA"),
        Country("Greece", "GRC"),
        Country("Grenada", "GRD"),
        Country("Guatemala", "GTM"),
        Country("Guinea", "GIN"),
        Country("Guinea-Bissau", "GNB"),
        Country("Guyana", "GUY"),
        Country("Haiti", "HTI"),
        Country("Honduras", "HND"),
        Country("Hungary", "HUN"),
        Country("Iceland", "ISL"),
        Country("India", "IND"),
        Country("Indonesia", "IDN"),
        Country("Iran", "IRN"),
        Country("Iraq", "IRQ"),
        Country("Ireland", "IRL"),
        Country("Israel", "ISR"),
        Country("Italy", "ITA"),
        Country("Jamaica", "JAM"),
        Country("Japan", "JPN"),
        Country("Jordan", "JOR"),
        Country("Kazakhstan", "KAZ"),
        Country("Kenya", "KEN"),
        Country("Kiribati", "KIR"),
        Country("Kuwait", "KWT"),
        Country("Kyrgyzstan", "KGZ"),
        Country("Laos", "LAO"),
        Country("Latvia", "LVA"),
        Country("Lebanon", "LBN"),
        Country("Lesotho", "LSO"),
        Country("Liberia", "LBR"),
        Country("Libya", "LBY"),
        Country("Liechtenstein", "LIE"),
        Country("Lithuania", "LTU"),
        Country("Luxembourg", "LUX"),
        Country("Madagascar", "MDG"),
        Country("Malawi", "MWI"),
        Country("Malaysia", "MYS"),
        Country("Maldives", "MDV"),
        Country("Mali", "MLI"),
        Country("Malta", "MLT"),
        Country("Marshall Islands", "MHL"),
        Country("Mauritania", "MRT"),
        Country("Mauritius", "MUS"),
        Country("Mexico", "MEX"),
        Country("Micronesia", "FSM"),
        Country("Moldova", "MDA"),
        Country("Monaco", "MCO"),
        Country("Mongolia", "MNG"),
        Country("Montenegro", "MNE"),
        Country("Morocco", "MAR"),
        Country("Mozambique", "MOZ"),
        Country("Myanmar", "MMR"),
        Country("Namibia", "NAM"),
        Country("Nauru", "NRU"),
        Country("Nepal", "NPL"),
        Country("Netherlands", "NLD"),
        Country("New Zealand", "NZL"),
        Country("Nicaragua", "NIC"),
        Country("Niger", "NER"),
        Country("Nigeria", "NGA"),
        Country("North Korea", "PRK"),
        Country("North Macedonia", "MKD"),
        Country("Norway", "NOR"),
        Country("Oman", "OMN"),
        Country("Pakistan", "PAK"),
        Country("Palau", "PLW"),
        Country("Palestine", "PSE"),
        Country("Panama", "PAN"),
        Country("Papua New Guinea", "PNG"),
        Country("Paraguay", "PRY"),
        Country("Peru", "PER"),
        Country("Philippines", "PHL"),
        Country("Poland", "POL"),
        Country("Portugal", "PRT"),
        Country("Qatar", "QAT"),
        Country("Romania", "ROU"),
        Country("Russia", "RUS"),
        Country("Rwanda", "RWA"),
        Country("Saint Kitts and Nevis", "KNA"),
        Country("Saint Lucia", "LCA"),
        Country("Saint Vincent and the Grenadines", "VCT"),
        Country("Samoa", "WSM"),
        Country("San Marino", "SMR"),
        Country("Sao Tome and Principe", "STP"),
        Country("Saudi Arabia", "SAU"),
        Country("Senegal", "SEN"),
        Country("Serbia", "SRB"),
        Country("Seychelles", "SYC"),
        Country("Sierra Leone", "SLE"),
        Country("Singapore", "SGP"),
        Country("Slovakia", "SVK"),
        Country("Slovenia", "SVN"),
        Country("Solomon Islands", "SLB"),
        Country("Somalia", "SOM"),
        Country("South Africa", "ZAF"),
        Country("South Korea", "KOR"),
        Country("South Sudan", "SSD"),
        Country("Spain", "ESP"),
        Country("Sri Lanka", "LKA"),
        Country("Sudan", "SDN"),
        Country("Suriname", "SUR"),
        Country("Sweden", "SWE"),
        Country("Switzerland", "CHE"),
        Country("Syria", "SYR"),
        Country("Tajikistan", "TJK"),
        Country("Tanzania", "TZA"),
        Country("Thailand", "THA"),
        Country("Timor-Leste", "TLS"),
        Country("Togo", "TGO"),
        Country("Tonga", "TON"),
        Country("Trinidad and Tobago", "TTO"),
        Country("Tunisia", "TUN"),
        Country("Turkey", "TUR"),
        Country("Turkmenistan", "TKM"),
        Country("Tuvalu", "TUV"),
        Country("Uganda", "UGA"),
        Country("Ukraine", "UKR"),
        Country("United Arab Emirates", "ARE"),
        Country("United Kingdom", "GBR"),
        Country("United States", "USA"),
        Country("Uruguay", "URY"),
        Country("Uzbekistan", "UZB"),
        Country("Vanuatu", "VUT"),
        Country("Vatican City", "VAT"),
        Country("Venezuela", "VEN"),
        Country("Vietnam", "VNM"),
        Country("Yemen", "YEM"),
        Country("Zambia", "ZMB"),
        Country("Zimbabwe", "ZWE")
    )

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

        val filteredCountries = countries.filter { it.name.contains(query.value, true) }

        filteredCountries.forEach { country ->
            Text(country.name)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    SearchBar()
}