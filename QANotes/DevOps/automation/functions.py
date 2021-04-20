#! /usr/bin/env python
# helper function library
from pathlib import Path
import os
import re
import json
def get_overview(contents):
    overview_list = re.findall(r"(?<=## Overview\n).*", contents)
    overview = ""
    if len(overview_list) > 0:
        overview = overview_list[0]
    return overview

def get_title(contents):
    title_list = re.findall(r"(?<=# ).*", contents)
    title = ""
    if len(title_list) > 0:
        title = title_list[0]
    else:
        print("no title in given contents")
        exit(1)
    return title
def get_enclosed_contents(start, end, content):
    sub_content_list = re.findall(r"(?<=" + start + ")((.*\n)*)(?=" + end + ")", content)
    if len(sub_content_list) > 0:
        return sub_content_list[0][0].strip()
    else:
        return ""
def remove_enclosed_contents(start, end, content):
    sub_content = re.sub(r""+ start + "((.*\n)*)" + end, "", content)
    return sub_content.strip() + "\n"
def get_props(module):
    module_readme = open(module + "/README.md", "r")
    contents = module_readme.read()
    module_readme.close()
    props_string = get_enclosed_contents("<!--PROPS", "-->", contents)
    if props_string == "":
        props_string = "{}"
    props = json.loads(props_string)
    props["path"] = module
    props["readme"] = module + "/README.md"
    props["overview"] = get_overview(contents)
    props["name"] = get_title(contents)
    return props

def get_all_modules_for_topic(topic):
    items = Path(topic).glob("modules/*")
    module_paths = filter(lambda item: os.path.isdir(item), items)
    module_paths = map(lambda module: str(module), module_paths)
    modules = []
    for module in module_paths:
        modules.append(get_props("./" + module))
    return modules

def get_all_topics():
    items = list(Path("./topics").glob("*"))
    topics = filter(lambda item: os.path.isdir(item), items)
    topics = map(lambda topic: str(topic), topics)
    new_topics = []
    for topic in topics:
        new_topics.append(get_props("./" + topic))
    return new_topics

def get_all_courses():
    items = list(Path("./courses").glob("*"))
    courses = filter(lambda item: os.path.isdir(item), items)
    courses = map(lambda course: str(course), courses)
    new_courses = []
    for course in courses:
        new_courses.append(get_props("./" + course))
    return new_courses

def get_state():
    state = {
        "topics": [],
        "modules": [],
        "courses": []
    }
    # topics & modules
    for topic in get_all_topics():
        modules = get_all_modules_for_topic(topic["path"])
        for module in modules:
            state["modules"].append(module)
        state["topics"].append(topic)
    # courses
    for course in get_all_courses():
        est_time = 0
        if "modules" in course:
            for module in course["modules"]:
                props = get_props(module)
                if "estTime" in props:
                    est_time += props["estTime"]
        course["estTime"] = est_time
        state["courses"].append(course)
    return state

