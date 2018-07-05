package com.homePage;

import com.example.HttpUtil;
import com.example.LoginTest;
import com.example.MetaOper;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//import org.junit.Test;

public class HomePageListTest extends HttpUtil {
    // 首页列表
    String url = "/UU/homepage";
    JSONObject body;
    String uuid;
    String chcode;
    LoginTest login = new LoginTest();
    @BeforeClass
    public void  beforeClass(){

        try {
            body = login.getLoginTestChcodeBy177();
            uuid= (body.get("userId")).toString();
            chcode= (body.get("checkCode")).toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * 正确参数查询
     */
    @Test
    public void postHomePageSearchTestCorrectParameter() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("正确参数查询" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(0);
        assertThat(head1.get("msg")).isEqualTo("成功");
    }
    /**
     * 用户ID为未登陆
     */
    @Test
    public void postHomePageSearchTestUserIdNotLoggedIn() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为未登陆" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(0);
        assertThat(head1.get("msg")).isEqualTo("成功");
    }
    /**
     * 用户ID为错误用户
     */
    @Test
    public void postHomePageSearchTestUserIdIsError() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", 1212);
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为错误用户" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-1);
        assertThat(head1.get("msg")).isEqualTo("参数有误");
    }
    /**
     * 用户ID为非法字符
     */
    @Test
    public void postHomePageSearchTestUserIdIllegalCharacters() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", "<.@#$>");
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为非法字符" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-1);
        assertThat(head1.get("msg")).isEqualTo("参数有误");
    }
    /**
     * 用户ID为小数
     */
    @Test
    public void postHomePageSearchTestUserIdIsDecimal() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", 1.3);
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为小数" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-1);
        assertThat(head1.get("msg")).isEqualTo("参数有误");
    }
    /**
     * 用户ID为负数
     */
    @Test
    public void postHomePageSearchTestUserIdIsNegativeNumber() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", -22);
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为负数" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-1);
        assertThat(head1.get("msg")).isEqualTo("参数有误");
    }
    /**
     * 用户ID为空
     */
    @Test
    public void postHomePageSearchTestUserIdIsEmpty() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", "");
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为空" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-1);
        assertThat(head1.get("msg")).isEqualTo("参数有误");
    }
    /**
     * 用户ID为空格
     */
    @Test
    public void postHomePageSearchTestUserIdIsSpace() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", " ");
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为空格" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-1);
        assertThat(head1.get("msg")).isEqualTo("参数有误");
    }
    /**
     * 用户ID为null
     */
    @Test
    public void postHomePageSearchTestUserIdIsNull() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", null);
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID为null" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-1);
        assertThat(head1.get("msg")).isEqualTo("参数有误");
    }
    /**
     * 用户ID不传该参数
     */
    @Test
    public void postHomePageSearchTestUserIdNonSubmissionParameters() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("pageNow", 1);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("用户ID不传该参数" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-1);
        assertThat(head1.get("msg")).isEqualTo("参数有误");
    }

    /**
     * 每页显示数量最大值
     */
    @Test
    public void postHomePageSearchTestPageSizeIsMax() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);
        con.put("pageSize", 999999999999999999L);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("每页显示数量最大值" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 每页显示数量为0
     */
    @Test
    public void postHomePageSearchTestPageSizeIsZero() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);
        con.put("pageSize", 0);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("每页显示数量为0" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(0);
        assertThat(head1.get("msg")).isEqualTo("成功");
    }
    /**
     * 每页显示数量为负数
     */
    @Test
    public void postHomePageSearchTestPageSizeIsNegativeNumber() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", "1");
        con.put("pageSize", "-1");


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("每页显示数量为负数" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 每页显示数量为小数
     */
    @Test
    public void postHomePageSearchTestPageSizeIsDecimal() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);
        con.put("pageSize", 9.9);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("每页显示数量为小数" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 每页显示数量为字符
     */
    @Test
    public void postHomePageSearchTestPageSizeIsString() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);
        con.put("pageSize", "aaa");


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("每页显示数量为字符" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 每页显示数量为空格
     */
    @Test
    public void postHomePageSearchTestPageSizeIsSpace() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);
        con.put("pageSize", " ");


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("每页显示数量为空格" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 每页显示数量为空
     */
    @Test
    public void postHomePageSearchTestPageSizeIsEmpty() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);
        con.put("pageSize", "");


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("每页显示数量为空" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 每页显示数量为非法字符
     */
    @Test
    public void postHomePageSearchTestPageSizeIllegalCharacters() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);
        con.put("pageSize", "<.#$%>");


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("每页显示数量为非法字符" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 每页显示数量不传该参数
     */
    @Test
    public void postHomePageSearchTestPageSizeNonSubmissionParameters() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("每页显示数量不传该参数" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("页面总数不能为空");
    }
    /**
     * 当前页码数量最大值
     */
    @Test
    public void postHomePageSearchTestPageNowIsMax() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 999999999999999999L);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("当前页码数量最大值" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 当前页码数量为0
     */
    @Test
    public void postHomePageSearchTestPageNowIsZero() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 0);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("当前页码数量为0" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(0);
        assertThat(head1.get("msg")).isEqualTo("成功");
    }
    /**
     * 当前页码数量为负数
     */
    @Test
    public void postHomePageSearchTestPageNowIsNegativeNumber() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", "-1");
        con.put("pageSize", "1");


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("当前页码数量为负数" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(0);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 当前页码数量为小数
     */
    @Test
    public void postHomePageSearchTestPageNowIsDecimal() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", 1.4);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("当前页码数量为小数" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 当前页码数量为字符
     */
    @Test
    public void postHomePageSearchTestPageNowIsString() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", "aaa");
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("当前页码数量为字符" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 当前页码数量为空
     */
    @Test
    public void postHomePageSearchTestPageNowIsEmpty() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", "");
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("当前页码数量为空" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 当前页码数量为非法字符
     */
    @Test
    public void postHomePageSearchTestPageNowIllegalCharacters() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", "<@@@>");
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("前页码数量为非法字符" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 当前页码数量为空格
     */
    @Test
    public void postHomePageSearchTestPageNowIsSpace() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageNow", " ");
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("当前页码数量为空格" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("数据包错误！");
    }
    /**
     * 当前页码数量不传该参数
     */
    @Test
    public void postHomePageSearchTestPageNowNonSubmissionParameters() throws Exception {
        Map<String, Object> con = new HashMap<String, Object>();
        con.put("userId", uuid);
        con.put("pageSize", 1);


        Map<String, Object> head = new HashMap<String, Object>();
        head.put("ver", "1.2.1");
        head.put("cmd", "4891");
        head.put("uuid", uuid);
        head.put("ln", "cn");
        head.put("chcode", chcode);
        head.put("sync", "1");
        head.put("mod", "ios");
        Map<String, Object> request = new HashMap<String, Object>(); // 给request赋值
        request.put("con", con);
        request.put("head", head);

        JSONObject post = super.UNSPost(url, request);
        System.out.println("当前页码数量不传该参数" + post);
        JSONObject head1 = (JSONObject) post.get("head");

        assertThat(head1.get("st")).isEqualTo(-3);
        assertThat(head1.get("msg")).isEqualTo("当前页数不能为空");
    }
}
