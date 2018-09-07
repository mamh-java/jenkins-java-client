package com.mage.jenkins.server;

import com.mage.jenkins.model.Crumb;
import com.mage.jenkins.model.HudsonInfo;
import com.mage.jenkins.model.Job;

import com.mage.jenkins.model.Queue;
import com.mage.jenkins.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.util.List;

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
}
