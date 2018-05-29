package com.homePage;

import com.example.HttpUtil;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class InvisibleTest extends HttpUtil {
    // 启用/隐藏容器模块接口
    String url = "/uu-admin/container/invisible";
    String selectStatus = "SELECT * FROM T_HOME_PAGE_CONTAINER WHERE CONTAINER_ID = 2 ";
    String dataType = "perCenter81";
    List<Map<String,Object>> list ;

    /**
     * 提交正确参数
     */
    @Test
    public void postInvisibleTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status",1);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString())).isEqualTo("1");
    }
    /**
     * 用户ID为未登录
     */
    @Test
    public void postInvisibleTestUserIdNotLoggedIn() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495325);
        request.put("containerId", 2);
        request.put("status",1);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为未登录" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("未登录");

    }
    /**
     * 用户ID为错误用户
     */
    @Test
    public void postInvisibleTestUserIdIsError() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 1239913);
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为错误用户" + post);

        assertThat(post.get("status")).isEqualTo(-3);
        assertThat(post.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 用户ID为非法字符
     */
    @Test
    public void postInvisibleTestUserIdIllegalCharacters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", "<$%^>");
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为非法字符" + post);

        assertThat(post.get("status")).isEqualTo(400);
    }
    /**
     * 用户ID为小数
     */
    @Test
    public void postInvisibleTestUserIdIsDecimal() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 121123.33);
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为小数" + post);

        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 用户ID为负数
     */
    @Test
    public void postInvisibleTestUserIdIsNegativeNumber() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", -121312);
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为负数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
    }
    /**
     * 用户ID为空格
     */
    @Test
    public void postInvisibleTestUserIdIsSpace() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", " ");
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为空格" + post);


        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 用户ID为空
     */
    @Test
    public void postInvisibleTestUserIdIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", "");
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为空" + post);

        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 用户ID为null
     */
    @Test
    public void postInvisibleTestUserIdIsNull() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", null);
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为null" + post);

        assertThat(post.get("status")).isEqualTo(-3);
        assertThat(post.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 用户ID为0
     */
    @Test
    public void postInvisibleTestUserIdIsZero() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 0);
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为0" + post);

        assertThat(post.get("status")).isEqualTo(-3);
        assertThat(post.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 用户ID不传该参数
     */
    @Test
    public void postInvisibleTestUserIdNonSubmissionParameters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID不传该参数" + post);

        assertThat(post.get("status")).isEqualTo(-3);
        assertThat(post.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 用户ID为String
     */
    @Test
    public void postInvisibleTestUserIdIsString() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", "fggf");
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为String" + post);

        assertThat(post.get("status")).isEqualTo(400);
    }
    /**
     * 用户ID超长
     */
    @Test
    public void postInvisibleTestUserIdIsLong() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", "56526666666666666666666666666666");
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID超长" + post);

        assertThat(post.get("status")).isEqualTo(400);
    }
    /**
     * 容器id为错误
     */
    @Test
    public void postInvisibleTestContainerIdIsError() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 10000);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为错误" + post);

        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 容器id为超长
     */
    @Test
    public void postInvisibleTestContainerIdIsLong() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", "1211111111111112222222222221");
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为超长" + post);

        assertThat(post.get("status")).isEqualTo(400);
    }
    /**
     * 容器id为String
     */
    @Test
    public void postInvisibleTestContainerIdIsString() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", "dfdsfd");
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为String" + post);

        assertThat(post.get("status")).isEqualTo(400);
    }
    /**
     * 容器id为空
     */
    @Test
    public void postInvisibleTestContainerIdIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", "");
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为空" + post);

        assertThat(post.get("status")).isEqualTo(-1);
        assertThat(post.get("msg")).isEqualTo("容器id不能为空");
    }
    /**
     * 容器id为空格
     */
    @Test
    public void postInvisibleTestContainerIdIsSpace() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", " ");
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为空格" + post);

        assertThat(post.get("status")).isEqualTo(-1);
        assertThat(post.get("msg")).isEqualTo("容器id不能为空");
    }
    /**
     * 容器id为null
     */
    @Test
    public void postInvisibleTestContainerIdIsNull() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", null);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为null" + post);

        assertThat(post.get("status")).isEqualTo(-1);
        assertThat(post.get("msg")).isEqualTo("容器id不能为空");
    }
    /**
     * 容器id为0
     */
    @Test
    public void postInvisibleTestContainerIdIsZero() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 0);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为0" + post);

        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 容器id为非法字符
     */
    @Test
    public void postInvisibleTestContainerIdIsIllegalCharacters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", "<@$%&*_>");
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为非法字符" + post);

        assertThat(post.get("status")).isEqualTo(400);
    }
    /**
     * 容器id为小数
     */
    @Test
    public void postInvisibleTestContainerIdIsDecimal() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 12.369);
        request.put("status",1);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为小数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
    }
    /**
     * 容器id为负数
     */
    @Test
    public void postInvisibleTestContainerIdIsNegativeNumber() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", -125);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id为负数" + post);

        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 容器id不传
     */
    @Test
    public void postInvisibleTestContainerIdNonSubmissionParameters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器id不传" + post);

        assertThat(post.get("status")).isEqualTo(-1);
        assertThat(post.get("msg")).isEqualTo("容器id不能为空");
    }

    /**
     * 状态为0隐藏
     */
    @Test
    public void postInvisibleTestStatusIs0() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status",0);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态为0隐藏" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);
        assertThat((list.get(0).get("STATUS").toString())).isEqualTo("0");
    }
    /**
     * 状态为1启用
     */
    @Test
    public void postInvisibleTestStatusIs1() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status",1);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态为1启用" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);
        assertThat((list.get(0).get("STATUS").toString())).isEqualTo("1");
    }
    /**
     * 状态为小数
     */
    @Test
    public void postInvisibleTestStatusIsDecimal() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status",1.5);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态为小数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);
        assertThat((list.get(0).get("STATUS").toString())).isEqualTo("1");
    }
    /**
     * 状态为负数
     */
    @Test
    public void postInvisibleTestStatusIsNegativeNumber() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status",-10);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态为负数" + post);

        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 状态为最大值
     */
    @Test
    public void postInvisibleTestStatusIsMax() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status",999999999);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态为最大值" + post);

        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 状态为字符串
     */
    @Test
    public void postInvisibleTestStatusIsString() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status","aa");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态为字符串" + post);

        assertThat(post.get("status")).isEqualTo(400);
    }
    /**
     * 状态为空
     */
    @Test
    public void postInvisibleTestStatusIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status","");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态为空" + post);

        assertThat(post.get("status")).isEqualTo(-1);
        assertThat(post.get("msg")).isEqualTo("信息不能为空");
    }
    /**
     * 状态为空格
     */
    @Test
    public void postInvisibleTestStatusIsSpace() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status"," ");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态为空格" + post);

        assertThat(post.get("status")).isEqualTo(-1);
        assertThat(post.get("msg")).isEqualTo("信息不能为空");
    }
    /**
     * 状态为null
     */
    @Test
    public void postInvisibleTestStatusIsNull() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("status",null);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态为null" + post);

        assertThat(post.get("status")).isEqualTo(-1);
        assertThat(post.get("msg")).isEqualTo("信息不能为空");
    }
    /**
     * 状态不传改参数
     */
    @Test
    public void postInvisibleTestStatusNonSubmissionParameters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("状态不传改参数" + post);

        assertThat(post.get("status")).isEqualTo(-1);
        assertThat(post.get("msg")).isEqualTo("信息不能为空");
    }



}
