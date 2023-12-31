import re
import requests
from bs4 import BeautifulSoup
import pandas
import csv

# A program to find recent news Articles of a specific area (eg: Europe, Middle East, Culture)


newsArea = "Europe" # what type of news we will filter by

# scraping from BBC
website_name = "https://www.bbc.com/"
response = requests.get(website_name)
soup = BeautifulSoup(response.text,'html.parser')

# finding the first 13 news headings, times they were released, and their area (Europe, US & Canada, India)
# note, this program only finds the first 13 as it becomes troublesome to scrape for the time and location after the
# first 13 articles. Also, 13 is a succinct number
p = soup.find_all("h2")[:13]
spans = soup.find_all("span", attrs={"data-testid":"card-metadata-lastupdated"})[:len(p)-2]
spans2 = soup.find_all("span", attrs={"data-testid":"card-metadata-tag"})[:len(p)-2]

# making adjustments such as deleting unnecessary tags and saving only the text
del p[5]
p = [i.text for i in p if i.text != "Latest world headlines"]
spans = [i.text for i in spans]
spans2 = [i.text for i in spans2]

# defining variables
final_paragraph = []
final_times = []
time_score = []

# using regexes to only save articles that match our country
for i in range(len(spans2)):
    match = re.search(newsArea,spans2[i],re.IGNORECASE)
    if match:
        final_paragraph.append(p[i])
        final_times.append(spans[i])

# sorting the paragraphs based on time they were released
# the loop fills the previously declared array, which we use to sort the paragraphs
for i in final_times:
    num = int(i[:i.index(" ")])
    if "hrs" in i:
        num += 1000000
    elif "days" in i:
        num += 100000000
    time_score.append(num)
final_paragraph = sorted(final_paragraph, key=lambda x: time_score[final_paragraph.index(x)])
final_times = sorted(final_times, key=lambda x: time_score[final_times.index(x)])


# making a csv file
with open("output.csv",'w') as output:
    writer = csv.writer(output)
    writer.writerow(["Latest news","Time"])
    for i in range(len(final_paragraph)):
        writer.writerow([final_paragraph[i],final_times[i],newsArea])






