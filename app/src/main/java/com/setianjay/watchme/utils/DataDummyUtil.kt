package com.setianjay.watchme.utils

import com.setianjay.watchme.R
import com.setianjay.watchme.model.Movies

object DataDummyUtil {
    private val movies: MutableList<Movies> = mutableListOf()

    fun generateDataMovies(): List<Movies> {
        if (movies.isNotEmpty()) movies.clear()

        movies.add(
            Movies(
                "A Star Is Born",
                R.drawable.poster_a_start_is_born,
                "Bradley Cooper",
                "2h 16m",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                listOf("Drama", "Romance"),
                4.3F
            )
        )
        movies.add(
            Movies(
                "Alita: Battle Angel",
                R.drawable.poster_alita,
                "Robert Rodriguez",
                "2h 2m",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                listOf("Action, Science Fiction, Adventure"),
                4.0F
            )
        )
        movies.add(
            Movies(
                "Aquaman",
                R.drawable.poster_aquaman,
                "James Wan",
                "2h 23m",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                listOf("Action, Adventure, Fantasy"),
                3.5F
            )
        )
        movies.add(
            Movies(
                "Creed II",
                R.drawable.poster_creed,
                "Steven Caple Jr.",
                "2h 10m",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                listOf("Drama"),
                3.5F
            )
        )
        movies.add(
            Movies(
                "Ralph Breaks the Internet",
                R.drawable.poster_ralph,
                "Phil Johnston",
                "1h 52m",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                listOf("Family, Animation, Comedy, Adventure"),
                4.2F
            )
        )
        movies.add(
            Movies(
                "Spider-Man: Into the Spider-Verse",
                R.drawable.poster_spiderman,
                "Peter Ramsey",
                "1h 57m",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                listOf("Action", "Adventure", "Animation", "Comedy"),
                4.7F
            )
        )
        movies.add(
            Movies(
                "Glass",
                R.drawable.poster_glass,
                "M. Night Shyamalan",
                "2h 9m",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                listOf("Thriller", "Science Fiction", "Drama"),
                3.7F
            )
        )
        movies.add(
            Movies(
                "Bohemian Rhapsody",
                R.drawable.poster_bohemian,
                "Bryan Singer",
                "2h 15m",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                listOf("Music", "Drama", "History"),
                4.3F
            )
        )
        movies.add(
            Movies(
                "Avenger: Infinity War",
                R.drawable.poster_infinity_war,
                "Antony Rhusso",
                "2h 29m",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                listOf("Adventure", "Action", "Science Fiction"),
                4.5F
            )
        )
        movies.add(
            Movies(
                "Master Z: Ip Man Legacy",
                R.drawable.poster_master_z,
                "Yuen Woo-ping",
                "1h 47m",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                listOf("Action"),
                3.3F
            )
        )

        return movies
    }

    fun generateDataTvShows(): List<Movies> {
        if (movies.isNotEmpty()) movies.clear()

        movies.add(
            Movies(
                "Arrow",
                R.drawable.poster_arrow,
                "Greg Berlanti",
                "42m",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                listOf("Crime", "Drama", "Mystery"),
                3.9F
            )
        )
        movies.add(
            Movies(
                "Doom Patrol",
                R.drawable.poster_doom_patrol,
                "Jeremy Carver",
                "49m",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                listOf("Sci-Fi", "Fantasy", "Drama"),
                4.2F
            )
        )
        movies.add(
            Movies(
                "Flash",
                R.drawable.poster_flash,
                "Greg Berlanti",
                "44m",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                listOf("Drama", "Sci-Fi", "Fantasy"),
                4.0F
            )
        )
        movies.add(
            Movies(
                "Supergirl",
                R.drawable.poster_supergirl,
                "Greg Berlanti",
                "42m",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                listOf("Drama", "Fantasu", "Action"),
                4.2F
            )
        )
        movies.add(
            Movies(
                "Gotham",
                R.drawable.poster_gotham,
                "Bruno Heller",
                "43m",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                listOf("Drama", "Crime", "Fantasy"),
                4.4F
            )
        )
        movies.add(
            Movies(
                "Marvel's Iron Fist",
                R.drawable.poster_iron_fist,
                "Scott Buck",
                "55m",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                listOf("Action", "Adventure", "Drama"),
                3.5F
            )
        )
        movies.add(
            Movies(
                "NCIS",
                R.drawable.poster_ncis,
                "Don Mc Gil",
                "45m",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                listOf("Crime", "Action", "Drama"),
                3.9F
            )
        )
        movies.add(
            Movies(
                "Riverdale",
                R.drawable.poster_riverdale,
                "Roberto Aguirre-Sacasa",
                "45m",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                listOf("Mystery", "Drama", "Crime"),
                4.6F
            )
        )
        movies.add(
            Movies(
                "The Walking Dead",
                R.drawable.poster_the_walking_dead,
                "Frank Darabont",
                "42m",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                listOf("Action", "Drama", "Fantasy"),
                4.8F
            )
        )
        movies.add(
            Movies(
                "Supernatural",
                R.drawable.poster_supernatural,
                "Eric Kripke",
                "45m",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                listOf("Drama", "Mystery", "Fantasy"),
                4.5F
            )
        )

        return movies
    }
}