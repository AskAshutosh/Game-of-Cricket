| Sl No. | To-do:-                                                                                            | Query                                                                                                                                                                                                                   | Index used               | With Index Time(in mill secs) | with Index totalDocsExamined | Without Index Time(milli Secs) | Without Index totalDocsExamined |
| ------ | -------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------ | ----------------------------- | ---------------------------- | ------------------------------ | ------------------------------- |
| 1      | Find number of movies created after 1990                                                           | db.movie.find({year:{$gt:1990}}).count()                                                                                                                                                                                | Index used on Year       | 31                            | 17306                        | 37                             | 23562                           |
| 2      | find list of movie names which are created after 1990 and won atleast 4 awards.                    | db.movie.find({year:{$gt:1990},"awards.wins":{$gt:4}}).count()                                                                                                                                                          | Year                     | 42                            | 17306                        | 30                             | 23562                           |
| 3      | Find number of movie where genre is crime or thriller.                                             | db.movie.find({genres:{$in:["Crime","Thriller"]}}).count()                                                                                                                                                              | genres[]                 | 19                            | 2661                         | 27                             | 23562                           |
| 4      | find movie names which released in multiple languages                                              | NA                                                                                                                                                                                                                      |                          |                               |                              |                                | 23562                           |
| 5      | Find movie names which are created after 2000 and in multiple languages and in multiple countries. | db.movie.find({year:{$gt:2000},"countries":{$exists:true, $gte:2 }}).count()                                                                                                                                            | Year,Countries           | 27                            | 13145                        | 27                             | 23562                           |
| 6      | find movies which have at least 7 IMDB rating and won more than 3 awards                           | db.movie.find({"imdb.rating":{$gte:7},"awards.wins":{$gt:3}}).count()                                                                                                                                                   | imdb.rating, awards.wins | 23                            | 4768                         | 36                             | 23562                           |
| 7      | find avg of tomato rating of all movies where Salman Khan is casted.                               | var pipeline=[{"$unwind":{"path":"$cast"}}, {"$match":{cast:"Salman Khan"}},{"$group":{"_id":"$cast",AverageRating:{"$avg":"$tomatoes.viewer.rating"}}}];<br><br>db.movie.aggregate(pipeline)<br>                       |                          |                               |                              | 86                             | 23562                           |
| 8      | find year-wise count of awards won by Amitabh Bachchan's movie. (sort result by count of awards)   | var pipeline=[{"$unwind":{"path":"$cast"}},{"$match":{cast:"Amitabh Bachchan"}},{"$group":{"_id":"$year", AwardsCount:{"$sum":"$awards.wins"}}},{"$sort":{AwardsCount:1}}]<br><br>db.movie.aggregate(pipeline)<br><br>ˇ | year, awards.wins        | 83                            | 23562                        | 80                             | 23562                           |
| 9      | find year-wise count of action, thriller movies. (sort result by count of movies)                  | db.movie.aggregate([{$match: {genres: { $in: ["Action", "Thriller"] }}},{$group: {_id: null,count: { $sum: 1 }}}])                                                                                                      | genres[]                 | 14                            | 0                            | 31                             | 23562                           |
| 10     | find number of movies done by each actor.                                                          | db.movie.aggregate([{$unwind: "$cast"},{$group: {_id: "$cast",numberOfMovies: { $sum: 1 }}}])                                                                                                                           | cast[]                   | 93                            | 23562                        | 91                             | 23562                           |