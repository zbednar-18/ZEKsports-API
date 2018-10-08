import base64
import requests
import json
import pymongo

def send_request():
    # Request
    api_key = "46dacc81-c83f-4fec-97ed-7c45f7"
    pull = "https://api.mysportsfeeds.com/v1.2/pull/nfl/2018-regular/cumulative_player_stats.json"
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
collection = mydb['NFLPlayer']
collection.drop()


for data in content['rosterplayers']['playerentry']:
    height = ""
    weight = ""
    jerseyNumber = ""
    team = ""
    dateOfBirth = ""
    isRookie = "false"
    if("Height" in data['player']):
        height = data['player']['Height']
        height.replace("'/'", "")
    if("Weight" in data['player']):
        weight = data['player']['Weight']
    if("JerseyNumber" in data['player']):
        jerseyNumber = data['player']['JerseyNumber']
    if ('team' in data):
        if("Name" in data['team']):
            team = data['team']['Name']
    if("BirthDate" in data['player']):
        dateOfBirth = data['player']['BirthDate']
    if("IsRookie" in data['player']):
        isRookie = data['player']['IsRookie']
    dictionary = {
        "firstName": data['player']['FirstName'],
        "lastName": data['player']['LastName'],
        "jerseyNumber": jerseyNumber,
        "position": data['player']['Position'],
        "height": height,
        "weight": weight,
        "dateOfBirth": dateOfBirth,
        "isRookie": isRookie,
        "team": team
    }
    collection.insert_one(dictionary)

