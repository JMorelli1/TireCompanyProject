# TireCompanyProject

Hello Team!

I am going to use this Read Me file to stash some helpful info for using GitHub with your IDE since I know a few of you haven't used it before. Currently I have gotten it working best with NetBeans although the built in controls with NetBeans are dreadfully tedious. I will also let yall know how I have been using the Command terminal to get around that. 

Thanks James

Install Git Command Line extension, this will be extremely useful as the commands on the terminal are much faster than the Netbeans functionality. Link: https://git-scm.com/downloads 

Cloning this repository:

First click Clone/Download in Git and copy the link there
In NetBeans under the Team tab go to Git->Clone (Sign in w/ Git info where it asks) and under URL paste the Git URL
This will clone the repository over to NetBeans as a web app and it should just run like normal after being built.

Git Controls -> you can get to this list by typing "git" into the cmd once Git is installed

start a working area<br />
   clone: Clone a repository into a new directory<br />
   init:      Create an empty Git repository or reinitialize an existing one<br />

work on the current change (see also: git help everyday)<br />
   add :      Add file contents to the index<br />
   mv    :    Move or rename a file, a directory, or a symlink<br />
   restore:   Restore working tree files<br />
   rm      :  Remove files from the working tree and from the index<br />

examine the history and state (see also: git help revisions)<br />
   bisect   : Use binary search to find the commit that introduced a bug<br />
   diff     : Show changes between commits, commit and working tree, etc<br />
   grep     : Print lines matching a pattern<br />
   log      : Show commit logs<br />
   show     : Show various types of objects<br />
   status   : Show the working tree status<br />

grow, mark and tweak your common history<br />
   branch   : List, create, or delete branches<br />
   commit   : Record changes to the repository<br />
   merge    : Join two or more development histories together<br />
   rebase   : Reapply commits on top of another base tip<br />
   reset    : Reset current HEAD to the specified state<br />
   switch   : Switch branches<br />
   tag      : Create, list, delete or verify a tag object signed with GPG<br />

collaborate (see also: git help workflows)<br />
   fetch    : Download objects and refs from another repository<br />
   pull     : Fetch from and integrate with another repository or a local branch<br />
   push     : Update remote refs along with associated objects<br />
   
   **All commands are used with "git" before such as : git commit -m or git fetch etc.<br />
   
When making changes you should first create a new branch of master and then work on the file (this can be done in Github or in the cmd)
Use the fetch command to update the local git list then use the checkout command to move and access the new branch
