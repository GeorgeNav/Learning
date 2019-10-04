# pip3 install requests
# Remove virtual environment created by this command (when in same directory)
#   pipenv --rm 
import requests

response = requests.get('https://httpbin.org/ip')
print('Your IP is {0}'.format(response.json()['origin']))
