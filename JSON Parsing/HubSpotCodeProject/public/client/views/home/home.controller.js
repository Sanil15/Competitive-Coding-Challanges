/**
 * Created by jains on 8/20/2016.
 */

(function(){

    'use-strict'

    angular
        .module("HubSpotApp")
        .controller("HomeController",HomeController)

    function HomeController(DataService) {

        var vm = this;

        function init() {

            // Fetch data from the server
            DataService
                .getData()
                .then(function (response) {
                    //console.log(response.data);

                    var countryList= {};

                    var partners = response.data.partners;

                    // Iterating over the partners list to categorize them via
                    // there countries.
                    for(var i in partners){

                        if(countryList.hasOwnProperty(partners[i].country)){
                            countryList[partners[i].country].push(partners[i]);
                        }

                        else{
                            countryList[partners[i].country] = [];
                            countryList[partners[i].country].push(partners[i]);
                        }

                    }

                    // console.log(countryList);


                    var result = {
                        "countries": []
                    }


                    // Iterating Over Each Country To a possible date
                    // When max number of partners are available (if such date exists)
                    for (var c in countryList){

                        var possibleDates = []

                        // This Loop gets all possible start dates for a country when
                        // HubSpot can organize special two day events
                        for (var d in countryList[c]){
                            for(var da in countryList[c][d].availableDates)
                            possibleDates = arrayUnique(possibleDates.concat(countryList[c][d].availableDates))
                        }


                        var checkDates = {}
                        var guestList = {}

                        // Initializing possible start date in a json with 0 count of partners in checkDates JSON Object
                        // Initializing guest List as an empty array for possible partners at the event;
                        for(var i in possibleDates){
                            possibleDates[i] = new Date(possibleDates[i]);
                            checkDates[possibleDates[i]] = 0;
                            guestList[possibleDates[i]] = new Array();
                        }


                        // For every guest/partner for a country find whether his availability for two consecutive days
                        // matches with our start dates and end dates in possibleDates JSON Object
                        for(var guest in countryList[c]){

                            var guestDates = {};

                            for(d in countryList[c][guest].availableDates){
                                guestDates[new Date(countryList[c][guest].availableDates[d])] = "";
                            }


                            // This Loop checks that for a partner, is he available on consecutive days or not
                            // If yes check whether those two dates are available in checkDates
                            // If yes increment guest count and the guest list with the email of Partner
                            for(var i in guestDates){
                                var temp = new Date(i);
                                temp.setDate(temp.getDate() + 1);
                                if(guestDates.hasOwnProperty(temp.toString())){
                                    if(checkDates.hasOwnProperty(i)){
                                        checkDates[i] = checkDates[i] + 1;
                                        guestList[i].push(countryList[c][guest].email);
                                    }
                                }
                            }

                        }


                        // Initialize max to 0
                        var max = 0;
                        var possibleDate = null;

                        // This determines the max head count available for a date
                        // and also checks if two dates have same partner count, if yes pick the
                        // date which is earlier
                        for(var t in checkDates){

                            if(checkDates[t] > max){
                                possibleDate = new Date(t);
                                max = checkDates[t];
                            }

                            else if(checkDates[t] == max){
                                if(possibleDate!= null && new Date(t) < possibleDate){
                                    possibleDate = new Date(t);
                                }
                            }

                        }

                        // Writing all the results to a temp JSON object called out
                        var out = {
                            "attendeeCount": max,
                            "attendees":guestList[possibleDate],
                            "name": c,
                            "startDate": possibleDate.toISOString().substring(0,10)
                        }

                        // Push the temp object to final result JSON.
                        result.countries.push(out);

                    }

                    // console.log(result);


                    // Service will post data that is generated to the URL provided;
                    DataService
                        .postData(result)
                        .then(function (response) {
                            console.log(response);
                            vm.response = response.data.message;
                        })

                });


        }

        init();

        // Simple code Snippet to merge two arrays and
        // delete duplicate elements
        function arrayUnique(array) {
            var a = array.concat();
            for(var i=0; i<a.length; ++i) {
                for(var j=i+1; j<a.length; ++j) {
                    if(a[i] === a[j])
                        a.splice(j--, 1);
                }
            }

            return a;
        }

    }

})();