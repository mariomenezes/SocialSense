/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package GEO;

import twitter4j.*;


/**
 * Shows specified place's detailed information
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class GetGeoDetails {
    /**
     * Usage: java twitter4j.examples.geo.GetGeoDetails [place id]
     *
     * @param args message
     */
    public static void main(String[] args) {
//        if (args.length < 1) {
//            System.out.println("Usage: java twitter4j.examples.geo.GetGeoDetails [place id]");
//            System.exit(-1);
//        }

        DoConfiguration doconf = new DoConfiguration();
        Twitter twitter = doconf.getInstance();

        //ResponseList<Place> l = twitter.reverseGeoCode()
        String maceio_geo_id = "70d9237ded8be5f4";
        try {
            //twitter = new TwitterFactory().getInstance();
            //Place place = twitter.getGeoDetails(args[0]);
            Place place = twitter.getGeoDetails(maceio_geo_id);
            System.out.println("name: " + place.getName());
            System.out.println("country: " + place.getCountry());
            System.out.println("country code: " + place.getCountryCode());
            System.out.println("full name: " + place.getFullName());
            System.out.println("id: " + place.getId());
            System.out.println("place type: " + place.getPlaceType());
            System.out.println("street address: " + place.getStreetAddress());
            Place[] containedWithinArray = place.getContainedWithIn();
            if (containedWithinArray != null && containedWithinArray.length != 0) {
                System.out.println("  contained within:");
                for (Place containedWithinPlace : containedWithinArray) {
                    System.out.println("  id: " + containedWithinPlace.getId() + " name: " + containedWithinPlace.getFullName());
                }
            }
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to retrieve geo details: " + te.getMessage());
            System.exit(-1);
        }
    }
}
