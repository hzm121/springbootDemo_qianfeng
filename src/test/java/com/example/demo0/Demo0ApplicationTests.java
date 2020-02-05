package com.example.demo0;

import com.example.demo0.dao.AuserMapper;
import com.example.demo0.entity.Auser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo0Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@Rollback
class Demo0ApplicationTests {
    @LocalServerPort
    private int port;

    private URL base;
    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void contextLoads() {
        System.err.println(template);
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        Assert.assertThat(response.getBody(), CoreMatchers.equalTo("Hello SpringBoot!"));
    }

    @Autowired
    private AuserMapper auserMapper;

    @Test
    public void testSelect() {
        List<Auser> ausers = auserMapper.selectAll();
        for (Auser u : ausers) {
            System.out.println(u.getName());
        }
    }

    @Test
    public void testPage(){
        PageHelper.startPage(1,10);
//        List<Auser> ausers = auserMapper.selectByExample(new Example(Auser.class));
        List<Auser> ausers = auserMapper.selectAll();
        PageInfo<Auser> list = new PageInfo<>(ausers);
        for (Auser u :list.getList()){
            System.out.println(u.getPwd());
        }
    }

}
