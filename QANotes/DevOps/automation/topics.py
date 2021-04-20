#! /usr/bin/env python
# generate topic list in topics/README.md
import os
import re

# get everything from a folder but the README.md file
def get_folders(dir):
    return list(filter(lambda file: file != "README.md", os.listdir(dir)))

# find the first sentence in a readme file after the ## Overview heading
def get_first_sentence(readme_contents):
    readme_lines = readme_contents.split("\n")
    for index, line in enumerate(readme_lines):
        if line == "## Overview":
            sentence_regex = r'(?<!\w\.\w.)(?<![A-Z][a-z]\.)(?<=\.|\?)\s'
            next_line = readme_lines[index + 1]
            return re.split(sentence_regex, next_line)[0]

# get the full topic name by reading the first heading
def get_topic_name(readme_contents):
    readme_lines = readme_contents.split("\n")
    for line in readme_lines:
        if line.startswith("#"):
            return line

# make a list of topics from the folder name; name, overview and link
def get_topics(topic_folders):
    topics = []
    for topic_folder in topic_folders:
        topic = {}
        readme_file = open("./topics/" + topic_folder + "/README.md", "r")
        contents = readme_file.read()
        formatted_topic_name = re.sub(r'^#+\s', '', get_topic_name(contents))
        topic["name"] = formatted_topic_name
        topic["overview"] = get_first_sentence(contents)
        topic["link"] = "./" + topic_folder
        topics.append(topic)
        readme_file.close()
    return topics

# create markdown from topics list
def generate_markdown_for_topics(topics):
    markdown = ""
    for topic in topics:
        markdown = markdown + "\n## " + topic["name"] + " [&xrarr;](" + topic["link"] + ")\n" + topic["overview"]
    return markdown


topic_folders = list(get_folders("./topics"))
topic_folders.sort()
topics = get_topics(topic_folders)
with open("./topics/README.md", "w") as readme:
    readme.write("# Topics" + generate_markdown_for_topics(topics))

