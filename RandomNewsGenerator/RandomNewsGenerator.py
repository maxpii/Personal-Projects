# importing important libraries
import requests, webbrowser, random
from bs4 import BeautifulSoup

# defining variables
arr = []
website_name = "https://www.bbc.com/" # our news website is BBC
response = requests.get(website_name)
soup = BeautifulSoup(response.text,'html.parser')


# finding all a tags with a specific class, then getting all the links and putting them in a list
for i in soup.find_all('a',attrs={"data-testid":"external-anchor"}):
    s = i['href']
    if (s[0] != "h"):
        s = "https://www.bbc.com/news" + s
    arr.append(s)


# generating a random website link, making sure that the website is valid
rand = random.randrange(0,len(arr)+1)
while requests.get(arr[rand]).status_code != 200:
    rand = random.randrange(0, len(arr))

print([print(i) for i in arr])
# opening our website
webbrowser.open_new_tab(arr[rand])

