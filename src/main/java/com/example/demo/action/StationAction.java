package com.example.demo.action;

import com.example.demo.domain.Data;
import com.example.demo.domain.Station;
import com.example.demo.tools.HttpTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class StationAction {
    @RequestMapping("/putStation")
    public String putStation() {
        String url = "http://211.160.73.240:19018/gffp/pv/data/stationmsg";
        // String url = "http://127.0.0.1:8000/test";

        // TOKEN由单独方法获取
        String token = "718f04ced8f5925f2963b022697e11e7";

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Station station = new Station();
        station.GC_ID = 1212112L;
        station.GC_NO = "2232187";
        station.VOLT_CODE = "220v";
        station.STATUS_CODE = "0";
        station.ABSO_MODE = "01";
        station.POVERTY_ALLEV_FLAG = "01";
        station.CONTRACT_CAP = 20.00;
        station.GC_DATE = df.format(date);

        List<Station> sList = new ArrayList<>();
        sList.add(station);

        // DATA数据
        Data data =new Data();
        System.out.println(data.TOKEN);
        data.TOKEN = token;
        data.DATA_COUNT = "1";
        data.DATA_LIST = sList;

        String res = HttpTools.postData(url, data);
        System.out.println(res);
        return res;
    }
}
