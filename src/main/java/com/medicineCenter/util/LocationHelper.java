package com.medicineCenter.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 16/9/19.
 */
class LocationHelper {

    static String[] locationStops = {"省","市"/*,"地区"*/,"区","县"};
    static String[] orgStops = {"中心","所","局","站","队","院"};

    protected static String getLocation(String address){
        if(address == "")
            return null;
//        int index;
//        List<String> locationList = new ArrayList<String>();
//        String location = "";
//        for(String stop:locationStops) {
//            index = address.indexOf(stop);
//            if (index < 0)
//                continue;
//            else {
//                location = address.substring(0, index + 1);
//                String child = getLocation(address.substring(index + 1));
//                if (child == null)
//                    return location;
//                else
//                    return location + "," + child;
//            }
//        }
        return stopWordReplace(address, locationStops);
    }

    protected static String getOrgName(String locationDetail){
        String[] locationDetails = getLocation(locationDetail).split(",");
        if(locationDetails.length == 0)
            return "";
        String orgDetail = locationDetails[locationDetails.length-1];
        if(locationDetails.length == 1)
            return stopWordReplace(orgDetail, orgStops).split(",")[0];
        return locationDetails[locationDetails.length-2]+stopWordReplace(orgDetail, orgStops).split(",")[0];
    }

    protected static String stopWordReplace(String orig, String[] stops){
        orig = orig.replaceAll(" ","");
        orig = orig.replaceAll("\t","");
        orig = orig.replaceAll("\n","");
        for(String stop : stops){
            orig = orig.replaceAll(stop,stop+",");
        }
        return orig;
    }

    public static void main(String args[]){
        String test = "省局 安监处";
        System.out.println(LocationHelper.getOrgName(test));
    }
}
