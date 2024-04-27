package com.tripplanner.utils

import java.util.regex.Pattern

fun isValidEmail(s: String): Boolean {
    val emailPattern = ("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
            + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
            + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
            + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
            + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")
    val pattern = Pattern.compile(emailPattern)
    val matcher = pattern.matcher(s)

    return !matcher.matches()
}

fun getData(index:String) : String {
    var data = ""
    when(index) {
        "0" -> {
            data =  "Delhi>>Paris>>Amsterdam>>switzerland(multiple cities)>>Venice>>Pisa>>Rome>>delhi .\n" +
                    "\n" +
                    "Itinerary:\n" +
                    "⦁\tParis-3 days\n" +
                    "⦁\tAmsterdam-2 days\n" +
                    "⦁\tSwitzerland-3 days\n" +
                    "⦁\tVenice-2 days\n" +
                    "⦁\tPisa-half day\n" +
                    "⦁\tRome-3 and a half days\n" +
                    "⦁\t24 hours flight -to and fro\n" +
                    "\n" +
                    "\n" +
                    "Expenses: 1700 Gbp for each person\n" +
                    "\n" +
                    "You can calculate based on number of persons and can display the total expenses approximately.\n"
        }
        "1" -> {
            data = "Day 1: Departure from Delhi\n" +
                    "⦁\tFly from Delhi to Paris. arrive in Paris is Charles de Gaulle Airport (CDG).\n" +
                    "Day 2-4: Exploring Paris\n" +
                    "⦁\tmust-visit places include the Eiffel Tower, Louvre Museum, Notre-Dame Cathedral, Champs-Élysées, Montmartre, and the Seine River.\n" +
                    "⦁\tTake a cruise along the Seine River to enjoy the scenic beauty of Paris.\n" +
                    "\n" +
                    "Day 5: Day Trip to Versailles\n" +
                    "⦁\tTake a day trip to the Palace of Versailles, located just outside of Paris. Explore the stunning palace, its gardens, and the Hall of Mirrors. It's recommended to book tickets in advance to avoid long queues.\n" +
                    "\n" +
                    "⦁\t.\n" +
                    "Day 6: Cultural Immersion\n" +
                    "⦁\tVisit art galleries, charming boutiques, and local markets.\n" +
                    "⦁\tIndulge in French pastries and macarons at renowned patisseries.\n" +
                    "⦁\tEnjoy a traditional French dinner at a local bistro.\n" +
                    "⦁\t\n" +
                    "Day 7: Departure\n" +
                    "⦁\tDepending on your flight time, you may have some free time to explore more of the city or do any last-minute shopping.\n" +
                    "⦁\tDepart from Paris to Delhi.\n" +
                    "\n" +
                    "Expenses: 2500 Gbp Approximate Per person\n" +
                    "\n" +
                    "You can calculate based on number of persons and can display the total expenses approximately.\n"
        }
        "2" -> {
            data = "Amsterdam is a beautiful city to visit and I would highly recommend to visit during early spring i.e., April or March.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Days Required: 5-6\n" +
                    "\n" +
                    "stay\n" +
                    "\n" +
                    "\n" +
                    "Hostel Recommendation - Hostel Meininger City West Amsterdam.\n" +
                    "\n" +
                    "The Hostel is beautiful and nothing less than a good Indian hotel.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "How to roam around into the city?\n" +
                    "\n" +
                    "\n" +
                    "Buy a multi entry GVB pass for 4 days. This pass is valid for 4 days from your first check-in. The cost of the pass is 22.5 Euros.\n" +
                    "\n" +
                    "Pass is valid for bus, tram and metro. This pass is not valid for the trains.\n" +
                    "\n" +
                    "Where to visit?\n" +
                    "\n" +
                    "-Tulip Garden\n" +
                    "\n" +
                    "-Rijksmuseum\n" +
                    "\n" +
                    "\n" +
                    "--Van Gogh Museum - \n" +
                    "\n" +
                    "\n" +
                    "Central Station and Dam Square-\n" +
                    "\n" +
                    "\n" +
                    "Dam square \n" +
                    "\n" +
                    "\n" +
                    "Albert Cyub Market / Flower Market .\n" +
                    "\n" +
                    "Flower Market- \n" +
                    "\n" +
                    "\n" +
                    "The famous RLD Area - \n" +
                    "\n" +
                    "\n" +
                    "Country Side (ZaanseSchans)\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Enjoy your stay in the paradise for Youth on this earth !\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Expenses per person: 1300 GBp \n" +
                    "\n" +
                    "\n" +
                    "You can calculate based on number of persons and can display the total expenses approximately.\n"
        }
        "3" -> {
            data = "Days Required: 5-6\n" +
                    "\n" +
                    "\n" +
                    "Day 1-2: New Delhi Airport to Zurich Airport at 10.00 AM\n" +
                    "\n" +
                    "Day 3\n" +
                    "Zurich Airport to Rhine Falls (Unimaginable water falls !)\n" +
                    "\n" +
                    "Rhine falls to Luzerne\n" +
                    "\n" +
                    "Lucerne to Vitznau via Ferry\n" +
                    "\n" +
                    "Vitznau to Mount Rigi by Mountain Train (Very beautiful views !)\n" +
                    "\n" +
                    "Mount Rigi to my hotel in Zurich\n" +
                    "\n" +
                    "Day 4 :\n" +
                    "\n" +
                    "Zurich to Mount Titlis via Luzerne\n" +
                    "\n" +
                    "Availed 50% off on the tickets to top of Mount Titlis as i had Swiss pass.\n" +
                    "\n" +
                    "Titlis to Luzerne and visit to lakefront\n" +
                    "\n" +
                    "Luzerne to Zurich for overnight stay.\n" +
                    "\n" +
                    "Day 5 :\n" +
                    "\n" +
                    "Zurich to Interlaken via Bern by Train\n" +
                    "\n" +
                    "Interlaken to Brienz via Ferry (Brienz was simply supeb !)\n" +
                    "\n" +
                    "Brienz to Luzerne via Interlaken Express ( Most beautiful train journey !)\n" +
                    "\n" +
                    "Luzerne to Zurich Airport for my flight.\n" +
                    "\n" +
                    "Day 6 Zurich to New Delhi\n" +
                    "\n" +
                    "buy swiss pass since it has many advantages such as providing free access to all modes of transport, No need to wait at any counter for buying ticket and saves time ! \n" +
                    "\n" +
                    "\n" +
                    "Expenses per person: 1700 GBp \n" +
                    "\n" +
                    "\n" +
                    "You can calculate based on number of persons and can display the total expenses approximately.\n" +
                    "\n"
        }
        "4" -> {
            data = "\n" +
                    "museums, such as the Science Museum and Natural History Museum. \n" +
                    "\n" +
                    "Another day where you can simply walk the city and see the bigger tourist attractions in Westminster, Piccadilly Circus, etc… \n" +
                    "\n" +
                    "\n" +
                    "Take one day to get on a hop-on, hop-off, and hit several different spots around town. You’ll want to spend time in Soho, especially if you enjoy shopping. \n" +
                    "\n" +
                    "Another great thing about London is its proximity to Stonehenge, which makes a great day trip. \n" +
                    "\n" +
                    "City of Bath, which is absolutely lovely. This will give you another day to simply get lost, hit pubs, eat too much and float about. \n" +
                    "\n" +
                    "\n" +
                    "Expenses per person: 1100 GBp \n" +
                    "\n" +
                    "\n" +
                    "You can calculate based on number of persons and can display the total expenses approximately.\n"
        }
        else -> {
            data =  "Delhi>>Paris>>Amsterdam>>switzerland(multiple cities)>>Venice>>Pisa>>Rome>>delhi .\n" +
                    "\n" +
                    "Itinerary:\n" +
                    "⦁\tParis-3 days\n" +
                    "⦁\tAmsterdam-2 days\n" +
                    "⦁\tSwitzerland-3 days\n" +
                    "⦁\tVenice-2 days\n" +
                    "⦁\tPisa-half day\n" +
                    "⦁\tRome-3 and a half days\n" +
                    "⦁\t24 hours flight -to and fro\n" +
                    "\n" +
                    "\n" +
                    "Expenses: 1700 Gbp for each person\n" +
                    "\n" +
                    "You can calculate based on number of persons and can display the total expenses approximately.\n"
        }
    }
    return  data
}