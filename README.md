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

git checkout -b cjy

新建名为cjy的本地分支

git fetch origin cjy

从远程(origin)获取cjy，远程(origin)上的 cjy 分支 将被获取，且本地副本被命名为origin/cjy 

git merge origin/cjy

合并origin/cjy与本地分支 cjy

git push -u origin cjy

推送本地分支到远程同名分支


作出修改

