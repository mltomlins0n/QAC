#! /usr/bin/env python
# generate modules list for every topic

import os

#set global variables
start = "<!--MODULES_START-->"
end = "<!--MODULES_END-->"

# function to get a list of everything in a given directory, apart from the README.md files
def get_folders(dir):
    return list(filter(lambda file: file != "README.md", os.listdir(dir)))


# function to create a list of module links from the given topic's README.md file
def get_module_links(topic):
	module_links = "## Modules"
	module_name = ""
	modules = get_folders("./topics/" + topic + "/modules")
	modules.sort()
	for module in modules:
		# get the module name from the module's readme
		with open("./topics/" + topic + "/modules/" + module + "/README.md") as file:
			for line in file.read().split("\n"):
				if line.startswith("#"):
					module_name = line.replace("#","").strip()
					break
			print("\t" + module_name)
			module_links = module_links + "\n- [" + module_name + "](./modules/" + module + ")"
	module_links = start  + "\n" + module_links + "\n" + end
	return module_links

# function 2 - stages README.md to include new module links
def build_readme(topic, module_links, readme_file):
	readme = ""
	with open(readme_file, "r") as file:
		delete = False
		for i, line in enumerate(file.read().split("\n")):
			if line == start:
				delete = True
			if line == end:
				delete = False
				continue
			if not delete:
				if i == 0:
					readme = readme + line
				else:
					readme = readme + "\n" + line
	readme = readme.strip() + "\n" + module_links
	return readme

# function 3 - writes staged README.md to existing README.md
def update_readme(topic, readme, readme_file):
	with open(readme_file, "w") as file:
		file.write(readme)

#function calls
for topic in get_folders("./topics"):
	print(topic + ":")
	readme_file = "./topics/" + topic + "/README.md"
	module_links = get_module_links(topic)
	readme = build_readme(topic, module_links, readme_file)
	update_readme(topic, readme, readme_file)
