package com.smart.github.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trend {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("node_id")
    @Expose
    private String nodeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("private")
    @Expose
    private Boolean isPrivate;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("fork")
    @Expose
    private Boolean fork;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("archive_url")
    @Expose
    private String archiveUrl;
    @SerializedName("assignees_url")
    @Expose
    private String assigneesUrl;
    @SerializedName("blobs_url")
    @Expose
    private String blobsUrl;
    @SerializedName("branches_url")
    @Expose
    private String branchesUrl;
    @SerializedName("collaborators_url")
    @Expose
    private String collaboratorsUrl;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("commits_url")
    @Expose
    private String commitsUrl;
    @SerializedName("compare_url")
    @Expose
    private String compareUrl;
    @SerializedName("contents_url")
    @Expose
    private String contentsUrl;
    @SerializedName("contributors_url")
    @Expose
    private String contributorsUrl;
    @SerializedName("deployments_url")
    @Expose
    private String deploymentsUrl;
    @SerializedName("downloads_url")
    @Expose
    private String downloadsUrl;
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;
    @SerializedName("forks_url")
    @Expose
    private String forksUrl;
    @SerializedName("git_commits_url")
    @Expose
    private String gitCommitsUrl;
    @SerializedName("git_refs_url")
    @Expose
    private String gitRefsUrl;
    @SerializedName("git_tags_url")
    @Expose
    private String gitTagsUrl;
    @SerializedName("git_url")
    @Expose
    private String gitUrl;
    @SerializedName("issue_comment_url")
    @Expose
    private String issueCommentUrl;
    @SerializedName("issue_events_url")
    @Expose
    private String issueEventsUrl;
    @SerializedName("issues_url")
    @Expose
    private String issuesUrl;
    @SerializedName("keys_url")
    @Expose
    private String keysUrl;
    @SerializedName("labels_url")
    @Expose
    private String labelsUrl;
    @SerializedName("languages_url")
    @Expose
    private String languagesUrl;
    @SerializedName("merges_url")
    @Expose
    private String mergesUrl;
    @SerializedName("milestones_url")
    @Expose
    private String milestonesUrl;
    @SerializedName("notifications_url")
    @Expose
    private String notificationsUrl;
    @SerializedName("pulls_url")
    @Expose
    private String pullsUrl;
    @SerializedName("releases_url")
    @Expose
    private String releasesUrl;
    @SerializedName("ssh_url")
    @Expose
    private String sshUrl;
    @SerializedName("stargazers_url")
    @Expose
    private String stargazersUrl;
    @SerializedName("statuses_url")
    @Expose
    private String statusesUrl;
    @SerializedName("subscribers_url")
    @Expose
    private String subscribersUrl;
    @SerializedName("subscription_url")
    @Expose
    private String subscriptionUrl;
    @SerializedName("tags_url")
    @Expose
    private String tagsUrl;
    @SerializedName("teams_url")
    @Expose
    private String teamsUrl;
    @SerializedName("trees_url")
    @Expose
    private String treesUrl;

    public Integer getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getFork() {
        return fork;
    }

    public String getUrl() {
        return url;
    }

    public String getArchiveUrl() {
        return archiveUrl;
    }

    public String getAssigneesUrl() {
        return assigneesUrl;
    }

    public String getBlobsUrl() {
        return blobsUrl;
    }

    public String getBranchesUrl() {
        return branchesUrl;
    }

    public String getCollaboratorsUrl() {
        return collaboratorsUrl;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public String getCommitsUrl() {
        return commitsUrl;
    }

    public String getCompareUrl() {
        return compareUrl;
    }

    public String getContentsUrl() {
        return contentsUrl;
    }

    public String getContributorsUrl() {
        return contributorsUrl;
    }

    public String getDeploymentsUrl() {
        return deploymentsUrl;
    }

    public String getDownloadsUrl() {
        return downloadsUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public String getForksUrl() {
        return forksUrl;
    }

    public String getGitCommitsUrl() {
        return gitCommitsUrl;
    }

    public String getGitRefsUrl() {
        return gitRefsUrl;
    }

    public String getGitTagsUrl() {
        return gitTagsUrl;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getIssueCommentUrl() {
        return issueCommentUrl;
    }

    public String getIssueEventsUrl() {
        return issueEventsUrl;
    }

    public String getIssuesUrl() {
        return issuesUrl;
    }

    public String getKeysUrl() {
        return keysUrl;
    }

    public String getLabelsUrl() {
        return labelsUrl;
    }

    public String getLanguagesUrl() {
        return languagesUrl;
    }

    public String getMergesUrl() {
        return mergesUrl;
    }

    public String getMilestonesUrl() {
        return milestonesUrl;
    }

    public String getNotificationsUrl() {
        return notificationsUrl;
    }

    public String getPullsUrl() {
        return pullsUrl;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public String getSshUrl() {
        return sshUrl;
    }

    public String getStargazersUrl() {
        return stargazersUrl;
    }

    public String getStatusesUrl() {
        return statusesUrl;
    }

    public String getSubscribersUrl() {
        return subscribersUrl;
    }

    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    public String getTagsUrl() {
        return tagsUrl;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public String getTreesUrl() {
        return treesUrl;
    }

    @Override
    public String toString() {
        return "Trend{" +
                "id=" + id +
                ", nodeId='" + nodeId + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", owner=" + owner +
                ", isPrivate=" + isPrivate +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", description='" + description + '\'' +
                ", fork=" + fork +
                ", url='" + url + '\'' +
                ", archiveUrl='" + archiveUrl + '\'' +
                ", assigneesUrl='" + assigneesUrl + '\'' +
                ", blobsUrl='" + blobsUrl + '\'' +
                ", branchesUrl='" + branchesUrl + '\'' +
                ", collaboratorsUrl='" + collaboratorsUrl + '\'' +
                ", commentsUrl='" + commentsUrl + '\'' +
                ", commitsUrl='" + commitsUrl + '\'' +
                ", compareUrl='" + compareUrl + '\'' +
                ", contentsUrl='" + contentsUrl + '\'' +
                ", contributorsUrl='" + contributorsUrl + '\'' +
                ", deploymentsUrl='" + deploymentsUrl + '\'' +
                ", downloadsUrl='" + downloadsUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                ", forksUrl='" + forksUrl + '\'' +
                ", gitCommitsUrl='" + gitCommitsUrl + '\'' +
                ", gitRefsUrl='" + gitRefsUrl + '\'' +
                ", gitTagsUrl='" + gitTagsUrl + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", issueCommentUrl='" + issueCommentUrl + '\'' +
                ", issueEventsUrl='" + issueEventsUrl + '\'' +
                ", issuesUrl='" + issuesUrl + '\'' +
                ", keysUrl='" + keysUrl + '\'' +
                ", labelsUrl='" + labelsUrl + '\'' +
                ", languagesUrl='" + languagesUrl + '\'' +
                ", mergesUrl='" + mergesUrl + '\'' +
                ", milestonesUrl='" + milestonesUrl + '\'' +
                ", notificationsUrl='" + notificationsUrl + '\'' +
                ", pullsUrl='" + pullsUrl + '\'' +
                ", releasesUrl='" + releasesUrl + '\'' +
                ", sshUrl='" + sshUrl + '\'' +
                ", stargazersUrl='" + stargazersUrl + '\'' +
                ", statusesUrl='" + statusesUrl + '\'' +
                ", subscribersUrl='" + subscribersUrl + '\'' +
                ", subscriptionUrl='" + subscriptionUrl + '\'' +
                ", tagsUrl='" + tagsUrl + '\'' +
                ", teamsUrl='" + teamsUrl + '\'' +
                ", treesUrl='" + treesUrl + '\'' +
                '}';
    }
}