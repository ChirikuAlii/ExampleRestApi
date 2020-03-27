package info.chirikualii.restapi


import com.google.gson.annotations.SerializedName

data class TopheadlineResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)