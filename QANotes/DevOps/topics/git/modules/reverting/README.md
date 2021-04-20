# Reverting

<!--TOC_START-->
### Contents
- [Reviewing the history of a repository](#reviewing-the-history-of-a-repository)
- [Reverting to an older commit with checkout](#reverting-to-an-older-commit-with-checkout)
- [Reverting to a previous commit with revert](#reverting-to-a-previous-commit-with-revert)
- [Reverting with reset](#reverting-with-reset)
- [Summary](#summary)
- [Tasks](#tasks)
	- [Task 1](#task-1)
	- [Task 2](#task-2)
	- [Task 3](#task-3)
		- [Task Summary](#task-summary)

<!--TOC_END-->
## Reviewing the history of a repository

The best way to view the history is by using the following command:

``git log``

This command will show the history of all commits for the current branch, with the output including: date, commit message
 and the SHA-1 identifying hash. There are also additional flags that make this command easier to use, such as: 

``git log --oneline``

Using ``--oneline`` flag simplifies the output into one line per commit.

``git log --branches=*``

By using the ``--branches=*`` flag, we are making Git return the history of all commits for all the branches. The asterisk
acts as a wildcard, including all the branches. To get the data for a specific branch, the log command would need to be
used like this:

``git log branchname``

where ``branchname`` would be the name of the branch you wish to get the history of. If you aren't sure of the 
existing branch names, you can use the commad ``git branch -a`` to find out.

## Reverting to an older commit with checkout

Once you know the commit that you want to return to, ``git checkout`` can be used; this will load your chosen commit's state.
Usually, Git would have the HEAD pointing to master or some other local branch, although this changes once you invoke
the ``git checkout`` command. From then, the HEAD points directly to the commit and this is called `detached HEAD`.

Let's assume that your ``git log --oneline`` looks similar to this:

```
875f31e (HEAD -> master) fourth commit
483856a third commit
2dd011d second commit
bcabb84 first commit
```

If we want to revert back to the third commit, which has the SHA-1 of ``483856a``, the checkout command would look like this:

``git checkout 483856a``

After this command is executed, the repository would go into the ``detached HEAD`` state, and we wouldn't be on a branch any more. Because we aren't working on a branch any more, any new commits you make would be 'orphaned' once we changed branches (for example, if we wanted to change branches to make a new branch). Orphaned commits get deleted by Git's garbage collector, which runs in specific intervals and destroys all orphaned commits.

In order to avoid orphaned commits being destroyed, we need to make sure we are on a branch. This can be done from
the ``detached HEAD`` state, by executing ``git checkout -b newbranchname``. 

Now there would be a new history for the repository's timeline, without the ``fourth commit``.

## Reverting to a previous commit with revert

Let's assume that your ``git log --oneline`` looks similar to this:
             
 ```
 875f31e (HEAD -> master) fourth commit
 483856a third commit
 2dd011d second commit
 bcabb84 first commit
 ```

If we execute: 

``git revert HEAD``

Git will create a new commit, which will do the opposite of the previous commit (for example, if you added a piece of code you didn't need, the revert would create a commit deleting this piece of code). You can also use revert to go back to a specific SHA-1. 

The history will still contain the fourth commit, but it's changes will be undone. Using ``revert`` allows us to use the same branch and is considered the better solution for reverting.

## Reverting with reset

We will work with the same ``git log`` history seen in the previous examples.

``git reset --hard 483856a``

This command will return the state to the selected commit (483856a). The difference between this and ``revert`` is that, in this solution, the Git history will no longer contain the fourth commit and work can resume just like the ``fourth commit`` never happened.

This method has the smallest effect on history. Resetting local changes poses no complications, although using it for a shared
remote repository will increase the complexity.

If the reset happened to a commit that is already shared on Git with others, and we tried to push some changes afterwards,
Git would throw an error; this is because it would think that our local Git history isn't up to date. In these scenarios it's more appropriate to use the ```
revert``` strategy.

## Summary
* ``log`` - checking on the commit history
* ``checkout`` - moving around and reviewing commit history
* ``revert`` - shared work undoing
* ``reset`` - local work undoing

## Tasks

Now it's practice time, where you will try the two different ways of reverting back to a previous commit:

### Task 1 

Reverting local work:

* Create a folder called "tmp"
* Initialise the folder as a git repository
* Create a new text file called test.txt
* Place some text within the file
* Stage the file and commit
* Repeat the previous two steps until you have done 4-5 commits
* Now check the git log history for the branch you are on (try out the additional flags for viewing the git log history)
* Pick one of the previous commits to revert to and keep note of the SHA-1
* Now use the ``revert`` command to go back to your chosen commit
* You will get a conflict for the file test.txt
* Open the test.txt in a text editor
* Resolve the conflict by selecting which parts of the code you want to keep
* Create a new branch with your chosen name
* Stage the file
* Commit the file
* Delete the previous branch
* Check all the current branches - ``master`` shouldn't be there
* Once you're done with the task, remove the tmp folder and all of the files inside it

### Task 2

Reverting local work:

* Create a folder called "tmp"
* Initialise the folder as a git repository
* Create a new text file called test.txt
* Place some text within the file
* Stage the file and commit
* Repeat the previous two steps until you have done 4-5 commits
* Now check the git log history for the branch you are on (try out the additional flags for viewing the git log history)
* Pick one of the previous commits to revert to and keep note of the SHA-1
* Now use the ``reset`` command and do a hard reset to your chosen commit
* Stage the file
* Commit the file
* Once you're done with the task, remove the tmp folder and all of the files inside it

### Task 3

Reverting pushed work:


* Create a folder called "tmp"
* Initialise the folder as a git repository
* Create a new text file called test.txt
* Place some text within the file
* Stage the file and commit
* Repeat the previous two steps until you have done 4-5 commits
* Now check the git log history for the branch you are on (try out the additional flags for viewing the git log history)
* Pick one of the previous commits to revert to and keep note of the SHA-1
* Create a new repository on GitHub with the name of your choosing, and leave everything else as default
* Associate the remote repository with your local repository
* Push all your work
* Now use the ``revert`` command to revert to a previous commit
* You will need to resolve any merge conflicts
* Stage your files
* Commit your files
* Push your changes
* Once you're done with the task, remove the tmp folder and all of the files inside it (as well as the git repository)

#### Task Summary
* Learned how to check git commit history
* Learned how to revert and reset back to a previous commit
* Learned about the differences between the revert and reset, and the use cases for them
