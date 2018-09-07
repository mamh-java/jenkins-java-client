package com.mage.jenkins.model;

import java.util.List;

public class JobDetails extends Job {

    private String description;

    private String fullName;

    private String displayName;
    private String displayNameOrNull;


    private boolean buildable;

    //private List healthReport;

    private boolean inQueue;

    private boolean keepDependencies;

    private List<Build> builds;

    private Build firstBuild;

    private Build lastBuild;

    private Build lastCompletedBuild;

    private Build lastFailedBuild;

    private Build lastStableBuild;

    private Build lastSuccessfulBuild;

    private Build lastUnstableBuild;

    private Build lastUnsuccessfulBuild;

    private int nextBuildNumber;

    private List<Job> downstreamProjects;

    private List<Job> upstreamProjects;

    private String labelExpression;

    private boolean concurrentBuild;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayNameOrNull() {
        return displayNameOrNull;
    }

    public void setDisplayNameOrNull(String displayNameOrNull) {
        this.displayNameOrNull = displayNameOrNull;
    }

    public boolean isBuildable() {
        return buildable;
    }

    public void setBuildable(boolean buildable) {
        this.buildable = buildable;
    }

    public boolean isInQueue() {
        return inQueue;
    }

    public void setInQueue(boolean inQueue) {
        this.inQueue = inQueue;
    }

    public boolean isKeepDependencies() {
        return keepDependencies;
    }

    public void setKeepDependencies(boolean keepDependencies) {
        this.keepDependencies = keepDependencies;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public Build getFirstBuild() {
        return firstBuild;
    }

    public void setFirstBuild(Build firstBuild) {
        this.firstBuild = firstBuild;
    }

    public Build getLastBuild() {
        return lastBuild;
    }

    public void setLastBuild(Build lastBuild) {
        this.lastBuild = lastBuild;
    }

    public Build getLastCompletedBuild() {
        return lastCompletedBuild;
    }

    public void setLastCompletedBuild(Build lastCompletedBuild) {
        this.lastCompletedBuild = lastCompletedBuild;
    }

    public Build getLastFailedBuild() {
        return lastFailedBuild;
    }

    public void setLastFailedBuild(Build lastFailedBuild) {
        this.lastFailedBuild = lastFailedBuild;
    }

    public Build getLastStableBuild() {
        return lastStableBuild;
    }

    public void setLastStableBuild(Build lastStableBuild) {
        this.lastStableBuild = lastStableBuild;
    }

    public Build getLastSuccessfulBuild() {
        return lastSuccessfulBuild;
    }

    public void setLastSuccessfulBuild(Build lastSuccessfulBuild) {
        this.lastSuccessfulBuild = lastSuccessfulBuild;
    }

    public Build getLastUnstableBuild() {
        return lastUnstableBuild;
    }

    public void setLastUnstableBuild(Build lastUnstableBuild) {
        this.lastUnstableBuild = lastUnstableBuild;
    }

    public Build getLastUnsuccessfulBuild() {
        return lastUnsuccessfulBuild;
    }

    public void setLastUnsuccessfulBuild(Build lastUnsuccessfulBuild) {
        this.lastUnsuccessfulBuild = lastUnsuccessfulBuild;
    }

    public int getNextBuildNumber() {
        return nextBuildNumber;
    }

    public void setNextBuildNumber(int nextBuildNumber) {
        this.nextBuildNumber = nextBuildNumber;
    }

    public List<Job> getDownstreamProjects() {
        return downstreamProjects;
    }

    public void setDownstreamProjects(List<Job> downstreamProjects) {
        this.downstreamProjects = downstreamProjects;
    }

    public List<Job> getUpstreamProjects() {
        return upstreamProjects;
    }

    public void setUpstreamProjects(List<Job> upstreamProjects) {
        this.upstreamProjects = upstreamProjects;
    }

    public String getLabelExpression() {
        return labelExpression;
    }

    public void setLabelExpression(String labelExpression) {
        this.labelExpression = labelExpression;
    }

    public boolean isConcurrentBuild() {
        return concurrentBuild;
    }

    public void setConcurrentBuild(boolean concurrentBuild) {
        this.concurrentBuild = concurrentBuild;
    }
}
