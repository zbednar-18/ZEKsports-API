import base64
import requests
import json
import pymongo

def send_request():
    # Request
    api_key = "46dacc81-c83f-4fec-97ed-7c45f7"
    pull = "https://api.mysportsfeeds.com/v1.2/pull/nfl/2018-regular/full_game_schedule.json"
    password = "Peewee79!"
    try:
        response = requests.get(
            url=pull,
            headers={
                "Authorization": "Basic " + base64.b64encode('{}:{}'.format(api_key,password).encode('utf-8')).decode('ascii')
            }
        )
        return response
    except requests.exceptions.RequestException:
        print('HTTP Request failed')

client = pymongo.MongoClient('mongodb+srv://KyleWilsonJPNV:Peewee79!@zeksports-gckht.mongodb.net/test?retryWrites=true')
content = json.loads(send_request().content)
mydb = client['ZEKsports']
collection = mydb['NFLSchedule']

for data in content['fullgameschedule']['gameentry']:
    dictionary = {
        "week": data['week'],
        "date": data['date'],
        "time": data['time'],
        "hometeam": data['homeTeam']['Name'],
        "awayteam": data['awayTeam']['Name'],
        "stadium": data['location']
    }
    collection.insert_one(dictionary)