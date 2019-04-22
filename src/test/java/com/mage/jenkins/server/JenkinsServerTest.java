package com.mage.jenkins.server;

import com.mage.jenkins.model.BlockedItem;
import com.mage.jenkins.model.Crumb;
import com.mage.jenkins.model.HudsonInfo;
import com.mage.jenkins.model.Job;
import com.mage.jenkins.model.Queue;
import com.mage.jenkins.model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mage.jenkins.utils.Utils.pprint;

public class JenkinsServerTest {

    private JenkinsServer server;

    @Before
    public void setUp() throws Exception {
        URI uri = new URI("http://localhost:8080/");
        String username = "";
        String password = "";
        server = new JenkinsServer(uri, username, password);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetJobs() {
        List<Job> jobs = server.getJobs();
        List<Job> jobs1 = server.getJobs();
        pprint(jobs);
    }

    @Test
    public void testGetJobs1() {
        List<Job> jobs = server.getJobs("All");
        pprint(jobs);
    }

    @Test
    public void testGetHudsonInfo() {
        HudsonInfo hudson = server.getHudsonInfo();
        pprint(hudson);
    }

    @Test
    public void testGetCrumb() {
        Crumb crumb = server.getCrumb();
        pprint(crumb);
    }

    @Test
    public void testWhoAmI() {
        User s = server.whoAmI();
        pprint(s);
    }

    @Test
    public void testGetQueue() {
        Queue queue = server.getQueue();
        User s = server.whoAmI();
        System.out.println(s);
        User s1 = server.whoAmI();
        System.out.println(s1);


        Queue qq = server.getQueue();
        Queue q = server.getQueue();
        pprint(queue);
    }

    @Test
    public void testGetQueueJobs() {
        List<Job> jobs = server.getQueueJobs();
        pprint(jobs);
    }

    @Test
    public void testGetJob() {
        Job job = server.getJob("s_test_1", true);
        pprint(job);

    }

    @Test
    public void testGetJob1() {
        Job job = server.getJob("s_test_1");
        pprint(job);

    }

    @Test
    public void testGetConsoleOutputText() {
        String outputText = server.getConsoleOutputText("s_test_1", 45);
        System.out.println(outputText);
    }

    @Test
    public void testGetConsoleOutputHtml() {
        String outputText = server.getConsoleOutputHtml("s_test_1", 45);
        System.out.println(outputText);
    }

    @Test
    public void testBuildJob() {
        Map<String, String> params = new HashMap<>();
        params.put("PARAM1", "日期   " + new Date());
        server.buildJob("s_test_3", params);
    }

    @Test
    public void testBuildJob1() {
        server.buildJob("s_test_3", null);
    }

    @Test
    public void testBuildJob2() {
        server.buildJob("s_test_2");
    }
}
