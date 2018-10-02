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
date must be formatted in yyyy-mm-dd

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
    "_id" : ObjectId("5bb1675ad1124d2b08528db2"),
    "teamName" : "Jaguars",
    "teamCity" : "Jacksonville",
    "teamRank" : 10,
    "gamesPlayed" : "3",
    "passAttempts" : "112",
    "passCompletions" : "68",
    "passCompletionsPct" : "60.7",
    "grossPassYards" : "718",
    "netPassYards" : "700",
    "passAverageYards" : "6.4",
    "passYardsPerAttempt" : "6.0",
    "passTouchdowns" : "5",
    "passInterceptions" : "2",
    "rushAttempts" : "71",
    "rushYards" : "328",
    "rushAverageYards" : "4.6",
    "fumbles" : "0",
    "recTouchdowns" : "5",
    "sacks" : "7",
    "tackles" : "178",
    "safeties" : "0",
    "interceptions" : "1",
    "penalties" : "24",
    "offenseYards" : "1032",
    "totalTouchDowns" : "5",
    "totalTwoPointConversions" : "0"
},
```

### /nfl/teams/{team}/players
###  method = GET
return all players who belong to the team queried for the current season

example call: /nfl/player/team/Bears

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
},
```

## Players
### /nfl/players
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
