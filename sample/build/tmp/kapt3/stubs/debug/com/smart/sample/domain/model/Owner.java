package com.smart.sample.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010D\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR \u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b\'\u0010\bR \u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR \u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR \u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\"\u00101\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR \u0010;\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR \u0010>\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR \u0010A\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\b\u00a8\u0006E"}, d2 = {"Lcom/smart/sample/domain/model/Owner;", "", "()V", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "eventsUrl", "getEventsUrl", "setEventsUrl", "followersUrl", "getFollowersUrl", "setFollowersUrl", "followingUrl", "getFollowingUrl", "setFollowingUrl", "gistsUrl", "getGistsUrl", "setGistsUrl", "gravatarId", "getGravatarId", "setGravatarId", "htmlUrl", "getHtmlUrl", "setHtmlUrl", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "login", "getLogin", "setLogin", "nodeId", "getNodeId", "setNodeId", "organizationsUrl", "getOrganizationsUrl", "setOrganizationsUrl", "receivedEventsUrl", "getReceivedEventsUrl", "setReceivedEventsUrl", "reposUrl", "getReposUrl", "setReposUrl", "siteAdmin", "", "getSiteAdmin", "()Ljava/lang/Boolean;", "setSiteAdmin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "starredUrl", "getStarredUrl", "setStarredUrl", "subscriptionsUrl", "getSubscriptionsUrl", "setSubscriptionsUrl", "type", "getType", "setType", "url", "getUrl", "setUrl", "toString", "sample_debug"})
public final class Owner {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "login")
    private java.lang.String login;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "node_id")
    private java.lang.String nodeId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "avatar_url")
    private java.lang.String avatarUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "gravatar_id")
    private java.lang.String gravatarId;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "url")
    private java.lang.String url;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "html_url")
    private java.lang.String htmlUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "followers_url")
    private java.lang.String followersUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "following_url")
    private java.lang.String followingUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "gists_url")
    private java.lang.String gistsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "starred_url")
    private java.lang.String starredUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "subscriptions_url")
    private java.lang.String subscriptionsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "organizations_url")
    private java.lang.String organizationsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "repos_url")
    private java.lang.String reposUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "events_url")
    private java.lang.String eventsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "received_events_url")
    private java.lang.String receivedEventsUrl;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "type")
    private java.lang.String type;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "site_admin")
    private java.lang.Boolean siteAdmin;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLogin() {
        return null;
    }
    
    public final void setLogin(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNodeId() {
        return null;
    }
    
    public final void setNodeId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvatarUrl() {
        return null;
    }
    
    public final void setAvatarUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGravatarId() {
        return null;
    }
    
    public final void setGravatarId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final void setUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHtmlUrl() {
        return null;
    }
    
    public final void setHtmlUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFollowersUrl() {
        return null;
    }
    
    public final void setFollowersUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFollowingUrl() {
        return null;
    }
    
    public final void setFollowingUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGistsUrl() {
        return null;
    }
    
    public final void setGistsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStarredUrl() {
        return null;
    }
    
    public final void setStarredUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSubscriptionsUrl() {
        return null;
    }
    
    public final void setSubscriptionsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOrganizationsUrl() {
        return null;
    }
    
    public final void setOrganizationsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReposUrl() {
        return null;
    }
    
    public final void setReposUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEventsUrl() {
        return null;
    }
    
    public final void setEventsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReceivedEventsUrl() {
        return null;
    }
    
    public final void setReceivedEventsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getSiteAdmin() {
        return null;
    }
    
    public final void setSiteAdmin(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Owner() {
        super();
    }
}