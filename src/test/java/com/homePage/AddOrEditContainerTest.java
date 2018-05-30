package com.homePage;

import com.example.HttpUtil;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class AddOrEditContainerTest extends HttpUtil {
    // 添加/编辑容器模块接口
    String url = "/uu-admin/container/addOrEditContainer";
    String selectStatus = "SELECT * FROM T_HOME_PAGE_CONTAINER WHERE CONTAINER_ID = 1 ";
    String selectAdd = "SELECT * FROM T_HOME_PAGE_CONTAINER WHERE TITLE = '接口测试'AND CONTAINER_ID <> 1";
    String deleteSql = "DELETE FROM T_HOME_PAGE_CONTAINER WHERE TITLE = '接口测试'AND CONTAINER_ID <> 1";

    String dataType = "perCenter81";
    List<Map<String,Object>> list ;
    @BeforeMethod
    public void beforeMethod(){
        MetaOper.delete(deleteSql,dataType);
    }
    /**
     * 提交正确参数
     */
    @Test
    public void postAddOrEditContainerTestCorrectParameter() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        //request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("提交正确参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectAdd,dataType);

        assertThat((list.get(0).get("TITLE").toString())).isEqualTo("接口测试");


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

        assertThat(post.get("status")).isEqualTo(400);

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

        assertThat(post.get("status")).isEqualTo(400);
    }
    /**
     * 容器ID为小数
     */
    @Test
    public void postAddOrEditContainerTestContainerIdIsDecimal() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 1.2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为小数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("TITLE").toString())).isEqualTo("接口测试");
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

        assertThat(post.get("status")).isEqualTo(500);
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

        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 容器ID为空
     */
    @Test
    public void postAddOrEditContainerTestContainerIdIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", "");
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器ID为空" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectAdd,dataType);
        assertThat(list.get(0).get("TITLE")).isEqualTo("接口测试");
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
        list = MetaOper.read(selectAdd,dataType);
        assertThat(list.get(0).get("TITLE")).isEqualTo("接口测试");
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
        list = MetaOper.read(selectAdd,dataType);
        assertThat(list.get(0).get("TITLE")).isEqualTo("接口测试");
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
        list = MetaOper.read(selectAdd,dataType);
        assertThat(list.get(0).get("TITLE")).isEqualTo("接口测试");
    }
    /**
     * 类型为0
     */
    @Test
    public void postAddOrEditContainerTestTypeIsZero() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 1);
        request.put("type",0);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为0" + post);
        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);
        System.out.println("list===="+list);
        assertThat(list.get(0).get("TYPE").toString()).isEqualTo("0");

    }
    /**
     * 类型为1
     */
    @Test
    public void postAddOrEditContainerTestTypeIsOne() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为1" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat(list.get(0).get("TYPE").toString()).isEqualTo("1");
    }
    /**
     * 类型为2
     */
    @Test
    public void postAddOrEditContainerTestTypeIsTwo() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",2);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为2" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 类型为3
     */
    @Test
    public void postAddOrEditContainerTestTypeIsThree() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",3);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为3" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 类型为小数
     */
    @Test
    public void postAddOrEditContainerTestTypeIsDecimal() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1.5);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为小数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 类型为负数
     */
    @Test
    public void postAddOrEditContainerTestTypeIsNegativeNumber() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",-1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为负数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 类型为最大值
     */
    @Test
    public void postAddOrEditContainerTestTypeIsMax() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",999999999);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为最大值" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 类型为字符串
     */
    @Test
    public void postAddOrEditContainerTestTypeIsString() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type","aaa");
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为字符串" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 类型为空
     */
    @Test
    public void postAddOrEditContainerTestTypeIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type","");
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为空" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 类型为空格
     */
    @Test
    public void postAddOrEditContainerTestTypeIsSpace() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type"," ");
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为空格" + post);

        assertThat(post.get("status")).isEqualTo(500);
    }
    /**
     * 类型为null
     */
    @Test
    public void postAddOrEditContainerTestTypeIsNull() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",null);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型为null" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 类型不传该参数
     */
    @Test
    public void postAddOrEditContainerTestTypeNonSubmissionParameters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("类型不传该参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为0
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsZero() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",0);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为0" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为1
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsOne() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",1);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为1" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为2
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsTwo() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",2);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为2" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为3
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsThree() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",3);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为3" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为小数
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsDecimal() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",1.5);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为小数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为负数
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsNegativeNumber() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",-1);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为负数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为字符串
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsString() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType","aaa");
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为字符串" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为空
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType","");
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为空" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为空格
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsSpace() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType"," ");
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为空格" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型为null
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeIsNull() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",null);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型为null" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 板块源类型不传该参数
     */
    @Test
    public void postAddOrEditContainerTestBoardTypeNonSubmissionParameters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("title","接口测试");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("板块源类型不传该参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器标题为空
     */
    @Test
    public void postAddOrEditContainerTestTitleIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器标题为空" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));

    }

    /**
     * 容器标题为空格
     */
    @Test
    public void postAddOrEditContainerTestTitleIsSpace() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title"," ");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器标题为空格" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));

    }
    /**
     * 容器标题为null
     */
    @Test
    public void postAddOrEditContainerTestTitleIsNull() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title",null);
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器标题为空" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));

    }
    /**
     * 容器标题为非法字符
     */
    @Test
    public void postAddOrEditContainerTestTitleIllegalCharacters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","<#$%>");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器标题为非法字符" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));

    }
    /**
     * 容器标题不传该参数
     */
    @Test
    public void postAddOrEditContainerTestTitleNonSubmissionParameters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器标题不传该参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));

    }
    /**
     * 容器标题超长
     */
    @Test
    public void postAddOrEditContainerTestTitleIsLong() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","asdjisfihasifh就啊说的话萨帝啊好苏的话a是打算打算打算的撒打算打算当地发生的发生的夫人噶咖啡机那廉价的发生地附近如果你当时的分开始觉得你发觉你把人家的呢");
        request.put("remarks","接口测试请勿删除");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器标题超长" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器备注为空
     */
    @Test
    public void postAddOrEditContainerTestRemarksIsEmpty() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器备注为空" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器备注为空格
     */
    @Test
    public void postAddOrEditContainerTestRemarksIsSpace() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks"," ");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器备注为空格" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器备注为null
     */
    @Test
    public void postAddOrEditContainerTestRemarksIsNull() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks",null);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器备注为null" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器备注为非法字符
     */
    @Test
    public void postAddOrEditContainerTestRemarksIllegalCharacters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","<#$%^>");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器备注为非法字符" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器备注不传该参数
     */
    @Test
    public void postAddOrEditContainerTestRemarksNonSubmissionParameters() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器备注不传该参数" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }
    /**
     * 容器备注为超长
     */
    @Test
    public void postAddOrEditContainerTestRemarksIsLong() throws Exception {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("userId", 12495324);
        request.put("containerId", 2);
        request.put("type",1);
        request.put("boardType",2);
        request.put("title","接口测试");
        request.put("remarks","阿苏护肤都会发UFO撒豆腐花返回阿偶好豆腐花如何儒法；疯狂的发诶话回复杜阿拉大法好 ；地方尴尬");

        JSONObject post = super.UNSPost(url, request);
        System.out.println("容器备注为超长" + post);

        assertThat(post.get("status")).isEqualTo(0);
        assertThat(post.get("msg")).isEqualTo("成功");
        list = MetaOper.read(selectStatus,dataType);

        assertThat((list.get(0).get("STATUS").toString()).equals("1"));
    }

}
