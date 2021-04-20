#! /usr/bin/env python
from functions import get_state
from functions import get_enclosed_contents
from functions import remove_enclosed_contents
state = get_state()
for course in state["courses"]:
    modules = course["modules"]
    module_links = "## Modules"
    for module in modules:
        for state_module in state["modules"]:
            if state_module["path"] == module:
                module_links = module_links + "\n#### [" + state_module["name"] + "](" + state_module["path"] + ") (" + str(state_module["estTime"]) + "~ mins)" + "\n" + state_module["overview"]
    course_readme = open(course["readme"], "r")
    contents = course_readme.read()
    course_readme.close()
    contents = remove_enclosed_contents("<!--MODULES_START", "<!--MODULES_END-->", contents)
    contents = contents + "<!--MODULES_START-->\n" + module_links + "\n<!--MODULES_END-->"
    course_readme = open(course["readme"], "w")
    contents = course_readme.write(contents)
    course_readme.close()


