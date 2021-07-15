# Bigdata

1. 上传数据到hdfs
```bash
hadoop fs -mkdir -p /user/student/wjy/input
hadoop fs -put HTTP_20130313143750.dat /wjy/input
```
2. 将 MapReduce 程序提交给 Yarn 集群
3. ```bash
hadoop jar BigData-1.0-SNAPSHOT.jar com.jy.flowCount.JobMain

yarn jar BigData-1.0-SNAPSHOT.jar com.jy.flowCount.JobMain
```

# 运行结果
```bash
[student@jikehadoop05 wjy]$ hadoop fs -ls /user/student/wjy/output
Found 13 items
-rw-r--r--   3 student student          0 2021-07-15 15:36 /user/student/wjy/output/_SUCCESS
-rw-r--r--   3 student student         26 2021-07-15 15:36 /user/student/wjy/output/part-r-00000
-rw-r--r--   3 student student         56 2021-07-15 15:36 /user/student/wjy/output/part-r-00001
-rw-r--r--   3 student student          0 2021-07-15 15:36 /user/student/wjy/output/part-r-00002
-rw-r--r--   3 student student         26 2021-07-15 15:36 /user/student/wjy/output/part-r-00003
-rw-r--r--   3 student student         51 2021-07-15 15:36 /user/student/wjy/output/part-r-00004
-rw-r--r--   3 student student         79 2021-07-15 15:36 /user/student/wjy/output/part-r-00005
-rw-r--r--   3 student student          0 2021-07-15 15:36 /user/student/wjy/output/part-r-00006
-rw-r--r--   3 student student         75 2021-07-15 15:36 /user/student/wjy/output/part-r-00007
-rw-r--r--   3 student student          0 2021-07-15 15:36 /user/student/wjy/output/part-r-00008
-rw-r--r--   3 student student         85 2021-07-15 15:36 /user/student/wjy/output/part-r-00009
-rw-r--r--   3 student student         46 2021-07-15 15:36 /user/student/wjy/output/part-r-00010
-rw-r--r--   3 student student        107 2021-07-15 15:36 /user/student/wjy/output/part-r-00011
```
