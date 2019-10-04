# Run server
#   FLASK_APP=server.py flask run
import pymongo
import urllib.parse
from flask import Flask
from mongoengine import *

app = Flask(__name__)
print(__name__)


@app.route('/')
def hello():
    return 'Hello World'

""" username = urllib.parse.quote_plus('ServerAdmin')
password = urllib.parse.quote_plus('ServerAdminPassword1!')
print('Username for URI: ' + username + '\nPassword for URI: ' + password)
my_client = pymongo.MongoClient(
    'mongodb+srv://' + username + ':' + password +
    '@practice-yodsv.mongodb.net/test?retryWrites=true') """
