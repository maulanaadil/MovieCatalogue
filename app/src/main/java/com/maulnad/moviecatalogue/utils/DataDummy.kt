package com.maulnad.moviecatalogue.utils

import com.maulnad.moviecatalogue.R
import com.maulnad.moviecatalogue.model.DataEntity

object DataDummy {
    fun generateDummyMovies(): List<DataEntity> {
        val movies = ArrayList<DataEntity>()
        movies.add(
            DataEntity(
                "m1",
                "Ralph Breaks The Internet",
                "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
                "11/02/2012",
                "Family, Animation, Comedy, Adventure",
                R.drawable.poster_ralph
            )
        )

        movies.add(
            DataEntity(
                "m2",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "10/05/2018",
                "Drama, Romance, Music",
                R.drawable.poster_a_start_is_born
            )
        )

        movies.add(
            DataEntity(
                "m3",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018",
                "Music, Drama, History",
                R.drawable.poster_bohemian
            )
        )

        movies.add(
            DataEntity(
                "m4",
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "11/21/2018",
                "Drama",
                R.drawable.poster_creed
            )
        )

        movies.add(
            DataEntity(
                "m5",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                "Adventure, Action, Science Fiction",
                R.drawable.poster_infinity_war
            )
        )

        movies.add(
            DataEntity(
                "m6",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                "Action, Science Fiction, Adventure",
                R.drawable.poster_alita
            )
        )

        movies.add(
            DataEntity(
                "m7",
                "Mary Queen Of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "12/21/2018",
                "Drama, History",
                R.drawable.poster_marry_queen
            )
        )

        movies.add(
            DataEntity(
                "m8",
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "11/21/2018",
                "Adventure, Action, Thriller",
                R.drawable.poster_robin_hood
            )
        )

        movies.add(
            DataEntity(
                "m9",
                "Serenity",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "01/25/2019",
                "Thriller, Mystery, Drama",
                R.drawable.poster_serenity
            )
        )

        movies.add(
            DataEntity(
                "m10",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "01/18/2019",
                "Thriller, Drama, Science Fiction",
                R.drawable.poster_glass
            )
        )
        return movies
    }

    fun generateDummyTvShows(): List<DataEntity> {
        val tvShows = ArrayList<DataEntity>()

        tvShows.add(
            DataEntity(
                "ts1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012",
                "Crime, Drama, Action & Adventure",
                R.drawable.poster_arrow
            )
        )

        tvShows.add(
            DataEntity(
                "ts2",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999",
                "Animation, Comedy",
                R.drawable.poster_family_guy
            )
        )

        tvShows.add(
            DataEntity(
                "ts3",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014",
                "Drama, Sci-FI & Fantasy",
                R.drawable.poster_flash
            )
        )

        tvShows.add(
            DataEntity(
                "ts4",
                "Game Of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "2011",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                R.drawable.poster_god
            )
        )

        tvShows.add(
            DataEntity(
                "ts5",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019",
                "Sci-Fi & Fantasy, Comedy, Drama",
                R.drawable.poster_doom_patrol
            )
        )

        tvShows.add(
            DataEntity(
                "ts6",
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "2015",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                R.drawable.poster_supergirl
            )
        )

        tvShows.add(
            DataEntity(
                "ts7",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "1989",
                "Family, Animation, Comedy",
                R.drawable.poster_the_simpson
            )
        )

        tvShows.add(
            DataEntity(
                "ts8",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "2010",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                R.drawable.poster_the_walking_dead
            )
        )

        tvShows.add(
            DataEntity(
                "ts9",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "2005",
                "Drama, Mystery, Sci-Fi & Fantasy",
                R.drawable.poster_supernatural
            )
        )

        tvShows.add(
            DataEntity(
                "ts10",
                "Naruto Shippuden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "2007",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                R.drawable.poster_naruto_shipudden
            )
        )
        return tvShows
    }
}