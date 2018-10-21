# ZEKsports-API
Back-end API for our COSC 473 website.



# End Points

## Schedules

### /nfl/schedules
### method = GET
returns schedule for the entire season for all teams

```
Example Response

{
    "week" : "1",
    "date" : "2018-09-09",
    "time" : "1:00PM",
    "hometeam" : "Giants",
    "awayteam" : "Jaguars",
    "stadium" : "MetLife Stadium"
}
```

### /nfl/schedules/dates/{date} 
###  method = GET
return games that are scheduled on that date
example call: /nfl/schedulse/dates/2018-09-23

```
Example Response

{
    "week" : "3",
    "date" : "2018-09-23",
    "time" : "1:00PM",
    "hometeam" : "Jaguars",
    "awayteam" : "Titans",
    "stadium" : "EverBank Field"
}
```

### /nfl/schedules/teams/{team}
###  method = GET
return all games for a team for an entire season
example call: /nfl/schedules/teams/Steelers

```
Example Response
{
    "week" : "3",
    "date" : "2018-09-24",
    "time" : "8:15PM",
    "hometeam" : "Buccaneers",
    "awayteam" : "Steelers",
    "stadium" : "Raymond James Stadium"
}
```

### /nfl/schedules/weeks/{week}
###  method = GET
return all games for a given week of the nfl season
example call: /nfl/schedules/weeks/2

```
Example Response
{
    "week" : "2",
    "date" : "2018-09-13",
    "time" : "8:20PM",
    "hometeam" : "Bengals",
    "awayteam" : "Ravens",
    "stadium" : "Paul Brown Stadium"
}
```

## Teams

### /nfl/teams
###  method = GET
return all teams in the current NFL season
example call: /nfl/teams

```
Example Response
 {
    "division" : "AFC East",
    "teamName" : "Patriots",
    "teamCity" : "New England",
    "overallTeamRank" : 5,
    "divisionTeamRank" : "1",
    "gamesPlayed" : "6",
    "passAttempts" : "214",
    "passCompletions" : "145",
    "passCompletionsPct" : "67.8",
    "grossPassYards" : "1600",
    "netPassYards" : "1548",
    "passAverageYards" : "7.5",
    "passYardsPerAttempt" : "7.0",
    "passTouchdowns" : "13",
    "passInterceptions" : "6",
    "rushAttempts" : "174",
    "rushYards" : "731",
    "rushAverageYards" : "4.2",
    "fumbles" : "1",
    "recTouchdowns" : "13",
    "sacks" : "7",
    "tackles" : "391",
    "safeties" : "0",
    "interceptions" : "8",
    "penalties" : "24",
    "offenseYards" : "2303",
    "totalTouchDowns" : "20",
    "totalTwoPointConversions" : "0"
},
```

### /nfl/teams/{teamName}
###  method = GET
return all teams in the current NFL season
example call: /nfl/teams/Bengals

```
Example Response
{
    "division" : "AFC North",
    "teamName" : "Bengals",
    "teamCity" : "Cincinnati",
    "overallTeamRank" : 4,
    "divisionTeamRank" : "1",
    "gamesPlayed" : "6",
    "passAttempts" : "229",
    "passCompletions" : "149",
    "passCompletionsPct" : "65.1",
    "grossPassYards" : "1674",
    "netPassYards" : "1574",
    "passAverageYards" : "7.3",
    "passYardsPerAttempt" : "6.5",
    "passTouchdowns" : "14",
    "passInterceptions" : "7",
    "rushAttempts" : "123",
    "rushYards" : "539",
    "rushAverageYards" : "4.4",
    "fumbles" : "0",
    "recTouchdowns" : "14",
    "sacks" : "13",
    "tackles" : "407",
    "safeties" : "0",
    "interceptions" : "5",
    "penalties" : "36",
    "offenseYards" : "2115",
    "totalTouchDowns" : "21",
    "totalTwoPointConversions" : "0"
},
```

### /nfl/teams/{team}/players
###  method = GET
return all players who belong to the team queried for the current season
example call: /nfl/teams/Giants/players

```
Example Response
{
    "firstName" : "Jerell",
    "lastName" : "Adams",
    "jerseyNumber" : "89",
    "position" : "TE",
    "height" : "6'5\"",
    "weight" : "247",
    "dateOfBirth" : "1992-12-31",
    "isRookie" : "false",
    "team" : "Giants"
},
```

## Players
### /nfl/players
### METHOD = GET
return all players in the current NFL season
example call: /nfl/players

 ```
Example Response
{
    "firstName" : "Sam",
    "lastName" : "Acho",
    "jerseyNumber" : "49",
    "position" : "OLB",
    "height" : "6'3\"",
    "weight" : "257",
    "dateOfBirth" : "1988-09-06",
    "isRookie" : "false",
    "team" : "Bears"
}
```

 ### /nfl/players/teams/{team}
 ### METHOD = GET
 return all players who belong to the team queried for the current season
 example call: /nfl/players/teams/Bears
 
```
Example Response
{
    "firstName" : "Sam",
    "lastName" : "Acho",
    "jerseyNumber" : "49",
    "position" : "OLB",
    "height" : "6'3\"",
    "weight" : "257",
    "dateOfBirth" : "1988-09-06",
    "isRookie" : "false",
    "team" : "Bears"
}
```

 ### /nfl/players/positions/{position}
 ### METHOD = GET
 return all players who belong to the team queried for the current season
 example call: /nfl/players/positions/QB
 
```
Example Response
{
    "firstName" : "Brandon",
    "lastName" : "Allen",
    "jerseyNumber" : "10",
    "position" : "QB",
    "height" : "6'2\"",
    "weight" : "214",
    "dateOfBirth" : "1992-09-05",
    "isRookie" : "false",
    "team" : "Rams"
}
```

## Tweets

### /nfl/tweets
### METHOD = GET
return all tweets currently stored in db
example call: /nfl/tweets

```
Example Response
{
    "createdOn" : "Mon Oct 08 23:20:11 +0000 2018",
    "text" : "This is another test tweet 5 #ZEKsports",
    "screenName" : "JPNVKW",
    "name" : "KWils"
},
{
    "createdOn" : "Mon Oct 08 23:20:03 +0000 2018",
    "text" : "This is another test tweet 4 #ZEKsports",
    "screenName" : "JPNVKW",
    "name" : "KWils"
}

```

### /nfl/tweets/{number}
### METHOD = GET
return the {number} of most recent tweets
example call: /nfl/tweets/3

```
{
    "createdOn" : "Mon Oct 08 23:20:11 +0000 2018",
    "text" : "This is another test tweet 5 #ZEKsports",
    "screenName" : "JPNVKW",
    "name" : "KWils"
},
{
    "createdOn" : "Mon Oct 08 23:20:03 +0000 2018",
    "text" : "This is another test tweet 4 #ZEKsports",
    "screenName" : "JPNVKW",
    "name" : "KWils"
},
{
    "createdOn" : "Mon Oct 08 23:19:56 +0000 2018",
    "text" : "This is another test tweet 3 #ZEKsports",
    "screenName" : "JPNVKW",
    "name" : "KWils"
}
```

## Bugs

### Create a bug
### METHOD = POST
example call: /bug
Upon successful resource creation, appropriate status code with body of "Bug Created" is returned.

```
These fields are required for the post request
{
    "bugReporter" : "testing",
    "description" : "testing",
}
```

```
Example Bug Object
{
    "bugReporter" : "testing",
    "description" : "testing",
    "dateReported" : "2018/10/21 00:46:44",
}
```
