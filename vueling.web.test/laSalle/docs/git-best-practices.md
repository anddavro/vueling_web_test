# Git Best practices

## Tool

It is really easy to setup git on windows. Just download it using this [link](https://git-scm.com/) and go through the default installation process.

![Install](images/git.gif)

Possible tools to use:
* [git-fork](https://git-fork.com/) ==>> very cool resolving conflicts!
* [SourceTree](https://www.sourcetreeapp.com/)


### Branches
 There will those types of branches:
 * feature
 * hotfix
 * bugfix
 * release

 As this is a multi-team project the name of the branches should have this format: __feature/team[Number]/PBI/taskName__

 Sample: feature/team1/PBI4567/get_demographics

#### Rules:
 1. A task branch can only be merged into a PBI branch after a pull request
 1. PBI branches will only be merged into master once all tasks are finished (including functional reviews, acceptance tests and development tasks)
 1. Once a pull request is approved and completed, the source branch must be deleted
 1. Be aware of remote branches changes (i.e. often do fetch and merge if necessary as well as to review often the status of the ancestors branches)

#### Best scenario
In order to minimize the synchronization overhead between branches, each PBI branch should be smaller enough to avoid
the creation of task branches.

## Update local branch before push

1. From your "feature/team/name" branch: commit your changes to the task branch: `git commit -am 'Add some feature'`
2. Rebase "origin/dev" to "feature/team/name"
3. Force Push local to origin
4. Submit a pull request from task branch to PBI branch in TFS, add a reviewer and the URL with the CI ok.
5. When mergin PR to dev, squash commits and remove old branch.
