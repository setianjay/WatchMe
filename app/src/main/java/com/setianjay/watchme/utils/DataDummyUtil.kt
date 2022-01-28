package com.setianjay.watchme.utils

import com.setianjay.watchme.data.source.local.entity.MovieEntity
import com.setianjay.watchme.data.source.remote.response.*

object DataDummyUtil {
    private val movies: MutableList<MovieEntity> = mutableListOf()

    fun generateDataMovies(): List<MovieEntity> {
        if (movies.isNotEmpty()) movies.clear()

        movies.add(
            MovieEntity(
                524434L,
                "Eternals",
                "/b6qUu00iIIkXX13szFy7d0CyNcg.jpg",
                "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
                7.3F,
                "03/11/2021",
                "Action, Adventure, Fantasy, Science Fiction"
            )
        )

        movies.add(
            MovieEntity(
                438695L,
                "Sing 2",
                "/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
                "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
                8.2F,
                "01/12/2021",
                "Animation, Comedy, Family, Music"
            )
        )

        movies.add(
            MovieEntity(
                425909L,
                "Ghostbusters: Afterlife",
                "/sg4xJaufDiQl7caFEskBtQXfD4x.jpg",
                "When a single mom and her two kids arrive in a small town, they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
                7.6F,
                "11/11/2021",
                "Comedy, Fantasy, Adventure"
            )
        )

        movies.add(
            MovieEntity(
                634649L,
                "Spider-Man: No Way Home",
                "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                8.4F,
                "15/12/2021",
                "Action, Adventure, Science Fiction"
            )
        )

        movies.add(
            MovieEntity(
                568124L,
                "Encanto",
                "/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
                "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
                7.8F,
                "24/11/2021",
                "Animation, Comedy, Family, Fantasy"
            )
        )

        movies.add(
            MovieEntity(
                460458L,
                "Resident Evil: Welcome to Raccoon City",
                "/7uRbWOXxpWDMtnsd2PF3clu65jc.jpg",
                "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
                6.0F,
                "24/11/2021",
                "Horror, Action, Science Fiction"
            )
        )

        movies.add(
            MovieEntity(
                624860L,
                "The Matrix Resurrections",
                "/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
                "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.",
                6.9F,
                "16/12/2021",
                "Science Fiction, Action, Adventure"
            )
        )

        movies.add(
            MovieEntity(
                580489L,
                "Venom: Let There Be Carnage",
                "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
                "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
                7.1F,
                "30/09/2021",
                "Science Fiction, Action, Adventure"
            )
        )

        movies.add(
            MovieEntity(
                512195L,
                "Red Notice",
                "/lAXONuqg41NwUMuzMiFvicDET9Y.jpg",
                "An Interpol-issued Red Notice is a global alert to hunt and capture the world's most wanted. But when a daring heist brings together the FBI's top profiler and two rival criminals, there's no telling what will happen.",
                6.8F,
                "04/11/2021",
                "Action, Comedy, Crime, Thriller"
            )
        )

        movies.add(
            MovieEntity(
                566525L,
                "Shang-Chi and the Legend of the Ten Rings",
                "/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
                "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
                7.8F,
                "01/09/2021",
                "Action, Adventure, Fantasy"
            )
        )

        movies.add(
            MovieEntity(
                585083L,
                "Hotel Transylvania: Transformania",
                "/teCy1egGQa0y8ULJvlrDHQKnxBL.jpg",
                "When Van Helsing's mysterious invention, the \"Monsterfication Ray,\" goes haywire, Drac and his monster pals are all transformed into humans, and Johnny becomes a monster. In their new mismatched bodies, Drac and Johnny must team up and race across the globe to find a cure before it's too late, and before they drive each other crazy.",
                7.7F,
                "13/01/2022",
                "Animation, Family, Fantasy, Comedy, Adventure"
            )
        )

        movies.add(
            MovieEntity(
                763788L,
                "Dangerous",
                "/vTtkQGC7qKlSRQJZYtAWAmYdH0A.jpg",
                "A reformed sociopath heads to a remote island after the death of his brother. Soon after his arrival, the island falls under siege from a deadly gang of mercenaries, and when he discovers their role in his brother’s demise, he sets out on a relentless quest for vengeance.",
                6.7F,
                "05/11/2021",
                "Action, Thriller"
            )
        )

        movies.add(
            MovieEntity(
                787310L,
                "Survive the Game",
                "/xF1uc2pEf34X2G41wvZaF5H0V7C.jpg",
                "When cop David is injured in a drug bust gone wrong, his partner Cal chases the two criminals who shot him. They all land at a remote farm owned by troubled vet Eric, and as Cal and Eric plot their defense, more of the gang arrives - along with a wounded David. Outnumbered, the three heroes must use stealth, smarts, and good shooting to take down the drug-dealing mob.",
                6.0F,
                "08/10/2021",
                "Action, Thriller, Crime"
            )
        )

        movies.add(
            MovieEntity(
                516329L,
                "Antlers",
                "/cMch3tiexw3FdOEeZxMWVel61Xg.jpg",
                "A small-town Oregon teacher and her brother, the local sheriff, discover a young student is harbouring a dangerous secret that could have frightening consequences.",
                6.5F,
                "28/10/2021",
                "Drama, Horror, Mystery"
            )
        )

        movies.add(
            MovieEntity(
                826749L,
                "Fortress",
                "/fP3i67pt7n1vh9Sy3K9mlPjrGmC.jpg",
                "The story revolves around a top-secret resort for retired U.S. intelligence officers. A group of criminals led by Balzary breach the compound, hellbent on revenge on Robert, forcing the retired officer and his son to save the day.",
                6.3F,
                "17/12/2021",
                "Crime, Action, Thriller"
            )
        )

        movies.add(
            MovieEntity(
                635302L,
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                8.4F,
                "16/10/2020",
                "Animation, Action, Adventure, Fantasy"
            )
        )

        movies.add(
            MovieEntity(
                585245L,
                "Clifford the Big Red Dog",
                "/oifhfVhUcuDjE61V5bS5dfShQrm.jpg",
                "As Emily struggles to fit in at home and at school, she discovers a small red puppy who is destined to become her best friend. When Clifford magically undergoes one heck of a growth spurt, becomes a gigantic dog and attracts the attention of a genetics company, Emily and her Uncle Casey have to fight the forces of greed as they go on the run across New York City. Along the way, Clifford affects the lives of everyone around him and teaches Emily and her uncle the true meaning of acceptance and unconditional love.",
                7.4F,
                "10/11/2021",
                "Animation, Comedy, Family"
            )
        )

        movies.add(
            MovieEntity(
                843241L,
                "The Seven Deadly Sins: Cursed by Light",
                "/k0ThmZQl5nHe4JefC2bXjqtgYp0.jpg",
                "With the help of the \"Dragon Sin of Wrath\" Meliodas and the worst rebels in history, the Seven Deadly Sins, the \"Holy War\", in which four races, including Humans, Goddesses, Fairies and Giants fought against the Demons, is finally over. At the cost of the \"Lion Sin of Pride\" Escanor's life, the Demon King was defeated and the world regained peace. After that, each of the Sins take their own path.",
                8.0F,
                "02/07/2021",
                "Animation, Fantasy"
            )
        )

        movies.add(
            MovieEntity(
                899082L,
                "Harry Potter 20th Anniversary: Return to Hogwarts",
                "/jntLBq0MLR3hrwKaTQswxACRPMs.jpg",
                "An enchanting making-of story told through all-new in-depth interviews and cast conversations, inviting fans on a magical first-person journey through one of the most beloved film franchises of all time.",
                8.5F,
                "01/01/2022",
                "Documentary"
            )
        )

        movies.add(
            MovieEntity(
                646385L,
                "Scream",
                "/qvASAp0ZKkza023gjK1Tf2iiEos.jpg",
                "Twenty-five years after a streak of brutal murders shocked the quiet town of Woodsboro, a new killer has donned the Ghostface mask and begins targeting a group of teenagers to resurrect secrets from the town’s deadly past.",
                7.2F,
                "12/01/2022",
                "Horror, Mystery, Thriller"
            )
        )

        return movies
    }

