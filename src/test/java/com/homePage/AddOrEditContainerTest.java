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
    // 添加/编辑容器模块接口
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

    }
    /**
     * 用户ID为错误
     */
    @Test
    public void postAddOrEditContainerTestUserIdIsError() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 5324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为错误" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");

    }
    /**
     * 用户ID为非法字符
     */
    @Test
    public void postAddOrEditContainerTestUserIdIllegalCharacters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", "<$%^>");
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为非法字符" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");

    }
    /**
     * 用户ID为小数
     */
    @Test
    public void postAddOrEditContainerTestUserIdIsDecimal() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 1249.5324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为小数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 用户ID为负数
     */
    @Test
    public void postAddOrEditContainerTestUserIdIsNegativeNumber() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", -1);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为负数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");

    }
    /**
     * 用户ID为空格
     */
    @Test
    public void postAddOrEditContainerTestUserIdIsSpace() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", " ");
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为空格" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 用户ID为空
     */
    @Test
    public void postAddOrEditContainerTestUserIdIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", "");
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为空" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 用户ID为null
     */
    @Test
    public void postAddOrEditContainerTestUserIdIsNull() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", null);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为null" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 用户ID不传该参数
     */
    @Test
    public void postAddOrEditContainerTestUserIdNonSubmissionParameters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID不传该参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器ID为字符串
     */
    @Test
    public void postAddOrEditContainerTestContainerIdIsString() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", "aa");
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为字符串" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器ID为小数
     */
    @Test
    public void postAddOrEditContainerTestContainerIdIsDecimal() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2.2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为小数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器ID为负数
     */
    @Test
    public void postAddOrEditContainerTestContainerIdIsNegativeNumber() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", -2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为负数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器ID为0
     */
    @Test
    public void postAddOrEditContainerTestContainerIdIsZero() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 0);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为0" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器ID为空
     */
    @Test
    public void postAddOrEditContainerTestContainerIdIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", "aaa");
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为空" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器ID为空格
     */
    @Test
    public void postAddOrEditContainerTestContainerIdIsSpace() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", " ");
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为空格" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器ID为null
     */
    @Test
    public void postAddOrEditContainerTestContainerIdIsNull() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", null);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为null" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器ID为不传该参数
     */
    @Test
    public void postAddOrEditContainerTestContainerIdNonSubmissionParameters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为不传该参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }


}
