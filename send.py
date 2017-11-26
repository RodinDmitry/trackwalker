#from urllib.request import urlopen
from urllib import *
import urllib
import urllib.request
import json
import sys

#MY_API_KEY = "AlzaSyAu6KrQq83ORsPgGeTWybz2e0mT--TXbLI"
MY_API_KEY = "AIzaSyAu6KrQq83ORsPgGeTWybz2e0mT--TXbLI"
#MY_API_KEY = "1095032025522"
messageTitle = sys.argv[1]
messageBody =   sys.argv[2]
content = {'body': messageBody, 'title': messageTitle, 'icon': 'ic_blur_circular_white_48dp'}
data = {'to': '/topics/my_little_topic', 'notification': content}
dataAsJSON = json.dumps(data).encode('utf-8')

request = urllib.request.Request("https://gcm-http.googleapis.com/gcm/send", 
    dataAsJSON, 
    {"Authorization": "key=" + MY_API_KEY, "Content-type": "application/json"}
)

print(urllib.request.urlopen(request).read())