    fun generateDataTvShows(): List<MovieEntity> {
        if (movies.isNotEmpty()) movies.clear()

        movies.add(
            MovieEntity(
                110492L,
                "Peacemaker",
                "/hE3LRZAY84fG19a18pzpkZERjTE.jpg",
                "The continuing story of Peacemaker – a compellingly vainglorious man who believes in peace at any cost, no matter how many people he has to kill to get it – in the aftermath of the events of \"The Suicide Squad.\"",
                8.5F,
                "13/01/2022",
                "Action & Adventure, Comedy, Sci-Fi & Fantasy"
            )
        )

        movies.add(
            MovieEntity(
                115036L,
                "The Book of Boba Fett",
                "/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg",
                "Legendary bounty hunter Boba Fett and mercenary Fennec Shand must navigate the galaxy’s underworld when they return to the sands of Tatooine to stake their claim on the territory once ruled by Jabba the Hutt and his crime syndicate.",
                8.2F,
                "29/12/2021",
                "Sci-Fi & Fantasy, Action & Adventure"
            )
        )

        movies.add(
            MovieEntity(
                77169L,
                "Cobra Kai",
                "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                8.1F,
                "02/05/2018",
                "Action & Adventure, Drama"
            )
        )

        movies.add(
            MovieEntity(
                134949L,
                "Rebelde",
                "/jRlI5euugVZR6a1Ptt0nSWeiWH.jpg",
                "Head back to Elite Way School as a new generation of students hope to win the Battle of the Bands.",
                7.4F,
                "05/01/2022",
                "Drama"
            )
        )

        movies.add(
            MovieEntity(
                96777L,
                "The Silent Sea",
                "/fFT0IgqtCOks4munDTxQwkvNJkd.jpg",
                "During a perilous 24-hour mission on the moon, space explorers try to retrieve samples from an abandoned research facility steeped in classified secrets.",
                8.1F,
                "24/12/2021",
                "Drama, Sci-Fi & Fantasy"
            )
        )

        movies.add(
            MovieEntity(
                71914L,
                "The Wheel of Time",
                "/mpgDeLhl8HbhI03XLB7iKO6M6JE.jpg",
                "Follow Moiraine, a member of the shadowy and influential all-female organization called the “Aes Sedai” as she embarks on a dangerous, world-spanning journey with five young men and women. Moiraine believes one of them might be the reincarnation of an incredibly powerful individual, whom prophecies say will either save humanity or destroy it.",
                7.9F,
                "18/11/2021",
                "Sci-Fi & Fantasy, Drama"
            )
        )

        movies.add(
            MovieEntity(
                60735L,
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                7.8F,
                "07/10/2014",
                "Drama, Sci-Fi & Fantasy"
            )
        )

        movies.add(
            MovieEntity(
                2778L,
                "Wheel of Fortune",
                "/2fvAIyVfFHQdhJ7OsJWuMlF7836.jpg",
                "This game show sees contestants solve word puzzles, similar to those used in Hangman, to win cash and prizes determined by spinning a giant carnival wheel.",
                6.8F,
                "19/09/1983",
                "Family"
            )
        )

        movies.add(
            MovieEntity(
                63174L,
                "Lucifer",
                "/ekZobS8isE6mA53RAiGDG93hBxL.jpg",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                8.5F,
                "25/01/2016",
                "Crime, Sci-Fi & Fantasy"
            )
        )

        movies.add(
            MovieEntity(
                1416L,
                "Grey's Anatomy",
                "/zPIug5giU8oug6Xes5K1sTfQJxY.jpg",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                8.2F,
                "27/03/2005",
                "Drama"
            )
        )

        movies.add(
            MovieEntity(
                88329L,
                "Hawkeye",
                "/pqzjCxPVc9TkVgGRWeAoMmyqkZV.jpg",
                "Former Avenger Clint Barton has a seemingly simple mission: get back to his family for Christmas. Possible? Maybe with the help of Kate Bishop, a 22-year-old archer with dreams of becoming a superhero. The two are forced to work together when a presence from Barton’s past threatens to derail far more than the festive spirit.",
                8.4F,
                "24/11/2021",
                "Action & Adventure, Drama"
            )
        )

        movies.add(
            MovieEntity(
                60574L,
                "Peaky Blinders",
                "/pE8CScObQURsFZ723PSW1K9EGYp.jpg",
                "A gangster family epic set in 1919 Birmingham, England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby, who means to move up in the world.",
                8.6F,
                "12/09/2013",
                "Crime, Drama"
            )
        )

        movies.add(
            MovieEntity(
                90462L,
                "Chucky",
                "/iF8ai2QLNiHV4anwY1TuSGZXqfN.jpg",
                "After a vintage Chucky doll turns up at a suburban yard sale, an idyllic American town is thrown into chaos as a series of horrifying murders begin to expose the town’s hypocrisies and secrets. Meanwhile, the arrival of enemies — and allies — from Chucky’s past threatens to expose the truth behind the killings, as well as the demon doll’s untold origins.",
                7.9F,
                "12/10/2021",
                "Crime"
            )
        )

        movies.add(
            MovieEntity(
                132375L,
                "Um Lugar ao Sol",
                "/63qlVcvlVzOvMaFO8tFA2VG64Yc.jpg",
                "",
                5.0F,
                "08/11/2021",
                "Soap, Drama"
            )
        )

        movies.add(
            MovieEntity(
                117031L,
                "People Puzzler",
                "/gELQSCY5KKIGQAmOHbcgcRGNlp5.jpg",
                "Three lucky contestants put their pop culture knowledge to the test to complete iconic, People Puzzler crosswords. The player with the most points at the end of three rounds wins the game and goes on to play the \"Fast Puzzle Round\" for an enormous cash prize.",
                6.1F,
                "18/01/2021",
                "Drama"
            )
        )

        movies.add(
            MovieEntity(
                93405L,
                "Squid Game",
                "/dDlEmu3EZ0Pgg93K2SVNLCjCSvE.jpg",
                "Hundreds of cash-strapped players accept a strange invitation to compete in children's games—with high stakes. But, a tempting prize awaits the victor.",
                7.8F,
                "17/09/2021",
                "Action & Adventure, Mystery, Drama"
            )
        )

        movies.add(
            MovieEntity(
                154181L,
                "Ace Troops",
                "/A5Ug19rH4dpnEA8Pe7B0NNXtuRJ.jpg",
                "Gao Liang and Gu Yi Ye are good friends and rivals since they joined the army. They fall in love with the same girl, Jiang Nan Zheng. However, Gu Yi Ye eventually gives up his love in the name of friendship and marries A Xiu, the daughter of their old squad leader who died in a war. As time passes, Gao Liang not only stays true to his heart but also shoulders the duties and mission of a soldier. In 2003, Gao Liang and Jiang Nan Cheng got married and formed a happy family. In 2008, Gao Liang, who returns from further studies in Russia, was transferred to be the acting brigade commander of the Blue Army because of an observation report.",
                7.3F,
                "26/12/2021",
                "Action & Adventure, War & Politics, Drama"
            )
        )

        movies.add(
            MovieEntity(
                37680L,
                "Suits",
                "/vQiryp6LioFxQThywxbC6TuoDjy.jpg",
                "While running from a drug deal gone bad, Mike Ross, a brilliant young college-dropout, slips into a job interview with one of New York City's best legal closers, Harvey Specter. Tired of cookie-cutter law school grads, Harvey takes a gamble by hiring Mike on the spot after he recognizes his raw talent and photographic memory.",
                8.1F,
                "23/06/2011",
                "Drama"
            )
        )

        movies.add(
            MovieEntity(
                135753L,
                "Love Twist",
                "/5bTF522eYn6g6r7aYqFpTZzmQq6.jpg",
                "A drama depicting a sweet twist in love between the parents and children of three families around the love of two main characters.",
                2.0F,
                "13/12/2021",
                "Family, Comedy, Drama"
            )
        )

        movies.add(
            MovieEntity(
                71712L,
                "The Good Doctor",
                "/cXUqtadGsIcZDWUTrfnbDjAy8eN.jpg",
                "Shaun Murphy, a young surgeon with autism and savant syndrome, relocates from a quiet country life to join a prestigious hospital's surgical unit. Unable to personally connect with those around him, Shaun uses his extraordinary medical gifts to save lives and challenge the skepticism of his colleagues.",
                8.6F,
                "25/09/2021",
                "Drama"
            )
        )

        return movies
    }

