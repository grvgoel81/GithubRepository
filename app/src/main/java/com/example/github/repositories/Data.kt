package com.example.github.repositories

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoriesService {
    @GET("search/repositories")
    fun getRepositories(
        @Query("q") q: String,
        @Query("sort") sort: String,
        @Query("order") order: String
    ): Call<Response>
}

data class Response(
    val total_count: String,
    val incomplete_results: Boolean,
    val items: MutableList<RepositoryDTO>
)

data class UserDTO(
    var login: String,
    var id: Int,
    var node_id: String,
    var avatar_url: String,
    var gravatar_id: String,
    var url: String,
    var html_url: String,
    var followers_url: String,
    var following_url: String,
    var gists_url: String,
    var starred_url: String,
    var subscriptions_url: String,
    var organizations_url: String,
    var repos_url: String,
    var events_url: String,
    var received_events_url: String,
    var type: String,
    var site_admin: Boolean
)

data class LicenseDTO(
    var key: String,
    var name: String,
    var spdx_id: String,
    var url: String,
    var node_id: String
)

data class RepositoryDTO(
    var id: Int?,
    var node_id: String?,
    var name: String?,
    var full_name: String?,
    var private: Boolean?,
    var owner: UserDTO?,
    var html_url: String?,
    var description: String?,
    var fork: Boolean?,
    var url: String?,
    var forks_url: String?,
    var keys_url: String?,
    var collaborators_url: String?,
    var teams_url: String?,
    var hooks_url: String?,
    var issue_events_url: String?,
    var events_url: String?,
    var assignees_url: String?,
    var branches_url: String?,
    var tags_url: String?,
    var blobs_url: String?,
    var git_tags_url: String?,
    var git_refs_url: String?,
    var trees_url: String?,
    var statuses_url: String?,
    var languages_url: String?,
    var stargazers_url: String?,
    var contributors_url: String?,
    var subscribers_url: String?,
    var subscription_url: String?,
    var commits_url: String?,
    var git_commits_url: String?,
    var comments_url: String?,
    var issue_comment_url: String?,
    var contents_url: String?,
    var compare_url: String?,
    var merges_url: String?,
    var archive_url: String?,
    var downloads_url: String?,
    var issues_url: String?,
    var pulls_url: String?,
    var milestones_url: String?,
    var notifications_url: String?,
    var labels_url: String?,
    var releases_url: String?,
    var deployments_url: String?,
    var created_at: String?,
    var updated_at: String?,
    var pushed_at: String?,
    var git_url: String?,
    var ssh_url: String?,
    var clone_url: String?,
    var svn_url: String?,
    var homepage: String?,
    var size: Int?,
    var stargazers_count: Int?,
    var watchers_count: Int?,
    var language: String?,
    var has_issues: Boolean?,
    var has_projects: Boolean?,
    var has_downloads: Boolean?,
    var has_wiki: Boolean?,
    var has_pages: Boolean?,
    var forks_count: Int?,
    var mirror_url: String?,
    var archived: Boolean?,
    var disabled: Boolean?,
    var open_issues_count: Int?,
    var license: LicenseDTO?,
    var allow_forking: Boolean?,
    var is_template: Boolean?,
    var topics: ArrayList<String> = arrayListOf(),
    var visibility: String?,
    var forks: Int?,
    var open_issues: Int?,
    var watchers: Int?,
    var default_branch: String?,
    var score: Int?
)
