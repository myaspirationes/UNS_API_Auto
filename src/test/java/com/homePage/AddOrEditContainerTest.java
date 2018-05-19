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

public class AddOrEditContainerTest extends HttpUtil {
    // 启用/隐藏容器模块接口
    String url = "/uu-admin/container/addOrEditContainer";
    String selectStatus = "SELECT * FROM T_HOME_PAGE_CONTAINER WHERE CONTAINER_ID = 2 ";
    String dataType = "perCenter81";
    List<Map<String,Object>> list ;

    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 用户ID为未登录
     */
    @Test
    public void postAddOrEditContainerTestUserIdNotLoggedIn() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495325);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为未登录" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }


}
