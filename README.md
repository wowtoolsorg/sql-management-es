# sql-management-es

* 坑太大，慢慢地填。。
* Email:liuyu@wowtools.org


将sql转为elasticsearch的DSL语句，并可进行增删改查操作,例如：

```java
String sql = "update test set team_leader_name = 'tom',team_name = 'google',type = 100 where _id = '1'";
EsCommand cmd = ParseSql2EsCommand.parse(sql,"school","class");
System.out.println(cmd);
```
得到下列DSL语句:

```js
POST /school/class/1/_update
{
    "doc": {
        "team": {
            "leader": {
                "name": "tom"
            },
            "name": "google"
        },
        "type": 100
    }
}
```

