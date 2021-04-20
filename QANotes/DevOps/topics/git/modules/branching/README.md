# Branching
<!--TOC_START-->
### Contents
- [Overview](#overview)
- [Git Branching Workflow Example](#git-branching-workflow-example)
	- [New Application Features](#new-application-features)
	- [Releases](#releases)
	- [Hotfixes](#hotfixes)

<!--TOC_END-->
## Overview
Branching in Git helps us to define workflows that make sure the code that is being delivered is in the best state possible, minimising risks for any errors or crashes.
With version control systems like Git we can separate the codebase on to many different branches.
This feature can be utilised for isolating the development and testing of new features from working code that is running on a production environment.
## Git Branching Workflow Example
This is an example of a workflow using Git with some notes below which explain in more detail the processes.
The two main branches that exist are the `develop` and `master` branches.
### New Application Features
New features are to be created in feature branches from the develop branch, once the feature has been developed the code can be reviewed by a peer in a Pull Request and deployed to a test environment for Integration or User Acceptance Testing.
If all testing and reviews pass then the Pull Request can be approved and merged into the develop branch.
### Releases
When there is a release approaching, a release candidate branch can be made.
On this new branch, further testing of all the new features working together can take place, and more candidates can be made on this branch to amend any issues.
Once testing has passed and the release has been signed off by the individual accountable for releases, the release candidate branch can be merged into master for the release to be deployed to a production environment.
Once merged into the master branch, the code can be tagged or marked as a release on the Git service that you are using.
Changes must also be merged back into the develop branch, so that any changes that were made to the release candidate will also be included in future releases.
### Hotfixes
Preventing hotfixes is one of the main reasons for designing a workflow such as the one below.
Hotfixes should be prevented where possible, but, as this is the wonderful world of IT we work in, they could still happen at some point.
A hotfix can be conducted by creating a hotfix branch from the master branch and applying the changes on that branch; before merging back into the master branch all the changes should, of course, be tested and reviewed to avoid even more hotfixes!
Once merged into the master branch, the changes must also be merged back into the develop branch; this will keep any important changes the hotfix made, and the code in the master branch should be tagged.
![Workflow](https://i.imgur.com/TTzISff.png)
