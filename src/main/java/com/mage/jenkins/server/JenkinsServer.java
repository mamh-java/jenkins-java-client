package com.mage.jenkins.server;

import com.mage.jenkins.client.JenkinsClient;
import com.mage.jenkins.client.JenkinsConnection;
import com.mage.jenkins.model.Crumb;
import com.mage.jenkins.model.HudsonInfo;
import com.mage.jenkins.model.Job;
import com.mage.jenkins.model.AllView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.util.List;


public class JenkinsServer implements Closeable {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final JenkinsConnection client;


    public JenkinsServer(URI uri) {
        this(new JenkinsClient(uri));
    }


    public JenkinsServer(URI serverUri, String username, String password) {
        this(new JenkinsClient(serverUri, username, password));
    }

    public JenkinsServer(final JenkinsClient client) {
        this.client = client;
    }


    public List<Job> getJobs() {
        return getJobs("All");
    }

    public List<Job> getJobs(String viewName) {
        AllView allView = client.get(String.format("/view/%s/", viewName), AllView.class);
        return allView.getJobs();
    }

    public HudsonInfo getHudsonInfo() {
        return client.get("/", HudsonInfo.class);
    }

    public Crumb getCrumb() {
        return client.get("/crumbIssuer", Crumb.class);
    }

    /**
     * Closes underlying resources.
     * Closed instances should no longer be used
     * Closing an already closed instance has no side effects
     */
    @Override
    public void close() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