    private fun generateMovieGenre(): GenresResponse {
        return GenresResponse(
            listOf(
                GenresResponse.GenreItem(
                    28,
                    "Action"
                ),
                GenresResponse.GenreItem(
                    12,
                    "Adventure"
                ),
                GenresResponse.GenreItem(
                    16,
                    "Animation"
                ),
                GenresResponse.GenreItem(
                    35,
                    "Comedy"
                ),
                GenresResponse.GenreItem(
                    80,
                    "Crime"
                ),
                GenresResponse.GenreItem(
                    99,
                    "Documentary"
                ),
                GenresResponse.GenreItem(
                    18,
                    "Drama"
                ),
                GenresResponse.GenreItem(
                    10751,
                    "Family"
                ),
                GenresResponse.GenreItem(
                    14,
                    "Fantasy"
                ),
                GenresResponse.GenreItem(
                    36,
                    "History"
                ),
                GenresResponse.GenreItem(
                    27,
                    "Horror"
                ),
                GenresResponse.GenreItem(
                    10402,
                    "Music"
                ),
                GenresResponse.GenreItem(
                    9648,
                    "Mystery"
                ),
                GenresResponse.GenreItem(
                    10749,
                    "Romance"
                ),
                GenresResponse.GenreItem(
                    878,
                    "Science Fiction"
                ),
                GenresResponse.GenreItem(
                    10770,
                    "Tv Movie"
                ),
                GenresResponse.GenreItem(
                    53,
                    "Thriller"
                ),
                GenresResponse.GenreItem(
                    10752,
                    "War"
                ),
                GenresResponse.GenreItem(
                    37,
                    "Western"
                )
            )
        )
    }

