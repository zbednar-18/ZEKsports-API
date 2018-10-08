import requests
from requests_oauthlib import OAuth1
import tweepy
import base64
import requests
import json
import pymongo

API_KEY = 'xkESFLnxr8uvSbZGJ6JJ4B4Uy'
API_SECRET = 'HqRzR5T5Zc6tlwUCxHcvaEFQORvs3KafV7XxU3AGiP5WCCdtUW'
ACCESS_TOKEN = '855196983765741571-rs6f5dkguHi8ZAiozzczNC2LIP3YijX'
ACCESS_TOKEN_SECRET = 'Bl4jNwXXHwY0kt9g4j7TfSGZBCWmXwCCGEf3ArB0WjF63'



auth = tweepy.OAuthHandler(API_KEY, API_SECRET)
auth.set_access_token(ACCESS_TOKEN, ACCESS_TOKEN_SECRET)
api = tweepy.API(auth)

query = '#ZEKsports'
max_tweets = 1000
searched_tweets = [status for status in tweepy.Cursor(api.search, q=query).items(max_tweets)]
client = pymongo.MongoClient('mongodb+srv://KyleWilsonJPNV:Peewee79!@zeksports-gckht.mongodb.net/test?retryWrites=true')
mydb = client['ZEKsports']
collection = mydb['Tweet']
collection.drop()

for tweet in searched_tweets:
    json_tweet = json.loads(json.dumps(tweet._json))
    dictionary = {
        'createdOn': json_tweet['created_at'],
        'text': json_tweet['text'],
        'screenName': json_tweet['user']['screen_name'],
        'name': json_tweet['user']['name']
    }
    collection.insert_one(dictionary)
    
