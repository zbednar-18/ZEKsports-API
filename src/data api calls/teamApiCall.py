import base64
import requests
import json
import pymongo

def send_request():
    # Request
    api_key = '46dacc81-c83f-4fec-97ed-7c45f7'
    pull = 'https://api.mysportsfeeds.com/v1.2/pull/nfl/2018-regular/overall_team_standings.json'
    password = 'Peewee79!'
    try:
        response = requests.get(
            url=pull,
            headers={
                'Authorization': 'Basic ' + base64.b64encode('{}:{}'.format(api_key,password).encode('utf-8')).decode('ascii')
            }
        )
        return response
    except requests.exceptions.RequestException:
        print('HTTP Request failed')

client = pymongo.MongoClient('mongodb+srv://KyleWilsonJPNV:Peewee79!@zeksports-gckht.mongodb.net/test?retryWrites=true')
content = json.loads(send_request().content)
mydb = client['ZEKsports']
collection = mydb['NFLTeam']
collection.drop()
teamList = []

def partition(arr,low,high): 
    i = ( low-1 )
    pivot = arr[high].get('teamRank') 
  
    for j in range(low , high): 
        if   arr[j].get('teamRank') <= pivot: 
            i = i+1 
            arr[i],arr[j] = arr[j],arr[i] 
  
    arr[i+1],arr[high] = arr[high],arr[i+1] 
    return ( i+1 ) 
  
def quickSort(arr,low,high): 
    if low < high: 
        pi = partition(arr,low,high) 
        quickSort(arr, low, pi-1) 
        quickSort(arr, pi+1, high)


for team in content['overallteamstandings']['teamstandingsentry']:
    rank = (int (team['rank']))
    dictionary = {
        'teamName': team['team']['Name'],
        'teamCity': team['team']['City'],
        'teamRank':  rank,
        'gamesPlayed': team['stats']['GamesPlayed']['#text'],
        'passAttempts': team['stats']['PassAttempts']['#text'],
        'passCompletions': team['stats']['PassCompletions']['#text'],
        'passCompletionsPct': team['stats']['PassPct']['#text'],
        'grossPassYards': team['stats']['PassGrossYards']['#text'],
        'netPassYards': team['stats']['PassNetYards']['#text'],
        'passAverageYards': team['stats']['PassAvg']['#text'],
        'passYardsPerAttempt': team['stats']['PassYardsPerAtt']['#text'],
        'passTouchdowns': team['stats']['PassTD']['#text'],
        'passInterceptions': team['stats']['PassInt']['#text'],
        'rushAttempts': team['stats']['RushAttempts']['#text'],
        'rushYards': team['stats']['RushYards']['#text'],
        'rushAverageYards': team['stats']['RushAverage']['#text'],
        'fumbles': team['stats']['RushFumbles']['#text'],
        'recTouchdowns': team['stats']['RecTD']['#text'],
        'sacks': team['stats']['Sacks']['#text'],
        'tackles': team['stats']['TackleTotal']['#text'],
        'safeties': team['stats']['Safeties']['#text'],
        'interceptions': team['stats']['Interceptions']['#text'],
        'penalties': team['stats']['Penalties']['#text'],
        'offenseYards': team['stats']['OffenseYds']['#text'],
        'totalTouchDowns': team['stats']['TotalTD']['#text'],
        'totalTwoPointConversions': team['stats']['TwoPtMade']['#text']
    }
    teamList.append(dictionary)

quickSort(teamList, 0, len(teamList) - 1)

for team in teamList:
    collection.insert_one(team)


