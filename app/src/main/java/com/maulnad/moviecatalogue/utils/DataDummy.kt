package com.maulnad.moviecatalogue.utils

import com.maulnad.moviecatalogue.data.source.local.entity.MovieEntity
import com.maulnad.moviecatalogue.data.source.local.entity.TvShowEntity
import com.maulnad.moviecatalogue.data.source.remote.response.MovieDetailResponse
import com.maulnad.moviecatalogue.data.source.remote.response.TvShowDetailResponse

object DataDummy {

    fun generateDataDummyMoviesResponse(): List<MovieDetailResponse> {
        val movies = ArrayList<MovieDetailResponse>()
        movies.add(
            MovieDetailResponse(
                id = 1,
                title = "Tom Clancy's Without Remorse",
                overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                posterPath = "https://image.tmdb.org/t/p/w500/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/fPGeS6jgdLovQAKunNHX8l0avCy.jpg"
            )
        )

        movies.add(
            MovieDetailResponse(
                id = 2,
                title = "Mortal Kombat",
                overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                posterPath = "https://image.tmdb.org/t/p/w500/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/6ELCZlTA5lGUops70hKdB83WJxH.jpg"
            )
        )

        movies.add(
            MovieDetailResponse(
                id = 3,
                title = "Vanquish",
                overview = "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                posterPath = "https://image.tmdb.org/t/p/w500/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg"
            )
        )

        movies.add(
            MovieDetailResponse(
                id = 4,
                title = "Godzilla vs. Kong",
                overview = "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                posterPath = "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg"
            )
        )

        movies.add(
            MovieDetailResponse(
                id = 5,
                title = "Thunder Force",
                overview = "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                posterPath = "https://image.tmdb.org/t/p/w500/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg"
            )
        )

        movies.add(
            MovieDetailResponse(
                id = 6,
                title = "Nobody",
                overview = "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                posterPath = "https://image.tmdb.org/t/p/w500/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg"
            )
        )

        movies.add(
            MovieDetailResponse(
                id = 7,
                title = "Sentinelle",
                overview = "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                posterPath = "https://image.tmdb.org/t/p/w500/AmUGn1rJ9XDDP6DYn9OA2uV8MIg.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/eTgQlyIQH0nA5BsmYpvCzSPAorg.jpg"
            )
        )

        movies.add(
            MovieDetailResponse(
                id = 8,
                title = "Zack Snyder's Justice League",
                overview = "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                posterPath = "https://image.tmdb.org/t/p/w500/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg"
            )
        )

        movies.add(
            MovieDetailResponse(
                id = 9,
                title = "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                overview = "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                posterPath = "https://image.tmdb.org/t/p/w500/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/xPpXYnCWfjkt3zzE0dpCNME1pXF.jpg"
            )
        )

        movies.add(
            MovieDetailResponse(
                id = 10,
                title = "Miraculous World: Shanghai – The Legend of Ladydragon",
                overview = "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                posterPath = "https://image.tmdb.org/t/p/w500/msI5a9TPnepx47JUb2vl88hb80R.jpg",
                backgroundPath = "https://image.tmdb.org/t/p/w500/lHhc60NXYzswU4TvKSo45nY9Jzs.jpg"
            )
        )
        return movies
    }