    private fun generateTvGenre(): GenresResponse {
        return GenresResponse(
            listOf(
                GenresResponse.GenreItem(
                    10759,
                    "Action & Adventure"
                ),
                GenresResponse.GenreItem(
                    16,
                    "Animation"
                ),
                GenresResponse.GenreItem(
                    35,
                    "Comedy"
                ),
                GenresResponse.GenreItem(
                    80,
                    "Crime"
                ),
                GenresResponse.GenreItem(
                    99,
                    "Documentary"
                ),
                GenresResponse.GenreItem(
                    18,
                    "Drama"
                ),
                GenresResponse.GenreItem(
                    10751,
                    "Family"
                ),
                GenresResponse.GenreItem(
                    10762,
                    "Kids"
                ),
                GenresResponse.GenreItem(
                    9648,
                    "Mystery"
                ),
                GenresResponse.GenreItem(
                    10763,
                    "News"
                ),
                GenresResponse.GenreItem(
                    10764,
                    "Reality"
                ),
                GenresResponse.GenreItem(
                    10765,
                    "Sci-Fi & Fantasy"
                ),
                GenresResponse.GenreItem(
                    10766,
                    "Soap"
                ),
                GenresResponse.GenreItem(
                    10767,
                    "Talk"
                ),
                GenresResponse.GenreItem(
                    10768,
                    "War & Politics"
                ),
                GenresResponse.GenreItem(
                    37,
                    "Western"
                )
            )
        )
    }

