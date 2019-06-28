package com.smart.sample.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Trend(
        @SerializedName("id")
        @Expose
        var id: Int? = null,
        @SerializedName("node_id")
        @Expose
        var nodeId: String? = null,
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("full_name")
        @Expose
        var fullName: String? = null,
        @SerializedName("owner")
        @Expose
        var owner: Owner? = null,
        @SerializedName("private")
        @Expose
        var private: Boolean? = null,
        @SerializedName("html_url")
        @Expose
        var htmlUrl: String? = null,
        @SerializedName("description")
        @Expose
        var description: String? = null,
        @SerializedName("fork")
        @Expose
        var fork: Boolean? = null,
        @SerializedName("url")
        @Expose
        var url: String? = null,
        @SerializedName("archive_url")
        @Expose
        var archiveUrl: String? = null,
        @SerializedName("assignees_url")
        @Expose
        var assigneesUrl: String? = null,
        @SerializedName("blobs_url")
        @Expose
        var blobsUrl: String? = null,
        @SerializedName("branches_url")
        @Expose
        var branchesUrl: String? = null,
        @SerializedName("collaborators_url")
        @Expose
        var collaboratorsUrl: String? = null,
        @SerializedName("comments_url")
        @Expose
        var commentsUrl: String? = null,
        @SerializedName("commits_url")
        @Expose
        var commitsUrl: String? = null,
        @SerializedName("compare_url")
        @Expose
        var compareUrl: String? = null,
        @SerializedName("contents_url")
        @Expose
        var contentsUrl: String? = null,
        @SerializedName("contributors_url")
        @Expose
        var contributorsUrl: String? = null,
        @SerializedName("deployments_url")
        @Expose
        var deploymentsUrl: String? = null,
        @SerializedName("downloads_url")
        @Expose
        var downloadsUrl: String? = null,
        @SerializedName("events_url")
        @Expose
        var eventsUrl: String? = null,
        @SerializedName("forks_url")
        @Expose
        var forksUrl: String? = null,
        @SerializedName("git_commits_url")
        @Expose
        var gitCommitsUrl: String? = null,
        @SerializedName("git_refs_url")
        @Expose
        var gitRefsUrl: String? = null,
        @SerializedName("git_tags_url")
        @Expose
        var gitTagsUrl: String? = null,
        @SerializedName("git_url")
        @Expose
        var gitUrl: String? = null,
        @SerializedName("issue_comment_url")
        @Expose
        var issueCommentUrl: String? = null,
        @SerializedName("issue_events_url")
        @Expose
        var issueEventsUrl: String? = null,
        @SerializedName("issues_url")
        @Expose
        var issuesUrl: String? = null,
        @SerializedName("keys_url")
        @Expose
        var keysUrl: String? = null,
        @SerializedName("labels_url")
        @Expose
        var labelsUrl: String? = null,
        @SerializedName("languages_url")
        @Expose
        var languagesUrl: String? = null,
        @SerializedName("merges_url")
        @Expose
        var mergesUrl: String? = null,
        @SerializedName("milestones_url")
        @Expose
        var milestonesUrl: String? = null,
        @SerializedName("notifications_url")
        @Expose
        var notificationsUrl: String? = null,
        @SerializedName("pulls_url")
        @Expose
        var pullsUrl: String? = null,
        @SerializedName("releases_url")
        @Expose
        var releasesUrl: String? = null,
        @SerializedName("ssh_url")
        @Expose
        var sshUrl: String? = null,
        @SerializedName("stargazers_url")
        @Expose
        var stargazersUrl: String? = null,
        @SerializedName("statuses_url")
        @Expose
        var statusesUrl: String? = null,
        @SerializedName("subscribers_url")
        @Expose
        var subscribersUrl: String? = null,
        @SerializedName("subscription_url")
        @Expose
        var subscriptionUrl: String? = null,
        @SerializedName("tags_url")
        @Expose
        var tagsUrl: String? = null,
        @SerializedName("teams_url")
        @Expose
        var teamsUrl: String? = null,
        @SerializedName("trees_url")
        @Expose
        var treesUrl: String? = null
) {
//    override fun toString(): String {
//        return "Trend(id=$id, nodeId=$nodeId, name=$name, fullName=$fullName, owner=$owner, private=$private, htmlUrl=$htmlUrl, description=$description, fork=$fork, url=$url, archiveUrl=$archiveUrl, assigneesUrl=$assigneesUrl, blobsUrl=$blobsUrl, branchesUrl=$branchesUrl, collaboratorsUrl=$collaboratorsUrl, commentsUrl=$commentsUrl, commitsUrl=$commitsUrl, compareUrl=$compareUrl, contentsUrl=$contentsUrl, contributorsUrl=$contributorsUrl, deploymentsUrl=$deploymentsUrl, downloadsUrl=$downloadsUrl, eventsUrl=$eventsUrl, forksUrl=$forksUrl, gitCommitsUrl=$gitCommitsUrl, gitRefsUrl=$gitRefsUrl, gitTagsUrl=$gitTagsUrl, gitUrl=$gitUrl, issueCommentUrl=$issueCommentUrl, issueEventsUrl=$issueEventsUrl, issuesUrl=$issuesUrl, keysUrl=$keysUrl, labelsUrl=$labelsUrl, languagesUrl=$languagesUrl, mergesUrl=$mergesUrl, milestonesUrl=$milestonesUrl, notificationsUrl=$notificationsUrl, pullsUrl=$pullsUrl, releasesUrl=$releasesUrl, sshUrl=$sshUrl, stargazersUrl=$stargazersUrl, statusesUrl=$statusesUrl, subscribersUrl=$subscribersUrl, subscriptionUrl=$subscriptionUrl, tagsUrl=$tagsUrl, teamsUrl=$teamsUrl, treesUrl=$treesUrl)"
//    }

    override fun toString(): String {
        return "Trend(id=$id, name=$name)"
    }
}
