```git
echo "# homework" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/Easterlings/homework.git
git push -u origin master
```



```git
git remote add origin https://github.com/Easterlings/homework.git
git push -u origin master
```
git branch

查看分支

git commit -m "message"

提交到当前分支

git branch -d new

删除名为new的本地分支

git checkout -b paul

新建名为paul的本地分支

git fetch origin paul

从远程(origin)获取paul，远程(origin)上的 paul 分支 将被获取，且本地副本被命名为origin/paul 

git merge origin/paul

合并origin/paul与本地分支 paul

git push -u origin paul

推送本地分支到远程同名分支



