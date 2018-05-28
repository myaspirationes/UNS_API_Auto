package com.cloudWarehouse;

import com.example.HttpUtil;
import com.example.MetaOper;
import org.json.JSONObject;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class CreateOrderTest extends HttpUtil {
    // 添加/编辑容器模块接口
    String url = "/cloud-admin/webOrder/createOrder";
    String selectStatus = "SELECT * FROM T_HOME_PAGE_CONTAINER WHERE CONTAINER_ID = 2 ";
    String dataType = "perCenter81";
    List<Map<String,Object>> list ;

    /**
     * 提交正确参数
     */
    @Test
    public void postCreateOrderTestCorrectParameter() throws Exception {
        MultiValueMap<String,Object> request = new LinkedMultiValueMap<String,Object>();



    }


}