    fun generateDataDummyTvShowsResponse(): List<TvShowDetailResponse> {
        val tvShows = ArrayList<TvShowDetailResponse>()

        tvShows.add(
            TvShowDetailResponse(
                id = 1,
                name = "The Falcon and the Winter Soldier",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                posterPath = "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg"
            )
        )

        tvShows.add(
            TvShowDetailResponse(
                id = 2,
                name = "Invincible",
                overview = "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                posterPath = "https://image.tmdb.org/t/p/w500/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg"
            )
        )

        tvShows.add(
            TvShowDetailResponse(
                id = 3,
                name = "Selena: The Series",
                overview = "As Mexican-American Tejano singer Selena comes of age and realizes her dreams, she and her family make tough choices to hold on to love and music.",
                posterPath = "https://image.tmdb.org/t/p/w500/mYsWyfiIMxx4HDm0Wck7oJ9ckez.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/Wu8kh7oyvaIfkNyMJyJHCamh5L.jpg"

            )
        )

        tvShows.add(
            TvShowDetailResponse(
                id = 4,
                name = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                posterPath = "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg"
            )
        )

        tvShows.add(
            TvShowDetailResponse(
                id = 5,
                name = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                posterPath = "https://image.tmdb.org/t/p/w500/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg"
            )
        )

        tvShows.add(
            TvShowDetailResponse(
                id = 6,
                name = "The Handmaid's Tale",
                overview = "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship. A TV adaptation of Margaret Atwood's novel.",
                posterPath = "https://image.tmdb.org/t/p/w500/oIkxqt6ug5zT5ZSUUyc1Iqopf02.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/hNiGqLsiD30C194lci7VYDmciHD.jpg"
            )
        )

        tvShows.add(
            TvShowDetailResponse(
                id = 7,
                name = "Grey's Anatomy",
                overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                posterPath = "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg"
            )
        )

        tvShows.add(
            TvShowDetailResponse(
                id = 8,
                name = "Luis Miguel: The Series",
                overview = "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                posterPath = "https://image.tmdb.org/t/p/w500/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/wkyzeBBKLhSg1Oqhky5yoiFF2hG.jpg"
            )
        )

        tvShows.add(
            TvShowDetailResponse(
                id = 9,
                name = "The Bad Batch",
                overview = "Follow the elite and experimental Clones of the Bad Batch as they find their way in a rapidly changing galaxy in the aftermath of the Clone Wars.",
                posterPath = "https://image.tmdb.org/t/p/w500/WjQmEWFrOf98nT5aEfUfVYz9N2.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/WjQmEWFrOf98nT5aEfUfVYz9N2.jpg"
            )
        )

        tvShows.add(
            TvShowDetailResponse(
                id = 10,
                name = "Lucifer",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                posterPath = "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg"
            )
        )
        return tvShows
    }

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                1,
                "Tom Clancy's Without Remorse",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "https://image.tmdb.org/t/p/w500/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "https://image.tmdb.org/t/p/w500/fPGeS6jgdLovQAKunNHX8l0avCy.jpg"
            )
        )

        movies.add(
            MovieEntity(
                2,
                "Mortal Kombat",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "https://image.tmdb.org/t/p/w500/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "https://image.tmdb.org/t/p/w500/6ELCZlTA5lGUops70hKdB83WJxH.jpg"
            )
        )

        movies.add(
            MovieEntity(
                3,
                "Vanquish",
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                "https://image.tmdb.org/t/p/w500/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "https://image.tmdb.org/t/p/w500/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg"
            )
        )

        movies.add(
            MovieEntity(
                4,
                "Godzilla vs. Kong",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "https://image.tmdb.org/t/p/w500/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg"
            )
        )

        movies.add(
            MovieEntity(
                5,
                "Thunder Force",
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                "https://image.tmdb.org/t/p/w500/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                "https://image.tmdb.org/t/p/w500/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg"
            )
        )

        movies.add(
            MovieEntity(
                6,
                "Nobody",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "https://image.tmdb.org/t/p/w500/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "https://image.tmdb.org/t/p/w500/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg"
            )
        )

        movies.add(
            MovieEntity(
                7,
                "Sentinelle",
                "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                "https://image.tmdb.org/t/p/w500/AmUGn1rJ9XDDP6DYn9OA2uV8MIg.jpg",
                "https://image.tmdb.org/t/p/w500/eTgQlyIQH0nA5BsmYpvCzSPAorg.jpg"
            )
        )

        movies.add(
            MovieEntity(
                8,
                "Zack Snyder's Justice League",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "https://image.tmdb.org/t/p/w500/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "https://image.tmdb.org/t/p/w500/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg"
            )
        )

        movies.add(
            MovieEntity(
                9,
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "https://image.tmdb.org/t/p/w500/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                "https://image.tmdb.org/t/p/w500/xPpXYnCWfjkt3zzE0dpCNME1pXF.jpg"
            )
        )

        movies.add(
            MovieEntity(
                10,
                "Miraculous World: Shanghai – The Legend of Ladydragon",
                "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                "https://image.tmdb.org/t/p/w500/msI5a9TPnepx47JUb2vl88hb80R.jpg",
                "https://image.tmdb.org/t/p/w500/lHhc60NXYzswU4TvKSo45nY9Jzs.jpg"
            )
        )
        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()
        tvShows.add(
            TvShowEntity(
                1,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "https://image.tmdb.org/t/p/w500/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                2,
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "https://image.tmdb.org/t/p/w500/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "https://image.tmdb.org/t/p/w500/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                3,
                "Selena: The Series",
                "As Mexican-American Tejano singer Selena comes of age and realizes her dreams, she and her family make tough choices to hold on to love and music.",
                "https://image.tmdb.org/t/p/w500/mYsWyfiIMxx4HDm0Wck7oJ9ckez.jpg",
                "https://image.tmdb.org/t/p/w500/Wu8kh7oyvaIfkNyMJyJHCamh5L.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                4,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "https://image.tmdb.org/t/p/w500/jeruqNWhqRqOR1QyqdQdHunrvU5.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                5,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "https://image.tmdb.org/t/p/w500/53P8oHo9cfOsgb1cLxBi4pFY0ja.jpg",
                "https://image.tmdb.org/t/p/w500/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                6,
                "The Handmaid's Tale",
                "Set in a dystopian future, a woman is forced to live as a concubine under a fundamentalist theocratic dictatorship. A TV adaptation of Margaret Atwood's novel.",
                "https://image.tmdb.org/t/p/w500/oIkxqt6ug5zT5ZSUUyc1Iqopf02.jpg",
                "https://image.tmdb.org/t/p/w500/hNiGqLsiD30C194lci7VYDmciHD.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                7,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "https://image.tmdb.org/t/p/w500/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                8,
                "Luis Miguel: The Series",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "https://image.tmdb.org/t/p/w500/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "https://image.tmdb.org/t/p/w500/wkyzeBBKLhSg1Oqhky5yoiFF2hG.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                9,
                "The Bad Batch",
                "Follow the elite and experimental Clones of the Bad Batch as they find their way in a rapidly changing galaxy in the aftermath of the Clone Wars.",
                "https://image.tmdb.org/t/p/w500/WjQmEWFrOf98nT5aEfUfVYz9N2.jpg",
                "https://image.tmdb.org/t/p/w500/WjQmEWFrOf98nT5aEfUfVYz9N2.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                10,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "https://image.tmdb.org/t/p/w500/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "https://image.tmdb.org/t/p/w500/ta5oblpMlEcIPIS2YGcq9XEkWK2.jpg"
            )
        )
        return tvShows
    }
}
