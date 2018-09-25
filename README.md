# ZEKsports-API
Back-end API for our COSC 473 website.



# End Points

## Schedules

### /nfl/schedule

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

### /nfl/schedule/date/{date}
return games that are scheduled on that date
date must be formatted in yyyy-mm-dd

example call: /nfl/schedule/date/2018-09-23

```
Example Response

{
    "_id" : ObjectId("5ba96594d1124d39508b12a8"),
    "week" : "3",
    "date" : "2018-09-23",
    "time" : "1:00PM",
    "hometeam" : "Jaguars",
    "awayteam" : "Titans",
    "stadium" : "EverBank Field"
}
```

### /nfl/schedule/team/{team}
return all games for a team for an entire season

example call: /nfl/schedule/team/Steelers

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

### /nfl/schedule/week/{week}
return all games for a given week of the nfl season

example call: /nfl/schedule/week/2

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


## Players

### /nfl/player
return all players in the current NFL season

example call: /nfl/player

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

### /nfl/player/team/{team}
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
}
```

### /nfl/player/position/{position}
return all players who belong to the team queried for the current season

example call: /nfl/player/position/QB

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