    fun getMovieGenre(genreId: List<Int>): String {
        val genreBuilder = StringBuilder()

        val listGenres = generateMovieGenre().genres
        for (i in genreId) {
            for (j in listGenres) {
                if (i != j.genreId) {
                    continue
                }
                genreBuilder.append("${j.genre}, ")
            }
        }

        return genreBuilder.toString()
    }

    fun getTvGenre(genreId: List<Int>): String {
        val genreBuilder = StringBuilder()

        val listGenres = generateTvGenre().genres
        for (i in genreId) {
            for (j in listGenres) {
                if (i != j.genreId) {
                    continue
                }
                genreBuilder.append("${j.genre}, ")
            }
        }

        return genreBuilder.toString()
    }

    fun generateRemoteDataMovies(): List<MovieResponse.MovieItem> {

        return listOf(
            MovieResponse.MovieItem(
                438695L,
                "Sing 2",
                "/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
                listOf(
                    16,
                    35,
                    10751,
                    10402
                ),
                "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
                "01/12/2021",
                8.2F
            ),
            MovieResponse.MovieItem(
                425909L,
                "Ghostbusters: Afterlife",
                "/sg4xJaufDiQl7caFEskBtQXfD4x.jpg",
                listOf(
                    35,
                    14,
                    12
                ),
                "When a single mom and her two kids arrive in a small town, they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
                "11/11/2021",
                7.6F
            ),
            MovieResponse.MovieItem(
                634649L,
                "Spider-Man: No Way Home",
                "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                listOf(
                    28,
                    12,
                    878
                ),
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "15/12/2021",
                8.4F
            ),
            MovieResponse.MovieItem(
                524434L,
                "Eternals",
                "/b6qUu00iIIkXX13szFy7d0CyNcg.jpg",
                listOf(
                    28,
                    12,
                    14,
                    878
                ),
                "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
                "03/11/2021",
                7.3F
            ),
            MovieResponse.MovieItem(
                568124L,
                "Encanto",
                "/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
                listOf(
                    16,
                    35,
                    10751,
                    14
                ),
                "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
                "24/11/2021",
                7.8F
            ),
            MovieResponse.MovieItem(
                460458L,
                "Resident Evil: Welcome to Raccoon City",
                "/7uRbWOXxpWDMtnsd2PF3clu65jc.jpg",
                listOf(
                    27,
                    28,
                    878
                ),
                "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
                "24/11/2021",
                6.0F
            ),
            MovieResponse.MovieItem(
                624860L,
                "The Matrix Resurrections",
                "/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
                listOf(
                    878,
                    28,
                    12
                ),
                "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.",
                "16/12/2021",
                6.9F
            ),
            MovieResponse.MovieItem(
                580489L,
                "Venom: Let There Be Carnage",
                "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
                listOf(
                    878,
                    28,
                    12
                ),
                "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
                "30/09/2021",
                7.1F
            ),
            MovieResponse.MovieItem(
                512195L,
                "Red Notice",
                "/lAXONuqg41NwUMuzMiFvicDET9Y.jpg",
                listOf(
                    28,
                    35,
                    80,
                    53
                ),
                "An Interpol-issued Red Notice is a global alert to hunt and capture the world's most wanted. But when a daring heist brings together the FBI's top profiler and two rival criminals, there's no telling what will happen.",
                "04/11/2021",
                6.8F
            ),
            MovieResponse.MovieItem(
                566525L,
                "Shang-Chi and the Legend of the Ten Rings",
                "/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
                listOf(
                    28,
                    12,
                    14
                ),
                "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
                "01/09/2021",
                7.8F
            ),
            MovieResponse.MovieItem(
                585083L,
                "Hotel Transylvania: Transformania",
                "/teCy1egGQa0y8ULJvlrDHQKnxBL.jpg",
                listOf(
                    16,
                    10751,
                    14,
                    35,
                    12
                ),
                "When Van Helsing's mysterious invention, the \"Monsterfication Ray,\" goes haywire, Drac and his monster pals are all transformed into humans, and Johnny becomes a monster. In their new mismatched bodies, Drac and Johnny must team up and race across the globe to find a cure before it's too late, and before they drive each other crazy.",
                "13/01/2022",
                7.7F
            ),
            MovieResponse.MovieItem(
                763788L,
                "Dangerous",
                "/vTtkQGC7qKlSRQJZYtAWAmYdH0A.jpg",
                listOf(
                    28,
                    53
                ),
                "A reformed sociopath heads to a remote island after the death of his brother. Soon after his arrival, the island falls under siege from a deadly gang of mercenaries, and when he discovers their role in his brother’s demise, he sets out on a relentless quest for vengeance.",
                "05/11/2021",
                6.7F
            ),
            MovieResponse.MovieItem(
                787310L,
                "Survive the Game",
                "/xF1uc2pEf34X2G41wvZaF5H0V7C.jpg",
                listOf(
                    28,
                    53,
                    80
                ),
                "When cop David is injured in a drug bust gone wrong, his partner Cal chases the two criminals who shot him. They all land at a remote farm owned by troubled vet Eric, and as Cal and Eric plot their defense, more of the gang arrives - along with a wounded David. Outnumbered, the three heroes must use stealth, smarts, and good shooting to take down the drug-dealing mob.",
                "08/10/2021",
                6.0F
            ),
            MovieResponse.MovieItem(
                516329L,
                "Antlers",
                "/cMch3tiexw3FdOEeZxMWVel61Xg.jpg",
                listOf(
                    18,
                    27,
                    9648
                ),
                "A small-town Oregon teacher and her brother, the local sheriff, discover a young student is harbouring a dangerous secret that could have frightening consequences.",
                "28/10/2021",
                6.5F
            ),
            MovieResponse.MovieItem(
                826749L,
                "Fortress",
                "/fP3i67pt7n1vh9Sy3K9mlPjrGmC.jpg",
                listOf(
                    80,
                    28,
                    53
                ),
                "The story revolves around a top-secret resort for retired U.S. intelligence officers. A group of criminals led by Balzary breach the compound, hellbent on revenge on Robert, forcing the retired officer and his son to save the day.",
                "17/12/2021",
                6.3F
            ),
            MovieResponse.MovieItem(
                635302L,
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                listOf(
                    16,
                    28,
                    12,
                    14
                ),
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "16/10/2020",
                8.4F
            ),
            MovieResponse.MovieItem(
                585245L,
                "Clifford the Big Red Dog",
                "/oifhfVhUcuDjE61V5bS5dfShQrm.jpg",
                listOf(
                    16,
                    35,
                    10751
                ),
                "As Emily struggles to fit in at home and at school, she discovers a small red puppy who is destined to become her best friend. When Clifford magically undergoes one heck of a growth spurt, becomes a gigantic dog and attracts the attention of a genetics company, Emily and her Uncle Casey have to fight the forces of greed as they go on the run across New York City. Along the way, Clifford affects the lives of everyone around him and teaches Emily and her uncle the true meaning of acceptance and unconditional love.",
                "10/11/2021",
                7.4F
            ),
            MovieResponse.MovieItem(
                843241L,
                "The Seven Deadly Sins: Cursed by Light",
                "/k0ThmZQl5nHe4JefC2bXjqtgYp0.jpg",
                listOf(),
                "With the help of the \"Dragon Sin of Wrath\" Meliodas and the worst rebels in history, the Seven Deadly Sins, the \"Holy War\", in which four races, including Humans, Goddesses, Fairies and Giants fought against the Demons, is finally over. At the cost of the \"Lion Sin of Pride\" Escanor's life, the Demon King was defeated and the world regained peace. After that, each of the Sins take their own path.",
                "02/07/2021",
                8.0F
            ),
            MovieResponse.MovieItem(
                899082L,
                "Harry Potter 20th Anniversary: Return to Hogwarts",
                "/jntLBq0MLR3hrwKaTQswxACRPMs.jpg",
                listOf(),
                "An enchanting making-of story told through all-new in-depth interviews and cast conversations, inviting fans on a magical first-person journey through one of the most beloved film franchises of all time.",
                "01/01/2022",
                8.5F
            ),
            MovieResponse.MovieItem(
                646385L,
                "Scream",
                "/qvASAp0ZKkza023gjK1Tf2iiEos.jpg",
                listOf(),
                "Twenty-five years after a streak of brutal murders shocked the quiet town of Woodsboro, a new killer has donned the Ghostface mask and begins targeting a group of teenagers to resurrect secrets from the town’s deadly past.",
                "12/01/2022",
                7.2F
            )
        )
    }

    fun generateRemoteDataTv(): List<TvResponse.TvItem> {
        return listOf(
            TvResponse.TvItem(
                85552L,
                "Euphoria",
                "/jtnfNzqZwN4E32FGGxx1YZaBWWf.jpg",
                listOf(18),
                "A group of high school students navigate love and friendships in a world of drugs, sex, trauma, and social media.",
                "16/06/2019",
                8.4F
            ),


            TvResponse.TvItem(
                77169L,
                "Cobra Kai",
                "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
                listOf(
                    10759,
                    18
                ),
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "02/05/2018",
                8.1F
            ),


            TvResponse.TvItem(
                115036L,
                "The Book of Boba Fett",
                "/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg",
                listOf(
                    10759,
                    10765
                ),
                "Legendary bounty hunter Boba Fett and mercenary Fennec Shand must navigate the galaxy’s underworld when they return to the sands of Tatooine to stake their claim on the territory once ruled by Jabba the Hutt and his crime syndicate.",
                "29/12/2021",
                8.2F
            ),


            TvResponse.TvItem(
                134949L,
                "Rebelde",
                "/jRlI5euugVZR6a1Ptt0nSWeiWH.jpg",
                listOf(),
                "Head back to Elite Way School as a new generation of students hope to win the Battle of the Bands.",
                "05/01/2022",
                7.4F
            ),

            TvResponse.TvItem(
                96777L,
                "The Silent Sea",
                "/fFT0IgqtCOks4munDTxQwkvNJkd.jpg",
                listOf(),
                "During a perilous 24-hour mission on the moon, space explorers try to retrieve samples from an abandoned research facility steeped in classified secrets.",
                "24/12/2021",
                8.1F
            ),

            TvResponse.TvItem(
                71914L,
                "The Wheel of Time",
                "/mpgDeLhl8HbhI03XLB7iKO6M6JE.jpg",
                listOf(),
                "Follow Moiraine, a member of the shadowy and influential all-female organization called the “Aes Sedai” as she embarks on a dangerous, world-spanning journey with five young men and women. Moiraine believes one of them might be the reincarnation of an incredibly powerful individual, whom prophecies say will either save humanity or destroy it.",
                "18/11/2021",
                7.9F
            ),

            TvResponse.TvItem(
                60735L,
                "The Flash",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                listOf(),
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "07/10/2014",
                7.8F
            ),

            TvResponse.TvItem(
                2778L,
                "Wheel of Fortune",
                "/2fvAIyVfFHQdhJ7OsJWuMlF7836.jpg",
                listOf(10751),
                "This game show sees contestants solve word puzzles, similar to those used in Hangman, to win cash and prizes determined by spinning a giant carnival wheel.",
                "19/09/1983",
                6.8F
            ),

            TvResponse.TvItem(
                63174L,
                "Lucifer",
                "/ekZobS8isE6mA53RAiGDG93hBxL.jpg",
                listOf(),
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "25/01/2016",
                8.5F
            ),

            TvResponse.TvItem(
                1416L,
                "Grey's Anatomy",
                "/zPIug5giU8oug6Xes5K1sTfQJxY.jpg",
                listOf(),
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "27/03/2005",
                8.2F
            ),

            TvResponse.TvItem(
                88329L,
                "Hawkeye",
                "/pqzjCxPVc9TkVgGRWeAoMmyqkZV.jpg",
                listOf(),
                "Former Avenger Clint Barton has a seemingly simple mission: get back to his family for Christmas. Possible? Maybe with the help of Kate Bishop, a 22-year-old archer with dreams of becoming a superhero. The two are forced to work together when a presence from Barton’s past threatens to derail far more than the festive spirit.",
                "24/11/2021",
                8.4F
            ),

            TvResponse.TvItem(
                60574L,
                "Peaky Blinders",
                "/pE8CScObQURsFZ723PSW1K9EGYp.jpg",
                listOf(),
                "A gangster family epic set in 1919 Birmingham, England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby, who means to move up in the world.",
                "12/09/2013",
                8.6F
            ),


            TvResponse.TvItem(
                90462L,
                "Chucky",
                "/iF8ai2QLNiHV4anwY1TuSGZXqfN.jpg",
                listOf(),
                "After a vintage Chucky doll turns up at a suburban yard sale, an idyllic American town is thrown into chaos as a series of horrifying murders begin to expose the town’s hypocrisies and secrets. Meanwhile, the arrival of enemies — and allies — from Chucky’s past threatens to expose the truth behind the killings, as well as the demon doll’s untold origins.",
                "12/10/2021",
                7.9F
            ),

            TvResponse.TvItem(
                132375L,
                "Um Lugar ao Sol",
                "/63qlVcvlVzOvMaFO8tFA2VG64Yc.jpg",
                listOf(),
                "",
                "08/11/2021",
                5.0F
            ),

            TvResponse.TvItem(
                117031L,
                "People Puzzler",
                "/gELQSCY5KKIGQAmOHbcgcRGNlp5.jpg",
                listOf(),
                "Three lucky contestants put their pop culture knowledge to the test to complete iconic, People Puzzler crosswords. The player with the most points at the end of three rounds wins the game and goes on to play the \"Fast Puzzle Round\" for an enormous cash prize.",
                "18/01/2021",
                6.1F
            ),

            TvResponse.TvItem(
                93405L,
                "Squid Game",
                "/dDlEmu3EZ0Pgg93K2SVNLCjCSvE.jpg",
                listOf(),
                "Hundreds of cash-strapped players accept a strange invitation to compete in children's games—with high stakes. But, a tempting prize awaits the victor.",
                "17/09/2021",
                7.8F
            ),

            TvResponse.TvItem(
                154181L,
                "Ace Troops",
                "/A5Ug19rH4dpnEA8Pe7B0NNXtuRJ.jpg",
                listOf(),
                "Gao Liang and Gu Yi Ye are good friends and rivals since they joined the army. They fall in love with the same girl, Jiang Nan Zheng. However, Gu Yi Ye eventually gives up his love in the name of friendship and marries A Xiu, the daughter of their old squad leader who died in a war. As time passes, Gao Liang not only stays true to his heart but also shoulders the duties and mission of a soldier. In 2003, Gao Liang and Jiang Nan Cheng got married and formed a happy family. In 2008, Gao Liang, who returns from further studies in Russia, was transferred to be the acting brigade commander of the Blue Army because of an observation report.",
                "26/12/2021",
                7.3F
            ),

            TvResponse.TvItem(
                37680L,
                "Suits",
                "/vQiryp6LioFxQThywxbC6TuoDjy.jpg",
                listOf(),
                "While running from a drug deal gone bad, Mike Ross, a brilliant young college-dropout, slips into a job interview with one of New York City's best legal closers, Harvey Specter. Tired of cookie-cutter law school grads, Harvey takes a gamble by hiring Mike on the spot after he recognizes his raw talent and photographic memory.",
                "23/06/2011",
                8.1F
            ),

            TvResponse.TvItem(
                135753L,
                "Love Twist",
                "/5bTF522eYn6g6r7aYqFpTZzmQq6.jpg",
                listOf(),
                "A drama depicting a sweet twist in love between the parents and children of three families around the love of two main characters.",
                "13/12/2021",
                2.0F
            ),

            TvResponse.TvItem(
                71712L,
                "The Good Doctor",
                "/cXUqtadGsIcZDWUTrfnbDjAy8eN.jpg",
                listOf(),
                "Shaun Murphy, a young surgeon with autism and savant syndrome, relocates from a quiet country life to join a prestigious hospital's surgical unit. Unable to personally connect with those around him, Shaun uses his extraordinary medical gifts to save lives and challenge the skepticism of his colleagues.",
                "25/09/2021",
                8.6F
            )
        )
    }

    fun generateRemoteDetailMovie(): DetailMovieResponse {
        return DetailMovieResponse(
            listOf(
                GenresResponse.GenreItem(
                    28,
                    "Action"
                ),
                GenresResponse.GenreItem(
                    12,
                    "Adventure"
                ),
                GenresResponse.GenreItem(
                    14,
                    "Fantasy"
                ),
                GenresResponse.GenreItem(
                    878,
                    "Science Fiction"
                ),
            ),
            524434L,
            "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
            "/b6qUu00iIIkXX13szFy7d0CyNcg.jpg",
            7.3F,
            FormatUtil.dateFormat("2021-11-03"),
            "Eternals"
        )
    }

    fun generateRemoteDetailTv(): DetailTvResponse {
        return DetailTvResponse(
            listOf(
                GenresResponse.GenreItem(
                    18,
                    "Drama"
                )
            ),
            85552L,
            "A group of high school students navigate love and friendships in a world of drugs, sex, trauma, and social media.",
            "/jtnfNzqZwN4E32FGGxx1YZaBWWf.jpg",
            8.4F,
            FormatUtil.dateFormat("2019-06-16"),
            "Euphoria"
        )
    }
}