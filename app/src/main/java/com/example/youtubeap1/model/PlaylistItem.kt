package com.example.youtubeap1.model

data class PlaylistItem(
    val kind: String, // youtube#playlistItemListResponse
    val etag: String, // vcJky3RMFCKf2ZrRLSelGngPQo8
    val nextPageToken: String, // EAAaBlBUOkNBVQ
    val items: List<Item>,
    val pageInfo: PageInfo
) {
    data class Item(
        val kind: String, // youtube#playlistItem
        val etag: String, // rhhoCEGo68LLNLyOjV9D2BxEZ1c
        val id: String, // UExVQmpxTVBYSk5oYVFGTF9KOV9SWjdOOW5MXzRVcWhkTS41NkI0NEY2RDEwNTU3Q0M2
        val snippet: Snippet,
        val contentDetails: ContentDetails
    ) {
        data class Snippet(
            val publishedAt: String, // 2021-03-12T03:00:30Z
            val channelId: String, // UCkJ1rbOrsyPfBuHNfnLPm-Q
            val title: String, // ⭐️천재피디⭐️의 서막 | [이주연의 동행] EP.0
            val description: String, // ✔ More information about THE BOYZhttp://www.theboyz.krhttps://www.youtube.com/c/THEBOYZofficialhttp://channels.vlive.tv/DE341Fhttps://twitter.com/Creker_THEBOYZhttps://www.instagram.com/official_theboyzhttps://www.facebook.com/officialTHEBOYZhttp://cafe.daum.net/officialTHEBOYZCopyrights 2021 ⓒ Cre.ker Entertainment. All Rights Reserved.#THEBOYZ #더보이즈 #이주연의_동행
            val thumbnails: Thumbnails,
            val channelTitle: String, // THE BOYZ
            val playlistId: String, // PLUBjqMPXJNhaQFL_J9_RZ7N9nL_4UqhdM
            val position: Int, // 0
            val resourceId: ResourceId,
            val videoOwnerChannelTitle: String, // THE BOYZ
            val videoOwnerChannelId: String // UCkJ1rbOrsyPfBuHNfnLPm-Q
        ) {
            data class Thumbnails(
                val default: Default,
                val medium: Medium,
                val high: High,
                val standard: Standard,
                val maxres: Maxres
            ) {
                data class Default(
                    val url: String, // https://i.ytimg.com/vi/gntVqS_Z-gI/default.jpg
                    val width: Int, // 120
                    val height: Int // 90
                )

                data class Medium(
                    val url: String, // https://i.ytimg.com/vi/gntVqS_Z-gI/mqdefault.jpg
                    val width: Int, // 320
                    val height: Int // 180
                )

                data class High(
                    val url: String, // https://i.ytimg.com/vi/gntVqS_Z-gI/hqdefault.jpg
                    val width: Int, // 480
                    val height: Int // 360
                )

                data class Standard(
                    val url: String, // https://i.ytimg.com/vi/gntVqS_Z-gI/sddefault.jpg
                    val width: Int, // 640
                    val height: Int // 480
                )

                data class Maxres(
                    val url: String, // https://i.ytimg.com/vi/gntVqS_Z-gI/maxresdefault.jpg
                    val width: Int, // 1280
                    val height: Int // 720
                )
            }

            data class ResourceId(
                val kind: String, // youtube#video
                val videoId: String // gntVqS_Z-gI
            )
        }

        data class ContentDetails(
            val videoId: String, // gntVqS_Z-gI
            val videoPublishedAt: String // 2021-03-12T09:00:14Z
        )
    }

    data class PageInfo(
        val totalResults: Int, // 14
        val resultsPerPage: Int // 5
    )
}