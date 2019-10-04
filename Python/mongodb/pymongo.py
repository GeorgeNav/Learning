# https://docs.mongodb.com/manual/tutorial/install-mongodb-on-os-x/
# Run mongodb server
#   mongod --config /usr/local/etc/mongod.conf
# Code to connect to this local server
# MongoDB will create the database if it does not exist,
# and make a connection to it
#   my_client = pymongo.MongoClient('mongodb://localhost:27017/')
# pip3 install virtualenv
# pip3 install pipenv
# pip3 install pymongo
# pip3 install dnspython

import pymongo
import urllib.parse
username = urllib.parse.quote_plus('TestUser')
password = urllib.parse.quote_plus('TestUserPassword1!')
print('Username for URI: ' + username + '\nPassword for URI: ' + password)
my_client = pymongo.MongoClient(
    'mongodb+srv://' + username + ':' + password +
    '@practice-yodsv.mongodb.net/test?retryWrites=true')

# List of system databases
print(my_client.list_database_names())

# Get database
my_db = my_client['mydatabase']

my_db['customers'].drop()

# Creates collection 'customers' if it doesn't already exist and returns it
customer_collection = my_db['customers']
# Insert document into 'customer' collection
inserted_document = customer_collection.insert_one(
    {'name': 'Victor', 'address': 'Highway 37'})

# Insert document into 'customer' collection with specified id
inserted_document = customer_collection.insert_one(
    {'_id': 1, 'name': 'Greg', 'address': '54321 Made Up'})
print('Inserted document with specified id: ' +
      str(inserted_document.inserted_id))

# Prints the latest document object id that has been inserted
print('Inserted document: ' + str(inserted_document.inserted_id))

# Insert multiple documents
inserted_documents = customer_collection.insert_many([
    {'name': 'Sarah', 'address': '2134 Valley Lane'},
    {'name': 'Smith', 'address': '5124 Highway St.'}
])
print('Inserted documents..')
for document_id in inserted_documents.inserted_ids:
    print('\t' + str(document_id))

# print each document's data (all columns) in 'customer' collection
for document in customer_collection.find():
    print(document)

# print specified document's data in 'customer' collection
#   excluding the 'address'
print('Specified data')
# find(query_object, specify_columns_to_display)
#   query_object: limits the search
for document in customer_collection.find({}, {'_id': 0}):
    print('\t' + str(document))

# find documents that match the 'name' of 'Smith'
print('Smith name documents found:')
for found in customer_collection.find({'name': 'Smith'}):
    print('\t' + str(found))

# find documents that have a 'name' of 'S' or higher
print('Names that are S or higher documents found:')
for found in customer_collection.find({'name': {'$gt': 'S'}}):
    print('\t' + str(found))

# find documents that have a 'name' that starts with 'S'
print('Names that start with S documents found:')
for found in customer_collection.find({'name': {'$regex': '^S'}}):
    print('\t' + str(found))

# Make a update to one document
query = {'address': 'Highway 37'}
new_values = {'$set': {'name': 'George'}}
if customer_collection.update_one(query, new_values):
    print('Values updated successfully')
else:
    print('Could not update values')

# Make a update to multiple documents
query = {'name': {'$regex': '^S'}}
new_values = {'$set': {'name': 'Sally'}}
updated = customer_collection.update_many(query, new_values)
print(updated.modified_count, 'documents updated.')

# Print collection documents as they are stored
for document in customer_collection.find():
    print(document)

# Print first 2 collection documents as they are stored
print('First two collection documents')
for document in customer_collection.find().limit(2):
    print('\t', document)

# Print collection documents in descending order
for document in customer_collection.find().sort('name', -1):
    print(document)

# Print collection documents in ascending order
for document in customer_collection.find().sort('name', 1):
    print(document)

# Delete all documents in a collection
deleted = customer_collection.delete_many({})
print('# of documents deleted {0}'.format(deleted.deleted_count))

# Return list of collection in database
all_collections = my_db.list_collection_names()
print(all_collections)

# Sees if a collection by the name customers exists
if 'customers' in all_collections:
    print("The customers collection exists.")

# Drop 'customer' collection
if customer_collection.drop(''):
    print('Dropped an existing collection')
else:
    print('Collection cannot be dropped since it doesn\'t exist')
