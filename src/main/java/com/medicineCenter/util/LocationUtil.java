package com.medicineCenter.util;

import java.util.HashMap;
/**
 * Created by song on 16/9/18.
 */
public class LocationUtil {
    static HashMap<String,String> cityMap = new HashMap<String,String>();
    static {
        String[] initString = {"哈尔滨市道里区南岗区道外区平房区松北区香坊区呼兰区 阿城区双城区依兰县方正县宾县巴彦县木兰县 通河县延寿县尚志市五常市",
                "齐齐哈尔市龙沙区建华区铁锋区昂昂溪区富拉尔基区碾子山区梅里斯区 龙江县依安县泰来县甘南县富裕县克山县克东县 拜泉县讷河市",
                "鸡西市鸡冠区恒山区滴道区梨树区城子河区麻山区鸡东县 虎林市密山市",
                "鹤岗市向阳区工农区南山区兴安区东山区兴山区萝北县 绥滨县",
                "双鸭山市尖山区岭东区四方台区宝山区集贤县友谊县宝清县 饶河县",
                "大庆市萨尔图区龙凤区让胡路区红岗区大同区肇州县肇源县 林甸县杜尔伯特县",
                "伊春市伊春区南岔区友好区西林区翠峦区新青区美溪区 金山屯区五营区乌马河区汤旺河区带岭区乌伊岭区红星区 上甘岭区嘉荫县铁力市",
                "佳木斯市向阳区前进区东风区郊区桦南县桦川县汤原县 同江市富锦市抚远市",
                "七台河市新兴区桃山区茄子河区勃利县",
                "牡丹江市东安区阳明区爱民区西安区林口县绥芬河市海林市 宁安市穆棱市东宁市",
                "黑河市爱辉区嫩江县逊克县孙吴县北安市五大连池市",
                "绥化市北林区望奎县兰西县青冈县庆安县明水县绥棱县 安达市肇东市海伦市",
                "大兴安岭地区呼玛县塔河县漠河县"};
        String[] districts;
        String city;
        for(String location : initString){
            districts = LocationHelper.getLocation(location).split(",");
            city = districts[0];
            for(int index = 0; index < districts.length; index++){
                cityMap.put(districts[index], city);
            }
        }
    }

    public static String getCityName(String location){
        return LocationUtil.cityMap.get(location);
    }

    public static String getCityName(String[] locations){
        String city;
        for(String location : locations){
            if((city = getCityName(location)) !=null)
                return city;
        }
        return "省";
    }

    public static String getOrgName(String location){
        return LocationHelper.getOrgName(location);
    }

    public static String[] getLocationArray(String location){
        return LocationHelper.getLocation(location).split(",");
    }

    public static String getBelongedCity(String inspectionUnit){
        return LocationUtil.getCityName(LocationUtil.getLocationArray(inspectionUnit));
    }

    public static void main(String args[]){
//        LocationUtil locationUtil = new LocationUtil();
//       // System.out.println(LocationUtil.getCityName("密山市"));
       String test = "哈尔滨市食品药品监督管理局药品安全监管处";
//        System.out.println(LocationUtil.getCityName(getLocationArray(test)));
       System.out.println(LocationUtil.getOrgName(test));
//        String test = "肇东镇食品药品监督管理局药品安全监管处";
        System.out.println(LocationUtil.getBelongedCity(test));
    }

}
