# Linux Notes

* The `*` wildcard symbol looks for 0...* characters.

## Commands

`ls*.?` - List any files with any char, and exactly 1 char after a dot. Useful for finding directories (e.g. folder.d)

`more [A-Z]*` - Echo the contents of any file in the current dir

`ls /etc/[!a-m]*` - List any folders (and their files) in the etc/ folder that don`t include chars in the a-m range.

`file /usr/bin/*x*` - Reports the file type and symbolic links of all files in the directory /usr/bin/ that has an `x` in the file name.

`ls [a-z]*[0-9]` - List all files that start with a lowercase letter and end in a number (Character case)

`ls -l .[!.]*` - List the contents of all hidden files and folders

`ls -d /etc/*.d/*` - List the contents of all directories with any name, a `.d` extension, and anything after that

`compgen` shows what you are allowed to run. The flags are:
  - `-c` = all commands
  - `-a` = all aliases
  - `-k` = all keywords
  - `-b` = all builtins
  - `-A` = all functions

## Character Classes
Locale independent
  * `[[:lower:]]` - matches any lower case char
  * `[[:upper:]]` - matches any upper case char
  * `[[:alpha:]]` - matches any lower or upper case char
  * `[[:alum:]]`  - matches any alphanumeric char
  * `[[:punct:]]` - matches any one of  " # $ % & ` ( ) * + , - . / : ; < = > ? @ [ \ ] ^ _ ` { | } ~. chars
  * `[[:digit:]]` - matches 0 1 2 3 4 5 6 7 8 9

## INodes

An inode number points to an inode. This is a data structure that stores info about a file, such as:
  * Size
  * Device ID
  * User and Group ID
  * Access priveleges
  * File protection flags
  * Timestamps for creation, modification etc.
  * Link counter to determine no. of hard links
  * Pointers to the blocks containing the file`s content

To find the inode type `stat` <filename>

Files can be linked using inodes.

A hard link is a direct pointer to the inode of a file. A linked file points to the original and shares its` contents.

A symbolic link does the same, but the linked file stores the inode number of the origianl file.

You cannot link 2 existing files. To link a file, it must be created when you run the command to link it.

To link files, use the command `ln <file1> <file2>`. Use the flag `-s` for a symblic link.

Use `rm` to remove links. A file is deleted when all of its hard links are removed.

Using the `history` command displays all commands entered in numerical order. To rerun a command, type `!<number>`. To run a command that you ran x number of commands ago, use `! -n`, where n is the number you want.

Typing `!!` runs the last command.

Typing `!some prefix` runs the last command found with the specified prefix. e.g. `!ca` runs the last cat command found.

Running `^xx^yy` runs the last command with xx replaced with yy.
Running `!n:s/xx/yy` runs the command at the nth line, with xx replaced by yy.
Running `!*` displays all the arguments of the last command.
Running `!^` displays the first argument of the last command.
Running `!$` displays the last argument of the last command.
Running `!:n` displays the nth argument of the last commnad.

`set` displays all vars
`env` displays all exported vars
`unset` <var> deletes vars

`type`<program> displays where the program is located.

Use `export -f <function name>` to export a function.

`set -o` displays shell options.
`set -o <option name>` sets an option to `on`
`set +o <option name>` sets an option to `off`

## Permissions

chmod, chown and chgrp change permissions.

`chown newOwner file` gives another user ownership of a file
`chown newOwner:group file` changes user and group ownership of a file

## Data Streams

`echo "stuff" 1&2 > file` - sends either output or errors to file
`echo "stuff" > file 2> errorFile` - sends both output and errors to files

`echo stuff >| file` ignores the `noclobber` option. This allows you to overwrite the contents of a file when `noclobber` is set to on.

the `tee` command copies stdin to stdout. It must be surrounded by pipes | tee fileName |

Print out how many users are logged in, keep the list in a file, and output the line count to the terminal.
The `-a` flag appends output when writing to a file
`who | tee -a who.list | wc -l`

## Grep

`grep -v` otuputs non-mathced lines
`grep -c` outputs the count of matched lines
`grep -i` ignores case
`grep -n` gives lnie numbers to each result
`grep -E` allows for extended regular expressions (incorporating `OR` functionality) | = `OR`
e.g. `cat file | grep "text to find"`

## Cut

This command removes sections from each line of files.
`-d` is a delimiter, the character that differentiates fields.
`-f` specifies the fields to select. e.g `-f1,2,3` would return the first 3 fields
e.g `cat file | cut -d "," -f1-3`

## Uniq

Displays unique and non unique rows of data, only works if data is sorted so that unique data is grouped.

___

# Scripting

**Scripts must be made executable using the chmod +x command before it can be run.**
**To run a script, use the command ./nameOfScript**
**If statements need a space after `if`, after `[`, and before `]`.**

If statement conditionals
  - `-gt` = greater than
  - `-lt` = less than
  - `-ge` = greater than or equal to
  - `-le` = less than or equal to
  - `-eq` = equal to
  - `-ne` = not equal to

The keyword `read` is used to take user input.

## Loops

Double brackets are used for mathmatical operations, e.g. `((count++))` to increment count.  
`${}` notation is not needed on a variable when performing mathmatical operations on it.  

### Loop syntax

**For Loop**

```bash
    looper=1
    
    for i in 10
    do
        echo "Looper is ${looper}"
        ((looper++))
    done
```

**While Loop**

```bash
    looper=1

    while [ $looper -lt 5 ]
    do
        echo "${looper} is less than 5"
        ((looper++))
    done
```

Key word **until** can be used in place of **while**  
e.g. `until [ $looper -ge 5 ] `

### Switch Statements

```bash
    echo "Enter your grade (A-F) and hit Enter..."
    read grade

    case $grade in
        "A") echo "Nice one, well done";;
        "B") echo "Pretty good";;
        "C") echo "Not bad";;
        "D") echo "Eeehhhh...you did ok";;
        "E") echo "`E` is a grade?";;
        "F") echo "You F`ed it";;
        *) echo "Not even a grade, try again";;
    esac
```

### Arrays

```bash
    declare -a arrayVar=("Alice" "Bob" "Chris" "Dylan")

    counter=1

    for i in "${arrayVar[@]}"
    do
        echo "Person ${counter} is ${i}"
        ((counter++))
    done
```
**You must use the -a flag with the delcare keyword to declare an array**  

___